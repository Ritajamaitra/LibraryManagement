import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
public class issueBook extends JFrame {
    static issueBook frame;
    private JPanel contentPanel;
    private JTextField idLibrary;
    private JTextField studentId;
    private JTextField studentName;
    private JTextField studentContact;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    frame = new issueBook();
                    frame.setVisible(true);
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
            }
        });
    }
    public issueBook(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);

        JLabel mssgLabel = new JLabel("Issue Book");
        JLabel idLibraryJLabel = new JLabel("Id Library : ");
        JLabel studentIdJLabel = new JLabel("Student Id : ");
        JLabel studentNameJLabel = new JLabel("Student Name : ");
        JLabel studentContactJLabel = new JLabel("Student Id : ");
        
        idLibrary = new JTextField();
        idLibrary.setColumns(10);

        studentId = new JTextField();
        studentId.setColumns(10);

        studentName = new JTextField();
        studentName.setColumns(10);

        studentContact = new JTextField();
        studentContact.setColumns(10);

        JButton button = new JButton("Issue Book");
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String idLib = idLibrary.getText();
                int student = Integer.parseInt(studentId.getText());
                String studentN = studentName.getText();
                String studentC = studentContact.getText();

                if(issueBookDB.checkBook(idLib)){
                    int i = issueBookDB.save(idLib,student,studentC,studentN);
                    if(i>0){
                        JOptionPane.showMessageDialog(issueBook.this, "Book issued successfully!!");
                        Welcome.main(new String[]{});
                        frame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(issueBook.this, "Sorry!! Unable to issue!!");
                    }
                }else{
                    JOptionPane.showMessageDialog(issueBook.this, "Library Id does not exist!!");
                }
                }
            });
            JButton back = new JButton("Back");
            back.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    Welcome.main(new String[]{});
                    frame.dispose();
                }
                
            });
            JLabel mLabel = new JLabel("Note : Please check the student ID very carefully before issuing the book!!");
            mLabel.setForeground(Color.RED);
            GroupLayout contentPane = new GroupLayout(contentPanel);
		    contentPane.setHorizontalGroup(
			contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(contentPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(contentPane.createSequentialGroup()
							.addGroup(contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(idLibraryJLabel)
								.addComponent(studentIdJLabel)
								.addComponent(studentNameJLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(studentContactJLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(idLibrary, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(studentId, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(studentName, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(studentContact, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
							.addGap(48))
						.addGroup(Alignment.TRAILING, contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(mLabel)
								.addGroup(contentPane.createSequentialGroup()
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addComponent(back)))
							.addGap(100))))
				.addGroup(contentPane.createSequentialGroup()
					.addGap(146)
					.addComponent(mssgLabel)
					.addContainerGap(235, Short.MAX_VALUE))
		);
		contentPane.setVerticalGroup(
			contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(mssgLabel)
					.addGap(43)
					.addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(idLibraryJLabel)
						.addComponent(studentId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentIdJLabel)
						.addComponent(idLibrary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentNameJLabel)
						.addComponent(studentName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentContactJLabel)
						.addComponent(studentContact, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(back))
					.addGap(18)
					.addComponent(mLabel)
					.addGap(25))
		);
	    contentPanel.setLayout(contentPane);
	}
}

