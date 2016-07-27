package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class for the menus used in the
 * Implements several useful methods that are used by multiple menus
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public abstract class AbstractMenu extends JPanel {
    int menu_width = 240;
    int menu_height = 380;
    private static int frame_width = 890;
    private static int frame_height = 670;
    protected final Game game;
    protected final JFrame frame;
    Font smallFont = new Font("Comic Sans MS", Font.BOLD, 15);
    Font largeFont = new Font("Comic Sans MS", Font.BOLD, 22);


    /**
     * Constructor that takes in the references to the Game object, and JFrame object
     * Every call to this constructor should take in the same argument
     * except for the initial call inside of StartScreen's constructor, which in turn
     * takes the newly instantiated objects in the main() function
     *
     * @param game Game object that is passed to all menus so they have access to game info
     * @param frame The JFrame object that is passed to all menus and load(*)Menu functions
     *              so they have a reference to the frame on which they are drawn
     */
    public AbstractMenu(Game game, JFrame frame) {
        this.game = game;
        this.frame = frame;
    }

    /**
     * Method that displays the main menu, since many different panels return
     * to the main menu we implement it here so all subclasses have access
     * may have to push down into subclasses because of using "this"
     */
    public void loadMainMenu(Game game, JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(menu_width, menu_height);
        MainMenu nextMenu = new MainMenu(game, frame);
        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Method that displays the Player1ColorSelectMenu
     * Note: functionality lost from previous version, players can
     * no longer set their own names, have not found a solution in this
     * refactored version
     *
     * @param game game object that is passed to all menus so they can access game data
     * @param frame the JFrame reference that is passed to all load(*)Menu functions so they can add menus to the frame
     */
    public void loadPlayer1ColorSelectMenu(Game game, JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(menu_width, menu_height);
        Player1ColorSelectMenu nextMenu = new Player1ColorSelectMenu(game, frame);
        /*
        Issue #TODO fill in
        This was an attempt at allowing the players to enter in their own
        names to be displayed at the top of the screen instead of just
        "Player1" and "Player2"
        We were having trouble with getting the text from the JTextField
        with it sometimes working, sometimes getting nothing, and otherwise
        just breaking entirely
        We've left what we had commented out so you have somewhere to start
         */
//
//        JPanel namePanel = new JPanel();
//        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
//        JLabel enterName = new JLabel("Enter Name: ");
//        enterName.setFont(smallFont);
//        JTextField nameText = new JTextField("");
//        nameText.setFont(smallFont);
//        nameText.setFocusable(true);
//        nameText.requestFocus();
//        namePanel.add(enterName);
//        namePanel.add(nameText);
//
//        frame.getContentPane().add(BorderLayout.NORTH, namePanel);
//        game.setP1Name(nameText.getText());
        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Method that displays the Player2ColorSelectMenu
     * Note: functionality lost from previous version, players can
     * no longer set their own names, have not found a solution in this
     * refactored version
     *
     * @param game game object that is passed to all menus so they can access game data
     * @param frame the JFrame reference that is passed to all load(*)Menu functions so they can add menus to the frame
     */
    public void loadPlayer2ColorSelectMenu(Game game, JFrame frame, int colorToNotShow) {
        frame.getContentPane().removeAll();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(menu_width, menu_height);
        Player2ColorSelectMenu nextMenu = new Player2ColorSelectMenu(game, frame, colorToNotShow);
        /*
        Issue #TODO fill in
        This was an attempt at allowing the players to enter in their own
        names to be displayed at the top of the screen instead of just
        "Player1" and "Player2"
        We were having trouble with getting the text from the JTextField
        with it sometimes working, sometimes getting nothing, and otherwise
        just breaking entirely
        We've left what we had commented out so you have somewhere to start
         */
//
//        JPanel namePanel = new JPanel();
//        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
//        JLabel enterName = new JLabel("Enter Name: ");
//        enterName.setFont(smallFont);
//        JTextField nameText = new JTextField("");
//        nameText.setFont(smallFont);
//        nameText.setFocusable(true);
//        nameText.requestFocus();
//        namePanel.add(enterName);
//        namePanel.add(nameText);
//
//        frame.getContentPane().add(namePanel);
        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * This handles the GUI side of launching the game
     * creates the BoardDisplay and inGameMenu
     * then calls Game's launchGame() to handle
     * the logic side of launching the game
     */
    public void launchGame() {
        frame.setSize(frame_width, frame_height);
        frame.getContentPane().removeAll();
        game.setFrame(frame);
        inGameMenu nextMenu = new inGameMenu(game, frame);
        BoardDisplay display = new BoardDisplay(game, frame);
        display.repaint();
        game.launchGame();
        game.getBoard().setDisplay(display);
        frame.getContentPane().add(display, BorderLayout.CENTER);
        frame.getContentPane().add(nextMenu, BorderLayout.LINE_END);
        frame.getContentPane().add(display.getTurnPanel(), BorderLayout.PAGE_START);
        frame.addMouseListener(game.getBoard().getMouseClass());
        frame.revalidate();
        frame.repaint();
    }

    /**
     * This handles the GUI side of restarting a game
     * Called when the Restart button is pressed on the inGameMenu
     * We've implemented it in the abstract class in case future
     * versions have a need for it in other menus
     */
    public void restartGame() {
        BoardDisplay display = game.getBoard().getDisplay();
        frame.getContentPane().removeAll();
        game.setFrame(frame);
        game.getBoard().restart();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        inGameMenu nextMenu = new inGameMenu(game, frame);
        display.repaint();
        frame.getContentPane().add(display, BorderLayout.CENTER);
        frame.getContentPane().add(nextMenu, BorderLayout.LINE_END);
        /*
        Issue #TODO Fill in
        the turn panel is doing some funky stuff when the game is restarted
        commented out for now, so it disappears when pressing restart
         */
//        frame.getContentPane().add(display.getTurnPanel(), BorderLayout.PAGE_START);
        frame.revalidate();
        frame.repaint();
        game.restartGame();
    }

    /**
     * abstract method for general "back" button that appears on several menus
     * has a different function depending upon context, hence abstract
     */
    public abstract void back(Game game, JFrame frame);

}
