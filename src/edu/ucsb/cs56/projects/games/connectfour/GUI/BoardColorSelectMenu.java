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
 *Class for the board color selection menu
 *@author Brian Lee
 *@version CS56 F16
 */

public class BoardColorSelectMenu extends AbstractMenu
{
    
    private JLabel Background;
    private Image BackgroundImage;
    private BufferedImage BufferedBackgroundImage;
    private JLabel header;
    private JButton greyButton;
    private Image greyButtonImage;
    private BufferedImage greyButtonImageBuffered;
    private JButton blackButton;
    private Image blackButtonImage;
    private BufferedImage blackButtonImageBuffered;
    private JButton pinkButton;
    private Image pinkButtonImage;
    private BufferedImage pinkButtonImageBuffered;
    private JButton brownButton;
    private Image brownButtonImage;
    private BufferedImage brownButtonImageBuffered;
    private JButton redButton;
    private Image redButtonImage;
    private BufferedImage redButtonImageBuffered;
    private JButton yellowButton;
    private Image yellowButtonImage;
    private BufferedImage yellowButtonImageBuffered;
    private JButton beigeButton;
    private Image beigeButtonImage;
    private BufferedImage beigeButtonImageBuffered;
    private JButton cyanButton;
    private Image cyanButtonImage;
    private BufferedImage cyanButtonImageBuffered;
    private JButton oliveButton;
    private Image oliveButtonImage;
    private BufferedImage oliveButtonImageBuffered;
    //private JButton gradGreyToBlackButton;

