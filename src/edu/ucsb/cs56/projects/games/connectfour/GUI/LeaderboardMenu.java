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
    private JScrollPane leaderBoard;

    public LeaderboardMenu(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Leaderboard");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        backgroundImage();
        topScoresImage();
        mainMenuImage();
        leaderBoard();

	    this.add(Background);
        background();
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
    private void topScoresImage(){
        try{
            topScoresImageBuffered = ImageIO.read(new File("images/TopPlayersLabel.png"));
            topScoresImage = topScoresImageBuffered.getScaledInstance(200,50, Image.SCALE_DEFAULT);
            topScores = new JLabel(new ImageIcon(topScoresImage));
            topScores.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    private void mainMenuImage(){
        try{
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
    }
    private void leaderBoard(){
        game.loadLeaderBoard();
        String[] columns = {"Name", "Score"};
        Object[][] data = new Object[10][2];
        for (int r=0; r<10; r++){
            data[r][0] = game.getScoreName(r);
            data[r][1] = game.getScoreScore(r);
        }
        JTable table = new JTable(data, columns);
        table.setEnabled(false);
        for(int i = 0; i < 2; i++){
            table.getColumnModel().getColumn(i).setMaxWidth(100);
        }
        leaderBoard = new JScrollPane();
        leaderBoard.setViewportView(table);
        leaderBoard.setPreferredSize(new Dimension(100,50));
        table.setFillsViewportHeight(true);
        leaderBoard.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void background(){
        Background.add(Box.createRigidArea(new Dimension(0, 10)));
        Background.add(mainMenuButton);
        Background.add(Box.createRigidArea(new Dimension(0, 10)));
        Background.add(topScores);
        Background.add(Box.createRigidArea(new Dimension(0, 50)));
        Background.add(leaderBoard);
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