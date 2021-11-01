import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;

class Homeframe implements ActionListener{

    JFrame frame;
        JLabel label;
        JButton button1;
        JButton button2;
        JButton button3;
        JPanel panel;
        JPanel panel1;

    Homeframe(){
        frame = new JFrame(); 
        frame.setTitle("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,750); 
        frame.setLayout(null);
        // frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10)); 
    
        label = new JLabel();
        label.setBounds(300,90,800,200);
        label.setText("Welcome to PVPPCOE Library");
        label.setForeground(Color.red);
        label.setFont(new Font("Cascadia Code",Font.BOLD,40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        button1 = new JButton("User Login");
        button1.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button1.setBackground(Color.yellow);
        button1.setForeground(Color.red);
        button1.setFocusable(false);
        button1.addActionListener(this);

        button2 = new JButton("Admin Login");
        button2.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button2.setBackground(Color.yellow);
        button2.setForeground(Color.red);
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3 = new JButton("New User");
        button3.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button3.setBackground(Color.yellow);
        button3.setForeground(Color.red);
        button3.setFocusable(false);
        button3.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(500, 200, 400, 300);
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,50,40));
    
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        frame.add(label);
        frame.add(panel);
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setVisible(true); 
    }

        @Override 
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button1){
                frame.dispose();
                new UserLogin();
            }
            if(e.getSource()==button2){
                frame.dispose();
                new AdminLogin();
            }
            if(e.getSource()==button3){
                frame.dispose();
                new NewUser();
            }
        }
}
public class HomePage {
    public static void main(String[] args) {
        new Homeframe();
    }
}
