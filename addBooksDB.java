import java.sql.*;
public class addBooksDB {
    public static int save(String id, String b, String a, String gen, double quantity, String issueString,
            Timestamp aTimestamp) {
                int status =0;
                try {
                    Connection connection = Database.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO viewbooks");
                    preparedStatement.setString(1,id);
                    preparedStatement.setString(2,b);
                    preparedStatement.setString(3,a);
                    preparedStatement.setString(4,gen);
                    preparedStatement.setDouble(5,quantity);
                    preparedStatement.setString(6,issueString);
                    preparedStatement.setTimestamp(7,aTimestamp);
                    status = preparedStatement.executeUpdate();
                    connection.close();
                } catch (Exception e) {
                    //TODO: handle exception
                    System.out.println(e);
                }
                 return status;
             }
    
}
