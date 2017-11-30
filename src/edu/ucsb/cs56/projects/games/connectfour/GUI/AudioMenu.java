package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;
import edu.ucsb.cs56.projects.games.connectfour.GUI.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for audio menu
 * @author Eric Freilafert
 * @author Sam Kim
 * @version CS56 F17 UCSB
 */
public class AudioMenu extends AbstractMenu {

    private JButton mainMenuButton;
    private JButton changeMusicButton;
    private JButton toggleMusicButton;

    /**
     * Constructor for the Audio Page
     */
    public AudioMenu(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Audio");


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);

        changeMusicButton = new JButton("Change Music");
        changeMusicButton.addActionListener(new changeMusicListener());
        changeMusicButton.setFont(BFont);
        changeMusicButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        toggleMusicButton = new JButton("Toggle Music");
        toggleMusicButton.addActionListener(new toggleMusicListener());
        toggleMusicButton.setFont(BFont);
        toggleMusicButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainMenuButton = new JButton("Back");
        mainMenuButton.addActionListener(new backButtonListener());
        mainMenuButton.setFont(BFont);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(changeMusicButton);
        this.add(toggleMusicButton);
        this.add(mainMenuButton);
        frame.getContentPane().add(this);
    }

        /**
     * Listener for the back button
     */
    class changeMusicListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            MusicPlayer.changeSound();
        }
    }

    /**
     * Listener for the back button
     */
    class toggleMusicListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(MusicPlayer.musicOn) {
                MusicPlayer.stopSound();
            }

            else
            {
                MusicPlayer.playSound();
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

    @Override
    public void back(Game game, JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(menu_width, menu_height);
        SettingsMenu nextMenu = new SettingsMenu(game, frame);
        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
    }
}
