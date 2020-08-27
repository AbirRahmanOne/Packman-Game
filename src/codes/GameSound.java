package codes;

import javax.sound.sampled.*;
import java.io.*;

public class GameSound {

		public static void smashBricksSound(){
			
			try{
				
				File sound = new File("sounds//smash.wav");
				AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception e){
				
				
			}
		}
	
	
		public static void eatGhostSound(){
			
			try{
				
				File sound = new File("sounds//eatghost.wav");
				AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception e){
				
				
			}
		}
	
		public static void gameOverSound(){
			
			try{
				
				File sound = new File("sounds//gameOver.wav");
				AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
			}
			catch(Exception e){
				
				
			}
		}
		
		
}
