package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

/**
 * Class for the player color selection menu for player 2
 * @author Joel Bagan
 * @author Bryanna Phan
 * @version CS56 M16 UCSB
 *
 * @author Brian Lee
 * @version CS56 F16 UCSB
 */
public class Player2ColorSelectMenu extends AbstractMenu {

    private JLabel Background;
    private Image BackgroundImage;
    private BufferedImage BufferedBackgroundImage;
    private JLabel header;
    private JButton blackButton;
    private Image blackButtonImage;
    private BufferedImage bufferedBlackButtonImage;
    private JButton blueButton;
    private Image blueButtonImage;
    private BufferedImage bufferedBlueButtonImage;
    private JButton magentaButton;
    private Image magentaButtonImage;
    private BufferedImage bufferedMagentaButtonImage;
    private JButton brownButton;
    private Image brownButtonImage;
    private BufferedImage bufferedBrownButtonImage;
    private JButton pinkButton;
    private Image pinkButtonImage;
    private BufferedImage bufferedPinkButtonImage;
    private JButton redButton;
    private Image redButtonImage;
    private BufferedImage bufferedRedButtonImage;
    private JButton yellowButton;
    private Image yellowButtonImage;
    private BufferedImage bufferedYellowButtonImage;
    private JButton backButton;
    private Image backButtonImage;
    private BufferedImage bufferedBackButtonImage;
    private JLabel nameInst;
    private JTextField nameText;
    private int stateToNotShow;

    /**
     * Constructor for the Player2ColorSelectMenu
     * Note: The header is centered via us being lazy, future students should try to center it correctly
     *
     * @param game game object that is passed to all menus so they can access game data
     * @param frame the JFrame reference that is passed to all load(*)Menu functions so they can add menus to the frame
     * @param stateToNotShow int representing the color chosen by player 1 in the previous menu so this menu knows which
     *                       button to not display
     */
    public Player2ColorSelectMenu(Game game, JFrame frame, int stateToNotShow) {
        super(game, frame);
	    this.stateToNotShow = stateToNotShow;
        frame.setTitle("Player 2 Color and Name");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        header = new JLabel("    Player 2: Choose Color");
	    header.setForeground(Color.white);
        header.setFont(smallFont);
        header.setAlignmentX(Component.CENTER_ALIGNMENT);


        backgroundImage();

        // Black button
        blackButtonImage();

        // Blue button
        blueButtonImage();

        // Magenta Button
        magentaButtonImage();
	    
        // Brown button
        brownButtonImage();

        // Pink button
        pinkButtonImage();

        // Red button
        redButtonImage();

        // Yellow button
        yellowButtonImage();

        // Back button
        backButtonImage();

	
	    this.add(Background);

	    //Fix Issue #58
	    if(game.getGameMode() == 1) {
		    nameInst = new JLabel("Enter Player 2 name:");
	    }
	    else {
		    nameInst = new JLabel("Enter Computer name:");
	    }
        nameInst.setFont(smallFont);
        nameInst.setForeground(Color.white);
        nameInst.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameText = new JTextField("Player 2");
        nameText.setFont(smallFont);
        nameText.setFocusable(true);
        nameText.requestFocus();
        nameText.setHorizontalAlignment(JLabel.CENTER);

        background();
    }

