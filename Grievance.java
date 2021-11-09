import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Grievance implements ActionListener {

    JFrame frame3 = new JFrame();
    JLabel userlabel = new JLabel("Your Grievance :");
    JLabel hlabel = new JLabel("User Grievance");
    JButton hbutton = new JButton("Back");
    JButton button = new JButton("Submit");
    JButton button1 = new JButton("Reset");
    JTextArea textField = new JTextArea(10,15);
    JScrollPane sp;
    public static String uname;

    Grievance(){ 

        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(500,500);
        frame3.setLayout(null);

        hlabel.setBounds(140,40,250,30);
        hlabel.setFont(new Font("Cascadia Code",Font.BOLD,25));
        hlabel.setForeground(Color.red);

        userlabel.setBounds(50,100,160,25);
        userlabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        userlabel.setForeground(Color.red);

        textField.setBounds(200, 100, 240, 120);
        textField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        textField.setLineWrap(true);
        textField.setForeground(Color.red);
        sp = new JScrollPane(textField,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        hbutton.setBounds(0,0,100,25);
        hbutton.setBackground(Color.red);
        hbutton.setForeground(Color.yellow);
        hbutton.setFont(new Font("Cascadia Code",Font.BOLD,15));
        hbutton.setFocusable(false);
        hbutton.addActionListener(this);

        button.setBounds(145,250,100,25);
        button.setBackground(Color.red);
        button.setForeground(Color.yellow);
        button.setFont(new Font("Cascadia Code",Font.BOLD,15));
        button.setFocusable(false);
        button.addActionListener(this);

        button1.setBounds(255,250,100,25);
        button1.setBackground(Color.red);
        button1.setForeground(Color.yellow);
        button1.setFont(new Font("Cascadia Code",Font.BOLD,15));
        button1.setFocusable(false);
        button1.addActionListener(this);

        frame3.add(hlabel);
        frame3.add(userlabel);
        frame3.add(textField);
        frame3.add(hbutton);
        frame3.add(button);
        frame3.add(button1);
        frame3.getContentPane().setBackground(Color.yellow);
        frame3.add(sp);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1){
            textField.setText("");
        }
        if(e.getSource()==button){
            String user = UserLogin.uname;
            String gr = textField.getText();
            File nwfile = new File("grievance.txt");
            try {
                FileWriter fileWriter = new FileWriter(nwfile,true);
                fileWriter.append("Username:" + user + "\n");
                fileWriter.append(gr + "\n\n");
                fileWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Grievance Recorded", "", JOptionPane.PLAIN_MESSAGE);
        }
        if(e.getSource()==hbutton){
            frame3.dispose();
            new UserOptions();
        }
    }

    public static void main(String[] args) {
        new Grievance();
    }

}
