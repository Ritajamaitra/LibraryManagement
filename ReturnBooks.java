import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
public class ReturnBooks extends JFrame{
    static ReturnBooks frame;
    private JPanel contentPanel;
    private JTextField idLibrary;
    private JTextField studentId;

    public static void rB(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    frame = new ReturnBooks();
                    frame.setVisible(true);
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
            }
        });
    }

    public ReturnBooks(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 510, 410);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);

        JLabel mssgLabel = new JLabel("Return Books");
        
        JLabel idLib = new JLabel("ID Library : ");
        JLabel stuId = new JLabel("Student ID : ");

        idLibrary = new JTextField();
        idLibrary.setColumns(10);

        studentId = new JTextField();
        studentId.setColumns(10);

        JButton button = new JButton("Return Book");
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String idLibr = idLibrary.getText();
                int Student = Integer.parseInt(studentId.getText());
                int i = ReturnBooksDB.delete(idLibr,Student);
                if(i>0){
                    JOptionPane.showMessageDialog(ReturnBooks.this, "Book returned successfully!!");
                    new Welcome();
                    frame.dispose();
                }else{
                    JOptionPane.showConfirmDialog(ReturnBooks.this, "Book Could not be returned!!");
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
        JLabel label = new JLabel("Note : Check the book properly!");
        label.setForeground(Color.RED);
        GroupLayout conPan = new GroupLayout(contentPanel);

conPan.setHorizontalGroup(
    conPan.createParallelGroup(Alignment.LEADING)
        .addGroup(conPan.createSequentialGroup()
            .addContainerGap(10,Short.MAX_VALUE)
            .addGroup(conPan.createParallelGroup(Alignment.LEADING)
                .addComponent(idLib)
                .addComponent(stuId)
            .addGap(56)
            .addGroup(conPan.createParallelGroup(Alignment.LEADING)
                .addComponent(idLibrary, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                .addComponent(studentId, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
            .addGap(56))
        .addGroup(conPan.createSequentialGroup()
            .addContainerGap(210, Short.MAX_VALUE)
            .addComponent(button, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
            .addGap(176))
        .addGroup(conPan.createSequentialGroup()
            .addContainerGap(205, Short.MAX_VALUE)
            .addComponent(button)
            .addGap(187))
        .addGroup(conPan.createSequentialGroup()
            .addGap(19)
            .addComponent(mssgLabel)
            .addContainerGap(294, Short.MAX_VALUE))
        .addGroup(conPan.createSequentialGroup()
            .addContainerGap(355, Short.MAX_VALUE)
            .addComponent(back)
            .addGap(46)))
);
conPan.setVerticalGroup(
    conPan.createParallelGroup(Alignment.LEADING)
        .addGroup(conPan.createSequentialGroup()
            .addContainerGap()
            .addComponent(button)
            .addGap(32)
            .addGroup(conPan.createParallelGroup(Alignment.BASELINE)
                .addComponent(studentId)
                .addComponent(studentId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(34)
            .addGroup(conPan.createParallelGroup(Alignment.BASELINE)
                .addComponent(idLib)
                .addComponent(idLibrary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(29)
            .addComponent(button, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
            .addGap(23)
            .addComponent(back)
            .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
            .addComponent(mssgLabel)
            .addGap(72))
);
contentPanel.setLayout(conPan);
}

}
