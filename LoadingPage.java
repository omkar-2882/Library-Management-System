import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;

public class LoadingPage {
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();
    JProgressBar bar1 = new JProgressBar();
    JLabel bg;
    ImageIcon img = new ImageIcon("bkheart3.jpg");
    JLabel label;

    LoadingPage(){
        bg =  new JLabel("");
        bg.setOpaque(false);
        bg.setBounds(307,30,680,600);
        bg.setHorizontalAlignment(JLabel.CENTER);
        bg.setIcon(img);

        label = new JLabel("Loading Please Wait...");
        label.setOpaque(true);
        label.setBounds(560,600,205,15);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Cascadia Code",Font.BOLD,15));
        label.setForeground(Color.darkGray);
        label.setBackground(Color.WHITE);

        bar.setValue(0);
        bar.setBounds(0,640,1300,10);
        bar.setStringPainted(false);
        // bar.setFont(new Font("Cascadia Code",Font.BOLD,15));
        bar.setForeground(Color.ORANGE);
        bar.setBackground(Color.white);
        bar.setFocusable(false);
        bar.setBorderPainted(false);

        JLayeredPane lp = new JLayeredPane();
        lp.setBounds(28,0,1366,750);
        lp.add(bg,Integer.valueOf(0));
        lp.add(bar,Integer.valueOf(1));
        lp.add(label,Integer.valueOf(2));

        frame.add(lp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1366,750); 
        frame.getContentPane().setBackground(Color.white);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        fill();
    }
    public void fill(){
        int counter = 0;
        while(counter<=100)
        {
            bar.setValue(counter);
            try {
                Thread.sleep(50);       
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
        frame.dispose();
        new Homeframe();
    }

public static void main(String[] args) {
    new LoadingPage();
}
}


