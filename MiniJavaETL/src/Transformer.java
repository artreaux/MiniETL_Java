import java.util.ArrayList;
import java.util.List;

public class Transformer {
    public static List<String[]> transform(List<String[]> rawData) {
        List<String[]> cleaned = new ArrayList<>();
        for (String[] row : rawData) {
            String name = row[1].trim().toLowerCase();
            String email = row[2].trim().toLowerCase();
            if (email.contains("@")) {
                cleaned.add(new String[] { row[0], name, email });
            }
        }
        return cleaned;
    }
}
