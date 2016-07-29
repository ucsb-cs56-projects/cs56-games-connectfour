package edu.ucsb.cs56.projects.games.connectfour;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.Stack;

/**
 * startScreen2 class uses swing gui to represent the Connect 4 start Menu
 *
 * @author Vincent Tan
 * @author Girish Kowligi
 * @author Christian Newkirk
 * @author Sarah Zhong
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version Project1, CS56, M16
 */


public class startScreen2 extends JFrame {


    public static int frame_width = 890;
    public static int frame_height = 670;
    public static int menu_width = 240;
    public static int menu_height = 380;
    public static Board b;
    private static clickStartPanel startPanel;
    private static StartScreenButtonsPanel ss;
    private int gameMode = 1;
    private static singlePlayerMenuPanel SPMenu;
    private static rulesPanel RulesMenu;
    private static inGameMenuPanel inGameMenuP;
    private static Stack<IntPair> movesList = new Stack<IntPair>();
    private static Player1ColorSelectScreen p1ColorScreen;
    private static Player2ColorSelectScreen p2ColorScreen;
    private static namePanel namePanel1;
    private static namePanel namePanel2;
    private static String p1Name;
    private static String p2Name;
    private static int player1ColorState;
    private static int player2ColorState;
    private static settingsPanel settingsMenu;
    private static JPanel turnPanel;
    private static JLabel who;
    private int firstTurn;


