package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;
import edu.ucsb.cs56.projects.games.connectfour.Logic.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Abstract class for the menus used in the
 * Implements several useful methods that are used by multiple menus
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public abstract class AbstractMenu extends JPanel implements Serializable {
    int menu_width = 240;
    int menu_height = 380;
    private static int frame_width = 890;
    private static int frame_height = 690;
    protected final Game game;
    protected final JFrame frame;
    Font smallFont = new Font("Comic Sans MS", Font.BOLD, 15);
    Font mediumFont = new Font("Comic Sans MS", Font.BOLD, 18);
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

        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Method that displays the BoardColorSelectMenu
     *
     * @param game game object that si passed to all menus so they can access game data
     * @param frame the JFrame reference that is passed to all load(*)Menu functions so they can add menus to the frame
     * @param int colorToNotshow(*) the int reference to determine which colors do not show up in the menu
     */
    public void loadBoardColorSelectMenu(Game game, JFrame frame, int colorToNotShow1, int colorToNotShow2)
    {
        frame.getContentPane().removeAll();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(menu_width, menu_height);
        BoardColorSelectMenu nextMenu = new BoardColorSelectMenu(game, frame, colorToNotShow1, colorToNotShow2);

        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * This handles the GUI side of launching the game
     * creates the BoardDisplay and InGameMenu
     * then calls Game's launchGame() to handle
     * the logic side of launching the game
     */
    public void launchGame() {
        frame.setSize(frame_width, frame_height);
        frame.getContentPane().removeAll();
        game.setFrame(frame);
        InGameMenu nextMenu = new InGameMenu(game, frame);
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
     * Called when the Restart button is pressed on the InGameMenu
     * We've implemented it in the abstract class in case future
     * versions have a need for it in other menus
     */
    public void restartGame() {
        BoardDisplay display = game.getBoard().getDisplay();
        frame.getContentPane().removeAll();
        game.setFrame(frame);
        game.getBoard().restart();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        InGameMenu nextMenu = new InGameMenu(game, frame);
        display.repaint();
        frame.getContentPane().add(display, BorderLayout.CENTER);
        frame.getContentPane().add(nextMenu, BorderLayout.LINE_END);
        /*
        Issue #53
        the turn panel is doing some funky stuff when the game is restarted
        commented out for now, so it disappears when pressing restart
         */
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
