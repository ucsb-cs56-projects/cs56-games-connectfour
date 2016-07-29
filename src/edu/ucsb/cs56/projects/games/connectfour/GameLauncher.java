package edu.ucsb.cs56.projects.games.connectfour;

import edu.ucsb.cs56.projects.games.connectfour.GUI.StartScreen;
import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;

/**
 * Creates a JFrame and Game, whose references are passed to the StartScreen's constructor
 * these references are passed from one menu to the next, so that
 * there is only one frame being drawn on, and only one Game object holding data
 * Created by Joel on 7/23/2016.
 */
public class GameLauncher {
    public static void main(String [] args) {
        JFrame frame = new JFrame();
        Game game = new Game();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        StartScreen start = new StartScreen(game, frame);
        frame.getContentPane().add(start);
        frame.setVisible(true);
    }
}
