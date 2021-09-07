import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class viewIssuedBooks extends JFrame {
    private JPanel contPanel;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    viewIssuedBooks frame = new viewIssuedBooks();
                    frame.setVisible(true);
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
            }
            
        });
    }
    public viewIssuedBooks(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contPanel = new JPanel();
        contPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contPanel);

        String data[][] = null;
        String co
    }
}
