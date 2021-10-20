import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
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
    JPanel panel;

    UserOptions(){
        frame1 = new JFrame(); 
        frame1.setTitle("User Login");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(1500,750); 
        frame1.setLayout(null);
        // frame1.setLayout(new FlowLayout(FlowLayout.CENTER,10,10)); 
    
        label = new JLabel();
        label.setBounds(300,90,800,200);
        label.setText("User Login");
        label.setForeground(Color.red);
        label.setFont(new Font("Cascadia Code",Font.BOLD,40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        button1 = new JButton("Show All Books");
        button1.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button1.setBackground(Color.yellow);
        button1.setForeground(Color.red);
        button1.setFocusable(false);

        button2 = new JButton("Borrow Book");
        button2.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button2.setBackground(Color.yellow);
        button2.setForeground(Color.red); 
        button2.setFocusable(false);

        button3 = new JButton("Return Book");
        button3.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button3.setBackground(Color.yellow);
        button3.setForeground(Color.red);
        button3.setFocusable(false);

        button4 = new JButton("Enquiry/Grievance");
        button4.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button4.setBackground(Color.yellow);
        button4.setForeground(Color.red);
        button4.setFocusable(false);

        button5 = new JButton("Logout");
        button5.setFont(new Font("Cascadia Code",Font.BOLD,20));
        button5.setBackground(Color.yellow);
        button5.setForeground(Color.red);
        button5.setFocusable(false);

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

        frame1.add(label);
        frame1.add(panel);
        frame1.getContentPane().setBackground(Color.YELLOW);
        frame1.setVisible(true); 
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button1){
                
            }
        }
}
