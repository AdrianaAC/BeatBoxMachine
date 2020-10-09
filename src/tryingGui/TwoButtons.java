import tryingGui.MyDrawPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons {

    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
      TwoButtons myGui = new TwoButtons();
      myGui.go();
    }

    public void go () {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change label");
        labelButton.addActionListener(new LabelListener());           //Instead of passing "this" we pass a new instance of the appropriate listener class

        JButton colorButton = new JButton("Change color");
        colorButton.addActionListener(new ColorListener ());

        label = new JLabel("I'm the first label here");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label.setText("I'm a new label! Hi there!");
        }
    }

    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            frame.repaint();
        }
    }
}
