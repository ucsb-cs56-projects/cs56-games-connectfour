package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

/**                                                                                                                             
 * Class for Leaderboard menu                                                                                              
 * @author Sid Malik                                                                                                           
 * @author Alex Funk                                                                                                        
 * @version CS56 W18 UCSB                                                                                                      
 */

public class LeaderboardMenu extends AbstractMenu {

    private JLabel Background;
    private Image BackgroundImage;
    private BufferedImage BufferedBackgroundImage;
    private JButton mainMenuButton;
    private BufferedImage bufferedMainMenu;
    private Image mainMenuImage;
    private JLabel topScores;
    private Image topScoresImage;
    private BufferedImage topScoresImageBuffered;

    public LeaderboardMenu(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Leaderboard");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
   
	try{
	    BufferedBackgroundImage = ImageIO.read(new File("images/background.png"));
            BackgroundImage = BufferedBackgroundImage.getScaledInstance(250,375, Image.SCALE_DEFAULT);
            Background = new JLabel(new ImageIcon(BackgroundImage));
            Background.setAlignmentX(Component.CENTER_ALIGNMENT);
            Background.setLayout(new BoxLayout(Background, BoxLayout.Y_AXIS));

	    topScoresImageBuffered = ImageIO.read(new File("images/TopPlayersLabel.png"));
	    topScoresImage = topScoresImageBuffered.getScaledInstance(200,50, Image.SCALE_DEFAULT);
	    topScores = new JLabel(new ImageIcon(topScoresImage));
	    topScores.setAlignmentX(Component.CENTER_ALIGNMENT);

	    bufferedMainMenu = ImageIO.read(new File("images/MainMenuButton.png"));
            mainMenuImage = bufferedMainMenu.getScaledInstance(230,40, Image.SCALE_DEFAULT);
            mainMenuButton = new JButton(new ImageIcon(mainMenuImage));
            mainMenuButton.setBorder(BorderFactory.createEmptyBorder());
            mainMenuButton.setContentAreaFilled(false);
            mainMenuButton.addActionListener(new backButtonListener());
            mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	}
	catch(IOException ex){
	    System.out.println("error retrieving images for main menu");
	}
	this.add(Background);
	Background.add(Box.createRigidArea(new Dimension(0, 10)));
	Background.add(mainMenuButton);
	Background.add(Box.createRigidArea(new Dimension(0, 10)));
	Background.add(topScores);
	frame.getContentPane().add(this);
    }

    class backButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            back(game, frame);
        }

    }
    
    @Override
	public void back(Game game, JFrame frame) {
        loadMainMenu(game, frame);
    }


    

}