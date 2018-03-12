package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Class for the first screen that appears with the logo and "click here to start" button
 * @author Vincent Tan
 * @author Girish Kowligi
 * @author Christian Newkirk
 * @author Sarah Zhong
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class StartScreen extends AbstractMenu {

    private JLabel Background;
    private Image BackgroundImage;
    private BufferedImage BufferedBackgroundImage;
    private JButton startButton; // main Menu Button
    private Image startButtonImage;
    private BufferedImage startButtonImageBuffered;
    private JLabel logo; // label for image to go into
    private BufferedImage image; // image
    private Image scaledImage; // scaled image for logo

    /**
     * Constructor
     * @param gameIn
     * @param frameIn
     */
    public StartScreen(Game gameIn, JFrame frameIn) {
        super(gameIn, frameIn);

        frame.setSize(menu_width, menu_height);
        frame.setTitle("Start Screen");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);
        Font smallerBFont = new Font("Comic Sans MS", Font.BOLD, 15);

	/*
        startButton = new JButton("Click here to start!");
        startButton.addActionListener(new startButtonListener());
        startButton.setFont(smallerBFont);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	*/

        try {
	    BufferedBackgroundImage = ImageIO.read(new File("images/background.png"));
            BackgroundImage = BufferedBackgroundImage.getScaledInstance(250,375, Image.SCALE_DEFAULT);
            Background = new JLabel(new ImageIcon(BackgroundImage));
            Background.setAlignmentX(Component.CENTER_ALIGNMENT);
            Background.setLayout(new BoxLayout(Background, BoxLayout.Y_AXIS));
	  
	    startButtonImageBuffered = ImageIO.read(new File("images/StartButton.png"));
            startButtonImage = startButtonImageBuffered.getScaledInstance(200,70, Image.SCALE_DEFAULT);
            startButton = new JButton(new ImageIcon(startButtonImage));
            startButton.setBorder(BorderFactory.createEmptyBorder());
            startButton.setContentAreaFilled(false);
            startButton.addActionListener(new startButtonListener());
            startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
            image = ImageIO.read(new File("images/connect-4-logo.png"));
            scaledImage = image.getScaledInstance(200, 44, Image.SCALE_DEFAULT);
            logo = new JLabel(new ImageIcon(scaledImage));
            logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (IOException ex) {
            System.out.println("Image unavailable");
        }

	this.add(Background);
        Background.add(Box.createRigidArea(new Dimension(0, 50)));
        Background.add(logo);
        Background.add(Box.createRigidArea(new Dimension(0, 120)));
        Background.add(startButton);
    }

    /**
     * Listener class for the start button
     */
    class startButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            loadMainMenu(game, frame);
        }
    }

    /**
     * There is no back button on the start screen so return nothing
     */
    @Override
    public void back(Game game, JFrame frame) {
        return;
    }
}
