package org.example.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleButton {
    private static final Logger logger = LogManager.getLogger(SimpleButton.class);

    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Simple Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a new JButton
        JButton button = new JButton("Click Me!");

        // Add an ActionListener to the button
        button.addActionListener(e -> {
            logger.info("Button clicked!");
        });

        // Add the button to the frame
        frame.getContentPane().add(button);
        
        // Center
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
