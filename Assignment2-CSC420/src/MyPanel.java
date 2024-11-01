import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class MyPanel extends JFrame{

    JLabel picture;
    int height = 363 - 16 - 25 ;   //16 for extra length and 25 for center
    int width =  12 - 25 ;
    JComboBox<String> comboBox;
    Map<String, Color> map;
//    public JPanel getPanel(){
//        return this;
//    }


    public MyPanel(){
//        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//        setBorder(BorderFactory.createLineBorder(Color.BLACK));
//         MyPanel1 canvas = new MyPanel1();
        PaintCircle canvas = new PaintCircle();
//        canvas.setSize(450, 450);
        map = new HashMap<>();
        map.put("Black", Color.BLACK);
        map.put("Red", Color.RED);
        map.put("Blue", Color.BLUE);
        map.put("Green", Color.GREEN);
        map.put("Yellow", Color.YELLOW);
        map.put("Gray", Color.GRAY);
//        JLabel canvas = new JLabel("Canvas");
        JLabel label = new JLabel("test");
//        height = (height / 100 ) * canvas.getHeight();
//        width = (width / 100 ) * canvas.getWidth();
//        canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
//        canvas.setSize(450, 450);
        JSlider hSlider = new JSlider(JSlider.HORIZONTAL, 12, 440 - 12, 12);
      hSlider.addChangeListener(new ChangeListener() {
          @Override
          public void stateChanged(ChangeEvent e) {
              JSlider source = (JSlider) e.getSource();
              if(!source.getValueIsAdjusting()){
                  width = (int) ((source.getValue() - 25));
                  System.out.println("Canvas width: " +canvas.getWidth());
                  System.out.println("Width: "+ width);
              }
          }
      });
        JSlider vSlider = new JSlider(JSlider.VERTICAL, 16, 363-16, 16);
//        hSlider.setPreferredSize(new Dimension(500, 10));
        String[] colors = {"Black","Blue","Green","Gray","Yellow","Red"};
        JButton button = new JButton("Show");
         comboBox = new JComboBox<>(colors);

        vSlider.addChangeListener(new ChangeListener() {
           @Override
           public void stateChanged(ChangeEvent e) {
               JSlider source = (JSlider) e.getSource();
               System.out.println(source.getValue());
               if(!source.getValueIsAdjusting()){
                   height = (int) (((363 - source.getValue() - 25)));
                   System.out.println("Canvas Height: " + canvas.getHeight());
                   System.out.println("Height: "+ height);
               }
           }

       });
//        add(canvas, CENTER_ALIGNMENT);
//        add(hSlider, BoxLayout.X_AXIS);
//        add(vSlider, BoxLayout.Y_AXIS);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(vSlider)
                .addGroup(layout.createParallelGroup()
                        .addComponent(label)
                        .addComponent(canvas, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                        .addComponent(hSlider, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(comboBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                )
        );
//        layout.linkSize(SwingConstants.VERTICAL, canvas, hSlider);
//        layout.linkSize(SwingConstants.HORIZONTAL, canvas, vSlider);
        layout.linkSize(SwingConstants.VERTICAL, comboBox, button);
      layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(label)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(vSlider, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                        .addComponent(canvas, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
                .addComponent(hSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboBox)
                        .addComponent(button)));
        setTitle("Test");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



//        this.addContainerListener(new ComponentAdapter() {
//            @Override
//            public void componentAdded(ContainerEvent e) {
//                height *= canvas.getHeight();
//                width *= canvas.getWidth();
//            }
//
//            @Override
//            public void componentRemoved(ContainerEvent e) {
//
//            }
//        });
//    this.addComponentListener(new ComponentAdapter() {
//        @Override
//        public void componentResized(ComponentEvent e) {
//           super.componentResized(e);
//            System.out.println(canvas.getHeight());
//            System.out.println(canvas.getWidth());
//            height = (canvas.getHeight() * height) / 100;
//            width = (canvas.getWidth() * width) / 100;
//        }
//    });


      button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String x = (String) comboBox.getSelectedItem();
              System.out.println(x);
              Color color1 = map.get(x);
              Graphics g = canvas.getGraphics();
              if(button.getText().equals("Show")) {
                  canvas.paintComponent(g, width, height, color1);
                 // canvas.paintComponent(g, , 363 - 16 , color1);
                  button.setText("Hide");
              }else{
                  canvas.removeComponent(g);
                  button.setText("Show");
              }
          }
      });
    }

//    public Dimension getPreferredSize(){
//        return new Dimension(250, 200);
//    }

//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//    }

//    @Override
//    public void stateChanged(ChangeEvent e) {   //listen to the sliders
//        JSlider source = (JSlider) e.getSource();
//        if(!source.getValueIsAdjusting()){
//            int fps = (int) source.getValue();
//        }
//    }
}
