import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;


public class ReturnBook implements ActionListener {

    JFrame frame3 = new JFrame();
    JLabel userlabel = new JLabel("Book Name");
    JLabel passlabel = new JLabel("Date of Return");
    JLabel hlabel = new JLabel("Return Book");
    JButton hbutton = new JButton("Home");
    JButton button = new JButton("Submit");
    JButton button1 = new JButton("Reset");
    JTextField textField = new JTextField();
    JTextField passField = new JTextField();
    public static Scanner sc1 = new Scanner(System.in);
    public String genre1;
    File f1 = new File("D:\\Library Management Project\\IssueBooks.txt");
    File pbf = new File("D:\\Library Management Project\\Previous Books.txt");

    ReturnBook(String type){ 
        genre1 = type;
        frame3.setSize(500,500);
        frame3.setLayout(null);

        hlabel.setBounds(170,40,200,30);
        hlabel.setFont(new Font("Cascadia Code",Font.BOLD,25));
        hlabel.setForeground(Color.red);

        userlabel.setBounds(50,100,90,25);
        userlabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        userlabel.setForeground(Color.red);

        passlabel.setBounds(50,150,150,25);
        passlabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        passlabel.setForeground(Color.red);

        textField.setBounds(200, 100, 200, 25);
        textField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        textField.setForeground(Color.red);
        passField.setBounds(200, 150, 200, 25);
        passField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        passField.setForeground(Color.red);

        hbutton.setBounds(0,0,100,25);
        hbutton.setBackground(Color.red);
        hbutton.setForeground(Color.yellow);
        hbutton.setFont(new Font("Cascadia Code",Font.BOLD,15));
        hbutton.setFocusable(false);
        hbutton.addActionListener(this);

        button.setBounds(145,200,100,25);
        button.setBackground(Color.red);
        button.setForeground(Color.yellow);
        button.setFont(new Font("Cascadia Code",Font.BOLD,15));
        button.setFocusable(false);
        button.addActionListener(this);

        button1.setBounds(255,200,100,25);
        button1.setBackground(Color.red);
        button1.setForeground(Color.yellow);
        button1.setFont(new Font("Cascadia Code",Font.BOLD,15));
        button1.setFocusable(false);
        button1.addActionListener(this);

        frame3.add(hlabel);
        frame3.add(userlabel);
        frame3.add(passlabel);
        frame3.add(hbutton);
        frame3.add(button);
        frame3.add(textField);
        frame3.add(passField);
        frame3.add(button1);
        frame3.getContentPane().setBackground(Color.yellow);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String idt1 = null;

        if(e.getSource()==button1){
            textField.setText("");
            passField.setText("");
        }
        if(e.getSource()==button){
            String user = UserLogin.uname;
            String bname = textField.getText();
            String rdt = passField.getText();
            try {
                Scanner sc = new Scanner(pbf);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if(line.contains(user) && line.contains(bname)){
                        int i = line.indexOf('/');
                        idt1 = line.substring(i-2);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            int ind = genre1.indexOf('.');
            String ngenre1 = genre1.substring(0,ind);
            File f3 = new File("D:\\Library Management Project\\All Books2\\"+ genre1);
            try {
                Scanner sc3 = new Scanner(f3);
                Scanner sc4 = new Scanner(f1);
                Scanner sc5 = new Scanner(pbf);
                StringBuffer buffer2 = new StringBuffer();
                StringBuffer buffer3 = new StringBuffer();
                StringBuffer buffer4 = new StringBuffer();
    
                while (sc3.hasNextLine()) {
                    buffer2.append(sc3.nextLine() + System.lineSeparator());
                }
                while (sc4.hasNextLine()) {
                    buffer3.append(sc4.nextLine() + System.lineSeparator());
                }
                while (sc5.hasNextLine()) {
                    buffer4.append(sc5.nextLine() + System.lineSeparator());
                }
    
                String bookContents = buffer2.toString();
                String issueContents = buffer3.toString();
                String prevContents = buffer4.toString();
                issueContents = issueContents.trim();
                prevContents = prevContents.trim();
    
                if (issueContents.contains(bname) && bookContents.contains("sold") && prevContents.contains(bname)) {
                    issueContents = issueContents.replaceAll("'" + bname + "', " + ngenre1 + ": issued to " + user + " on " + idt1,"");
                    prevContents = prevContents.replaceAll("'" + bname + "', " + ngenre1 + ": issued to " + user + " on " + idt1,"'" + bname + "', " + ngenre1 + ": issued to " + user + " on " + idt1 + " Returned on "+rdt+"\n");
                    bookContents = bookContents.replaceFirst("sold", bname);
                    try {
                        FileWriter fw3 = new FileWriter(f1);
                        FileWriter fw4 = new FileWriter(f3);
                        FileWriter fw5 = new FileWriter(pbf);
                        fw3.append(issueContents);
                        fw4.append(bookContents);
                        fw5.append(prevContents);
                        fw3.close();
                        fw4.close();
                        fw5.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Thankyou for returning the book, Keep Reading", null, JOptionPane.PLAIN_MESSAGE);
                }
                
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if(e.getSource()==hbutton){
            frame3.dispose();
            new Homeframe();
        }
    }
    public static void main(String[] args) {
        new Allgenre2();
    }

}

class Allgenre2 implements ActionListener {

    JFrame frame1;
    JLabel label;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton hbutton = new JButton("Back");

    JPanel panel;

    Allgenre2(){
            frame1 = new JFrame();  
            frame1.setTitle("Select Book Genre");
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setSize(1380,750); 
            frame1.setLayout(null);
        
            label = new JLabel();
            label.setBounds(300,90,800,200);
            label.setText("Select Book Genre");
            label.setForeground(Color.red);
            label.setFont(new Font("Cascadia Code",Font.BOLD,40));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.TOP);
    
            hbutton.setBounds(0,0,100,25);
            hbutton.setBackground(Color.red);
            hbutton.setForeground(Color.yellow);
            hbutton.setFont(new Font("Cascadia Code",Font.BOLD,15));
            hbutton.setFocusable(false);
            hbutton.addActionListener(this);
    
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
            frame1.add(label);
            frame1.add(panel);
            frame1.getContentPane().setBackground(Color.YELLOW);
            frame1.setLocationRelativeTo(null);
            frame1.setVisible(true); 
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button1){
                new ReturnBook("biography.txt");
            }
            if(e.getSource()==button2){
                new ReturnBook("science and research.txt");
            }
            if(e.getSource()==button3){
                new ReturnBook("health and fitness.txt");
            }
            if(e.getSource()==button4){
                new ReturnBook("politics and law.txt");
            }
            if(e.getSource()==button5){
                new ReturnBook("environment.txt");
            }
            if(e.getSource()==hbutton){
                frame1.dispose();
                new UserOptions();
            }
        }
}
