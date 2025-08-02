import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Extractor {
    public static List<String[]> extract(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        br.readLine(); // skip header
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            data.add(values);
        }
        return data;
    }
}
