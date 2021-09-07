import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class viewBooks extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable table = new JTable(model);

    public viewBooks(){
        cnt.setLayout(new FlowLayout(FlowLayout.CENTER));
        model.addColumn("idLibrary");
        model.addColumn("bookName");
        model.addColumn("authorName");
        model.addColumn("Genre");
        model.addColumn("Quantity");
        model.addColumn("Issued No.");
        model.addColumn("Date Added");
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM viewbooks");
           
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getInt(1) , resultSet.getString(2) , resultSet.getString(3) , resultSet.getString(4) , resultSet.getInt(5),resultSet.getString(6),resultSet.getTimestamp(7)});
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());

        }
        JScrollPane pg = new JScrollPane(table);
        cnt.add(pg);
        this.pack();
    }
    public static void viewbooks(String[] args) {
        JFrame frame = new viewBooks();
        frame.setTitle("Books Available");
        frame.setSize(600, 500);
        frame.setVisible(true);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
    
