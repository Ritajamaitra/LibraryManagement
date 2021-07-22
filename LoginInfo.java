import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.FontFamilyAction;



import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.font.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.color.*;
public class LoginInfo implements ActionListener{
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("UserName");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel("Login System");
    HashMap<String,String> loginInfo = new HashMap<String, String>();
    LoginInfo (HashMap<String,String> loginInfoOriginal){
        loginInfo = loginInfoOriginal;
        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);
        messageLabel.setBounds(125, 250, 250, 35);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
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
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful");
                    Welcome welcome = new Welcome();

                } else{
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Wrong Password");
                }
              }  else{
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Login Unsuccessful");
                }
            
        }
        
    }
    
    
}
