import java.sql.*;
public class Database{
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Kuka@0901");
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        } return connection;
    }  
}
    