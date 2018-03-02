package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Board;
import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.*;

/**
 * GUI class that handles drawing the board
 * Updates via repaint() which calls paint()
 * also draws the small green circles over winning circles
 * when a win is detected in Board class
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class BoardDisplay extends AbstractMenu {


    private JPanel turnPanel = new JPanel();
    private JLabel turnMessage= new JLabel();


    /**
     * Constructor that calls super with same arguments
     * @param game Game reference passed to every GUI class
     * @param frame JFrame reference passed to every GUI class
     */
    public BoardDisplay(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Connect Four");

    }

    /**
     * Method that redraws the board and updates the circles colors
     * if a win is detected, winning circles have small green circles
     * drawn over them
     * @param g Graphics object for drawing the circles
     */
    @Override
    public void paint(Graphics g) {
       Board b = game.getBoard();
	   if(game.getBoardColor() == 9)
	   {
	       g.setColor(Color.LIGHT_GRAY);
	   }
	   else if(game.getBoardColor() == 1)
	   {
	       g.setColor(Color.RED);
	   }
	   else if(game.getBoardColor() == 2)
	   {
	       g.setColor(Color.YELLOW);
	   }
	   else if(game.getBoardColor() == 4)
	   {
	       g.setColor(Color.BLACK);
	   }
	   else if(game.getBoardColor() == 8)
	   {
	       g.setColor(new Color(225,182,193));
	   }
	   else if(game.getBoardColor() == 10)
	   {
	       g.setColor(new Color(245,245,220));
	   }
	   else if(game.getBoardColor() == 11)
	   {
		  g.setColor(Color.CYAN);
	   }
	   else if(game.getBoardColor() == 12)
	   {
	       g.setColor(new Color(107,142,35));
	   }
	/*	else if(game.getBoardColor() == 13)
	    {
		g.setColor(new GradientPaint(0,20,Color.LIGHT_GRAY,this.getWidth(),this.getHeight(),Color.BLACK));
	    }
*/
	   g.fillRect(0, 20, this.getWidth(), this.getHeight());

        for (Circle[] circles : b.getGameGrid()) {
            for (Circle circle : circles) {
                circle.draw(g);
            }
        }
        if(b.checkVertical()){
            b.getDisplay().drawVerticalWin(g, b.winX, b.winY);
            return;
        }
        if(b.checkHorizontal()){
            b.getDisplay().drawHorizontalWin(g, b.winX, b.winY);
            return;
        }
        if(b.checkMainDiagonal()){
            b.getDisplay().drawMainDiagonalWin(g, b.winX,b.winY);
            return;
        }
        if(b.checkAntiDiagonal()){
            b.getDisplay().drawAntiDiagonalWin(g, b.winX, b.winY);
            return;
        }
        if(b.checkDraw()){
            b.getDisplay().drawDraw(g);
            return;
        }
        updateTurnPanel();
        //unsure of why this method MUST be called both in this function, and on every mouse click
	//Must be called so that the players know whose turn it is.
    }

    /**
     * Method that updates and returns turnpanel
     * @return turnPanel reference after updating
     */
    public JPanel getTurnPanel() {
        updateTurnPanel();
        return turnPanel;
    }

    /**
     * Method called after each mouse click to update the turn panel
     * to display whose turn it is
     */
    public void updateTurnPanel() {
        frame.getContentPane().remove(turnPanel);
        turnPanel.remove(turnMessage);


        if (game.getTurn() == 1) {
            turnMessage.setText("It's " + game.getP1Name() + "'s turn!");
        } else {
            turnMessage.setText("It's " + game.getP2Name() + "'s turn!");
        }
        turnPanel.add(turnMessage);
        frame.getContentPane().add(turnPanel, BorderLayout.PAGE_START);
        frame.repaint();
	//System.out.println("Turn Updated");
    }

    /**
     * Method for displaying text when a draw occurs
     * @param g Graphics object for drawing the message
     */
    private void drawDraw(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times", Font.BOLD, 100));
        g.drawString("Draw", 100, 400);
    }

    /**
     * Method for removing "Draw" text when user clicks "undo" after game ends in a draw
     * @param g Graphics object for drawing the message
     */
    // private void removeDraw(Graphics g) {
    //     g.setColor(Color.BLACK);
    //     g.setFont(new Font("Times", Font.BOLD, 100));
    //     g.drawString("Draw", 100, 400);
    // }

    /**
     * Method that draws small green circles over diagonal winning
     * circles starting at (row,col)
     *
     * @param g Graphics object for drawing the circles
     * @param col x index of start of winning string of circles
     * @param row y index of start of winning string of circles
     */
    private void drawAntiDiagonalWin(Graphics g, int col, int row) {
        Circle winCircle;
        Circle[][] gameGrid = game.getBoard().getGameGrid();

        for (int i = 0; i < 4; i++) {
            winCircle = gameGrid[col - i][row + i].smallCopy();
            winCircle.setState(3);
            winCircle.draw(g);
        }
        displayWinner(g);
    }

    /**
     * Method that draws small green circles over diagonal winning
     * circles starting at (row,col)
     *
     * @param g Graphics object for drawing the circles
     * @param col x index of start of winning string of circles
     * @param row y index of start of winning string of circles
     */
    private void drawMainDiagonalWin(Graphics g, int col, int row) {
        Circle winCircle;
        Circle[][] gameGrid = game.getBoard().getGameGrid();

        for (int i = 0; i < 4; i++) {
            winCircle = gameGrid[col + i][row + i].smallCopy();
            winCircle.setState(3);
            winCircle.draw(g);
        }
        displayWinner(g);
    }

    /**
     * Method that draws small green circles over vertical winning
     * circles starting at (row,col)
     *
     * @param g Graphics object for drawing the circles
     * @param col x index of start of winning string of circles
     * @param row y index of start of winning string of circles
     */
    private void drawVerticalWin(Graphics g, int col, int row) {
        Circle winCircle;
        Circle[][] gameGrid = game.getBoard().getGameGrid();

        for (int i = 0; i < 4; i++) {
            winCircle = gameGrid[col][row + i].smallCopy();
            winCircle.setState(3);
            winCircle.draw(g);
        }
        displayWinner(g);
    }

    /**
     * Method that draws small green circles over horizontal winning
     * circles starting at (row,col)
     *
     * @param g Graphics object for drawing the circles
     * @param col x index of start of winning string of circles
     * @param row y index of start of winning string of circles
     */
    private void drawHorizontalWin(Graphics g, int col, int row) {
        Circle winCircle;
        Circle[][] gameGrid = game.getBoard().getGameGrid();
        for (int i = 0; i < 4; i++) {
            winCircle = gameGrid[col + i][row].smallCopy();
            winCircle.setState(3);
            winCircle.draw(g);
        }
        displayWinner(g);
    }


    /**
     * Displays the win message on the screen when someone has won
     * If it is Red's Turn (turn == 1), and a winner has been detected, Yellow Wins
     * If it is Yellow's Turn (turn == 2) and a winner has been detected, Red Wins
     *
     * @param g to draw the message
     */
    private void displayWinner(Graphics g) {
        game.updateLeaderBoard();
        InGameMenu leaderboard = (InGameMenu)frame.getContentPane().getComponent(1);
        leaderboard.updateLeaderBoard(game);
        leaderboard.revalidate();
        System.out.println("Winstate");
        g.setColor(Color.black);
        if ((game.getPlayer1Color() == 4) || (game.getPlayer2Color() == 4))
            g.setColor(Color.cyan);
        g.setFont(new Font("Times", Font.BOLD, 75));
        if (game.getGameMode() == 1) {
            if (game.getTurn() == 1) {
                g.drawString(game.getP2Name() + " wins!", 100, 400);
            } else {
                g.drawString(game.getP1Name() + " wins!", 100, 400);
            }
        } else {
            if (game.getTurn() == 1) {
                g.drawString("YOU LOSE!", 100, 400);
            }
            else {
                g.drawString("YOU WIN!", 100, 400);
            }
        }
        game.setGameIsOver(true);
    }

    /**
     * no back button
     * @param game
     * @param frame
     */
    @Override
    public void back(Game game, JFrame frame) {
        return;
    }

}
