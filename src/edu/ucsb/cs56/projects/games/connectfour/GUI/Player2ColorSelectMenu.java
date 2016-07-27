package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the player color selection menu for player 2
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class Player2ColorSelectMenu extends AbstractMenu {

    private JLabel header;
    private JButton blackButton;
    private JButton blueButton;
    private JButton magentaButton;
    private JButton brownButton;
    private JButton pinkButton;
    private JButton redButton;
    private JButton yellowButton;

    /**
     * Constructor for the Player2ColorSelectMenu
     * Note: The header is centered via us being lazy, future students should try to center it correctly
     *
     * @param game game object that is passed to all menus so they can access game data
     * @param frame the JFrame reference that is passed to all load(*)Menu functions so they can add menus to the frame
     * @param stateToNotShow int representing the color chosen by player 1 in the previous menu so this menu knows which
     *                       button to not display
     */
    public Player2ColorSelectMenu(Game game, JFrame frame, int stateToNotShow) {
        super(game, frame);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        header = new JLabel("    Player 2: Choose Color");
        header.setFont(smallFont);


        blackButton = new JButton("Black");
        blackButton.addActionListener(new blackButtonListener());
        blackButton.setFont(largeFont);

        blueButton = new JButton("Blue");
        blueButton.addActionListener(new blueButtonListener());
        blueButton.setFont(largeFont);

        magentaButton = new JButton("Magenta");
        magentaButton.addActionListener(new magentaButtonListener());
        magentaButton.setFont(largeFont);

        brownButton = new JButton("Brown");
        brownButton.addActionListener(new brownButtonListener());
        brownButton.setFont(largeFont);

        pinkButton = new JButton("Pink");
        pinkButton.addActionListener(new pinkButtonListener());
        pinkButton.setFont(largeFont);

        redButton = new JButton("Red");
        redButton.addActionListener(new redButtonListener());
        redButton.setFont(largeFont);

        yellowButton = new JButton("Yellow");
        yellowButton.addActionListener(new yellowButtonListener());
        yellowButton.setFont(largeFont);

        this.add(header);
        if (stateToNotShow != 1) {
            this.add(redButton);
        }
        if (stateToNotShow != 2) {
            this.add(yellowButton);
        }
        if (stateToNotShow != 4) {
            this.add(blackButton);
        }
        if (stateToNotShow != 5) {
            this.add(blueButton);
        }
        if (stateToNotShow != 6) {
            this.add(magentaButton);
        }
        if (stateToNotShow != 7) {
            this.add(brownButton);
        }
        if (stateToNotShow != 8) {
            this.add(pinkButton);
        }
    }

    /**
     * Listener class for the black button
     * Sets player2's color and calls launchGame()
     */
    class blackButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            game.setPlayer2Color(4);
            launchGame();
        }
    }
    /**
     * Listener class for the blue button
     * Sets player2's color and calls launchGame()
     */
    class blueButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            game.setPlayer2Color(5);
            launchGame();
        }
    }
    /**
     * Listener class for the magenta button
     * Sets player2's color and calls launchGame()
     */
    class magentaButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            game.setPlayer2Color(6);
            launchGame();
        }
    }
    /**
     * Listener class for the red button
     * Sets player2's color and calls launchGame()
     */
    class brownButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            game.setPlayer2Color(7);
            launchGame();
        }
    }
    /**
     * Listener class for the pink button
     * Sets player2's color and calls launchGame()
     */
    class pinkButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            game.setPlayer2Color(8);
            launchGame();
        }
    }
    /**
     * Listener class for the red button
     * Sets player2's color and calls launchGame()
     */
    class redButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            game.setPlayer2Color(1);
            launchGame();
        }
    }
    /**
     * Listener class for the yellow button
     * Sets player2's color and calls launchGame()
     */
    class yellowButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            game.setPlayer2Color(2);
            launchGame();
        }
    }

    /**
     * No back button, may add one later
     */
    @Override
    public void back(Game game, JFrame frame) {
        return;
    }
}