    //constructor
    public BoardColorSelectMenu(Game game, JFrame frame, int stateToNotShow1, int stateToNotShow2){
		super(game,frame);
	    frame.setTitle("Board Color Selector");
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        header = new JLabel("Choose Board Color");
        header.setFont(smallFont);
	    header.setForeground(Color.white);
        header.setAlignmentX(Component.CENTER_ALIGNMENT);

        backgroundImage();
        blackButton();
        greyButton();
        pinkButton();
        redButton();
        yellowButton();
        beigeButton();
        cyanButton();
        oliveButton();

        this.add(Background);
        background(stateToNotShow1,stateToNotShow2); // Adds elements to background
    }
    private void backgroundImage(){
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
    private void blackButton(){
        try{
            blackButtonImageBuffered = ImageIO.read(new File("images/BlackButton.png"));
            blackButtonImage = blackButtonImageBuffered.getScaledInstance(175,30, Image.SCALE_DEFAULT);
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
    private void greyButton(){
        try{
            greyButtonImageBuffered = ImageIO.read(new File("images/GreyButton.png"));
            greyButtonImage = greyButtonImageBuffered.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            greyButton = new JButton(new ImageIcon(greyButtonImage));
            greyButton.setBorder(BorderFactory.createEmptyBorder());
            greyButton.setContentAreaFilled(false);
            greyButton.addActionListener(new greyButtonListener());
            greyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    private void pinkButton(){
        try{
            pinkButtonImageBuffered = ImageIO.read(new File("images/PinkButton.png"));
            pinkButtonImage = pinkButtonImageBuffered.getScaledInstance(175,30, Image.SCALE_DEFAULT);
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
    private void redButton(){
        try{
            redButtonImageBuffered = ImageIO.read(new File("images/RedButton.png"));
            redButtonImage = redButtonImageBuffered.getScaledInstance(175,30, Image.SCALE_DEFAULT);
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
    private void yellowButton(){
        try{
            yellowButtonImageBuffered = ImageIO.read(new File("images/YellowButton.png"));
            yellowButtonImage = yellowButtonImageBuffered.getScaledInstance(175,30, Image.SCALE_DEFAULT);
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
    private void beigeButton(){
        try{
            beigeButtonImageBuffered = ImageIO.read(new File("images/BeigeButton.png"));
            beigeButtonImage = beigeButtonImageBuffered.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            beigeButton = new JButton(new ImageIcon(beigeButtonImage));
            beigeButton.setBorder(BorderFactory.createEmptyBorder());
            beigeButton.setContentAreaFilled(false);
            beigeButton.addActionListener(new beigeButtonListener());
            beigeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    private void cyanButton(){
        try{
            cyanButtonImageBuffered = ImageIO.read(new File("images/CyanButton.png"));
            cyanButtonImage = cyanButtonImageBuffered.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            cyanButton = new JButton(new ImageIcon(cyanButtonImage));
            cyanButton.setBorder(BorderFactory.createEmptyBorder());
            cyanButton.setContentAreaFilled(false);
            cyanButton.addActionListener(new cyanButtonListener());
            cyanButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    private void oliveButton(){
        try{
            oliveButtonImageBuffered = ImageIO.read(new File("images/OliveButton.png"));
            oliveButtonImage = oliveButtonImageBuffered.getScaledInstance(175,30, Image.SCALE_DEFAULT);
            oliveButton = new JButton(new ImageIcon(oliveButtonImage));
            oliveButton.setBorder(BorderFactory.createEmptyBorder());
            oliveButton.setContentAreaFilled(false);
            oliveButton.addActionListener(new oliveButtonListener());
            oliveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    private void background(int stateToNotShow1, int stateToNotShow2){
        Background.add(header);
        Background.add(greyButton);
        if(stateToNotShow1 != 1 && stateToNotShow2 != 1) {
            Background.add(redButton);
        }
        if(stateToNotShow1 != 2 && stateToNotShow2 != 2) {
            Background.add(yellowButton);
        }
        if(stateToNotShow1 != 4 && stateToNotShow2 != 4) {
            Background.add(blackButton);
        }
        if(stateToNotShow1 != 8 && stateToNotShow2 != 8){
            Background.add(pinkButton);
        }
        Background.add(beigeButton);
        Background.add(cyanButton);
        Background.add(oliveButton);
    }
    /**
     * Action Listener for the grey button
     * Sets board color to light grey and launches the game
     */
    class greyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            //set board color to light grey
            game.setBoardColor(9);
            launchGame();
        }
    }

    /**
     * Action Listener for the red button
     * Sets board color to red and launches the game
     */
    class redButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            //set board color to red
            game.setBoardColor(1);
            launchGame();
        }
    }

    /**
     * Action Listener for the yellow button
     * Sets board color to yellow and launches the game
     */
    class yellowButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            //set board color to yellow
            game.setBoardColor(2);
            launchGame();
        }
    }

    /**
     * Action Listener for the black button
     * Sets board color to black and launches the game
     */
    class blackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            //set board color to black
            game.setBoardColor(4);
            launchGame();
        }
    }

    /**
     * Action Listener for the pink button
     * Sets board color to pink and launches the game
     */
    class pinkButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            //set board color to light pink
            game.setBoardColor(8);
            launchGame();
        }
    }

    /**
     * Action Listener for the beige button
     * Sets board color to beige and launches the game
     */
    class beigeButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent event)
        {
            //set board color to beige
            game.setBoardColor(10);
            launchGame();
        }
    }

    /**
     * Action Listener for the cyan button
     * Sets board color to cyan and launches the game
     */
    class cyanButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            //set board color to red
            game.setBoardColor(11);
            launchGame();
        }
    }

    /**
     * Action Listener for the olive button
     * Sets board color to olive and launches the game
     */
    class oliveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            //set board color to olive
            game.setBoardColor(12);
            launchGame();
        }
    }

    /**
     * Action Listener for the gadient-grey-to-black button
     * Sets board color to gradient-grey-to-black and launches the game
     */
    /*
    class gGTBButtonListener implements ActionListener
    {
	public void actionPerformed(ActionEvent event)
	{
	    //set board color to gradient-grey to black
	    game.setBoardColor(13);
	    launchGame();
	}
    }
    */
    /**
     * No Back Button
     * May add one later
     */
    @Override
    public void back(Game game, JFrame frame)
    {
        return;
    }
}
