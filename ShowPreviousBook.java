import java.io.File;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowPreviousBook extends JFrame implements ActionListener {
    
    JFrame frame2 = new JFrame();
    JLabel label = new JLabel();
    JLabel hlabel = new JLabel("Previous Issued Book");
    JButton hbutton = new JButton("Back");
    JPanel p;
    ShowPreviousBook(Boolean flag){

        hbutton.setBounds(0,0,100,25);
        hbutton.setBackground(Color.red);
        hbutton.setForeground(Color.yellow);
        hbutton.setFont(new Font("Cascadia Code",Font.BOLD,15));
        hbutton.setFocusable(false);
        hbutton.addActionListener(this);

        hlabel.setBounds(300,30,800,200);
        hlabel.setFont(new Font("Cascadia Code",Font.BOLD,25));
        hlabel.setForeground(Color.red);
        hlabel.setHorizontalAlignment(JLabel.CENTER);
        hlabel.setVerticalAlignment(JLabel.TOP);

        frame2 = new JFrame("Previous Issued Books"); 
        frame2.setSize(1385,750); 
        frame2.setLayout(new GridLayout());

        Object[][] data = new String[0][5];
        String[] column = {"Book Name","Genre","Issued to","Issue date","Return date"};
        DefaultTableModel model = new DefaultTableModel(data,column);

        File myFile = new File("Previous Books.txt");
        if(myFile.length() == 0){

        }
        try{
            Scanner sc = new Scanner(myFile);
            for(int i=0;sc.hasNextLine();i++)
            {
                String line = sc.nextLine();
                int a = line.indexOf(",");
                String bkn = line.substring(0, a);
                int b = line.indexOf(":");
                String gen = line.substring(a+1,b);
                String u = line.substring(line.indexOf(" to")+4,line.indexOf("on")-1);
                String isd = line.substring(line.indexOf(" on")+4,line.indexOf(" on")+12);
                String rtd = line.substring(line.lastIndexOf(" "));
                Object[] newrow = {bkn,gen,u,isd,rtd};
                if(flag){
                    if(line.contains("Omkar")){
                        model.addRow(newrow);
                    }
                }
                else{
                    model.addRow(newrow);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        frame2.getContentPane().setBackground(Color.YELLOW);
        JTable table = new JTable(model);
        table.setBounds(0, 50, 1300, 750);
        table.setBackground(Color.YELLOW);
        table.setForeground(Color.red);
        table.setFont(new Font("Cascadia Code",Font.BOLD,13));
        frame2.add(new JScrollPane(table));
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }
    public static void main(String[] args) {
        new ShowPreviousBook(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==hbutton){
            frame2.dispose();
            new UserOptions();
        }        
    }
}
