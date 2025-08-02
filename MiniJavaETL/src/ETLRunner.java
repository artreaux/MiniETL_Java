import java.sql.Connection;
import java.sql.DriverManager;  
import java.util.List;  

public class ETLRunner {
    public static void main(String[] args) throws Exception {
        List<String[]> extracted = Extractor.extract("../data/customers.csv");
        List<String[]> transformed = Transformer.transform(extracted);

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etl_db", "root", "admin");
        Loader.load(transformed, conn);
        conn.close();
        System.out.println("ETL completed successfully!");
    }
}
