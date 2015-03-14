/*package edu.ucsb.cs56.projects.games.connectfour;

import java.awt.event.*;
import javax.swing.*;
import sun.audio.*;
import java.io.*;


public class Sound {

    public static void music()
    {
    AudioPlayer MGP = AudioPlayer.player;
    AudioStream BGM;
    AudioData MD;
    ContinuousAudioDataStream loop = null;
    
    try{
	BGM = new AudioStream (new FileInputStream("BackroundMusic.mp3"));
	MD = BGM.getData();
	loop = new ContinuousAudioDataStream(MD);
    }
    catch(IOException error){
	System.out.println(" music didn't work");
}
    
    MGP.start(loop);
    }
}

*/
