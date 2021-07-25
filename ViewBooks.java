import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewBooks {
    ViewBooks(){
        JLabel label = new JLabel("BOOKS AVAILABLE");
        JFrame frame = new JFrame();
        String data[][] = {{"ID(Books)","BOOK NAME","GENRE","AUTHOR NAME","PRICE"},{"10000","The Odyssey","TRAGEDY","HOMER","95"},{"10001","Jim Corbett","AUTOBIOGRAPHY","Jim Corbett","499"},
                           {"10002","Alice in Wonderland","FICTION","Lewis Caroll","250"},{"10003","Adventures of Tom Sawyer","FICTION","Mark Twain","150"},
                           {"10004","The Adventures of Sherlock Holmes","FICTION","Sir Aurthur Conan Doyal","190"}};
        String column[] = {"ID(Books)","BOOK NAME","GENRE","AUTHOR NAME","PRICE"};
        label.setBounds(75, 25, 200, 75);
        JTable table = new JTable(data, column);
        table.setBounds(20, 125, 800, 400);
        JScrollPane sp = new JScrollPane(table);
        frame.add(label);
        frame.add(table);
        frame.add(sp);
        frame.setLayout(null);
        frame.setSize(800,800);
        frame.setFocusable(false);
        frame.setVisible(true);
    }
    
}
