// This demo builds on FrameDemo to add buttons and Action Listeners

import java.awt.*;
import java.awt.event.*; // <- Note this is new! Needed for action listeners
import javax.swing.*;

public class ButtonDemo {

    private static final int HEIGHT = 800;
    private static final int WIDTH = 600;

    // We are going to access these from outside the class,
    // so be prepared
    
    private static JLabel _msg = new JLabel("Monorail!");

    private static JFrame _window = new JFrame("Genuine Bona Fide JFrame");
    
    public static JLabel getMsg() {
	return _msg;
    }

    public static JFrame getFrame() {
	return _window;
    }
    
    public static void main(String[] args) {
	// Create a frame (corresponds to a window)
	// Set it to the size of our values above

	_window.setSize(WIDTH, HEIGHT);
	// Close program when window is closed
	_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Window is invisible by default, make it visible
	_window.setVisible(true);
	
	// Now let's do some interesting things with our window
	// Add a message for a genuine bona fide electrified six-car MONORAIL
	
	_msg.setFont(new Font("TimesRoman", Font.ITALIC, 48));
	_msg.setForeground(Color.BLACK);
	_window.add(_msg);

	// Make a button with an ActionListener
	
	JButton btn = new JButton("More");
	ActionListener buttonListener = new ButtonListener();
	btn.addActionListener(buttonListener);

	_window.setLayout(new FlowLayout());
	_window.add(btn);
	
	JButton btn2 = new JButton("Less");
	ActionListener buttonListener2 = new ButtonListener2();
	btn2.addActionListener(buttonListener2);
	_window.add(btn2);

	JButton btn3 = new JButton("MONOSCHMAIL");
	ActionListener buttonListener3 = new ButtonListener();
	btn3.addActionListener(buttonListener3);
	_window.add(btn3);

	JButton btn4 = new JButton("DUORAIL");
	btn4.addActionListener(buttonListener);
	_window.add(btn4);
	
	
	// Refresh window - otherwise we will not be able to see it
	// THIS IS A COMMON SOURCE OF BUGS!
	_window.setVisible(true);
	
    }
}

// ActionListener is an _interface_.  Interfaces are like classes but only
// include method signatures.  A class which implements an interface must
// implement all of those methods.  

// The ButtonListener _implements_ ActionListener.  This means
// that it promises to implement the following method:
// public void actionPerformed(ActionEvent e)

// We will discuss interfaces in more detail later.  For our purposes, know
// that you just need something to write "implements ActionListener" and
// have a method with that signature.

// NOTE - this class is not public!  Thus -
//     1. It is not visible outside of this file
//     2. It does not need the same class name as the file name

class ButtonListener implements ActionListener {

    // Every time we click the button, it will perform
    // the following action.

    public void actionPerformed(ActionEvent e) {
	System.out.println("Pressed More Button!");
	String newText = ButtonDemo.getMsg().getText();
	newText += " Monorail!";
	ButtonDemo.getMsg().setText(newText);
    }
    
}

class ButtonListener2 implements ActionListener {

    // Every time we click the button, it will perform
    // the following action.

    public void actionPerformed(ActionEvent e) {
	System.out.println("Pressed Less Button!");
	String newText = ButtonDemo.getMsg().getText();
	newText = newText.substring(0, newText.length() - 10);
	ButtonDemo.getMsg().setText(newText);
    }
    
}

