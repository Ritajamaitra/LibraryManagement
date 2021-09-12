import java.sql.*;
public class ReturnBooksDB {
    public static int delete(String idLibr, int student) {
        int status=0;
        try {
            Connection connection = Database.getConnection();
            status = updatebook(idLibr);
            if (status>0) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from issuebooks where idLibr=? and student=?");
                preparedStatement.setString(1, idLibr);
                preparedStatement.setInt(2, student);
                status = preparedStatement.executeUpdate();
            }connection.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return status;
    }

    private static int updatebook(String idLibr) {
       int status =0;
       int quantity =0, issued = 0;
       try {
           Connection connection = Database.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("select quantity,issued from viewbooks where idLibrary=?");
           preparedStatement.setString(1, idLibr);
           ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               quantity=resultSet.getInt("quantity");
               issued=resultSet.getInt("issued");
           }
           if (issued>0) {
               PreparedStatement preparedStatement2 = connection.prepareStatement("update viewbooks set quantity=?,issued=? where idLibrary=?");
               preparedStatement2.setInt(1, quantity+1);
               preparedStatement2.setInt(2, issued-1);
               preparedStatement2.setString(3, idLibr);
               status= preparedStatement2.executeUpdate();
           }connection.close();
       } catch (Exception e) {
           //TODO: handle exception
           System.out.println(e);
       }
    return status;
    }
    
}
