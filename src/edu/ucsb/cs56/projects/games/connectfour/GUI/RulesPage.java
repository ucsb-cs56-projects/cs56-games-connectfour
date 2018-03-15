package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the rules page
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
*/
public class RulesPage extends AbstractMenu {


    private JButton mainMenuButton;
    private JTextArea rulesTextArea;
    private JScrollPane scrollPane;
    private String rulesTextString = "RULES" +
            "\n\n*GamePlay" +
            "\n- First to get 4 of their color in a row wins \n  (Diagonal, horizontal, or vertical)." +
            "\n  If no one wins then the game is declared a Draw." +
            "\n- For Multiplayer: player 1 chooses their color first," +
            "\n  player 2 chooses their color second." +
            "\n  The undo button takes away 1 move." +
            "\n- For Singleplayer: the user chooses their color first and goes first," +
            "\n  the computer's color is the second color chosen." +
            "\n  The undo button takes away 2 moves (the user's and the computer's)." +
            "\n\n*Features " +
            "\n- Choose colors for the circles" +
            "\n- Undo button" +
            "\n- Restart game button" +
            "\n- Main menu button" +
            "\n- Exit program button";

    /**
     * Constructor for rulesPanel
     */
    public RulesPage(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Rules");


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);

        mainMenuButton(BFont);

        rulesText();

        this.add(mainMenuButton);
        this.add(rulesTextArea);
    }

    private void rulesText() {
        rulesTextArea = new JTextArea(5, 20);
        scrollPane = new JScrollPane(rulesTextArea);
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.append(rulesTextString);
    }

    private void mainMenuButton(Font BFont) {
        mainMenuButton = new JButton("Back");
        mainMenuButton.addActionListener(new backButtonListener());
        mainMenuButton.setFont(BFont);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * Listener for the Back button in the rules page
     */
    class backButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            back(game, frame);
        }

    }

    /**
     * Method called when "back" button pressed, returns to settings page
     */
    @Override
    public void back(Game game, JFrame frame) {
        loadMainMenu(game, frame);
    }
}
