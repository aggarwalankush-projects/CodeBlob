import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class Utility {

    static final String SRC_PATH = "./src";
    static String OUT_PATH = SRC_PATH + "/";
    static final String SERVER_BASE_URL = "http://hilite.me/api";
    static final String LEXER = "java";
    static String STYLE = "friendly";
    static final String charset = "UTF-8";
    static String spanString = "Invalid span string";


    public static TreeMap<String, ArrayList<String>> getTopicToQuestionMap() {
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();
        File directory = new File(SRC_PATH);
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                String topic = file.getName();
                directory = new File(file.getAbsolutePath());
                ArrayList<String> questions = new ArrayList<>();
                for (File f : directory.listFiles()) {
                    if (f.isFile()) {
                        questions.add(f.getName());
                    }
                }
                map.put(topic, questions);
            }
        }
        return map;
    }


    public static void generateColoredHtml(String style, String outDirectory, String commentSpanString) {
        STYLE = style;
        OUT_PATH += outDirectory;
        spanString = commentSpanString;

        TreeMap<String, ArrayList<String>> topicToQuestionMap = getTopicToQuestionMap();
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

                String htmlDarkCode = javaToColoredHtml(javaCode.toString());

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


    private static String javaToColoredHtml(String javaCode) {

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

                int len = spanString.length();
                if (line.contains(spanString)) {
                    String subPart = line.substring(line.indexOf(spanString) + len);
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


    private static String getQuery(String javaCode) throws UnsupportedEncodingException {

        return String.format("code=%s&lexer=%s&style=%s",
                URLEncoder.encode(javaCode, charset),
                URLEncoder.encode(LEXER, charset),
                URLEncoder.encode(STYLE, charset));
    }

}
