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
 * Class for the Single player menu where the difficulty is chosen
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class SinglePlayerMenu extends AbstractMenu {
    private JLabel background;
    private BufferedImage bufferedBackgroundImage;
    private Image backgroundImage;
    private JButton singlePlayerEasy;
    private BufferedImage bufferedSinglePlayerEasy;
    private Image singlePlayerEasyImage;
    private JButton singlePlayerNormal;
    private BufferedImage bufferedSinglePlayerNormal;
    private Image singlePlayerNormalImage;
    private JButton singlePlayerAdvanced;
    private BufferedImage bufferedSinglePlayerAdvanced;
    private Image singlePlayerAdvancedImage;
    private JButton mainMenuButton;
    private BufferedImage bufferedMainMenu;
    private Image mainMenuImage;
    
    /**
     * Constructor for the single player menu panel
     * @param game Game reference passed to all GUI classes
     * @param frame JFrame reference passed to all GUI calsses
     */
    public SinglePlayerMenu(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Single Player");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);

	try{
            bufferedBackgroundImage = ImageIO.read(new File("images/background.png"));
            backgroundImage = bufferedBackgroundImage.getScaledInstance(250,375, Image.SCALE_DEFAULT);
            background = new JLabel(new ImageIcon(backgroundImage));
            background.setAlignmentX(Component.CENTER_ALIGNMENT);
            background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

	    // Easy Difficulty
	    
            bufferedSinglePlayerEasy = ImageIO.read(new File("images/EasyButton.png"));
            singlePlayerEasyImage = bufferedSinglePlayerEasy.getScaledInstance(230,40, Image.SCALE_DEFAULT);
	        singlePlayerEasy = new JButton(new ImageIcon(singlePlayerEasyImage));
            singlePlayerEasy.setBorder(BorderFactory.createEmptyBorder());
	        singlePlayerEasy.setContentAreaFilled(false);
            singlePlayerEasy.addActionListener(new singlePlayerEasyListener());
            singlePlayerEasy.setAlignmentX(Component.CENTER_ALIGNMENT);

	    // Normal difficulty

	        bufferedSinglePlayerNormal = ImageIO.read(new File("images/NormalButton.png"));
            singlePlayerNormalImage = bufferedSinglePlayerNormal.getScaledInstance(230,40, Image.SCALE_DEFAULT);
            singlePlayerNormal = new JButton(new ImageIcon(singlePlayerNormalImage));
            singlePlayerNormal.setBorder(BorderFactory.createEmptyBorder());
            singlePlayerNormal.setContentAreaFilled(false);
            singlePlayerNormal.addActionListener(new singlePlayerNormalListener());
            singlePlayerNormal.setAlignmentX(Component.CENTER_ALIGNMENT);

	    // Advanced difficulty                                                                                               
            bufferedSinglePlayerAdvanced = ImageIO.read(new File("images/AdvancedButton.png"));
            singlePlayerAdvancedImage = bufferedSinglePlayerAdvanced.getScaledInstance(230,40, Image.SCALE_DEFAULT);
            singlePlayerAdvanced = new JButton(new ImageIcon(singlePlayerAdvancedImage));
            singlePlayerAdvanced.setBorder(BorderFactory.createEmptyBorder());
            singlePlayerAdvanced.setContentAreaFilled(false);
            singlePlayerAdvanced.addActionListener(new singlePlayerAdvancedListener());
            singlePlayerAdvanced.setAlignmentX(Component.CENTER_ALIGNMENT);

	    // Main Menu

	        bufferedMainMenu = ImageIO.read(new File("images/MainMenuButton.png"));
            mainMenuImage = bufferedMainMenu.getScaledInstance(230,40, Image.SCALE_DEFAULT);
            mainMenuButton = new JButton(new ImageIcon(mainMenuImage));
            mainMenuButton.setBorder(BorderFactory.createEmptyBorder());
            mainMenuButton.setContentAreaFilled(false);
            mainMenuButton.addActionListener(new backButtonListener());
            mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);


	}
	catch(IOException ex){
            System.out.println("error retrieving images for single player menu");
        }
	
	this.add(background);
	background.add(Box.createRigidArea(new Dimension(0, 10)));
	background.add(singlePlayerEasy);
	background.add(singlePlayerNormal);
	background.add(singlePlayerAdvanced);
	background.add(mainMenuButton);

	/*

        singlePlayerEasy = new JButton("Easy");
        singlePlayerEasy.addActionListener(new singlePlayerEasyListener());
        singlePlayerEasy.setFont(BFont);
        singlePlayerEasy.setAlignmentX(Component.CENTER_ALIGNMENT);


        singlePlayerNormal = new JButton("Normal");
        singlePlayerNormal.addActionListener(new singlePlayerNormalListener());
        singlePlayerNormal.setFont(BFont);
        singlePlayerNormal.setAlignmentX(Component.CENTER_ALIGNMENT);

        singlePlayerAdvanced = new JButton("Advanced");
        singlePlayerAdvanced.addActionListener(new singlePlayerAdvancedListener());
        singlePlayerAdvanced.setFont(BFont);
        singlePlayerAdvanced.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainMenuButton = new JButton("Back");
        mainMenuButton.addActionListener(new backButtonListener());
        mainMenuButton.setFont(BFont);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(singlePlayerEasy);
        this.add(singlePlayerNormal);
        this.add(singlePlayerAdvanced);
        this.add(mainMenuButton);

	*/
    }

    /**
     * Listener for the main menu button in the single player difficulty menu
     */
    class backButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            back(game, frame);
        }

    }

    /**
     * Listener for the easy difficulty button in the single player difficulty menu
     */
    class singlePlayerEasyListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            game.setGameMode(2);
            loadPlayer1ColorSelectMenu(game, frame);
        }
    }

    /**
     * Listener for the normal difficulty button in the single player difficulty menu
     */
    class singlePlayerNormalListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            game.setGameMode(3);
            loadPlayer1ColorSelectMenu(game, frame);
        }
    }

    /**
     * Listener for the advanced difficulty button in the single player difficulty menu
     */
    class singlePlayerAdvancedListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            game.setGameMode(4);
            loadPlayer1ColorSelectMenu(game, frame);
        }
    }

    /**
     * Convenience method for the "Back" button
     * calls loadMainMenu to go back to Main Menu
     * @param game game object that is passed to all menus so they can access game data
     * @param frame the JFrame reference that is passed to all load(*)Menu functions so they can add menus to the frame
     */
    @Override
    public void back(Game game, JFrame frame) {
        loadMainMenu(game, frame);
    }
}
