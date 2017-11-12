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
 *
 * @author Brian Lee
 * @version CS56 F16 UCSB
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
    private JButton invisibleButton;
    private JLabel nameInst;
    private JTextField nameText;
    private int stateToNotShow;

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
	this.stateToNotShow = stateToNotShow;

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

	//Fix Issue #58
	if(game.getGameMode() == 1)
	    {
		nameInst = new JLabel("Enter Player 2 name:");
	    }
	else
	    {
		nameInst = new JLabel("Enter Computer name:");
	    }
	nameInst.setFont(smallFont);
	nameText = new JTextField("Player 2");
	nameText.setFont(smallFont);
	nameText.setFocusable(true);
	nameText.requestFocus();

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
        this.add(Box.createVerticalStrut(40));
	this.add(nameInst);
        this.add(nameText);
    }

    /**
     * Listener class for the black button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */

    class blackButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
	    //Issue #58 get name
      	    String getName = nameText.getText();
            game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(4);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,4);
	    }
    }
    /**
     * Listener class for the blue button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class blueButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
      	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(5);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,5);
        }
    }
    /**
     * Listener class for the magenta button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class magentaButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
       	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(6);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,6);
        }
    }
    /**
     * Listener class for the red button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class brownButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
       	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(7);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,7);
        }
    }
    /**
     * Listener class for the pink button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class pinkButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
       	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(8);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,8);
        }
    }
    /**
     * Listener class for the red button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class redButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
      	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(1);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,1);
        }
    }
    /**
     * Listener class for the yellow button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class yellowButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
     	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(2);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,2);
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
