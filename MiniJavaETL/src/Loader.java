import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Loader {
    public static void load(List<String[]> data, Connection conn) throws SQLException {
        String sql = "INSERT INTO customers (id, name, email) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (String[] row : data) {
            ps.setInt(1, Integer.parseInt(row[0]));
            ps.setString(2, row[1]);
            ps.setString(3, row[2]);
            ps.addBatch();
        }
        ps.executeBatch();
    }
}
