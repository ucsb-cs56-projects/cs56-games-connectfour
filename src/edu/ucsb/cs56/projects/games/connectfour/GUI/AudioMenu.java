package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;
import edu.ucsb.cs56.projects.games.connectfour.GUI.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

/**
 * Class for audio menu
 * @author Eric Freilafert
 * @author Sam Kim
 * @version CS56 F17 UCSB
 */
public class AudioMenu extends AbstractMenu {
    
    private JLabel Background;
    private Image BackgroundImage;
    private BufferedImage BufferedBackgroundImage;
    private JButton mainMenuButton;
    private Image mainMenuButtonImage;
    private BufferedImage mainMenuButtonImageBuffered;
    private JButton changeMusicButton;
    private Image changeMusicButtonImage;
    private BufferedImage changeMusicButtonImageBuffered;
    private JButton toggleMusicButton;
    private Image toggleMusicButtonImage;
    private BufferedImage toggleMusicButtonImageBuffered;
    private JLabel audioSelectionLabel;
    private Image audioSelectionLabelImage;
    private BufferedImage audioSelectionLabelImageBuffered;
    private ButtonGroup musicSelection;
    private JRadioButton musicMysticalSelection;
    private JRadioButton musicObnoxiousSelection;
    private JRadioButton musicDancePopSelection;
    private JRadioButton musicBuddySelection;
    private JRadioButton musicSunnySelection;
    private JRadioButton musicTendernessSelection;