    /**
     * Launches game
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new startScreen2();
    }

    /**
     * Constructor intitializes JFrame For all panels
     */
    public startScreen2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(menu_width, menu_height);
        this.setResizable(false);
        startPanel = new clickStartPanel(this);
        this.add(startPanel);
        this.addMouseListener(new MouseClass());
        this.setVisible(true);
    }

    /**
     * Displays StartScreenButtonsPanel when "Click Here to Start" button pressed
     * Called from clickStartpanel
     */
    public void loadFirstMenu() {
        this.setSize(menu_width, menu_height);
        this.remove(startPanel);
        this.repaint();
        ss = new StartScreenButtonsPanel(this);
        this.add(ss);
        this.setVisible(true);
    }

    /**
     * Displays SingePlayerMenu when "Single Player" button pressed from first menu
     * Called from StartScreenButtonsPanel
     */
    public void loadSinglePlayerMenu() {
        this.setSize(menu_width, menu_height);
        this.remove(ss);
        this.repaint();
        SPMenu = new singlePlayerMenuPanel(this);
        this.add(SPMenu);
        this.revalidate();
    }

    /**
     * sets Player1 color to that corresponding to int state1 passed in
     *
     * @param state1
     */
    public void setPlayer1ColorState(int state1) {
        player1ColorState = state1;
        //b.setPlayer1State(state1);
    }

    /**
     * sets Player2 color to that corresponding to int state2 passed in
     *
     * @param state2
     */
    public void setPlayer2ColorState(int state2) {
        player2ColorState = state2;
        //b.setPlayer2State(state2);
    }

    /**
     * @return int representing Player1 color
     */
    public int getPlayer1ColorState() {
        return b.getPlayer1State();
    }

    /**
     * @return int representing Player2 color
     */
    public int getPlayer2ColorState() {
        return b.getPlayer2State();
    }

    /**
     * Displays a rulesMenu when "Rules" button pressed on first menu
     * Called from StartScreenButtonsPanel
     */
    public void loadRulesPage() {
        this.setSize(2 * menu_width, (int) (1.25 * menu_height));
        this.remove(ss);
        RulesMenu = new rulesPanel(this);
        this.add(RulesMenu);
        this.revalidate();
        this.repaint();
    }

    /**
     * Displays settingsPanel when "Settings" button pressed on first menu
     * Called from StartScreenButtonsPanel
     */
    public void loadSettingsPage() {
        this.setSize(menu_width, menu_height);
        this.remove(ss);
        this.repaint();
        settingsMenu = new settingsPanel(this);
        this.add(settingsMenu);
        this.revalidate();
        this.repaint();
    }

    /**
     * Diplays Player1ColorSelectScreen when "Multiplayer" button pressed from first menu
     * or when "Single Player Easy/Advanced" buttons pressed from singlePlayerMenuPanel
     * Called from singlePlayerMenuPanel and StartScreenButtonsPanel
     */
    public void launchPlayer1ColorSelectScreen() {
        remove(ss);
        if (SPMenu != null)
            remove(SPMenu);
        this.setSize(menu_width, menu_height);
        this.repaint();
        p1ColorScreen = new Player1ColorSelectScreen(this);
        namePanel1 = new namePanel(this);
        this.getContentPane().add(BorderLayout.NORTH, namePanel1);
        p1Name = namePanel1.getName();
        this.add(p1ColorScreen);
        this.revalidate();
        this.repaint();
    }

    /**
     * Displays Player2ColorSelectScreen after a color is chosen in Player1ColorSelect Screen
     * Called form Player1ColorSelectScreen
     */
    public void launchPlayer2ColorSelectScreen() {
        if (p1ColorScreen != null)
            remove(p1ColorScreen);
        if (namePanel1 != null) {
            p1Name = namePanel1.getName();
            if (p1Name.equals(""))
                p1Name = "Player 1";
            this.remove(namePanel1);
        }
        if (ss != null)
            remove(ss);
        this.setSize(menu_width, menu_height);
        this.remove(ss);
        p2ColorScreen = new Player2ColorSelectScreen(this, player1ColorState);
        if (gameMode == 1) {
            namePanel2 = new namePanel(this);
            this.getContentPane().add(BorderLayout.NORTH, namePanel2);
        }
        this.add(p2ColorScreen);
        this.revalidate();
        this.repaint();
    }

    /**
     * Returns to StartScreenButtonsPanel after closing all open menus
     */
    public void BackToStartScreen() {
        if (b != null) {
            b.setGameOver();
            this.remove(b);
        }
        if (inGameMenuP != null)
            this.remove(inGameMenuP);
        this.setSize(menu_width, menu_height);
        if (SPMenu != null)
            this.remove(SPMenu);
        if (RulesMenu != null)
            this.remove(RulesMenu);
        if (settingsMenu != null)
            this.remove(settingsMenu);
        this.setLayout(new BorderLayout());
        this.add(ss);
        this.revalidate();
        this.repaint();
    }

    /**
     * Random player method
     */
    public void coinToss() {
        Random randomNum = new Random();
        int result = randomNum.nextInt(2 - 1 + 1) + 1;
        b.setTurn(result);
        if (b.getTurn() == 1) {
            System.out.println("Player 1 gets to start!");
        } else {
            System.out.println("Player 2 gets to start!");
        }
    }


    /**
     * Launch the game. Remove the board if one already exists.
     */
    // remove the board if one already exists
    // and make a new one
    public void launchGame(boolean firstLaunch) {
        // Make sure Panel already Exist.
        // remove if it does.
        if (b != null)
            this.remove(b);
        if (inGameMenuP != null)
            this.remove(inGameMenuP);
        if (p1ColorScreen != null)
            this.remove(p1ColorScreen);
        if (p2ColorScreen != null) {
            this.remove(p2ColorScreen);
        }


        //remove name panels if they exist and take p2name
        if (namePanel1 != null)
            this.remove(namePanel1);
        if (namePanel2 != null) {
            p2Name = namePanel2.getName();
            if (p2Name.equals(""))
                p2Name = "Player 2";
            this.remove(namePanel2);
        }
        this.repaint();
        // set the Game size ready for The board
        this.setSize(frame_width, frame_height);
        // Remove SinglePlayer Menu if it exist
        if (SPMenu != null)
            this.remove(SPMenu);
        // remove startScreen if it exist
        if (ss != null)
            this.remove(ss);
        //this.setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        // initiate a new board and a in-Game Menu
        inGameMenuP = new inGameMenuPanel(this);
        b = new Board();
        b.setPlayer1State(player1ColorState);
        b.setPlayer2State(player2ColorState);

        // Panel for whose turn it is.
        turnPanel = new JPanel();
        who = new JLabel();
        if (firstLaunch) {
            this.coinToss();
            firstTurn = b.getTurn();
        } else {
            b.setTurn(firstTurn);
        }
        if (b.getTurn() == 2) {
            try {
                // Thread.sleep(1000);
                Robot r = new Robot();
                r.mouseMove(100, 100);
                r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);

            } catch (AWTException ex) {
                System.out.println("didn't work");
            }
        }
        if (b.getTurn() == 1)
            who.setText("It's " + p1Name + "'s turn!");
        else
            who.setText("It's " + p2Name + "'s turn!");
        turnPanel.add(who);

        // add it to frame and refresh
        /* this.add(b);
        this.add(inGameMenuP);
	      this.add(turnPanel);*/
        this.getContentPane().add(b, BorderLayout.CENTER);
        this.getContentPane().add(inGameMenuP, BorderLayout.LINE_END);
        this.getContentPane().add(turnPanel, BorderLayout.PAGE_START);
        this.revalidate();
        this.repaint();
    }

    /**
     * Undo the last move that was done. (undo 1 move is multiplayer, 2 moves if singleplayer)
     */
    public void undo() {
        if (b.checkIfGameOver())
            return;
        if (b.getMoveCounter() < 1)
            return;

        // gameMode is multiplayer
        if (gameMode == 1) {
            // Decrement moveCounter
            b.decrementMoveCounter();
            System.out.println("Move Counter Decremented to: " + b.getMoveCounter());

            // pop from movesList
            IntPair tempPair = movesList.pop();

            // switch turns back to original person
            if (b.getTurn() == 1) {
                b.setTurn(2);

            } else {
                b.setTurn(1);
            }

            int xSpot = tempPair.getX();
            int ySpot = tempPair.getY();

            // set spot as available
            b.getGameGridCircle(xSpot, ySpot).setState(0);

            // redraw circle as all white
            b.repaint();
        }

        // gameMode is singleplayer
        else if ((gameMode == 2) || (gameMode == 3) || (gameMode == 4)) {
            if (b.checkIfGameOver())
                return;
            if (b.getMoveCounter() < 1)
                return;

            // The only time there is only one move is when there is the bug
            // from X11 forwarding.
            // As a result the game can get confused and accidentally switch turns
            // if the turn state is not set.
            // (It is currently set to always return to the user's turn)
            if (b.getMoveCounter() % 2 == 1) {
                IntPair tempPair = movesList.pop();
                b.decrementMoveCounter();
                b.setTurn(1);
                System.out.println("Move Counter Decremented to: " + b.getMoveCounter());
                b.getGameGridCircle(tempPair.getX(), tempPair.getY()).setState(0);
            }

            // pop two moves fom the moves list
            // and set both spots as available
            else {
                IntPair tempPair1 = movesList.pop();
                b.decrementMoveCounter();
                IntPair tempPair2 = movesList.pop();
                b.decrementMoveCounter();

                System.out.println("Move Counter Decremented to: " + b.getMoveCounter());
                b.getGameGridCircle(tempPair1.getX(), tempPair1.getY()).setState(0);
                b.getGameGridCircle(tempPair2.getX(), tempPair2.getY()).setState(0);
            }
            if (b.getTurn() == 1)
                who.setText("It's " + p1Name + "'s turn!");
            else
                who.setText("It's " + p2Name + "'s turn!");
            turnPanel.add(who);
            b.repaint();
        }
    }

    /**
     * Listener for the mouse clicks on the board.
     */
    class MouseClass implements MouseListener {
        private int xIndex;
        private int yIndex;

        public void mouseClicked(MouseEvent e) {
            if (b.getGameOver())
                return;

            System.out.println("GameMode is " + gameMode);

            if (gameMode == 1) {// multiplayer
                b.setSinglePlayer(false);
                xIndex = e.getX() / 100;
                yIndex = 0;


                while (b.getGameGridCircle(xIndex, yIndex + 1).getState() == 0) {
                    yIndex++;
                    if (yIndex == Board.numRows - 1) {
                        break;
                    }
                }

                //if the top circle is already filled, do nothing and return
                if (yIndex == 0 && b.getGameGridCircle(xIndex, yIndex).getState() != 0) {
                    return;
                }

                //set the selected circle's state to current player's color
                if (b.getTurn() == 1) {
                    b.getGameGridCircle(xIndex, yIndex).setState(b.getPlayer1State());

                } else if (b.getTurn() == 2) {
                    b.getGameGridCircle(xIndex, yIndex).setState(b.getPlayer2State());

                }

                b.incrementMoveCounter();
                System.out.println("Move Counter: " + b.getMoveCounter());
                IntPair spotOnBoard = new IntPair(xIndex, yIndex);
                movesList.push(spotOnBoard);

                //change turns
                if (b.getTurn() == 1) {
                    b.setTurn(2);
                    //inGameMenuP.setCurrentTurn(player2ColorState);
                } else {
                    b.setTurn(1);
                    //inGameMenuP.setCurrentTurn(player1ColorState);
                }

                //repaint after every mouseClick
                b.repaint();

                b.setDrawCounter(b.getDrawCounter() + 1);

            } else {//gameMode != 1, so singleplayer

                b.setSinglePlayer(true);

                if (b.getTurn() == 1) {//if human turn
                    xIndex = e.getX() / 100;
                    yIndex = 0;
                    //find lowest empty circle
                    while (b.getGameGridCircle(xIndex, yIndex + 1).getState() == 0) {
                        yIndex++;
                        if (yIndex == Board.numRows - 1) {
                            break;
                        }
                    }

                    //if the top circle is already filled, do nothing and return
                    if (yIndex == 0 && b.getGameGridCircle(xIndex, yIndex).getState() != 0) {
                        return;
                    }

                    //set the selected circle's state to current turn value (1 or 2)
                    if (b.getTurn() == 1) {
                        b.getGameGridCircle(xIndex, yIndex).setState(b.getPlayer1State());
                    } else {
                        b.getGameGridCircle(xIndex, yIndex).setState(b.getPlayer2State());
                    }

                    b.incrementMoveCounter();
                    System.out.println("Move Counter: " + b.getMoveCounter());
                    IntPair spotOnBoard = new IntPair(xIndex, yIndex);
                    movesList.push(spotOnBoard);

                    //change turns
                    b.setTurn(2);


                    //repaint after every mouseClick
                    b.repaint();

                    b.setDrawCounter(b.getDrawCounter() + 1);


                    //Make a automatic mouse click to start the Computer Move
                    try {
                        // Thread.sleep(1000);
                        Robot r = new Robot();
                        r.mousePress(InputEvent.BUTTON1_MASK);
                        r.mouseRelease(InputEvent.BUTTON1_MASK);

                    } catch (AWTException ex) {
                        System.out.println("didn't work");
                    }
                } else {
                    if (gameMode == 2) {//
                        try {
                            Thread.sleep(500);
                            //Generate a Random Move
                            IntPair easyMoveSpot = SinglePlayerEasy.randomMove(b);
                            b.incrementMoveCounter();
                            movesList.push(easyMoveSpot);
                            System.out.println("Move Counter: " + b.getMoveCounter());
                        } catch (InterruptedException ex1) {
                            System.out.println("Broken Thread");
                        }
                    } else if (gameMode == 3) {
                        //retrieve a normal difficulty AI move
                        //generate a delay to slow computer down
                        try {
                            Thread.sleep(500);
                            IntPair normalMoveSpot = SinglePlayerNormal.normalComputerMove(b);
                            b.incrementMoveCounter();
                            movesList.push(normalMoveSpot);
                            System.out.println("Move Counter: " + b.getMoveCounter());
                        } catch (InterruptedException ex1) {
                            System.out.println("Broken Thread");
                        }
                    }// end else if (gameMode == 3)
                    else if (gameMode == 4) {
                        //retrieve an advanced difficulty AI move
                        //generate a delay to slow computer down
                        try {
                            Thread.sleep(500);
                            IntPair advancedMoveSpot = SinglePlayerAdvanced.AdvancedComputerMove(b);
                            b.incrementMoveCounter();
                            movesList.push(advancedMoveSpot);
                            System.out.println("Move Counter: " + b.getMoveCounter());
                        } catch (InterruptedException ex1) {
                            System.out.println("Broken Thread");
                        }
                    }// end else if (gameMode == 4)
                }// end else
            }// end else
            if (b.getTurn() == 1)
                who.setText("It's " + p1Name + "'s turn!");
            else
                who.setText("It's " + p2Name + "'s turn!");
            turnPanel.add(who);
        }// end Method

        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        /**
         * mouseExited is a function in the MouseListener interface
         *
         * @param e represents the mouseEvent
         */

        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        /**
         * mousePressed is a function in the MouseListener interface
         *
         * @param e represents the mouseEvent
         */

        public void mousePressed(MouseEvent e) {
            //TODO Auto-generated method stub
        }

        /**
         * mouseReleased is a function in the MouseListener interface
         *
         * @param e represents the mouseEvent
         */

        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
        }


    }


    /**
     * Get the current game mode
     *
     * @return int gameMode
     */
    //getters and Setters
    public int getGameMode() {
        return gameMode;
    }

    /**
     * Set the current game mode
     *
     * @param gMode int that determines the gamemode. 1 - multiplayer, 2 - singleplayer easy, 3 - singleplayer normal, 4 - singleplayer advanced.
     */
    public void setGameMode(int gMode) {
        gameMode = gMode;
    }


}// end of startScreen Class
