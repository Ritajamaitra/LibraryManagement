import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.AddResult;

public class LoginInfo implements ActionListener{
    JFrame frame = new JFrame();
    static JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    static JTextField userIDField = new JTextField();
    static JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("UserName");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel("Login System");
    JLabel mJLabel  = new JLabel("New User?");
    JButton link = new JButton("Register");
    HashMap<String,String> loginInfo = new HashMap<String, String>();
    LoginInfo (HashMap<String,String> loginInfoOriginal){
        loginInfo = loginInfoOriginal;
        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);
        messageLabel.setBounds(150, 50, 250, 35);
        mJLabel.setBounds(100, 300, 250, 35);
        link.setBounds(225, 300, 100, 25);
        link.setForeground(Color.BLUE);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(mJLabel);
        frame.add(link);
        messageLabel.setFont(new Font("Dancing Script", Font.ITALIC,20));
        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);
        frame.add(userIDField);
        frame.add(userPasswordField);
        loginButton.setBounds(125, 200, 100, 25);
        loginButton.addActionListener((ActionListener) this);
        frame.add(loginButton);
       resetButton.setBounds(225, 200, 100, 25);
        resetButton.addActionListener((ActionListener) this);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource()== loginButton){
            String userId = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            if(loginInfo.containsKey(userId)){
                if(loginInfo.get(userId).equals(password)){
                    JOptionPane.showMessageDialog(loginButton, "You are successfully logged in!!");
                    new Welcome();

                } else{
                    JOptionPane.showMessageDialog(loginButton, " Passwors Incorrect...Login Unsuccessful!!");
                }
        if(e.getSource()==link){
            AddUsers.au(new String[]{});

        }
            
        }else{
            JOptionPane.showMessageDialog(loginButton, "Not yet registered... create new account");
        }
        
    }
    
}
}  