    /**
     * Constructor for the Audio Page
     */
    public AudioMenu(Game game, JFrame frame) {
        super(game, frame);
        frame.setTitle("Audio");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        backgroundImage(); // Draws background image
        changeMusicImage(); // Draws change music image and button
        toggleMusicImage(); // Draws toggle music image and button
        mainMenuButtonImage(); // Draws main menu image and button
        musicSelection(); // Draws list of music choices
	    addMusicSelections(); // Adds music selection choices to the button group

        this.add(Background);
        background();

    	frame.getContentPane().add(this);
    }
    private void backgroundImage(){
        try {
            BufferedBackgroundImage = ImageIO.read(new File("images/background.png"));
            BackgroundImage = BufferedBackgroundImage.getScaledInstance(250, 375, Image.SCALE_DEFAULT);
            Background = new JLabel(new ImageIcon(BackgroundImage));
            Background.setAlignmentX(Component.CENTER_ALIGNMENT);
            Background.setLayout(new BoxLayout(Background, BoxLayout.Y_AXIS));
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    private void changeMusicImage(){
        try{
            changeMusicButtonImageBuffered = ImageIO.read(new File("images/NextSongButton.png"));
            changeMusicButtonImage = changeMusicButtonImageBuffered.getScaledInstance(175,50, Image.SCALE_DEFAULT);
            changeMusicButton = new JButton(new ImageIcon(changeMusicButtonImage));
            changeMusicButton.setBorder(BorderFactory.createEmptyBorder());
            changeMusicButton.setContentAreaFilled(false);
            changeMusicButton.addActionListener(new changeMusicListener());
            changeMusicButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    private void toggleMusicImage(){
        try{
            toggleMusicButtonImageBuffered = ImageIO.read(new File("images/MuteButton.png"));
            toggleMusicButtonImage = toggleMusicButtonImageBuffered.getScaledInstance(175,50, Image.SCALE_DEFAULT);
            toggleMusicButton = new JButton(new ImageIcon(toggleMusicButtonImage));
            toggleMusicButton.setBorder(BorderFactory.createEmptyBorder());
            toggleMusicButton.setContentAreaFilled(false);
            toggleMusicButton.addActionListener(new toggleMusicListener());
            toggleMusicButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    private void mainMenuButtonImage(){
        try{
            mainMenuButtonImageBuffered = ImageIO.read(new File("images/BackButton.png"));
            mainMenuButtonImage = mainMenuButtonImageBuffered.getScaledInstance(175,50, Image.SCALE_DEFAULT);
            mainMenuButton = new JButton(new ImageIcon(mainMenuButtonImage));
            mainMenuButton.setBorder(BorderFactory.createEmptyBorder());
            mainMenuButton.setContentAreaFilled(false);
            mainMenuButton.addActionListener(new backButtonListener());
            mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch(IOException ex){
            System.out.println("error retrieving images for main menu");
        }
    }
    private void musicSelection(){
        Font BFont = new Font("Comic Sans MS", Font.BOLD, 22);

        audioSelectionLabel = new JLabel("Audio Selection");
        audioSelectionLabel.setFont(BFont);
        audioSelectionLabel.setForeground(Color.white);
        audioSelectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        musicMysticalSelection = new JRadioButton("Mystical");
        musicMysticalSelection.setAlignmentX(Component.LEFT_ALIGNMENT);
        musicMysticalSelection.setForeground(Color.white);
        musicMysticalSelection.addActionListener(new selectSongOneListener());

        musicObnoxiousSelection = new JRadioButton("Obnoxious");
        musicObnoxiousSelection.setAlignmentX(Component.LEFT_ALIGNMENT);
        musicObnoxiousSelection.setForeground(Color.white);
        musicObnoxiousSelection.addActionListener(new selectSongTwoListener());

        musicDancePopSelection = new JRadioButton("Pop Dance");
        musicDancePopSelection.setAlignmentX(Component.LEFT_ALIGNMENT);
        musicDancePopSelection.setForeground(Color.white);
        musicDancePopSelection.addActionListener(new selectSongThreeListener());

        musicBuddySelection = new JRadioButton("Buddy");
        musicBuddySelection.setAlignmentX(Component.LEFT_ALIGNMENT);
        musicBuddySelection.setForeground(Color.white);
        musicBuddySelection.addActionListener(new selectSongFourListener());

        musicSunnySelection = new JRadioButton("Sunny");
        musicSunnySelection.setAlignmentX(Component.LEFT_ALIGNMENT);
        musicSunnySelection.setForeground(Color.white);
        musicSunnySelection.addActionListener(new selectSongFiveListener());

        musicTendernessSelection = new JRadioButton("Tenderness");
        musicTendernessSelection.setAlignmentX(Component.LEFT_ALIGNMENT);
        musicTendernessSelection.setForeground(Color.white);
        musicTendernessSelection.addActionListener(new selectSongSixListener());


    }

    private void addMusicSelections(){
        musicSelection = new ButtonGroup();
        musicSelection.add(musicMysticalSelection);
        musicSelection.add(musicObnoxiousSelection);
        musicSelection.add(musicDancePopSelection);
        musicSelection.add(musicBuddySelection);
        musicSelection.add(musicSunnySelection);
        musicSelection.add(musicTendernessSelection);
        musicMysticalSelection.setSelected(true);
    }
    private void background() {
        Background.add(changeMusicButton);
        Background.add(toggleMusicButton);
        Background.add(mainMenuButton);
        Background.add(audioSelectionLabel);
        Background.add(musicMysticalSelection);
        Background.add(musicObnoxiousSelection);
        Background.add(musicDancePopSelection);
        Background.add(musicBuddySelection);
        Background.add(musicSunnySelection);
        Background.add(musicTendernessSelection);
    }

    
    class selectSongOneListener implements ActionListener {
	public void actionPerformed(ActionEvent event){
	    MusicPlayer.selectSong(0);
	}
    }

    class selectSongTwoListener implements ActionListener {
	public void actionPerformed(ActionEvent even){
	    MusicPlayer.selectSong(1);
	}
    }

    class selectSongThreeListener implements ActionListener {
        public void actionPerformed(ActionEvent even){
            MusicPlayer.selectSong(2);
        }
    }

    class selectSongFourListener implements ActionListener {
        public void actionPerformed(ActionEvent even){
            MusicPlayer.selectSong(3);
        }
    }

    class selectSongFiveListener implements ActionListener {
        public void actionPerformed(ActionEvent even){
            MusicPlayer.selectSong(4);
        }
    }

    class selectSongSixListener implements ActionListener {
        public void actionPerformed(ActionEvent even){
            MusicPlayer.selectSong(5);
        }
    }


        /**
     * Listener for the back button
     */
    class changeMusicListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            MusicPlayer.changeSound();
        }
    }

    /**
     * Listener for the back button
     */
    class toggleMusicListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(MusicPlayer.musicOn) {
                MusicPlayer.stopSound();
            }

            else
            {
                MusicPlayer.playSound();
            }
            
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

    @Override
    public void back(Game game, JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setSize(menu_width, menu_height);
        SettingsMenu nextMenu = new SettingsMenu(game, frame);
        frame.getContentPane().add(nextMenu);
        frame.revalidate();
        frame.repaint();
    }
}
