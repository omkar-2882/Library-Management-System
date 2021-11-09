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

public class ShowPreviousBook extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JLabel hlabel = new JLabel("Previous Issued Book");
    JButton hbutton = new JButton("Back");
    public String fileContents = "";
    ShowPreviousBook(){
        frame.setSize(1385,750);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hbutton.setBounds(0,0,100,25);
        hbutton.setBackground(Color.red);
        hbutton.setForeground(Color.yellow);
        hbutton.setFont(new Font("Cascadia Code",Font.BOLD,15));
        hbutton.setFocusable(false);
        hbutton.addActionListener(this);

        hlabel.setBounds(300,30,800,200);
        hlabel.setFont(new Font("Cascadia Code",Font.BOLD,25));
        hlabel.setForeground(Color.red);
        hlabel.setHorizontalAlignment(JLabel.CENTER);
        hlabel.setVerticalAlignment(JLabel.TOP);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.white);
        redPanel.setBounds(280, 100, 900, 400);
        redPanel.setLayout(new FlowLayout());  

        File myFile = new File("Previous Books.txt");
        if(myFile.length() == 0){

        }
        fileContents = fileContents.concat("<html>");
        try {
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.contains(UserLogin.uname))
                    fileContents = fileContents.concat("==>" + line + "<br>");
            }
            fileContents = fileContents.concat("</html>");
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        new ShowPreviousBook();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==hbutton){
            frame.dispose();
            new UserOptions();
        }        
    }
}
