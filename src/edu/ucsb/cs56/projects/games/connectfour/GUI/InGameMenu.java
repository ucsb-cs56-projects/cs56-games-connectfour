package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Class for the menu panel shown while the game is played.
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class InGameMenu extends AbstractMenu {

    private JButton mainMButton;
    private JButton restartButton;
    private JButton exitButton;
    private JButton undoButton;
    private JLabel leaderBoardLabel;
    private JScrollPane leaderBoard;

    /**
     * @param game  game object that is passed to all menus so they can access game data
     * @param frame the JFrame reference that is passed to all load(*)Menu functions so they can add menus to the frame
     */
    public InGameMenu(Game game, JFrame frame) {
        super(game, frame);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0, 50)));

        mainMButton = new JButton("Main Menu");
        mainMButton.addActionListener(new mainMenuButtonListener());
        mainMButton.setFont(largeFont);
        mainMButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        restartButton = new JButton("Restart");
        restartButton.addActionListener(new restartButtonListener());
        restartButton.setFont(largeFont);
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new exitButtonListener());
        exitButton.setFont(largeFont);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        undoButton = new JButton("Undo");
        undoButton.addActionListener(new undoButtonListener());
        undoButton.setFont(largeFont);
        undoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	leaderBoardLabel = new JLabel("Leaderboard");
	leaderBoardLabel.setLabelFor(leaderBoard);
	leaderBoardLabel.setSize(50,30);
	leaderBoardLabel.setBackground(Color.BLACK);
	leaderBoardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	//saving and loading done here
	       	
	
	//adding leaderboard here
	
	String[] columns = {"Name", "Score"};
	
	//reading in data
	game.loadLeaderBoard();
	
	Object[][] data = { {game.getScoreName(0), game.getScoreScore(0)},{game.getScoreName(1), game.getScoreScore(1)}};
	
	//Object[][] data = { {"supperino", 100}};
	
	JTable table = new JTable(data, columns); 
       	for(int i = 0; i < 2; i++){
	    table.getColumnModel().getColumn(i).setMaxWidth(100);
	}
	leaderBoard = new JScrollPane(table);
	leaderBoard.setPreferredSize(new Dimension(100,50));
	table.setFillsViewportHeight(true);
	leaderBoard.setAlignmentX(Component.CENTER_ALIGNMENT);

	if (game.isTestingModeEnabled()) {
            JButton printBoard = new JButton("Print Board");
            printBoard.addActionListener(new printBoardButtonListener());
            printBoard.setFont(largeFont);
           this.add(printBoard);
        }
        this.add(undoButton);
        this.add(restartButton);
        this.add(mainMButton);
        this.add(exitButton);
	this.add(leaderBoardLabel);
	this.add(leaderBoard);
    }

    /**
     * Method for printing the state of the board to the command line
     * Printed as an int[][] where the ints represent the state of each
     * circle
     * formated for easy copy/pasting into test functions to assign
     * an int[][] with a literal
     * @param game
     */
    public void printBoard(Game game) {
        int rowEnd = game.getBoard().numRows;
        int colEnd = game.getBoard().numColumns;

        System.out.println("{");
        for (int y = 0; y < rowEnd; y++) {
            System.out.print("{ ");
            for (int x = 0; x < colEnd; x++) {

                System.out.printf("%1d ", game.getBoard().getGameGrid()[x][y].getState());
                if (!(x == colEnd - 1)) {
                    System.out.print(",");
                }
            }
            System.out.print(" }");
            if (!(y == rowEnd - 1)) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("}");
    }

    /**
     * Listener class for the Print Board button
     */
    class printBoardButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            printBoard(game);
        }
    }
    /**
     * Listener class for the restart button
     */
    class restartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            restartGame();
        }
    }

    /**
     * Listener class for the main menu button
     */

    class mainMenuButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.removeMouseListener(frame.getMouseListeners()[0]);
            game.setGameIsOver(true);
            loadMainMenu(game, frame);
        }
    }


    /**
     * Listener class for the exit button
     */
    class exitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    /**
     * Listener class for the undo button
     */
    class undoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            game.undo();
        }
    }

    /**
     * No back button, only "Main Menu" button
     * One could make a backButton with the string "Main Menu"
     * and call loadMainMenu() in this function, but that isn't
     * the clearest code-wise so we leave blank
     *
     * @param game  game object that is passed to all menus so they can access game data
     * @param frame the JFrame reference that is passed to all load(*)Menu functions so they can add menus to the frame the JFrame reference that is passed to all load(*)Menu functions so they can add menus to the frame
     */
    @Override
    public void back(Game game, JFrame frame) {
        return;
    }
}



