import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class NewUser implements ActionListener {

    JFrame frame3 = new JFrame();
    JLabel namelabel = new JLabel("Name");
    JLabel phlabel = new JLabel("Phone No.");
    JLabel Ulabel = new JLabel("Set Username");
    JLabel Plabel = new JLabel("Set Password");
    JLabel adlabel = new JLabel("Address");
    JLabel hlabel = new JLabel("New User Registration");
    JButton hbutton = new JButton("Home");
    JButton button = new JButton("Submit");
    JButton button1 = new JButton("Reset");
    JTextField textField = new JTextField();
    JTextField UField = new JTextField();
    JTextField phField = new JTextField();
    JTextField adField = new JTextField();
    JPasswordField passField = new JPasswordField();

    NewUser(){ 

        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(500,500);
        frame3.setLayout(null);

        hlabel.setBounds(80,40,350,30);
        hlabel.setFont(new Font("Cascadia Code",Font.BOLD,25));
        hlabel.setForeground(Color.red);

        namelabel.setBounds(80,100,90,25);
        namelabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        namelabel.setForeground(Color.red);

        phlabel.setBounds(80,150,90,25);
        phlabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        phlabel.setForeground(Color.red);

        Ulabel.setBounds(80,200,120,25);
        Ulabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        Ulabel.setForeground(Color.red);

        Plabel.setBounds(80,250,120,25);
        Plabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        Plabel.setForeground(Color.red);

        adlabel.setBounds(80,300,120,25);
        adlabel.setFont(new Font("Cascadia Code",Font.BOLD,15));
        adlabel.setForeground(Color.red);

        textField.setBounds(200, 100, 200, 25);
        textField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        textField.setForeground(Color.red);

        phField.setBounds(200, 150, 200, 25);
        phField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        phField.setForeground(Color.red);

        UField.setBounds(200, 200, 200, 25);
        UField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        UField.setForeground(Color.red);
        
        passField.setBounds(200, 250, 200, 25);
        passField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        passField.setForeground(Color.red);
        
        adField.setBounds(200, 300, 200, 25);
        adField.setFont(new Font("Cascadia Code",Font.BOLD,15));
        adField.setForeground(Color.red);

        hbutton.setBounds(0,0,100,25);
        hbutton.setBackground(Color.red);
        hbutton.setForeground(Color.yellow);
        hbutton.setFont(new Font("Cascadia Code",Font.BOLD,15));
        hbutton.setFocusable(false);
        hbutton.addActionListener(this);

        button.setBounds(145,350,100,25);
        button.setBackground(Color.red);
        button.setForeground(Color.yellow);
        button.setFont(new Font("Cascadia Code",Font.BOLD,15));
        button.setFocusable(false);
        button.addActionListener(this);

        button1.setBounds(255,350,100,25);
        button1.setBackground(Color.red);
        button1.setForeground(Color.yellow);
        button1.setFont(new Font("Cascadia Code",Font.BOLD,15));
        button1.setFocusable(false);
        button1.addActionListener(this);

        frame3.add(hlabel);
        frame3.add(namelabel);
        frame3.add(phlabel);
        frame3.add(Ulabel);
        frame3.add(Plabel);
        frame3.add(adlabel);
        frame3.add(textField);
        frame3.add(passField);
        frame3.add(phField);
        frame3.add(UField);
        frame3.add(adField);
        frame3.add(hbutton);
        frame3.add(button);
        frame3.add(button1);
        frame3.getContentPane().setBackground(Color.yellow);
        frame3.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1){
            textField.setText("");
            passField.setText("");
        }
        if(e.getSource()==button){
            String name = textField.getText();
            String ph = phField.getText();
            String uname = UField.getText();
            String ad = adField.getText();
            String pass = passField.getText();
            if((uname.length()>10 || pass.length()>10)){
                JOptionPane.showMessageDialog(null, "Username or Password must be atleast 7 characters.", "Some Error Occured", JOptionPane.ERROR_MESSAGE);
            }
            else if(name.equals("") || ph.equals("") || uname.equals("") || pass.equals("") || ad.equals("")){
                JOptionPane.showMessageDialog(null, "Please fill all Fields", "Fields are empty", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                File regfile = new File("D:\\Library Management Project\\Registered Users.txt");
                File userlist = new File("D:\\Library Management Project\\LoginDetails.txt");
                try {
                    FileWriter rfw = new FileWriter(regfile, true);
                    rfw.append("Name: "+name+"\n"+"Phone"+"("+name+"): "+ph+"\n"+"Address"+"("+name+"): "+ad+"\n");
                    rfw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    FileWriter lfw = new FileWriter(userlist, true);
                    lfw.append("\n"+uname+" "+pass);
                    lfw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "User Registration successfully done", "Registered Successfully", JOptionPane.PLAIN_MESSAGE);
                frame3.dispose();
                new Homeframe();
            }
        }
        if(e.getSource()==hbutton){
            frame3.dispose();
            new Homeframe();
        }
    }

}

