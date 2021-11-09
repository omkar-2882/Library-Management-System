import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;

public class ShowAllBooks implements ActionListener {

    JFrame frame1;
    JLabel label;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton hbutton = new JButton("User Options");
    JButton hbutton1 = new JButton("Admin Options");
    JPanel panel;

    ShowAllBooks(){
        frame1 = new JFrame(); 
        frame1.setTitle("All Books");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(1500,750); 
        frame1.setLayout(null);
        // frame1.setLayout(new FlowLayout(FlowLayout.CENTER,10,10)); 
    
        label = new JLabel();
        label.setBounds(300,90,800,200);
        label.setText("All Books");
        label.setForeground(Color.red);
        label.setFont(new Font("Cascadia Code",Font.BOLD,40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        hbutton.setBounds(0,0,200,25);
        hbutton.setBackground(Color.red);
        hbutton.setForeground(Color.yellow);
        hbutton.setFont(new Font("Cascadia Code",Font.BOLD,15));
        hbutton.setFocusable(false);
        hbutton.addActionListener(this);

        hbutton1.setBounds(200,0,200,25);
        hbutton1.setBackground(Color.red);
        hbutton1.setForeground(Color.yellow);
        hbutton1.setFont(new Font("Cascadia Code",Font.BOLD,15));
        hbutton1.setFocusable(false);
        hbutton1.addActionListener(this);

        button1 = new JButton("Biography");
        button1.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button1.setBackground(Color.yellow);
        button1.setForeground(Color.red);
        button1.setFocusable(false);
        button1.addActionListener(this);

        button2 = new JButton("Science and Research");
        button2.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button2.setBackground(Color.yellow);
        button2.setForeground(Color.red); 
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3 = new JButton("Health and Fitness");
        button3.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button3.setBackground(Color.yellow);
        button3.setForeground(Color.red);
        button3.setFocusable(false);
        button3.addActionListener(this);

        button4 = new JButton("Politics and Law");
        button4.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button4.setBackground(Color.yellow);
        button4.setForeground(Color.red);
        button4.setFocusable(false);
        button4.addActionListener(this);

        button5 = new JButton("Environment");
        button5.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button5.setBackground(Color.yellow);
        button5.setForeground(Color.red);
        button5.setFocusable(false);
        button5.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(500, 200, 400, 400);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,40));
    
        panel.add(button1);
        panel.add(button2);
        panel.add(button3); 
        panel.add(button4);
        panel.add(button5);

        frame1.add(hbutton);
        frame1.add(hbutton1);
        frame1.add(label);
        frame1.add(panel);
        frame1.getContentPane().setBackground(Color.YELLOW);
        frame1.setVisible(true); 
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==hbutton){
                frame1.dispose();
                new UserOptions();
            }
            if(e.getSource()==hbutton1){
                frame1.dispose();
                new AdminOptions();
            }
            if(e.getSource()==button1){
                new genre("biography.txt");
            }
            if(e.getSource()==button2){
                new genre("science and research.txt");
            }
            if(e.getSource()==button3){
                new genre("health and fitness.txt");
            }
            if(e.getSource()==button4){
                new genre("politics and law.txt");
            }
            if(e.getSource()==button5){
                new genre("environment.txt");
            }
        }
    public static void main(String[] args) {
        new ShowAllBooks();
    }
}
class genre {
    genre(String file){
        JFrame frame2 = new JFrame(""); 
        frame2.setSize(800,600); 

        Object[][] data = new String[0][2];
        String[] column = {"Sr. No.","Book Name"};
        DefaultTableModel model = new DefaultTableModel(data,column);
        try {
            File f = new File("D:\\Library Management Project\\All Books\\"+ file);
            Scanner sc = new Scanner(f);
            for(int i=0;sc.hasNextLine();i++)
            {
                String line = sc.nextLine();
                Object[] newrow = {i+1,line};
                model.addRow(newrow);
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        frame2.getContentPane().setBackground(Color.YELLOW);
        JTable table = new JTable(model);
        table.setBackground(Color.YELLOW);
        table.setForeground(Color.red);
        table.setFont(new Font("Cascadia Code",Font.BOLD,13));
        frame2.add(new JScrollPane(table));
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }
}
