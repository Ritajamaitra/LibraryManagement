import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class ViewIssuedBooks extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable table = new JTable(model);

    public ViewIssuedBooks(){
        cnt.setLayout(new FlowLayout(FlowLayout.CENTER));
        model.addColumn("idIssueBooks");
        model.addColumn("Book Id");
        model.addColumn("Student Id");
        model.addColumn("Student Name");
        model.addColumn("Student Contact No.");
        model.addColumn("Issue Date");
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM issuebooks");
           
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getInt(1) , resultSet.getInt(2) , resultSet.getInt(3) , resultSet.getString(4) , resultSet.getString(5),resultSet.getTimestamp(6)});
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());

        }
        JScrollPane pg = new JScrollPane(table);
        cnt.add(pg);
        this.pack();
    }
    public static void viewissued(String[] args) {
        JFrame frame = new ViewIssuedBooks();
        frame.setTitle("Issued Books");
        frame.setSize(600, 500);
        frame.setVisible(true);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}