import java.sql.*; 
public class AddUsersDB {

    public static int save(String name, String pass, String em, String c, String con) {
        int status =0;
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert *from user(name,pass,em,c,con) values(?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(1, pass);
            preparedStatement.setString(1, em);
            preparedStatement.setString(1, c);
            preparedStatement.setString(1, con);
            status = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return status;
    }
    public static int delete(int id) {
        int status = 0;
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return status;
    }
    public static boolean validate(String name, String password) {
        boolean status=false;
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where name=? and password=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            status  = resultSet.next();
            connection.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return status;
    }
}
