import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Welcome extends JFrame implements ActionListener{
    JFrame frame = new JFrame();
    JLabel label = new JLabel("FUNCTIONS");
    JButton viewUsers = new JButton("VIEW USERS");
    static JButton viewBooks = new JButton("VIEW BOOKS");
    JButton viewIssuedBooks = new JButton("VIEW ISSUED BOOKS");
    JButton issueBooks = new JButton("ISSUE BOOKS");
    JButton addBooks = new JButton("ADD BOOKS");
    JButton addUsers = new JButton("ADD USERS");
    JButton returnBooks = new JButton("RETURN BOOKS");
    JButton create = new JButton("CREATE/RESET");
    Welcome(){
        label.setBounds(170, 30, 250, 35);
        frame.add(label);
        viewUsers.setBounds(25, 100, 125, 75);
        viewUsers.addActionListener(this);
        frame.add(viewUsers);
        viewBooks.setBounds(170, 100, 125, 75);
        viewBooks.addActionListener(this);
        frame.add(viewBooks);
        viewIssuedBooks.setBounds(310, 100, 125, 75);
        viewIssuedBooks.addActionListener(this);
        frame.add(viewIssuedBooks);
        issueBooks.setBounds(25, 195, 125, 75);
        issueBooks.addActionListener(this);
        frame.add(issueBooks);
        addBooks.setBounds(170, 195, 125, 75);
        addBooks.addActionListener(this);
        frame.add(addBooks);
        addUsers.setBounds(310, 195, 125, 75);
        addUsers.addActionListener(this);
        frame.add(addUsers);
        returnBooks.setBounds(170, 290, 125, 75);
        returnBooks.addActionListener(this);
        frame.add(returnBooks);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(false);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewUsers){
          ViewUsers.viewusers(new String[]{});
        }
        if(e.getSource()==viewBooks){
            ViewBooks.viewbooks(new String[]{});
        }
        if(e.getSource()==viewIssuedBooks){
           ViewIssuedBooks.viewissued(new String[]{});
        }
        if(e.getSource()==issueBooks){
            IssueBooks.iB(new String[]{});
        }
        if(e.getSource()==addBooks){
            AddBooks.ab(new String[]{});
        }
        if(e.getSource()==addUsers){
            AddUsers.au(new String[]{});
        }
        if(e.getSource()==returnBooks){
            ReturnBooks.rB(new String[]{});
        }

        
    }
}