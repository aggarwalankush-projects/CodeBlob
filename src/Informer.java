import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Informer {
    public static void main(String[] args) {
        JsonObject info = new JsonObject();
        File directory = new File("./src");
        Gson gson = new Gson();
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                String topic = file.getName();
                directory = new File(file.getAbsolutePath());
                List<String> questions = new ArrayList<>();
                for (File f : directory.listFiles()) {
                    if (f.isFile()) {
                        questions.add(f.getName());
                    }
                }
                info.addProperty(topic, gson.toJson(questions));
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Informer.json"))) {
            writer.write(info.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
