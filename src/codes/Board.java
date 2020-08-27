package codes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements KeyListener {

	public final static int LENGTH = 600, WIDTH = 550;
	Pacman pacman;
	
	Ghost[] ghost = new Ghost[3];
	Brick[] bricks = new Brick[3];
	
	public Board(){
		
		pacman = new Pacman(0,0,"images//pacman.png");
		
		for(int i = 0; i < ghost.length; i++){
			ghost[i] = new Ghost((int)(Math.random()* 500),(int)(Math.random()* 500),"images//ghost.png");
			bricks[i] = new Brick((int)(Math.random()* 500),(int)(Math.random()* 500),"images//brick.png");
		}
			
		super.addKeyListener(this);
	}
	

	public void paint(Graphics g){

		ImageIcon background = new ImageIcon("images//background.jpg");	
		Image back_img = background.getImage();
		g.drawImage(back_img,0,0,null);
		
		pacman.draw(g);
		
		for(int i = 0; i < ghost.length; i++){
			ghost[i].draw(g);
			bricks[i].draw(g);
		}	
	}

	public void eatGhost(){
		
		Rectangle pacmanRect = new Rectangle(pacman.getX(),pacman.getY(),30,30);
		
		for(int i = 0; i < ghost.length; i++){
			
			Rectangle ghostRect = new Rectangle(ghost[i].getX(),ghost[i].getY(),20,20);
			
			if(pacmanRect.intersects(ghostRect) == true){
				GameSound.eatGhostSound();
				ghost[i].setX(1000);
			}
		}
	}
	
	public boolean checkBrickCollision(){
		
		Rectangle pacmanRect = new Rectangle(pacman.getX(),pacman.getY(),30,30);
		
		for(int i = 0; i < bricks.length; i++){
			
			Rectangle brickRect = new Rectangle(bricks[i].getX(),bricks[i].getY(),24,28);
			
			if(pacmanRect.intersects(brickRect) == true){
				GameSound.smashBricksSound();
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isGameOver(){
		
		for(int i = 0; i < ghost.length; i++){
			
				if(ghost[i].getX() != 1000)
					return false;
			
		}
		
		return true;
		
	}
	
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == e.VK_UP){
		  pacman.moveUp();
		  
		  if(checkBrickCollision() == true){
			  pacman.moveDown();
		  	pacman.moveDown();
		  }
		  
	}
		  
		else if(e.getKeyCode() == e.VK_DOWN){
			pacman.moveDown();
			
			if(checkBrickCollision() == true){
				  pacman.moveUp();
			 	  pacman.moveUp();
			}
	}
		else if(e.getKeyCode() == e.VK_LEFT){
			pacman.moveLeft();
			
			if(checkBrickCollision() == true){
				  pacman.moveRight();
			 	  pacman.moveRight();	
		}
		
		}
		else if(e.getKeyCode() == e.VK_RIGHT){
			pacman.moveRight();
			
			if(checkBrickCollision() == true){
				  pacman.moveLeft();
			      pacman.moveLeft();
			      
			}
		}
		eatGhost();
		super.repaint();
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
