import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowUserGrievance extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JLabel hlabel = new JLabel("User Grievances/Request");
    JButton hbutton = new JButton("Back");
    public String fileContents = "";
    ShowUserGrievance(){
        frame.setSize(500,500);
        frame.setLayout(null);
        
        hbutton.setBounds(0,0,100,25);
        hbutton.setBackground(Color.red);
        hbutton.setForeground(Color.yellow);
        hbutton.setFont(new Font("Cascadia Code",Font.BOLD,15));
        hbutton.setFocusable(false);
        hbutton.addActionListener(this);

        hlabel.setBounds(58,30,400,30);
        hlabel.setFont(new Font("Cascadia Code",Font.BOLD,25));
        hlabel.setForeground(Color.red);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.white);
        redPanel.setBounds(45,80,400,360);
        redPanel.setLayout(new FlowLayout());  

        File myFile = new File("grievance.txt");
        if(myFile.length() == 0){
            System.out.println("No Grievance found");
        }
        fileContents = fileContents.concat("<html>");
        try {
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                fileContents = fileContents.concat(line + "<br>");
            }
            fileContents = fileContents.concat("</html>");
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fileContents = fileContents.replace("Username", "\n==> Username");
        label.setBounds(20,50,200,200);
        label.setText(fileContents);
        label.setFont(new Font("Cascadia Code",Font.BOLD,15));
        label.setForeground(Color.red);
        redPanel.add(label);
        
        frame.add(hbutton);
        frame.add(redPanel);
        frame.add(hlabel);
        frame.getContentPane().setBackground(Color.yellow);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new ShowUserGrievance();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==hbutton){
            frame.dispose();
            new AdminOptions();
        }        
    }
}
