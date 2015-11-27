import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class GenerateOutput {

    final static String SRC_PATH = "./src";
    final static String OUTPUT_FILE = SRC_PATH+"/Output.json";

    public static void main(String[] args) throws Exception {
        TreeMap<String, ArrayList<String>> topicToQuestionMap = getTopicToQuestionMap();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        JsonObject info = new JsonObject();
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        for (Map.Entry<String, ArrayList<String>> entry : topicToQuestionMap.entrySet()) {
            String topic = entry.getKey();
            ArrayList<String> questions = entry.getValue();
            JsonObject quesToSol = new JsonObject();
            for (String question : questions) {
                baos.reset();
                question = question.split("\\.")[0];
                Class cls = Class.forName(topic + "." + question);
                try {
                    Method method = cls.getMethod("main", String[].class);
                    method.invoke(null, new Object[]{new String[]{}});
                } catch (Exception e) {
                    System.out.println("This is a helper class to be used by other programs.");
                }
                System.out.flush();
                String solution = baos.toString();
                quesToSol.addProperty(question, solution);
            }
            info.addProperty(topic, gson.toJson(quesToSol));
        }

        System.setOut(old);

        System.out.println(info);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            writer.write(info.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

}
