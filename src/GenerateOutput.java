import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class GenerateOutput {

    final static String SRC_PATH = Utility.SRC_PATH;
    final static String OUTPUT_FILE = SRC_PATH+"/Output.json";

    public static void main(String[] args) {
        TreeMap<String, ArrayList<String>> topicToQuestionMap = Utility.getTopicToQuestionMap();

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
                Class cls = null;
                try {
                    cls = Class.forName(topic + "." + question);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
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


}
