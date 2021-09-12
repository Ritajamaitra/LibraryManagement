import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class ViewUsers extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable table = new JTable(model);

    public ViewUsers(){
        cnt.setLayout(new FlowLayout(FlowLayout.CENTER));
        model.addColumn("idUser");
        model.addColumn("Name");
        model.addColumn("Password");
        model.addColumn("Email");
        model.addColumn("City");
        model.addColumn("Contact");
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
           
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getInt(1) , resultSet.getString(2) , resultSet.getString(3) , resultSet.getString(4) , resultSet.getString(5),resultSet.getString(6)});
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());

        }
        JScrollPane pg = new JScrollPane(table);
        cnt.add(pg);
        this.pack();
    }
    public static void viewusers(String[] args) {
        JFrame frame = new ViewUsers();
        frame.setTitle("Users");
        frame.setSize(600, 500);
        frame.setVisible(true);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
    