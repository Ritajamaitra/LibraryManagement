import java.sql.*;
public class issueBookDB {

    public static boolean checkBook(String idLib) {
        boolean status = true;
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from viewbooks where idLibrary=?");
            preparedStatement.setString(1, idLib);
            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();
            connection.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return status;
    }

    public static int save(String idLib, int student, String studentC, String studentN) {
        int sts = 0;
        try {
            Connection connection = Database.getConnection();
            sts = updateBook(idLib);

            if(sts>0){
                PreparedStatement preparedStatement2 = connection.prepareStatement("insert into issuebooks(Book Id, Student Id, Student Name, Student Contact no.) values(?,?,?,?)");
                preparedStatement2.setString(1, idLib);
                preparedStatement2.setInt(2, student);
                preparedStatement2.setString(3, studentN);
                preparedStatement2.setString(4, studentC);
                sts = preparedStatement2.executeUpdate();
            }connection.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return sts;
    }

    private static int updateBook(String idLib) {
        int status =0;
        int quantity = 0, issued =0;
        try {
            Connection connection= Database.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("select quantity,issued from viewbooks where idLibrary=?");
            preparedStatement.setString(1, idLib);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                quantity = resultSet.getInt("quantity");
                issued = resultSet.getInt("issued");
            }
            if (quantity>0) {
                PreparedStatement preparedStatement2 = connection.prepareStatement("update viewbook set quantity=?, issued=? where idLibrary=?");
                preparedStatement2.setInt(1, quantity-1);
                preparedStatement2.setInt(2, issued+1);
                preparedStatement2.setString(3, idLib);
                status = preparedStatement2.executeUpdate();
            }
            connection.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return status;
    }
    
}
