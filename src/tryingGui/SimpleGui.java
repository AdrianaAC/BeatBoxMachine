import tryingGui.MyDrawPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui implements ActionListener {                                         // Implementing the interface is saying "an instance of SimpleGui IS-A ActionListener

    JFrame frame;

    public static void main(String[] args) {
        SimpleGui myGui = new SimpleGui();                                                 //First step when program runs: creating a new SimpleGui object and tell it so start itself
        myGui.go();
    }

    public void go() {
        frame = new JFrame();                                                       //Creating a new frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                              //Telling the program to quit as soon the window of the GUI is closed

        JButton button = new JButton("Click me to change colors");
        button.addActionListener(this);                                                   //Telling the button we want to know when it is pressed

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);                             // Adding the draw pannel to the frame
        frame.getContentPane().add(BorderLayout.SOUTH, button);                             //Adding the button to the frame's content pane (like the canvas of simpleGFX)
        frame.setSize(300, 300);                                                //setting the size of the frame (in pxl)
        frame.setVisible(true);                                                             //Like de draw() in simpleGFX, this method it's what makes the frame visible. If not setted, default is false and it'll be invisible
    }

    public void actionPerformed(ActionEvent event) {                                        //Event handling method. The button will call this method to let us know he's been pressed
        frame.repaint();
    }
}




