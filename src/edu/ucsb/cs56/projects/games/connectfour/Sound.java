package edu.ucsb.cs56.projects.games.connectfour;

import java.awt.event.*;
import javax.swing.*;
import sun.audio.*;
import java.io.*;


public class Sound {


	AudioPlayer gameMusic = AudioPlayer.player;
	AudioStream musicImported;
	AudioData musicData;
	ContinuousAudioDataStream loop = null;

	try{
	musicImported = new AudioStream (new FileInputStream("BackroundMusic.mp3"));
	musicData = musicImported.getData();
	loop = new ContinuousAudioDataStream(musicData);
	}
	catch(IOException error){}

	gameMusic.start(loop);
    }
}
