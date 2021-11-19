import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class UserLogin implements ActionListener {

    JFrame frame3 = new JFrame();
    JLabel userlabel = new JLabel("Username");
    JLabel passlabel = new JLabel("Password");
    JLabel hlabel = new JLabel("User Login");
    JButton hbutton = new JButton("Home");
    JButton button = new JButton("Login");
    JButton button1 = new JButton("Reset");
    JTextField textField = new JTextField();
    JPasswordField passField = new JPasswordField();
    public static String uname;

    UserLogin(){ 

        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(500,500);
        frame3.setLayout(null);

        hlabel.setBounds(170,40,200,30);
        hlabel.setFont(new Font("Cascadia Code",Font.BOLD,25));
        hlabel.setForeground(Color.red);

        userlabel.setBounds(80,130,90,25);
        userlabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        userlabel.setForeground(Color.red);
 
        passlabel.setBounds(80,180,90,25);
        passlabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        passlabel.setForeground(Color.red);

        textField.setBounds(200, 130, 200, 25);
        textField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        textField.setForeground(Color.red);
        passField.setBounds(200, 180, 200, 25);
        passField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        passField.setForeground(Color.red);

        hbutton.setBounds(0,0,100,25);
        hbutton.setBackground(Color.red);
        hbutton.setForeground(Color.yellow);
        hbutton.setFont(new Font("Cascadia Code",Font.BOLD,15));
        hbutton.setFocusable(false);
        hbutton.addActionListener(this);

        button.setBounds(145,230,100,25);
        button.setBackground(Color.red);
        button.setForeground(Color.yellow);
        button.setFont(new Font("Cascadia Code",Font.BOLD,15));
        button.setFocusable(false);
        button.addActionListener(this);

        button1.setBounds(255,230,100,25);
        button1.setBackground(Color.red);
        button1.setForeground(Color.yellow);
        button1.setFont(new Font("Cascadia Code",Font.BOLD,15));
        button1.setFocusable(false);
        button1.addActionListener(this);

        frame3.add(hlabel);
        frame3.add(userlabel);
        frame3.add(passlabel);
        frame3.add(textField);
        frame3.add(passField);
        frame3.add(hbutton);
        frame3.add(button);
        frame3.add(button1);
        frame3.getContentPane().setBackground(Color.yellow);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1){
            textField.setText("");
            passField.setText("");
        }
        if(e.getSource()==button){
            uname = textField.getText();
            String pass = passField.getText();
            if(uname.equals("") || pass.equals("")) 
                JOptionPane.showMessageDialog(null, "Please fill all fields!", "Empty Fields!", JOptionPane.ERROR_MESSAGE);
            if(LibraryManagement3.checkDetails(uname, pass) == 0){
                JOptionPane.showMessageDialog(null, "Username or Password Incorrect!", "Login failed", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Successfully Login to your account", "Login Successfully", JOptionPane.PLAIN_MESSAGE);
                frame3.dispose();
                new UserOptions();
            }
        }
        if(e.getSource()==hbutton){
            frame3.dispose();
            new Homeframe();
        }
    }
    public static void main(String[] args) {
        new UserLogin();
    }

}
