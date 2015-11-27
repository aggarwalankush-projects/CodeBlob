import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class GenerateDarkMode {

    static final String SRC_PATH = "./src";
    static final String OUT_PATH = "./src/DarkModeHtml";
    static final String SERVER_BASE_URL = "http://hilite.me/api";
    static final String LEXER = "java";
    static final String STYLE = "monokai";
    static final String charset = "UTF-8";

    public static void main(String[] args) {
        TreeMap<String, ArrayList<String>> topicToQuestionMap = GenerateOutput.getTopicToQuestionMap();
        System.out.println("Started");
        long startTime = System.currentTimeMillis();
        for (Map.Entry<String, ArrayList<String>> entry : topicToQuestionMap.entrySet()) {
            String topic = entry.getKey();
            for (String question : entry.getValue()) {
                StringBuilder javaCode = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(SRC_PATH + "/" + topic + "/" + question))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        javaCode.append(line).append("\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String htmlDarkCode = javaToDarkHtml(javaCode.toString());

                String fname = question;
                if (question.endsWith(".java")) {
                    fname = question.replace(".java", "");
                }

                final File file = new File(OUT_PATH + "/" + topic + "/" + fname);
                final File parent_directory = file.getParentFile();

                if (null != parent_directory) {
                    parent_directory.mkdirs();
                }


                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    if (htmlDarkCode == null)
                        throw new Exception("null html code");

                    htmlDarkCode = htmlDarkCode.substring(htmlDarkCode.indexOf("<span"), htmlDarkCode.lastIndexOf("</span>") + 7);

                    htmlDarkCode = htmlDarkCode.replaceAll("<span style=\"color: ", "<font color=\"").replaceAll("</span>", "</font>");

                    writer.write(htmlDarkCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Ended");
        long millis = endTime - startTime;
        System.out.println("Processing Time : " + String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        ));
    }


    public static String javaToDarkHtml(String javaCode) {

        BufferedReader reader = null;
        try {
            URLConnection connection = new URL(SERVER_BASE_URL).openConnection();
            connection.setDoOutput(true); // Triggers POST.
            connection.setRequestProperty("Accept-Charset", charset);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

            try (OutputStream output = connection.getOutputStream()) {
                output.write(getQuery(javaCode).getBytes(charset));
            }

            InputStream inputStream = connection.getInputStream();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                int space = line.indexOf(line.trim());
                String leadSpace = "";
                for (int i = 0; i < space; i++) {
                    leadSpace += "&nbsp;";
                }
                String spanString = "<span style=\"color: #75715e\">";
                int len = spanString.length();
                if (line.contains(spanString)) {
                    String subPart = line.substring(line.indexOf(spanString)+len);
                    subPart = subPart.replaceAll(" ", "&nbsp;&nbsp;");
                    line = spanString + subPart;
                }
                line = leadSpace + line.trim();


                builder.append(line).append("<br/>");
            }

            if (builder.length() == 0) {
                return null;
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    public static String getQuery(String javaCode) throws UnsupportedEncodingException {

        return String.format("code=%s&lexer=%s&style=%s",
                URLEncoder.encode(javaCode, charset),
                URLEncoder.encode(LEXER, charset),
                URLEncoder.encode(STYLE, charset));
    }


}
