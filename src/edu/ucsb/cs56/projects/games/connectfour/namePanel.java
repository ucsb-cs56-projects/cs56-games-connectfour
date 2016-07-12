package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

// Panel for telling whose turn it is and displaying it.

/**
 * Class for the panel in player color selection screens.
 */

public class namePanel extends JPanel {
    private JLabel enterName; // Textfield indicating whose turn it is
    public JTextField nameText;

    /**
     * Constructor for inGameMenuPanel
     *
     * @param ss startScreen2
     */
    public namePanel(startScreen2 ss) {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        Font smallFont = new Font("Comic Sans MS", Font.BOLD, 15);

        enterName = new JLabel("Enter Name: ");
        enterName.setFont(smallFont);
        nameText = new JTextField("");
        nameText.setFont(smallFont);
        nameText.setFocusable(true);
        nameText.requestFocus();

        // this.add(Box.createRigidArea(new Dimension(0,50)));
        this.add(enterName);
        this.add(nameText);
    }

    public String getName() {
        return nameText.getText();
    }
}
    
