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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.File;

public class BorrowBook implements ActionListener {

    JFrame frame3 = new JFrame();
    JLabel userlabel = new JLabel("Book Name");
    JLabel passlabel = new JLabel("Date of Issue");
    JLabel hlabel = new JLabel("Issue Book");
    JButton hbutton = new JButton("Back");
    JButton button = new JButton("Submit");
    JButton button1 = new JButton("Reset");
    JTextField textField = new JTextField();
    JTextField passField = new JTextField();
    public static Scanner sc1 = new Scanner(System.in);
    public String genre;
    public static String idt;
    File f1 = new File("D:\\Library Management Project\\IssueBooks.txt");
    File pbf = new File("D:\\Library Management Project\\Previous Books.txt");

    BorrowBook(String type) {
        genre = type;
        frame3.setSize(500, 500);
        frame3.setLayout(null);

        hlabel.setBounds(170, 40, 200, 30);
        hlabel.setFont(new Font("Cascadia Code", Font.BOLD, 25));
        hlabel.setForeground(Color.red);

        userlabel.setBounds(50, 100, 90, 25);
        userlabel.setFont(new Font("Cascadia Code", Font.BOLD, 15));
        userlabel.setForeground(Color.red);

        passlabel.setBounds(50, 150, 130, 25);
        passlabel.setFont(new Font("Cascadia Code", Font.BOLD, 15));
        passlabel.setForeground(Color.red);

        textField.setBounds(200, 100, 200, 25);
        textField.setFont(new Font("Cascadia Code", Font.BOLD, 15));
        textField.setForeground(Color.red);
        passField.setBounds(200, 150, 200, 25);
        passField.setFont(new Font("Cascadia Code", Font.BOLD, 15));
        passField.setForeground(Color.red);

        hbutton.setBounds(0, 0, 100, 25);
        hbutton.setBackground(Color.red);
        hbutton.setForeground(Color.yellow);
        hbutton.setFont(new Font("Cascadia Code", Font.BOLD, 15));
        hbutton.setFocusable(false);
        hbutton.addActionListener(this);

        button.setBounds(145, 200, 100, 25);
        button.setBackground(Color.red);
        button.setForeground(Color.yellow);
        button.setFont(new Font("Cascadia Code", Font.BOLD, 15));
        button.setFocusable(false);
        button.addActionListener(this);

        button1.setBounds(255, 200, 100, 25);
        button1.setBackground(Color.red);
        button1.setForeground(Color.yellow);
        button1.setFont(new Font("Cascadia Code", Font.BOLD, 15));
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

        if (e.getSource() == button1) {
            textField.setText("");
            passField.setText("");
        }
        if (e.getSource() == button) {
            String user = UserLogin.uname;
            String bname = textField.getText();
            LocalDateTime dt = LocalDateTime.now();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/LL/yy");
            String time = dt.format(df);
            idt = passField.getText();
            if (!(idt.equals(time))) {
                JOptionPane.showMessageDialog(null, "Enter Today's date", "Incorrect Date", JOptionPane.ERROR_MESSAGE);
            } else {
                int ind = genre.indexOf('.');
                String ngenre = genre.substring(0, ind);
                File f2 = new File("D:\\Library Management Project\\All Books2\\" + genre);
                try {
                    Scanner sc = new Scanner(f2);
                    StringBuffer buffer = new StringBuffer();
                    while (sc.hasNextLine()) {
                        buffer.append(sc.nextLine() + System.lineSeparator());
                    }
                    String fileContents = buffer.toString();
                    if (fileContents.contains(bname)) { 
                        fileContents = fileContents.replaceFirst(bname, "sold");
                        try {
                            FileWriter fw1 = new FileWriter(f1, true);
                            FileWriter fw3 = new FileWriter(pbf, true);
                            fw1.append("'" + bname + "', " + ngenre + ": issued to " + user + " on " + idt + "\n");
                            fw1.close();
                            fw3.append("'" + bname + "', " + ngenre + ": issued to " + user + " on " + idt + "\n");
                            fw3.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }

                        try {
                            FileWriter fw2 = new FileWriter(f2);
                            fw2.append(fileContents);
                            fw2.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "Book Issued to you,Please return it in time", null,
                                JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry Book is not available for now", null,
                                JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (e.getSource() == hbutton) {
            frame3.dispose();
            new Allgenre();
        }
    }

    public static void main(String[] args) {
        new Allgenre();
    }

}

class Allgenre implements ActionListener {

    JFrame frame1;
    JLabel label;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton hbutton = new JButton("Back");
    JPanel panel;

    Allgenre() {
        frame1 = new JFrame();
        frame1.setTitle("All Books");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(1380, 750);
        frame1.setLayout(null);

        label = new JLabel();
        label.setBounds(300, 90, 800, 200);
        label.setText("Select Book Genre");
        label.setForeground(Color.red);
        label.setFont(new Font("Cascadia Code", Font.BOLD, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        hbutton.setBounds(0, 0, 100, 25);
        hbutton.setBackground(Color.red);
        hbutton.setForeground(Color.yellow);
        hbutton.setFont(new Font("Cascadia Code", Font.BOLD, 15));
        hbutton.setFocusable(false);
        hbutton.addActionListener(this);

        button1 = new JButton("Biography");
        button1.setFont(new Font("Cascadia Code", Font.BOLD, 20));
        button1.setBackground(Color.yellow);
        button1.setForeground(Color.red);
        button1.setFocusable(false);
        button1.addActionListener(this);

        button2 = new JButton("Science and Research");
        button2.setFont(new Font("Cascadia Code", Font.BOLD, 20));
        button2.setBackground(Color.yellow);
        button2.setForeground(Color.red);
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3 = new JButton("Health and Fitness");
        button3.setFont(new Font("Cascadia Code", Font.BOLD, 20));
        button3.setBackground(Color.yellow);
        button3.setForeground(Color.red);
        button3.setFocusable(false);
        button3.addActionListener(this);

        button4 = new JButton("Politics and Law");
        button4.setFont(new Font("Cascadia Code", Font.BOLD, 20));
        button4.setBackground(Color.yellow);
        button4.setForeground(Color.red);
        button4.setFocusable(false);
        button4.addActionListener(this);

        button5 = new JButton("Environment");
        button5.setFont(new Font("Cascadia Code", Font.BOLD, 20));
        button5.setBackground(Color.yellow);
        button5.setForeground(Color.red);
        button5.setFocusable(false);
        button5.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(500, 200, 400, 400);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));

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
        if (e.getSource() == button1) {
            new BorrowBook("biography.txt");
        }
        if (e.getSource() == button2) {
            new BorrowBook("science and research.txt");
        }
        if (e.getSource() == button3) {
            new BorrowBook("health and fitness.txt");
        }
        if (e.getSource() == button4) {
            new BorrowBook("politics and law.txt");
        }
        if (e.getSource() == button5) {
            new BorrowBook("environment.txt");
        }
        if (e.getSource() == hbutton) {
            frame1.dispose();
            new UserOptions();
        }
    }
}
