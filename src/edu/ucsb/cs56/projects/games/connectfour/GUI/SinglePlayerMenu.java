package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the Single player menu where the difficulty is chosen
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class SinglePlayerMenu extends AbstractMenu {

    private JButton singlePlayerEasy;
    private JButton singlePlayerNormal;
    private JButton singlePlayerAdvanced;
    private JButton mainMenuButton;

    /**
     * Constructor for the single player menu panel
     * @param game Game reference passed to all GUI classes
     * @param frame JFrame reference passed to all GUI calsses
     */
    public SinglePlayerMenu(Game game, JFrame frame) {
        super(game, frame);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);

        singlePlayerEasy = new JButton("Easy");
        singlePlayerEasy.addActionListener(new singlePlayerEasyListener());
        singlePlayerEasy.setFont(BFont);

        singlePlayerNormal = new JButton("Normal");
        singlePlayerNormal.addActionListener(new singlePlayerNormalListener());
        singlePlayerNormal.setFont(BFont);

        singlePlayerAdvanced = new JButton("Advanced");
        singlePlayerAdvanced.addActionListener(new singlePlayerAdvancedListener());
        singlePlayerAdvanced.setFont(BFont);

        mainMenuButton = new JButton("Back");
        mainMenuButton.addActionListener(new backButtonListener());
        mainMenuButton.setFont(BFont);

        this.add(singlePlayerEasy);
        this.add(singlePlayerNormal);
        this.add(singlePlayerAdvanced);
        this.add(mainMenuButton);
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
