import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class AddUsers extends JFrame{
    static AddUsers frame;
    private JPanel contentPanel;
    private JTextField uName;
    private JTextField email;
    private JPasswordField upassword;
    private JTextField ucontact;
    private JTextField ucity;

    public static void au(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    frame = new AddUsers();
                    frame.setVisible(true);
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
            }
            
        });
    }
    public AddUsers(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);

        JLabel mJLabel = new JLabel("Add Users");
        JLabel name = new JLabel("Name : ");
        JLabel password = new JLabel("Password : ");
        JLabel mail = new JLabel("Email : ");
        JLabel contact = new JLabel("Contact No. : ");
        JLabel city = new JLabel("City : ");

        uName = new JTextField();
        uName.setColumns(10);

        upassword = new JPasswordField();
        upassword.setColumns(10);

        ucity = new JTextField();
        ucity.setColumns(10);

        email = new JTextField();
        email.setColumns(10);

        ucontact = new JTextField();
        ucontact.setColumns(10);

        JButton button = new JButton("Add Users");
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String Name = uName.getText();
                String pass = String.valueOf(upassword.getPassword());
                String em = email.getText();
                String c = ucity.getText();
                String con = ucontact.getText();

                int i = AddUsersDB.save(Name,pass,em,c,con);
                if(i>0){
                    JOptionPane.showMessageDialog(AddUsers.this, "User added successfully!!");
                    new Welcome();
                    frame.dispose();
                }else{
                    JOptionPane.showMessageDialog(AddUsers.this, "User couldn't be added!! ");
                }
            }
            
        });

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                 new Welcome();
                frame.dispose();
            }
            
        });
        GroupLayout contentPane = new GroupLayout(contentPanel);
        contentPane.setHorizontalGroup(
        contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(contentPane.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(contentPane.createParallelGroup(Alignment.LEADING)
                    .addGroup(contentPane.createSequentialGroup()
                        .addGroup(contentPane.createParallelGroup(Alignment.LEADING)
                            .addComponent(name)
                            .addComponent(password)
                            .addComponent(mail, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                            .addComponent(city, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addComponent(contact, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGap(10)
                        .addGroup(contentPane.createParallelGroup(Alignment.LEADING)
                            .addComponent(uName, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                            .addComponent(upassword, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ucity, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ucontact, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                        .addGap(48))
                    .addGroup(Alignment.TRAILING, contentPane.createSequentialGroup()
                        .addGap(20)
                        .addGroup(contentPane.createParallelGroup(Alignment.TRAILING)
                            .addComponent(mJLabel)
                            .addGroup(contentPane.createSequentialGroup()
                                .addComponent(button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(47)
                                .addComponent(back)))
                        .addGap(100))))
            .addGroup(contentPane.createSequentialGroup()
                .addGap(146)
                .addComponent(mJLabel)
                .addContainerGap(235, Short.MAX_VALUE))
    );
    contentPane.setVerticalGroup(
        contentPane.createParallelGroup(Alignment.TRAILING)
            .addGroup(contentPane.createSequentialGroup()
                .addGap(37)
                .addComponent(mJLabel)
                .addGap(43)
                .addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(upassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28)
                .addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(contact)
                    .addComponent(ucontact, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28)
                .addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(uName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28)
                .addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(mail)
                    .addComponent(ucity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(26)
                .addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(city)
                    .addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
                    .addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addComponent(back))
                .addGap(18)
                .addComponent(mJLabel)
                .addGap(25))
    );
    contentPanel.setLayout(contentPane);
}
}

