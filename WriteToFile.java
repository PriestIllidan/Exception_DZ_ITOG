import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class WriteToFile {
    public void write(LinkedHashMap<String, String> map, String path) {
        try {
            for (Map.Entry<String, String> value : map.entrySet()) {
                FileWriter writer = new FileWriter(path, true);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write("<" + value.getValue() + "> ");
                bufferWriter.close();
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

