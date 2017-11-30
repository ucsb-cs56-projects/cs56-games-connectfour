package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the color selection menu for player 1
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 *
 * @author Brian Lee
 * @version CS56 F16 UCSB
 */
public class Player1ColorSelectMenu extends AbstractMenu {

    private JLabel header;
    private JButton blackButton;
    private JButton blueButton;
    private JButton magentaButton;
    private JButton brownButton;
    private JButton pinkButton;
    private JButton redButton;
    private JButton yellowButton;
    private JButton backButton;
    private JLabel nameInst;
    private JTextField nameText;

    private JPanel namePanel;

    /**
     * Constructor for the Player1ColorSelectMenu
     * Note: the header is centered in a cheesy way, future peoples should fix this :P
     *
     * @param game  game object that is passed to all menus so they can access game data
     * @param frame the JFrame reference that is passed to all load(*)Menu functions so they can add menus to the frame
     */
    public Player1ColorSelectMenu(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Player 1");


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        header = new JLabel("    Player 1: Choose Color");
        header.setFont(smallFont);
        header.setAlignmentX(Component.CENTER_ALIGNMENT);


        blackButton = new JButton("Black");
        blackButton.addActionListener(new blackButtonListener());
        blackButton.setFont(mediumFont);
        blackButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        blueButton = new JButton("Blue");
        blueButton.addActionListener(new blueButtonListener());
        blueButton.setFont(mediumFont);
        blueButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        magentaButton = new JButton("Magenta");
        magentaButton.addActionListener(new magentaButtonListener());
        magentaButton.setFont(mediumFont);
        magentaButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        brownButton = new JButton("Brown");
        brownButton.addActionListener(new brownButtonListener());
        brownButton.setFont(mediumFont);
        brownButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        pinkButton = new JButton("Pink");
        pinkButton.addActionListener(new pinkButtonListener());
        pinkButton.setFont(mediumFont);
        pinkButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        redButton = new JButton("Red");
        redButton.addActionListener(new redButtonListener());
        redButton.setFont(mediumFont);
        redButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        yellowButton = new JButton("Yellow");
        yellowButton.addActionListener(new yellowButtonListener());
        yellowButton.setFont(mediumFont);
        yellowButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButton = new JButton("Back");
        backButton.addActionListener(new backButtonListener());
        backButton.setFont(mediumFont);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

	//Fix Issue #58
	nameInst = new JLabel("Enter Player 1 name:");
	nameInst.setFont(smallFont);
    nameInst.setAlignmentX(Component.CENTER_ALIGNMENT);
	nameText = new JTextField("Player 1");
	nameText.setFont(smallFont);
	nameText.setFocusable(true);
	nameText.requestFocus();
    nameText.setHorizontalAlignment(JLabel.CENTER);

	

    this.add(header);
    this.add(redButton);
    this.add(yellowButton);
    this.add(blackButton);
    this.add(blueButton);
    this.add(magentaButton);
    this.add(brownButton);
    this.add(pinkButton);
    this.add(backButton);
	this.add(nameInst);
	this.add(nameText);
    }

    /**
     * Listener class for the red button
     * Calls loadPlayer2ColorSelectMenu and passes the int chosen by Player 1
     * so the next menu knows which button to not display
     */
    class redButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
     	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP1Name(getName);
	    
            game.setPlayer1Color(1);
            loadPlayer2ColorSelectMenu(game, frame, 1);
        }
    }

    /**
     * Listener class for the yellow button
     * Calls loadPlayer2ColorSelectMenu and passes the int chosen by Player 1
     * so the next menu knows which button to not display
     */
    class yellowButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP1Name(getName);
	    
            game.setPlayer1Color(2);
            loadPlayer2ColorSelectMenu(game, frame, 2);
        }
    }

    /**
     * Listener class for the black button
     * Calls loadPlayer2ColorSelectMenu and passes the int chosen by Player 1
     * so the next menu knows which button to not display
     */
    class blackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP1Name(getName);
	    
            game.setPlayer1Color(4);
            loadPlayer2ColorSelectMenu(game, frame, 4);
        }
    }

    /**
     * Listener class for the blue button
     * Calls loadPlayer2ColorSelectMenu and passes the int chosen by Player 1
     * so the next menu knows which button to not display
     */
    class blueButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP1Name(getName);
	    
            game.setPlayer1Color(5);
            loadPlayer2ColorSelectMenu(game, frame, 5);
        }
    }

    /**
     * Listener class for the magenta button
     * Calls loadPlayer2ColorSelectMenu and passes the int chosen by Player 1
     * so the next menu knows which button to not display
     */
    class magentaButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP1Name(getName);
	    
            game.setPlayer1Color(6);
            loadPlayer2ColorSelectMenu(game, frame, 6);
        }
    }

    /**
     * Listener class for the brown button
     * Calls loadPlayer2ColorSelectMenu and passes the int chosen by Player 1
     * so the next menu knows which button to not display
     */
    class brownButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP1Name(getName);
	    
            game.setPlayer1Color(7);
            loadPlayer2ColorSelectMenu(game, frame, 7);
        }
    }

    /**
     * Listener class for the pink button
     * Calls loadPlayer2ColorSelectMenu and passes the int chosen by Player 1
     * so the next menu knows which button to not display
     */
    class pinkButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
	    //Issue #58 get name
	    String getName = nameText.getText();
	    game.setP1Name(getName);
	    
            game.setPlayer1Color(8);
            loadPlayer2ColorSelectMenu(game, frame, 8);
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

    /**
     * Loads the main menu
     *
     * @param game
     * @param frame
     */
    @Override
    public void back(Game game, JFrame frame) {
        loadMainMenu(game, frame);
        //return;
    }
}
