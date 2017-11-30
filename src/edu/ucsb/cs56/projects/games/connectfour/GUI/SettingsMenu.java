package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for settings menu
 * Currently only has a checkbox for entering Testing mode for easy printing out of game grid
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class SettingsMenu extends AbstractMenu {

    private JButton mainMenuButton;
    private JButton audioMenuButton;
    private JCheckBox testingModeBox;

    /**
     * Constructor for the settingsPanel
     */
    public SettingsMenu(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Settings");


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);

        audioMenuButton = new JButton("Audio");
        audioMenuButton.addActionListener(new audioButtonListener());
        audioMenuButton.setFont(BFont);
        audioMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainMenuButton = new JButton("Back");
        mainMenuButton.addActionListener(new backButtonListener());
        mainMenuButton.setFont(BFont);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        testingModeBox = new JCheckBox("Testing Mode");
        testingModeBox.addActionListener(new testingModeBoxListener());
        testingModeBox.setSelected(false);
        testingModeBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(testingModeBox);
        this.add(audioMenuButton);
        this.add(mainMenuButton);
        frame.getContentPane().add(this);
    }

    /**
     * Listener class for the audio menu button
     */
    class audioButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            loadAudioPage(game, frame);
        }
    }

    /**
     * Listener class for the testing mode check box
     */
    class testingModeBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JCheckBox cb = (JCheckBox) event.getSource();
            if (cb.isSelected()) {
                game.setTestingModeEnabled(true);
                System.out.println("Testing Mode Enabled");
            } else {
                game.setTestingModeEnabled(false);
                System.out.println("Testing Mode Disabled");
            }
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

    public void loadAudioPage(Game game, JFrame frame) {
        frame.setSize(menu_width, menu_height);
        frame.getContentPane().removeAll();
        AudioMenu nextMenu = new AudioMenu(game, frame);
        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    @Override
    public void back(Game game, JFrame frame) {
        loadMainMenu(game, frame);
    }
}
