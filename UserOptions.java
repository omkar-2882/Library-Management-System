import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class UserOptions implements ActionListener {

    JFrame frame1;
    JLabel label;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JPanel panel;
    File f1 = new File("D:\\Library Management Project\\IssueBooks.txt");
    public int f = 0;

    UserOptions(){
        
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/LL/yy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/LL/yy");
        String time = dt.format(df);
        long diff = 0;
        try {
            Scanner sc = new Scanner(f1);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.contains(UserLogin.uname)){
                    int i = line.indexOf('/');
                    int j = line.indexOf(',');
                    String idt2 = line.substring(i-2);
                    String bk = line.substring(0,j);
                    try {
                        Date d1 = sdf.parse(idt2);
                        Date d2 = sdf.parse(time);
                        if(idt2.equals(time)) {
                            int f = 1;}
                        diff = ((d2.getTime() - d1.getTime())/(1000*60*60*24))%365;
                    } catch (ParseException e) { 
                        e.printStackTrace();
                    }
                    if(diff<=5)
                        JOptionPane.showMessageDialog(null, "Please return "+bk+" book in time\nthat issued to you on "+idt2+" "+(5-diff)+" days remaining.", "Gentle Reminder", JOptionPane.PLAIN_MESSAGE);
                    else if(diff>5 && f!=1)
                        JOptionPane.showMessageDialog(null, "Due Date exceeded,\nYou have to pay fine else your account will be blocked", "Gentle Reminder", JOptionPane.WARNING_MESSAGE);

                }

            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        frame1 = new JFrame(); 
        frame1.setTitle("User Login");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(1500,750); 
        frame1.setLayout(null);
    
        label = new JLabel();
        label.setBounds(300,90,800,200);
        label.setText("User Options");
        label.setForeground(Color.red);
        label.setFont(new Font("Cascadia Code",Font.BOLD,40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        button1 = new JButton("Show All Books");
        button1.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button1.setBackground(Color.yellow);
        button1.setForeground(Color.red);
        button1.setFocusable(false);
        button1.addActionListener(this);

        button2 = new JButton("Borrow Book");
        button2.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button2.setBackground(Color.yellow);
        button2.setForeground(Color.red); 
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3 = new JButton("Return Book");
        button3.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button3.setBackground(Color.yellow);
        button3.setForeground(Color.red);
        button3.setFocusable(false);
        button3.addActionListener(this);

        button4 = new JButton("Enquiry/Grievance/Request");
        button4.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button4.setBackground(Color.yellow);
        button4.setForeground(Color.red);
        button4.setFocusable(false);
        button4.addActionListener(this);

        button6 = new JButton("Show Previous Book");
        button6.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button6.setBackground(Color.yellow);
        button6.setForeground(Color.red);
        button6.setFocusable(false);
        button6.addActionListener(this);

        button5 = new JButton("Logout");
        button5.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button5.setBackground(Color.yellow);
        button5.setForeground(Color.red);
        button5.setFocusable(false);
        button5.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(500, 230, 400, 400);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,30));
    
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button6);
        panel.add(button5);

        frame1.add(label);
        frame1.add(panel);
        frame1.getContentPane().setBackground(Color.YELLOW);
        frame1.setVisible(true); 
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button1){
                frame1.dispose();
                new ShowAllBooks(true);
            }
            if(e.getSource()==button2){
                frame1.dispose();
                new Allgenre();
            }
            if(e.getSource()==button3){
                frame1.dispose();
                new Allgenre2();
            }
            if(e.getSource()==button4){
                frame1.dispose();
                new Grievance();
            }
            if(e.getSource()==button5){
                frame1.dispose();
                new Homeframe();
            }
            if(e.getSource()==button6){
                // frame1.dispose();
                new ShowPreviousBook(true);
            }
        }
        public static void main(String[] args) {
            new UserOptions();
        }
}
