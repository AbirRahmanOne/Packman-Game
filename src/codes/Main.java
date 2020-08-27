package codes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setTitle("Pacman Game");
		window.setSize(600, 600);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE); 
		
		Board board = new Board();
		
		window.add(board);
		window.setVisible(true);
		board.setFocusable(true);
		
		while(board.isGameOver() == false){
			
			
			
		}
		GameSound.gameOverSound();
		JOptionPane.showMessageDialog(null, "Game Over!!!");
		window.dispose();

	}

}
