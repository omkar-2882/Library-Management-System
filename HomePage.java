import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.BorderFactory;

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
        JLabel bg;
        ImageIcon img = new ImageIcon("bgbooks.jpg");

    Homeframe(){
        frame = new JFrame(); 
        frame.setTitle("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300,750); 
        frame.setLayout(null);

        bg =  new JLabel("");
        bg.setOpaque(true);
        bg.setBounds(0,0,1300,750);
        bg.setHorizontalAlignment(JLabel.CENTER);
        bg.setIcon(img);

        label = new JLabel();
        label.setBounds(250,90,800,70);
        label.setText("Welcome to PVPPCOE Library");
        label.setForeground(Color.white);
        label.setBackground(new Color(56,172,236));
        label.setBackground(Color.DARK_GRAY);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        label.setOpaque(true);
        label.setFont(new Font("Cascadia Code",Font.BOLD,40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        button1 = new JButton("User Login");
        button1.setOpaque(true);
        button1.setPreferredSize(new Dimension(200,70));
        button1.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button1.setBackground(Color.cyan);
        button1.setForeground(Color.DARK_GRAY);
        button1.setFocusable(false);
        button1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5, true));
        button1.addActionListener(this);

        button2 = new JButton("Admin Login");
        button2.setOpaque(true);
        button2.setPreferredSize(new Dimension(200,70));
        button2.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button2.setBackground(Color.cyan);
        button2.setForeground(Color.DARK_GRAY);
        button2.setFocusable(false);
        button2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5, true));
        button2.addActionListener(this);

        button3 = new JButton("New User");
        button3.setOpaque(true);
        button3.setPreferredSize(new Dimension(200,70));
        button3.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button3.setBackground(Color.cyan);
        button3.setForeground(Color.DARK_GRAY);
        button3.setFocusable(false);
        button3.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5, true));
        button3.addActionListener(this);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setBounds(280, 250, 750, 300);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,70,40));
    
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        JLayeredPane lp = new JLayeredPane();
        lp.setBounds(0,0,1385,750);
        lp.add(bg,Integer.valueOf(0));
        lp.add(label,Integer.valueOf(2));
        lp.add(panel,Integer.valueOf(1));
        
        
        frame.add(lp);
        frame.setLocationRelativeTo(null);
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

