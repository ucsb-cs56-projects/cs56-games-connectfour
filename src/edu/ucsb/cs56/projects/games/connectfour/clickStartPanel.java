package edu.ucsb.cs56.projects.games.connectfour;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.util.ArrayList;

// Panel for screen before menus.

/**
 * Class for the start screen opened when first run.
 */

public class clickStartPanel extends JPanel {
    private JButton startButton; // main Menu Button
    private JLabel logo; // label for image to go into
    private BufferedImage image; // image
    private Image scaledImage; // scaled image for logo

    /**
     * Constructor for clickStartPanel
     *
     * @param ss startScreen2
     */

    public clickStartPanel(startScreen2 ss) {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        //this.setMaximumSize(new Dimension(100,650));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
        Font smallerBFont = new Font("Comic Sans MS", Font.BOLD, 15);


        // Create a
        // startButton
        // logo image
        startButton = new JButton("Click here to start!");
        startButton.addActionListener(new startButtonListener(ss));
        startButton.setFont(smallerBFont);

        try {
            image = ImageIO.read(new File("images/connect-4-logo.png"));
            scaledImage = image.getScaledInstance(200, 44, Image.SCALE_DEFAULT);
            logo = new JLabel(new ImageIcon(scaledImage));
        } catch (IOException ex) {
            System.out.println("Image unavailable");
        }

        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(logo);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(startButton);


    }


    // Listeners for Buttons in Panel

    // when start Button is pressed
    // go to next menu

    /**
     * Listener class for the start button
     */
    class startButtonListener implements ActionListener {
        private startScreen2 ss1;

        startButtonListener(final startScreen2 ss) {
            ss1 = ss;
        }

        public void actionPerformed(ActionEvent event) {
            ss1.loadFirstMenu();
        }
    }// end of startButtonListener Class


}// end of clickStartPanel Class



