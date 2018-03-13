package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel for the main menu screen
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class MainMenu extends AbstractMenu {
    private Image BackgroundImage;
    private BufferedImage BufferedBackgroundImage;
    private JLabel Background;
    private BufferedImage SinglePlayerImage;
    private Image SinglePlayer;
    private JButton MPButton;
    private Image MultiPlayer;
    private BufferedImage MultiPlayerImage;
    private JButton SPButton;
    private JButton ExitButton;
    private BufferedImage ExitImage;
    private Image Exit;
    private JButton ruleButton;
    private BufferedImage ruleImage;
    private Image rules;
    private JButton settingsButton;
    private BufferedImage SettingsImage;
    private Image Settings;
    private JButton LeaderboardButton;
    private BufferedImage LeaderboardImage;
    private Image Leaderboard;

    /**
     * Constructor for the panel
     */
    public MainMenu(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Main Menu");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);

        //Background Image
        backgroundImage();

        // Single Player Button image
        singlePlayerButton();

        // Multiplayer Button image
        multiPlayerButton();

        // Settings Button Image
        settingsButton();

        // rules Button Image
        rulesButton();

        // leaderboard Image
        leaderBoardImage();

        //Exit Image
        exitImage();


        this.add(Background);
        background();
    }


    private void backgroundImage() {
        try {
            BufferedBackgroundImage = ImageIO.read(new File("images/background.png"));
            BackgroundImage = BufferedBackgroundImage.getScaledInstance(250, 375, Image.SCALE_DEFAULT);
            Background = new JLabel(new ImageIcon(BackgroundImage));
            Background.setAlignmentX(Component.CENTER_ALIGNMENT);
            Background.setLayout(new BoxLayout(Background, BoxLayout.Y_AXIS));
        } catch (IOException ex) {
            System.out.print("File not found error");
        }
    }

    private void singlePlayerButton() {
        try {
            SinglePlayerImage = ImageIO.read(new File("images/SingleplayerButton.png"));
            SinglePlayer = SinglePlayerImage.getScaledInstance(225, 60, Image.SCALE_DEFAULT);
            SPButton = new JButton(new ImageIcon(SinglePlayer));
            SPButton.setBorder(BorderFactory.createEmptyBorder());
            SPButton.setContentAreaFilled(false);
            SPButton.addActionListener(new SPButtonListener());
            SPButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (IOException ex) {
            System.out.print("File not found error");
        }
    }

    private void multiPlayerButton() {
        try {
            MultiPlayerImage = ImageIO.read(new File("images/MultiplayerButton.png"));
            MultiPlayer = MultiPlayerImage.getScaledInstance(225, 60, Image.SCALE_DEFAULT);
            MPButton = new JButton(new ImageIcon(MultiPlayer));
            MPButton.setBorder(BorderFactory.createEmptyBorder());
            MPButton.setContentAreaFilled(false);
            MPButton.addActionListener(new MPButtonListener());
            MPButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (IOException ex) {
            System.out.print("File not found error");
        }
    }

    private void settingsButton() {
        try {
            SettingsImage = ImageIO.read(new File("images/SettingsButton.png"));
            Settings = SettingsImage.getScaledInstance(225, 60, Image.SCALE_DEFAULT);
            settingsButton = new JButton(new ImageIcon(Settings));
            settingsButton.setBorder(BorderFactory.createEmptyBorder());
            settingsButton.setContentAreaFilled(false);
            settingsButton.addActionListener(new settingsButtonListener());
            settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (IOException ex) {
            System.out.print("File not found error");
        }
    }

    private void rulesButton() {
        try {
            ruleImage = ImageIO.read(new File("images/RulesButton.png"));
            rules = ruleImage.getScaledInstance(225, 60, Image.SCALE_DEFAULT);
            ruleButton = new JButton(new ImageIcon(rules));
            ruleButton.setBorder(BorderFactory.createEmptyBorder());
            ruleButton.setContentAreaFilled(false);
            ruleButton.addActionListener(new ruleButtonListener());
            ruleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (IOException ex) {
            System.out.print("File not found error");
        }
    }

    private void leaderBoardImage() {
        try {
            LeaderboardImage = ImageIO.read(new File("images/LeaderboardButton.png"));
            Leaderboard = LeaderboardImage.getScaledInstance(225, 60, Image.SCALE_DEFAULT);
            LeaderboardButton = new JButton(new ImageIcon(Leaderboard));
            LeaderboardButton.setBorder(BorderFactory.createEmptyBorder());
            LeaderboardButton.setContentAreaFilled(false);
            LeaderboardButton.addActionListener(new LeaderboardButtonListener());
            LeaderboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (IOException ex) {
            System.out.print("File not found error");
        }
    }

    private void exitImage() {
        try {
            ExitImage = ImageIO.read(new File("images/ExitButton.png"));
            Exit = ExitImage.getScaledInstance(225, 60, Image.SCALE_DEFAULT);
            ExitButton = new JButton(new ImageIcon(Exit));
            ExitButton.setBorder(BorderFactory.createEmptyBorder());
            ExitButton.setContentAreaFilled(false);
            ExitButton.addActionListener(new ExitButtonListener());
            ExitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (IOException ex) {
            System.out.print("File not found error");
        }
    }
    private void background() {
        Background.add(SPButton);
        Background.add(MPButton);
        Background.add(settingsButton);
        Background.add(ruleButton);
        Background.add(LeaderboardButton);
        Background.add(ExitButton);
    }

    /**
     * Listener for the multiplayer button
     */
    class MPButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            game.setGameMode(1);
            loadPlayer1ColorSelectMenu(game, frame);
        }
    }

    /**
     * Listener for the leaderboard button
     */

    class LeaderboardButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent event){
	    loadLeaderboardMenu(game,frame);
	}
    }

    /**
     * Listener for the single player button
     */
    class SPButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            loadSinglePlayerMenu(game, frame);
        }
    }

    /**
     * Listener for the rules button
     */
    class ruleButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            loadRulesPage(game, frame);
        }
    }

    /**
     * Listener for the exit button
     */
    class ExitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    /**
     * Listener for the settings button
     */
    class settingsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            loadSettingsPage(game, frame);
        }
    }

	
    /**
     * Method that removes current menu, then displays the SettingsMenu
     */
    public void loadSettingsPage(Game game, JFrame frame) {
        frame.setSize(menu_width, menu_height);
        frame.getContentPane().removeAll();
        SettingsMenu nextMenu = new SettingsMenu(game, frame);
        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    /**
     * Displays a rulesMenu when "Rules" button pressed on first menu
     * Called from StartScreenButtonsPanel
     */
    public void loadRulesPage(Game game, JFrame frame) {
        frame.setSize(2 * menu_width, (int) (1.25 * menu_height));
        frame.getContentPane().removeAll();
        RulesPage nextMenu = new RulesPage(game, frame);
        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    /**
     * Method for displaying the single player menu
     * Creates a SinglePlayerMenu and adds it to the frame
     */
    public void loadSinglePlayerMenu(Game game, JFrame frame) {
        frame.setSize(menu_width, menu_height);
        frame.getContentPane().removeAll();

        SinglePlayerMenu nextMenu = new SinglePlayerMenu(game, frame);
        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }
    
    /**
    * Method for diplaying the leaderboard menu
    */
    public void loadLeaderboardMenu(Game game, JFrame frame) {
	frame.setSize(menu_width, menu_height);
	frame.getContentPane().removeAll();
	LeaderboardMenu nextMenu = new LeaderboardMenu(game,frame);
	frame.getContentPane().add(nextMenu);
	frame.revalidate();
	frame.repaint();
	frame.setVisible(true);
    }
    
    /**
     * there is no back button on the main menu, so return nothing
     */
    @Override
    public void back(Game game, JFrame frame) {
        return;
    }
}
