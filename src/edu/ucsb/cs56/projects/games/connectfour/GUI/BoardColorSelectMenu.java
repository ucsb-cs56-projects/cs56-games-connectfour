package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *Class for the board color selection menu
 *@author Brian Lee
 *@version CS56 F16
 */

public class BoardColorSelectMenu extends AbstractMenu
{
    private JLabel header;
    private JButton greyButton;
    private JButton blackButton;
    private JButton pinkButton;
    private JButton brownButton;
    private JButton redButton;
    private JButton yellowButton;
    private JButton beigeButton;
    private JButton cyanButton;
    private JButton oliveButton;
    //private JButton gradGreyToBlackButton;

    //constructor
    public BoardColorSelectMenu(Game game, JFrame frame, int stateToNotShow1, int stateToNotShow2)
    {
	super(game,frame);
	
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        header = new JLabel("       Choose Board Color");
        header.setFont(smallFont);

        greyButton = new JButton("Grey");
	greyButton.addActionListener(new greyButtonListener());
	greyButton.setFont(largeFont);

	blackButton = new JButton("Black");
	blackButton.addActionListener(new blackButtonListener());
	blackButton.setFont(largeFont);

	pinkButton = new JButton("Light Pink");
	pinkButton.addActionListener(new pinkButtonListener());
	pinkButton.setFont(largeFont);

	redButton = new JButton("Red");
	redButton.addActionListener(new redButtonListener());
	redButton.setFont(largeFont);

	yellowButton = new JButton("Yellow");
	yellowButton.addActionListener(new yellowButtonListener());
	yellowButton.setFont(largeFont);

	beigeButton = new JButton("Beige");
	beigeButton.addActionListener(new beigeButtonListener());
	beigeButton.setFont(largeFont);

	cyanButton = new JButton("Cyan");
	cyanButton.addActionListener(new cyanButtonListener());
	cyanButton.setFont(largeFont);

	oliveButton = new JButton("Olive");
	oliveButton.addActionListener(new oliveButtonListener());
	oliveButton.setFont(largeFont);
	/*
	gradGreyToBlackButton = new JButton("Gradient, grey to black");
	gradGreyToBlackButton.addActionListener(new gGTBButtonListener());
	gradGreyToBlackButton.setFont(largeFont);
	*/
	this.add(header);
	this.add(greyButton);
	if(stateToNotShow1 != 1 && stateToNotShow2 != 1)
	    {
		this.add(redButton);
	    }
	if(stateToNotShow1 != 2 && stateToNotShow2 != 2)
	    {
		this.add(yellowButton);
	    }
	if(stateToNotShow1 != 4 && stateToNotShow2 != 4)
	    {
		this.add(blackButton);
		//this.add(gradGreyToBlackButton);
	    }
	if(stateToNotShow1 != 8 && stateToNotShow2 != 8)
	    {
		this.add(pinkButton);
	    }
	this.add(beigeButton);
	this.add(cyanButton);
	this.add(oliveButton);
    }

    /**
     * Action Listener for the grey button
     * Sets board color to light grey and launches the game
     */
    class greyButtonListener implements ActionListener
    {
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
    class redButtonListener implements ActionListener
    {
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
    class yellowButtonListener implements ActionListener
    {
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
    class blackButtonListener implements ActionListener
    {
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
    class pinkButtonListener implements ActionListener
    {
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
    class beigeButtonListener implements ActionListener
    {
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
    class cyanButtonListener implements ActionListener
    {
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
    class oliveButtonListener implements ActionListener
    {
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
