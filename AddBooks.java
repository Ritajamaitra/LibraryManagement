import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
public class AddBooks extends JFrame {
    static AddBooks frame;
    private JPanel contentPanel;
    private JTextField idLibrary;
    private JTextField bookName;
    private JTextField authorName;
    private JTextField genre;
    private JTextField quantity;
    private JTextField issue;
    private JTextField adate;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try {
                    frame = new AddBooks();
                    frame.setVisible(true);
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
            }
        });
    }
    public AddBooks(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);

        JLabel mssgLabel = new JLabel("ADD BOOKS");

        JLabel idLib = new JLabel("Id Library : ");
        JLabel bName = new JLabel("Book Name : ");
        JLabel aName = new JLabel("Author Name : ");
        JLabel g = new JLabel("Genre : ");
        JLabel q = new JLabel("Quantity : ");
        JLabel i = new JLabel("Issue No. : ");
        JLabel ad = new JLabel("Added date : ");

        idLibrary = new JTextField();
        idLibrary.setColumns(10);

        bookName = new JTextField();
        bookName.setColumns(10);

        authorName = new JTextField();
        authorName.setColumns(10);

        genre = new JTextField();
        genre.setColumns(10);

        quantity = new JTextField();
        quantity.setColumns(10);

        issue = new JTextField();
        issue.setColumns(10);

        adate = new JTextField();
        adate.setColumns(10);

        JButton button = new JButton("Add Books");
        button.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String id = idLibrary.getText();
                String b = bookName.getText();
                String a = authorName.getText();
                String gen = genre.getText();
                String quantityString = quantity.getText();
                double quantity = Double.parseDouble(id);
                String issueString = issue.getText();
                String aString = adate.getText();
                Timestamp aTimestamp = Timestamp.valueOf(aString);
                int i = addBooksDB.save(id,b,a,gen,quantity,issueString,aTimestamp);
                if(i>0){
                    JOptionPane.showMessageDialog(AddBooks.this,"Books added successfully!");
                    Welcome.main(new String[]{});
                    frame.dispose();
                    
                }else{
                    JOptionPane.showMessageDialog(AddBooks.this,"Sorry, unable to save!");
                }
            }
        });
        JButton back = new JButton("Back");
        GroupLayout conPan = new GroupLayout(contentPanel);
        
    
        conPan.setHorizontalGroup(
        conPan.createParallelGroup(Alignment.TRAILING)
        .addGroup(conPan.createSequentialGroup()
            .addGroup(conPan.createParallelGroup(Alignment.LEADING)
                .addGroup(conPan.createSequentialGroup()
                    .addGap(150)
                    .addComponent(mssgLabel))
                .addGroup(conPan.createSequentialGroup()
                    .addGap(18)
                    .addGroup(conPan.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(mssgLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(idLib)
                        .addComponent(bName, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(aName, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addComponent(g, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addComponent(q, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addComponent(i, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                        .addComponent(ad, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                    .addGap(47)
                    .addGroup(conPan.createParallelGroup(Alignment.LEADING)
                        .addComponent(idLibrary, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookName, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(authorName, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(genre, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(quantity, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(issue, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addComponent(adate, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
            
        .addGroup(Alignment.LEADING, conPan.createSequentialGroup()
            .addGap(161)
            .addComponent(button, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(162, Short.MAX_VALUE))
        .addGroup(conPan.createSequentialGroup()
            .addContainerGap(359, Short.MAX_VALUE)
            .addComponent(back)
            .addContainerGap())
);
conPan.setVerticalGroup(
    conPan.createParallelGroup(Alignment.LEADING)
        .addGroup(conPan.createSequentialGroup()
            .addComponent(mssgLabel)
            .addGap(18)
            .addGroup(conPan.createParallelGroup(Alignment.BASELINE)
                .addComponent(idLib)
                .addComponent(quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(conPan.createParallelGroup(Alignment.BASELINE)
                .addComponent(mssgLabel)
                .addComponent(genre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(conPan.createParallelGroup(Alignment.BASELINE)
                .addComponent(bookName)
                .addComponent(authorName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(conPan.createParallelGroup(Alignment.BASELINE)
                .addComponent(aName)
                .addComponent(bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(conPan.createParallelGroup(Alignment.BASELINE)
                .addComponent(ad)
                .addComponent(issue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(conPan.createParallelGroup(Alignment.BASELINE)
                .addComponent(i)
                .addComponent(adate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(conPan.createParallelGroup(Alignment.BASELINE)
                .addComponent(g)
                .addComponent(idLibrary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(30)
            .addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(back)
            .addContainerGap(53, Short.MAX_VALUE))
);
contentPanel.setLayout(conPan);
}

}

