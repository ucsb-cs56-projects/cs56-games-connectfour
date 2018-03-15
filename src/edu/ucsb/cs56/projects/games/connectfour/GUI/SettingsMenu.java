package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

/**
 * Class for settings menu
 * Currently only has a checkbox for entering Testing mode for easy printing out of game grid
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class SettingsMenu extends AbstractMenu {

    private JLabel Background;
    private Image BackgroundImage;
    private BufferedImage BufferedBackgroundImage;
    private JButton mainMenuButton;
    private Image mainMenuButtonImage;
    private BufferedImage mainMenuButtonImageBuffered;
    private JButton audioMenuButton;
    private Image audioMenuButtonImage;
    private BufferedImage audioMenuButtonImageBuffered;
    private JCheckBox testingModeBox;

    /**
     * Constructor for the settingsPanel
     */
    public SettingsMenu(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Settings");


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);

        backgroundImage();
        audioMenuButtonImage();
        mainMenuButtonImage();
        testingModeBox();

        this.add(Background);
        background();


	frame.getContentPane().add(this);
    }
    public void backgroundImage(){
        try{
            BufferedBackgroundImage = ImageIO.read(new File("images/background.png"));
            BackgroundImage = BufferedBackgroundImage.getScaledInstance(250,375, Image.SCALE_DEFAULT);
            Background = new JLabel(new ImageIcon(BackgroundImage));
            Background.setAlignmentX(Component.CENTER_ALIGNMENT);
            Background.setLayout(new BoxLayout(Background, BoxLayout.Y_AXIS));
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    public void audioMenuButtonImage(){
        try{
            audioMenuButtonImageBuffered = ImageIO.read(new File("images/AudioButton.png"));
            audioMenuButtonImage = audioMenuButtonImageBuffered.getScaledInstance(200,50, Image.SCALE_DEFAULT);
            audioMenuButton = new JButton(new ImageIcon(audioMenuButtonImage));
            audioMenuButton.setBorder(BorderFactory.createEmptyBorder());
            audioMenuButton.setContentAreaFilled(false);
            audioMenuButton.addActionListener(new audioButtonListener());
            audioMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    public void mainMenuButtonImage(){
        try{
            mainMenuButtonImageBuffered = ImageIO.read(new File("images/BackButton.png"));
            mainMenuButtonImage = mainMenuButtonImageBuffered.getScaledInstance(200,50, Image.SCALE_DEFAULT);
            mainMenuButton = new JButton(new ImageIcon(mainMenuButtonImage));
            mainMenuButton.setBorder(BorderFactory.createEmptyBorder());
            mainMenuButton.setContentAreaFilled(false);
            mainMenuButton.addActionListener(new backButtonListener());
            mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    public void testingModeBox(){
        testingModeBox = new JCheckBox("Testing Mode");
        testingModeBox.addActionListener(new testingModeBoxListener());
        testingModeBox.setSelected(false);
        testingModeBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        testingModeBox.setForeground(Color.white);
    }
    public void background(){
        Background.add(Box.createRigidArea(new Dimension(0, 10)));
        Background.add(audioMenuButton);
        Background.add(mainMenuButton);
        Background.add(testingModeBox);
    }
    /**
     * Listener class for the audio menu button
     */
    class audioButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            loadAudioPage(game, frame);
        }
    }

    /**
     * Listener class for the testing mode check box
     */
    class testingModeBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JCheckBox cb = (JCheckBox) event.getSource();
            if (cb.isSelected()) {
                game.setTestingModeEnabled(true);
                System.out.println("Testing Mode Enabled");
            } else {
                game.setTestingModeEnabled(false);
                System.out.println("Testing Mode Disabled");
            }
        }
    }

    /**
     * Listener for the back button
     */
    class backButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            back(game, frame);
        }
    }

    public void loadAudioPage(Game game, JFrame frame) {
        frame.setSize(menu_width, menu_height);
        frame.getContentPane().removeAll();
        AudioMenu nextMenu = new AudioMenu(game, frame);
        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    @Override
    public void back(Game game, JFrame frame) {
        loadMainMenu(game, frame);
    }
}
