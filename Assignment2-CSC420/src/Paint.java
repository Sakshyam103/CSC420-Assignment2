import javax.swing.*;
import java.awt.*;

//public class Paint {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
//
//    private static void createAndShowGUI() {
//        System.out.println("Created GUI on EDT? "+
//                SwingUtilities.isEventDispatchThread());
//        JFrame f = new JFrame("Swing Paint Demo");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(new MyPanel1());
//        f.pack();
//        f.setVisible(true);
//    }
//}

class MyPanel1 extends JPanel {

    public MyPanel1() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    public void paintComponent(Graphics g, int x, int y, Color color) {
        super.paintComponent(g);
        int size = 30;
        // Draw Text
        g.drawString("This is my custom Panel!",10,20);
//        g.setColor(Color.RED);
        g.fillRoundRect(x, y, size, size, size, size);
        g.drawRoundRect(20, 30, 10, 10, 10, 10);
//        g.setColor(Color.BLACK);
//        g.drawRect(10,20,10,20);
    }
}

