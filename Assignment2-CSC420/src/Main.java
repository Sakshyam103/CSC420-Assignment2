import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }


    private static void createAndShowGUI(){
//        JFrame f = new JFrame("Assignment 2");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        MyPanel x = new MyPanel();
//        f.setContentPane(x.getPanel());
//        f.setSize(500, 500);
////       f.pack();   //it sizes the frame so that all its contents are at or above their preferred sizes.
//        f.setVisible(true);
          MyPanel x =  new MyPanel();
          x.setPreferredSize(new Dimension(500, 500));
          x.setResizable(false);
          x.setSize(500, 500);
          x.setVisible(true);
    }
}