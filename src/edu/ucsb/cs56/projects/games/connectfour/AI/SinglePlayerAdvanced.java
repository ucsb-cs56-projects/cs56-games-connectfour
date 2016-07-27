package edu.ucsb.cs56.projects.games.connectfour.AI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Board;
import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;
import edu.ucsb.cs56.projects.games.connectfour.Logic.IntPair;
import edu.ucsb.cs56.projects.games.connectfour.Logic.Tuple;

import java.util.ArrayList;
import java.util.Random;

/**
 * Single Player Advanced difficulty class
 * This level of AI scans the entire board and maintains
 * lists of moves to either block or make. It intelligently
 * chooses its move by comparing int values that represent
 * the "weight" of each move.
 * Currently, the AI does NOT avoid setting up wins for the
 * human player, though it could easily be programmed to do so
 * by maintaining another list of moves to avoid, and ensuring
 * that it does not make any of those moves
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 */
public class SinglePlayerAdvanced {
    /**
     * Method that scans Board object b for all horizontal triples of
     * opponent's circles from left to right, top to bottom. Calls
     * checkAndAdd to check if move is legal and update lists of moves
     *
     * @param b            Board reference to retrieve relevant game data
     * @param movesToBlock List of moves that is updated with possible moves for the AI to block
     * @param movesToMake  List of moves that is updated with possible moves for the AI to make
     */
    private static void horizLeftRight(Board b, ArrayList<Tuple> movesToMake, ArrayList<Tuple> movesToBlock) {
        int xIndex;
        int yIndex;
        Game game = b.getGame();
        int player1Color = game.getPlayer1Color();
        int player2Color = game.getPlayer2Color();

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                //check for 3 in a row of opponent
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col + 1, row).getState()
                        && player1Color == b.getGameGridCircle(col + 2, row).getState()
                        && (b.getGameGridCircle(col + 3, row).getState() == 0)) {
                    xIndex = col + 3;
                    yIndex = row;
                    checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                }
                //check for 2 in a row of opponent
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col + 1, row).getState()
                        && (b.getGameGridCircle(col + 2, row).getState() == 0)) {
                    if (b.getGameGridCircle(col + 3, row).getState() == 0) {
                        xIndex = col + 2;
                        yIndex = row;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col + 3, row).getState() == player1Color) {
                        xIndex = col + 2;
                        yIndex = row;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                    }
                }
                //check for 3 in a row of AI
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col + 1, row).getState()
                        && player2Color == b.getGameGridCircle(col + 2, row).getState()
                        && (b.getGameGridCircle(col + 3, row).getState() == 0)) {
                    xIndex = col + 3;
                    yIndex = row;
                    checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                }
                //check for 2 in a row of AI
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col + 1, row).getState()
                        && (b.getGameGridCircle(col + 2, row).getState() == 0)) {
                    if (b.getGameGridCircle(col + 3, row).getState() == 0) {
                        xIndex = col + 2;
                        yIndex = row;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col + 3, row).getState() == player2Color) {
                        xIndex = col + 2;
                        yIndex = row;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                    }
                }
            }
        }
    }

    /**
     * Method that scans Board object b for all horizontal triples of
     * opponent's circles from right to left, top to bottom. Calls
     * checkAndAdd to check if move is legal and update lists of moves
     *
     * @param b            Board reference to retrieve relevant game data
     * @param movesToBlock List of moves thats is updated with possible moves for the AI to block
     * @param movesToMake  List of moves thats is updated with possible moves for the AI to make
     */
    private static void horizRightLeft(Board b, ArrayList<Tuple> movesToMake, ArrayList<Tuple> movesToBlock) {
        int xIndex;
        int yIndex;
        Game game = b.getGame();
        int player1Color = game.getPlayer1Color();
        int player2Color = game.getPlayer2Color();
        for (int row = 0; row < 6; row++) {
            for (int col = 6; col > 2; col--) {
                //check for 3 in a row of human player
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col - 1, row).getState()
                        && player1Color == b.getGameGridCircle(col - 2, row).getState()
                        && (b.getGameGridCircle(col - 3, row).getState() == 0)) {
                    xIndex = col - 3;
                    yIndex = row;
                    checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                }
                //check for 2 in a row of human player
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col - 1, row).getState()
                        && (b.getGameGridCircle(col - 2, row).getState() == 0)) {
                    if (b.getGameGridCircle(col - 3, row).getState() == 0) {
                        xIndex = col - 2;
                        yIndex = row;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col - 3, row).getState() == player1Color) {
                        xIndex = col - 2;
                        yIndex = row;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                    }
                }
                //check for 3 in a row of AI
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col - 1, row).getState()
                        && player2Color == b.getGameGridCircle(col - 2, row).getState()
                        && (b.getGameGridCircle(col - 3, row).getState() == 0)) {
                    xIndex = col - 3;
                    yIndex = row;
                    checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                }
                //check for 2 in a row of AI
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col - 1, row).getState()
                        && (b.getGameGridCircle(col - 2, row).getState() == 0)) {
                    if (b.getGameGridCircle(col - 3, row).getState() == 0) {
                        xIndex = col - 2;
                        yIndex = row;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col - 3, row).getState() == player2Color) {
                        xIndex = col - 2;
                        yIndex = row;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                    }
                }
            }
        }
    }

    /**
     * Method that scans Board object b for all vertical triples of
     * opponent's circles from left to right, bottom to top. Does NOT
     * call checkAndAdd, as it is unnecessary to check, adds manually
     *
     * @param b            Board reference to retrieve relevant game data
     * @param movesToMake  List of moves thats is updated with possible moves for the AI to make
     * @param movesToBlock List of moves thats is updated with possible moves for the AI to block
     */
    private static void vertical(Board b, ArrayList<Tuple> movesToMake, ArrayList<Tuple> movesToBlock) {
        int xIndex;
        int yIndex;
        Game game = b.getGame();
        int player1Color = game.getPlayer1Color();
        int player2Color = game.getPlayer2Color();

        for (int col = 0; col < 7; col++) {
            for (int row = 5; row > 2; row--) {
                //check for 3 in a row of human color
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col, row - 1).getState()
                        && player1Color == b.getGameGridCircle(col, row - 2).getState()
                        && (b.getGameGridCircle(col, row - 3).getState() == 0)) {
                    xIndex = col;
                    yIndex = row - 3;
                    IntPair location = new IntPair(xIndex,yIndex);
                    movesToBlock.add(new Tuple(location, 2));
                }
                //check for 2 in a row of human color
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col, row - 1).getState()
                        && (b.getGameGridCircle(col, row - 2).getState() == 0)) {
                    xIndex = col;
                    yIndex = row - 2;
                    IntPair location = new IntPair(xIndex,yIndex);
                    movesToBlock.add(new Tuple(location, 1));
                }
                //check for 3 in a row of AI color
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col, row - 1).getState()
                        && player2Color == b.getGameGridCircle(col, row - 2).getState()
                        && (b.getGameGridCircle(col, row - 3).getState() == 0)) {
                    xIndex = col;
                    yIndex = row - 3;
                    IntPair location = new IntPair(xIndex,yIndex);
                    movesToMake.add(new Tuple(location, 2));
                }
                //check for 2 in a row of AI color
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col, row - 1).getState()
                        && (b.getGameGridCircle(col, row - 2).getState() == 0)) {
                    xIndex = col;
                    yIndex = row - 2;
                    IntPair location = new IntPair(xIndex,yIndex);
                    movesToMake.add(new Tuple(location, 1));
                }
            }
        }
    }

    /**
     * Method that scans Board object b for all diagonal triples of
     * opponent's circles in South-East direction. Calls
     * checkAndAdd to check if move is legal and update lists of moves
     *
     * @param b            Board reference to retrieve relevant game data
     * @param movesToBlock List of moves thats is updated with possible moves for the AI to block
     * @param movesToMake  List of moves thats is updated with possible moves for the AI to make
     */
    private static void diagLeftRight_Right(Board b, ArrayList<Tuple> movesToMake, ArrayList<Tuple> movesToBlock) {
        int xIndex;
        int yIndex;
        Game game = b.getGame();
        int player1Color = game.getPlayer1Color();
        int player2Color = game.getPlayer2Color();

        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 3; row++) {
                //check for 3 in a row of human color
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col + 1, row + 1).getState()
                        && player1Color == b.getGameGridCircle(col + 2, row + 2).getState()
                        && (b.getGameGridCircle(col + 3, row + 3).getState() == 0)) {
                    xIndex = col + 3;
                    yIndex = row + 3;
                    checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                }
                //check for 2 in a row of human color
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col + 1, row + 1).getState()
                        && (b.getGameGridCircle(col + 2, row + 2).getState() == 0)) {
                    if (b.getGameGridCircle(col + 3, row + 3).getState() == 0) {
                        xIndex = col + 2;
                        yIndex = row + 2;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col + 3, row + 3).getState() == player1Color) {
                        xIndex = col + 2;
                        yIndex = row + 2;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                    }
                }
                //check for 3 in a row of AI color
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col + 1, row + 1).getState()
                        && player2Color == b.getGameGridCircle(col + 2, row + 2).getState()
                        && (b.getGameGridCircle(col + 3, row + 3).getState() == 0)) {
                    xIndex = col + 3;
                    yIndex = row + 3;
                    checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                }
                //check for 2 in a row of AI color
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col + 1, row + 1).getState()
                        && (b.getGameGridCircle(col + 2, row + 2).getState() == 0)) {
                    if (b.getGameGridCircle(col + 3, row + 3).getState() == 0) {
                        xIndex = col + 2;
                        yIndex = row + 2;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col + 3, row + 3).getState() == player2Color) {
                        xIndex = col + 2;
                        yIndex = row + 2;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                    }
                }
            }
        }
    }

    //diagonal upper left to lower right, right to left

    /**
     * Method that scans Board object b for all diagonal triples of
     * opponent's circles in North-West direction. Calls
     * checkAndAdd to check if move is legal and update lists of moves
     *
     * @param b            Board reference to retrieve relevant game data
     * @param movesToBlock List of moves thats is updated with possible moves for the AI to block
     * @param movesToMake  List of moves thats is updated with possible moves for the AI to make
     */
    private static void diagLeftRight_Left(Board b, ArrayList<Tuple> movesToMake, ArrayList<Tuple> movesToBlock) {
        int xIndex;
        int yIndex;
        Game game = b.getGame();
        int player1Color = game.getPlayer1Color();
        int player2Color = game.getPlayer2Color();

        for (int col = 6; col > 2; col--) {
            for (int row = 5; row > 2; row--) {
                //check for 3 in a row of human color
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col - 1, row - 1).getState()
                        && player1Color == b.getGameGridCircle(col - 2, row - 2).getState()
                        && (b.getGameGridCircle(col - 3, row - 3).getState() == 0)) {
                    xIndex = col - 3;
                    yIndex = row - 3;
                    checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                }
                //check for 2 in a row of human color
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col - 1, row - 1).getState()
                        && (b.getGameGridCircle(col - 2, row - 2).getState() == 0)) {
                    if (b.getGameGridCircle(col - 3, row - 3).getState() == 0) {
                        xIndex = col - 2;
                        yIndex = row - 2;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col - 3, row - 3).getState() == player1Color) {
                        xIndex = col - 2;
                        yIndex = row - 2;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                    }
                }
                //check for 3 in a row of AI
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col - 1, row - 1).getState()
                        && player2Color == b.getGameGridCircle(col - 2, row - 2).getState()
                        && (b.getGameGridCircle(col - 3, row - 3).getState() == 0)) {
                    xIndex = col - 3;
                    yIndex = row - 3;
                    checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                }
                //check for 2 in a row of AI
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col - 1, row - 1).getState()
                        && (b.getGameGridCircle(col - 2, row - 2).getState() == 0)) {
                    if (b.getGameGridCircle(col - 3, row - 3).getState() == 0) {
                        xIndex = col - 2;
                        yIndex = row - 2;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col - 3, row - 3).getState() == player2Color) {
                        xIndex = col - 2;
                        yIndex = row - 2;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                    }
                }
            }
        }
    }

    /**
     * Method that scans Board object b for all diagonal triples of
     * opponent's circles in South-West direction. Calls checkAndAdd
     * to check if move is legal and update lists of moves
     *
     * @param b            Board reference to retrieve relevant game data
     * @param movesToBlock List of moves thats is updated with possible moves for the AI to block
     * @param movesToMake  List of moves thats is updated with possible moves for the AI to make
     */
    private static void diagRightLeft_Left(Board b, ArrayList<Tuple> movesToMake, ArrayList<Tuple> movesToBlock) {
        int xIndex;
        int yIndex;
        Game game = b.getGame();
        int player1Color = game.getPlayer1Color();
        int player2Color = game.getPlayer2Color();

        for (int col = 6; col >= 3; col--) {
            for (int row = 0; row < 3; row++) {
                //check for 3 in a row of human color
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col - 1, row + 1).getState()
                        && player1Color == b.getGameGridCircle(col - 2, row + 2).getState()
                        && (b.getGameGridCircle(col - 3, row + 3).getState() == 0)) {
                    xIndex = col - 3;
                    yIndex = row + 3;
                    checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                }
                //check for 2 in a row of human color
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col - 1, row + 1).getState()
                        && (b.getGameGridCircle(col - 2, row + 2).getState() == 0)) {
                    if (b.getGameGridCircle(col - 3, row + 3).getState() == 0) {
                        xIndex = col - 2;
                        yIndex = row + 2;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col - 3, row + 3).getState() == player1Color) {
                        xIndex = col - 2;
                        yIndex = row + 2;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                    }
                }
                //check for 3 in a row of AI color
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col - 1, row + 1).getState()
                        && player2Color == b.getGameGridCircle(col - 2, row + 2).getState()
                        && (b.getGameGridCircle(col - 3, row + 3).getState() == 0)) {
                    xIndex = col - 3;
                    yIndex = row + 3;
                    checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                }
                //check for 2 in a row of AI color
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col - 1, row + 1).getState()
                        && (b.getGameGridCircle(col - 2, row + 2).getState() == 0)
                        && (b.getGameGridCircle(col - 3, row + 3).getState() == 0)) {
                    if (b.getGameGridCircle(col - 3, row + 3).getState() == 0) {
                        xIndex = col - 2;
                        yIndex = row + 2;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col - 3, row + 3).getState() == player2Color) {
                        xIndex = col - 2;
                        yIndex = row + 2;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                    }
                }
            }
        }
    }

    /**
     * Method that scans Board object b for all diagonal triples of
     * opponent's circles in North-East direction. Calls checkAndAdd
     * to check if move is legal and add to list of moves
     *
     * @param b            Board reference to retrieve relevant game data
     * @param movesToBlock List of moves thats is updated with possible moves for the AI to block
     * @param movesToMake  List of moves thats is updated with possible moves for the AI to make
     */
    private static void diagRightLeft_Right(Board b, ArrayList<Tuple> movesToMake, ArrayList<Tuple> movesToBlock) {
        int xIndex;
        int yIndex;
        Game game = b.getGame();
        int player1Color = game.getPlayer1Color();
        int player2Color = game.getPlayer2Color();

        for (int col = 0; col < 4; col++) {
            for (int row = 5; row > 2; row--) {
                //check for 3 in a row of human color
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col + 1, row - 1).getState()
                        && player1Color == b.getGameGridCircle(col + 2, row - 2).getState()
                        && (b.getGameGridCircle(col + 3, row - 3).getState() == 0)) {
                    xIndex = col + 3;
                    yIndex = row - 3;
                    checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                }
                //check for 2 in a row of human color
                if (player1Color == b.getGameGridCircle(col, row).getState()
                        && player1Color == b.getGameGridCircle(col + 1, row - 1).getState()
                        && (b.getGameGridCircle(col + 2, row - 2).getState() == 0)) {
                    if (b.getGameGridCircle(col + 3, row - 3).getState() == 0) {
                        xIndex = col + 2;
                        yIndex = row - 2;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col + 3, row - 3).getState() == player1Color) {
                        xIndex = col + 2;
                        yIndex = row - 2;
                        checkAndAdd(b, movesToBlock, xIndex, yIndex, 2);
                    }
                }
                //check for 3 in a row of AI color
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col + 1, row - 1).getState()
                        && player2Color == b.getGameGridCircle(col + 2, row - 2).getState()
                        && (b.getGameGridCircle(col + 3, row - 3).getState() == 0)) {
                    xIndex = col + 3;
                    yIndex = row - 3;
                    checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                }
                //check for 2 in a row of AI color
                if (player2Color == b.getGameGridCircle(col, row).getState()
                        && player2Color == b.getGameGridCircle(col + 1, row - 1).getState()
                        && (b.getGameGridCircle(col + 2, row - 2).getState() == 0)) {
                    if (b.getGameGridCircle(col + 3, row - 3).getState() == 0) {
                        xIndex = col + 2;
                        yIndex = row - 2;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 1);
                    }
                    if (b.getGameGridCircle(col + 3, row - 3).getState() == player2Color) {
                        xIndex = col + 2;
                        yIndex = row - 2;
                        checkAndAdd(b, movesToMake, xIndex, yIndex, 2);
                    }
                }
            }
        }
    }

    /**
     * Method checks that the location on Board object b passed in (xIndex,yIndex)
     * is a legal move and adds that location into movesToBlockOrAdd
     *
     * @param b                 Board reference to get relevant game data
     * @param movesToBlockOrAdd list of moves which will be appened to if the position at xIndex, yIndex is valid
     * @param xIndex            x coordinate of the move in question
     * @param yIndex            y coordinate of the move in question
     */
    private static void checkAndAdd(Board b, ArrayList<Tuple> movesToBlockOrAdd, int xIndex, int yIndex, int weight) {
        if (yIndex != Board.numRows - 1
                && b.getGameGridCircle(xIndex, yIndex + 1).getState() != 0) {
            IntPair location = new IntPair(xIndex, yIndex);
            movesToBlockOrAdd.add(new Tuple(location, weight));
        }
        //check if in bottom row
        if (yIndex == Board.numRows - 1) {
            IntPair location = new IntPair(xIndex, yIndex);
            movesToBlockOrAdd.add(new Tuple(location, weight));
        }
    }

    /**
     * Method that finds all possible moves to block the human from winning, and all possible moves
     * to win. Possible moves are added to instance variables movesToMake and movesToBlock
     *
     * @param b            Board on which moves are calculated
     * @param movesToMake  List of moves that will be updated with legal moves for the AI to make
     * @param movesToBlock List of moves that will be updated with legal moves for the AI to block
     */
    private static void findMoves(Board b, ArrayList<Tuple> movesToMake, ArrayList<Tuple> movesToBlock) {
        horizLeftRight(b, movesToMake, movesToBlock);
        horizRightLeft(b, movesToMake, movesToBlock);
        vertical(b, movesToMake, movesToBlock);
        diagLeftRight_Right(b, movesToMake, movesToBlock);
        diagLeftRight_Left(b, movesToMake, movesToBlock);
        diagRightLeft_Right(b, movesToMake, movesToBlock);
        diagRightLeft_Left(b, movesToMake, movesToBlock);
    }

    /**
     * Method determines best possible move to make given two ArrayList objects of moves to block
     * and moves to make. Find highest weight in movesToMake, if a win is possible then make winning move.
     * If no winning move and opponent is 1 move away from winning, then block opponent, else make a random move
     *
     * @param b            Board reference that is used to retrieve relevant game data
     * @param movesToMake  List of moves that is searched for possible move to make
     * @param movesToBlock List of moves that searched for possible move to block
     * @return Intpair of best move AI can currently calculate
     */
    public static IntPair calculateMove(Board b, ArrayList<Tuple> movesToMake, ArrayList<Tuple> movesToBlock) {
        for (Tuple item : movesToMake) {
            if (item.getWeight() == 2) {
                System.out.println("I'm smart, so I'm winning at " + item.getLocation().getX() + "," + item.getLocation().getY());
                return item.getLocation();
            }
        }
        for (Tuple item : movesToBlock) {
            if (item.getWeight() == 2) {
                System.out.println("I'm smart, so I'm blocking you at " + item.getLocation().getX() + "," + item.getLocation().getY());
                return item.getLocation();
            }
        }
        for (Tuple item : movesToMake) {
            if (item.getWeight() == 1) {
                System.out.println("Hmm, my best move is to make this triple at " + item.getLocation().getX() + "," + item.getLocation().getY());
                return item.getLocation();
            }
        }
        for (Tuple item : movesToBlock) {
            if (item.getWeight() == 1) {
                System.out.println("Hmm, my best move is to block your triple at " + item.getLocation().getX() + "," + item.getLocation().getY());
                return item.getLocation();
            }
        }

        Random rand = new Random();
        int xIndex = rand.nextInt(7);
        int yIndex = 0;
        // make sure random column is not already full
        while (b.getGameGridCircle(xIndex, yIndex).getState() != 0) {
            xIndex = (xIndex + 1) % 7;
        }
        //find the lowest empty slot in the chosen column
        while ((yIndex != Board.numRows - 1) && (b.getGameGridCircle(xIndex, yIndex + 1).getState() == 0)) {
            yIndex++;
            if (yIndex == Board.numRows - 1) {
                break;
            }
        }
        System.out.println("Hmm, I'm not sure so I'm guessing " + xIndex + "," + yIndex);
        return new IntPair(xIndex, yIndex);
    }

    /**
     * Method that generates an advanced move and returns and IntPair of the spot that was chosen.
     *
     * @param b Board on which the move should be made.
     * @return IntPair the IntPair of the spot at which the move is made
     */
    public static IntPair AdvancedComputerMove(Board b) {
        ArrayList<Tuple> movesToMake = new ArrayList<Tuple>();
        ArrayList<Tuple> movesToBlock = new ArrayList<Tuple>();

        if (!b.getGame().isGameIsOver()) {
            findMoves(b, movesToMake, movesToBlock);
            IntPair move = calculateMove(b, movesToMake, movesToBlock);
            return move;
        }
        return new IntPair(0, 0);
    }

}





