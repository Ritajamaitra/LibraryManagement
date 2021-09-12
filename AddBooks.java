import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.*;
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

    public static void ab(String[] args) {
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
        setBounds(100, 100, 650, 700);
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
                    new Welcome();
                    frame.dispose();
                    
                }else{
                    JOptionPane.showMessageDialog(AddBooks.this,"Sorry, unable to save!");
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
								.addComponent(idLib)
								.addComponent(aName)
								.addComponent(bName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(g, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(i, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(q, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ad, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(idLibrary, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(authorName, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(genre, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(quantity, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(issue, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(adate, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
							.addGap(48))
						.addGroup(Alignment.TRAILING, contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(mssgLabel)
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
						.addComponent(idLib)
						.addComponent(authorName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
                    .addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(q)
						.addComponent(quantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
                    .addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(i)
						.addComponent(issue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
                    .addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ad)
						.addComponent(adate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(aName)
						.addComponent(idLibrary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(bName)
						.addComponent(bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(g)
						.addComponent(genre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(back))
					.addGap(18)
					.addComponent(mssgLabel)
					.addGap(25))
		);
	    contentPanel.setLayout(contentPane);
	}
}

