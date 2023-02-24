package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    public static Connection openConnection() throws Exception {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
         String connectionUrl = "jdbc:sqlserver://localhost;database=QuanLyLuongNhanVien;";
         String username = "sa";
         String password = "123";

            Connection con = DriverManager.getConnection(connectionUrl, username, password);
        return con;
        
    } 
}
