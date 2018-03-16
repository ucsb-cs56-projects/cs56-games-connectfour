package edu.ucsb.cs56.projects.games.connectfour.GUI;

import edu.ucsb.cs56.projects.games.connectfour.Logic.Game;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.embed.swing.JFXPanel;
import java.applet.AudioClip;
import java.io.*;
import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Plays background music
 * @author Eric Freilafert
 * @version CS56 F17 UCSB
 * Music from: https://www.bensound.com
 */

public class MusicPlayer {

    //Music files must be in ".au" format
    private static String[] musicFiles =
            {"audio/maintheme.au","audio/dance.au", "audio/popdance.au", "audio/buddy.au",
                    "audio/sunny.au", "audio/tenderness.au"};
    private static Clip myClip;
    public static boolean musicOn;

    public MusicPlayer() {
        try {
            URL url = new File(musicFiles[0]).toURI().toURL();
            myClip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            myClip.open(ais);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Starts playing music in an infinite loop
    public static void playSound() {
        musicOn = true;
        myClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    //Stops playing music
    public static void stopSound() {
        musicOn = false;
        myClip.stop();
    }

    //Changes music to random song picked from musicFiles array
    public static void changeSound() {
        stopSound();
        int randomNum = ThreadLocalRandom.current().nextInt(0, musicFiles.length);

        try {
            URL url = new File(musicFiles[randomNum]).toURI().toURL();
            myClip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            myClip.open(ais);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        playSound();
    }
    
    //change to a selected song

    public static void selectSong(int i){
        stopSound();
        try{
            URL url = new File(musicFiles[i]).toURI().toURL();
            myClip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            myClip.open(ais);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        playSound();
    }
}