    private void backButtonImage() {
        try {
            bufferedBackButtonImage = ImageIO.read(new File("images/BackButton.png"));
            backButtonImage = bufferedBackButtonImage.getScaledInstance(175, 30, Image.SCALE_DEFAULT);
            backButton = new JButton(new ImageIcon(backButtonImage));
            backButton.setBorder(BorderFactory.createEmptyBorder());
            backButton.setContentAreaFilled(false);
            backButton.addActionListener(new backButtonListener());
            backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch( IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }

    private void yellowButtonImage() {
        try{
            bufferedYellowButtonImage = ImageIO.read(new File("images/YellowButton.png"));
            yellowButtonImage = bufferedYellowButtonImage.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            yellowButton = new JButton(new ImageIcon(yellowButtonImage));
            yellowButton.setBorder(BorderFactory.createEmptyBorder());
            yellowButton.setContentAreaFilled(false);
            yellowButton.addActionListener(new yellowButtonListener());
            yellowButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }

    private void redButtonImage() {
        try{
            bufferedRedButtonImage = ImageIO.read(new File("images/RedButton.png"));
            redButtonImage = bufferedRedButtonImage.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            redButton = new JButton(new ImageIcon(redButtonImage));
            redButton.setBorder(BorderFactory.createEmptyBorder());
            redButton.setContentAreaFilled(false);
            redButton.addActionListener(new redButtonListener());
            redButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }

    private void pinkButtonImage() {
        try{
            bufferedPinkButtonImage = ImageIO.read(new File("images/PinkButton.png"));
            pinkButtonImage = bufferedPinkButtonImage.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            pinkButton = new JButton(new ImageIcon(pinkButtonImage));
            pinkButton.setBorder(BorderFactory.createEmptyBorder());
            pinkButton.setContentAreaFilled(false);
            pinkButton.addActionListener(new pinkButtonListener());
            pinkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }

    private void brownButtonImage() {
        try{
            bufferedBrownButtonImage = ImageIO.read(new File("images/BrownButton.png"));
            brownButtonImage = bufferedBrownButtonImage.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            brownButton = new JButton(new ImageIcon(brownButtonImage));
            brownButton.setBorder(BorderFactory.createEmptyBorder());
            brownButton.setContentAreaFilled(false);
            brownButton.addActionListener(new brownButtonListener());
            brownButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }

    private void magentaButtonImage() {
        try{
            bufferedMagentaButtonImage = ImageIO.read(new File("images/MagentaButton.png"));
            magentaButtonImage = bufferedMagentaButtonImage.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            magentaButton = new JButton(new ImageIcon(magentaButtonImage));
            magentaButton.setBorder(BorderFactory.createEmptyBorder());
            magentaButton.setContentAreaFilled(false);
            magentaButton.addActionListener(new magentaButtonListener());
            magentaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }

    private void blueButtonImage() {
        try{
            bufferedBlueButtonImage = ImageIO.read(new File("images/BlueButton.png"));
            blueButtonImage = bufferedBlueButtonImage.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            blueButton = new JButton(new ImageIcon(blueButtonImage));
            blueButton.setBorder(BorderFactory.createEmptyBorder());
            blueButton.setContentAreaFilled(false);
            blueButton.addActionListener(new blueButtonListener());
            blueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }

    private void blackButtonImage() {
        try{
            bufferedBlackButtonImage = ImageIO.read(new File("images/BlackButton.png"));
            blackButtonImage = bufferedBlackButtonImage.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            blackButton = new JButton(new ImageIcon(blackButtonImage));
            blackButton.setBorder(BorderFactory.createEmptyBorder());
            blackButton.setContentAreaFilled(false);
            blackButton.addActionListener(new blackButtonListener());
            blackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }

    private void backgroundImage() {
        try{
            BufferedBackgroundImage = ImageIO.read(new File("images/background.png"));
            BackgroundImage = BufferedBackgroundImage.getScaledInstance(250,375, Image.SCALE_DEFAULT);
            Background = new JLabel(new ImageIcon(BackgroundImage));
            Background.setAlignmentX(Component.CENTER_ALIGNMENT);
            Background.setLayout(new BoxLayout(Background, BoxLayout.Y_AXIS));
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    private void background() {
        Background.add(header);
        if (stateToNotShow != 1) {
            Background.add(redButton);
        }
        if (stateToNotShow != 2) {
            Background.add(yellowButton);
        }
        if (stateToNotShow != 4) {
            Background.add(blackButton);
        }
        if (stateToNotShow != 5) {
            Background.add(blueButton);
        }
        if (stateToNotShow != 6) {
            Background.add(magentaButton);
        }
        if (stateToNotShow != 7) {
            Background.add(brownButton);
        }
        if (stateToNotShow != 8) {
            Background.add(pinkButton);
        }
        Background.add(backButton);
        //this.add(Box.createVerticalStrut(40));
        Background.add(nameInst);
        Background.add(nameText);
    }
    /**
     * Listener class for the black button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */

    class blackButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
	    //Issue #58 get name
      	    String getName = nameText.getText();
            game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(4);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,4);
	    }
    }
    /**
     * Listener class for the blue button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class blueButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
      	    //Issue #58 get name
	        String getName = nameText.getText();
	        game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(5);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,5);
        }
    }
    /**
     * Listener class for the magenta button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class magentaButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
       	    //Issue #58 get name
	        String getName = nameText.getText();
	        game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(6);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,6);
        }
    }
    /**
     * Listener class for the red button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class brownButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
       	    //Issue #58 get name
       	    String getName = nameText.getText();
	        game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(7);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,7);
        }
    }
    /**
     * Listener class for the pink button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class pinkButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
       	    //Issue #58 get name
	        String getName = nameText.getText();
	        game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(8);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,8);
        }
    }
    /**
     * Listener class for the red button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class redButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
      	    //Issue #58 get name
            String getName = nameText.getText();
            game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(1);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,1);
        }
    }
    /**
     * Listener class for the yellow button
     * Sets player2's color and calls launchGame() or BoardColorSelectMenu
     */
    class yellowButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
     	    //Issue #58 get name
            String getName = nameText.getText();
            game.setP2Name(getName);
            game.setP2NoName();

            game.setPlayer2Color(2);
            //launchGame();
	    loadBoardColorSelectMenu(game,frame,stateToNotShow,2);
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

    /**
     * Loads the main menu
     *
     * @param game
     * @param frame
     */
    @Override
    public void back(Game game, JFrame frame) {
        loadMainMenu(game, frame);
        //return;
    }


}
