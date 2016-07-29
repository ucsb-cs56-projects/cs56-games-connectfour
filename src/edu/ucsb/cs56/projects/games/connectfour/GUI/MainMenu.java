package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

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


    private JButton MPButton;
    private JButton SPButton;
    private JButton ExitButton;
    private JButton ruleButton;
    private JButton settingsButton;

    /**
     * Constructor for the panel
     */
    public MainMenu(Game game, JFrame frame) {
        super(game, frame);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);

        MPButton = new JButton("Multiplayer");
        MPButton.addActionListener(new MPButtonListener());
        MPButton.setFont(BFont);

        SPButton = new JButton("Single Player");
        SPButton.addActionListener(new SPButtonListener());
        SPButton.setFont(BFont);

        settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new settingsButtonListener());
        settingsButton.setFont(BFont);

        ruleButton = new JButton("Rules");
        ruleButton.addActionListener(new ruleButtonListener());
        ruleButton.setFont(BFont);

        ExitButton = new JButton("Exit");
        ExitButton.addActionListener(new ExitButtonListener());
        ExitButton.setFont(BFont);


        this.add(SPButton);
        this.add(MPButton);
        this.add(settingsButton);
        this.add(ruleButton);
        this.add(ExitButton);

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
     * there is no back button on the main menu, so return nothing
     */
    @Override
    public void back(Game game, JFrame frame) {
        return;
    }
}
