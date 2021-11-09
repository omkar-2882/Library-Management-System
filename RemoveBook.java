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


public class RemoveBook implements ActionListener {

    JFrame frame3 = new JFrame();
    JLabel userlabel = new JLabel("Book Name");
    JLabel hlabel = new JLabel("Remove Book");
    JButton hbutton = new JButton("Back");
    JButton button = new JButton("Remove");
    JButton button1 = new JButton("Reset");
    JTextField textField = new JTextField();
    public static Scanner sc1 = new Scanner(System.in);
    public static Scanner sc2 = new Scanner(System.in);
    public String genre;
    File f1 = new File("D:\\Library Management Project\\IssueBooks.txt");
    File pbf = new File("D:\\Library Management Project\\Previous Books.txt");

    RemoveBook(String type){ 
        genre = type;
        frame3.setSize(500,500);
        frame3.setLayout(null);

        hlabel.setBounds(170,40,200,30);
        hlabel.setFont(new Font("Cascadia Code",Font.BOLD,25));
        hlabel.setForeground(Color.red);

        userlabel.setBounds(50,120,90,25);
        userlabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        userlabel.setForeground(Color.red);

        textField.setBounds(200, 120, 200, 25);
        textField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        textField.setForeground(Color.red);

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
        frame3.add(hbutton);
        frame3.add(button);
        frame3.add(textField);
        frame3.add(button1);
        frame3.getContentPane().setBackground(Color.yellow);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1){
            textField.setText("");
        }
        if(e.getSource()==button){
            String rb_name = textField.getText();
            File f2 = new File("D:\\Library Management Project\\All Books2\\"+ genre);
            File f5 = new File("D:\\Library Management Project\\All Books\\"+ genre);
            try {
                Scanner sc2 = new Scanner(f5);
                Scanner sc3 = new Scanner(f2);
                StringBuffer buffer1 = new StringBuffer();
                StringBuffer buffer2 = new StringBuffer();
                while (sc2.hasNextLine()) {
                    buffer1.append(sc2.nextLine() + System.lineSeparator());
                }
                while (sc3.hasNextLine()) {
                    buffer2.append(sc3.nextLine() + System.lineSeparator());
                }
                String fileContents1 = buffer1.toString();
                String fileContents2 = buffer2.toString();
                if (fileContents1.contains(rb_name) && fileContents2.contains(rb_name)){
                    fileContents1 = fileContents1.replaceFirst("\n"+rb_name, "");
                    fileContents1 = fileContents1.trim();
                    fileContents2 = fileContents2.replaceFirst("\n"+rb_name, "");
                    fileContents2 = fileContents2.trim();
                    try {
                        FileWriter fw2 = new FileWriter(f5);
                        fw2.append(fileContents1);
                        fw2.close();
                        FileWriter fw3 = new FileWriter(f2);
                        fw3.append(fileContents2);
                        fw3.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Book Removed Successfully!", null, JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Book doesn't exist", null, JOptionPane.PLAIN_MESSAGE);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        if(e.getSource()==hbutton){
            frame3.dispose();
            new Allgenre4();
        }
    }
    public static void main(String[] args) {
        new Allgenre4();
    }

}

class Allgenre4 implements ActionListener {

    JFrame frame1;
    JLabel label;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton hbutton = new JButton("Back");
    JPanel panel;

    Allgenre4(){
            frame1 = new JFrame();  
            frame1.setTitle("All Books");
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setSize(1500,750); 
            frame1.setLayout(null);
        
            label = new JLabel();
            label.setBounds(300,90,800,200);
            label.setText("All Books");
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
                new RemoveBook("biography.txt");
            }
            if(e.getSource()==button2){
                new RemoveBook("science and research.txt");
            }
            if(e.getSource()==button3){
                new RemoveBook("health and fitness.txt");
            }
            if(e.getSource()==button4){
                new RemoveBook("politics and law.txt");
            }
            if(e.getSource()==button5){
                new RemoveBook("environment.txt");
            }
            if(e.getSource()==hbutton){
                frame1.dispose();
                new AdminOptions();
            }
        }
}
