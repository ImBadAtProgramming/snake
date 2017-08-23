package Snake;

import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Snake {
	
	public static JPanel background;
	public static String informativeText;
	public static JPanel mainPanel;
	public static String length;
	public static String score;
	public static JLabel scoreLabel;
	public static JLabel snakeScore;
	public static JFrame frame;
	public static JLabel informativeLabel;
	public static JLabel lengthLabel;
	public static SnakeBoard board;
	
	public static void main (String agr[]) throws IOException {
		
		frame = new JFrame("SnakeTester");
		
		board = new SnakeBoard(frame);
		board.createFrame();
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(topPanel);
		
		JPanel topTopPanel = new JPanel(new FlowLayout());
		JPanel bottomTopPanel = new JPanel(new FlowLayout());
		topPanel.add(topTopPanel);
		topPanel.add(bottomTopPanel);
		
		informativeLabel = new JLabel("Snake");
		topTopPanel.add(informativeLabel);
		
		JLabel snakeLabel = new JLabel("Snake Length:");
		bottomTopPanel.add(snakeLabel);
		
		length = Integer.toString(SnakeBoard.snakeLength);
		lengthLabel = new JLabel(length);
		bottomTopPanel.add(lengthLabel);
		
		scoreLabel = new JLabel("Score: ");
		bottomTopPanel.add(scoreLabel);
		
		score = Integer.toString(SnakeBoard.snakeScore);
		scoreLabel = new JLabel(score);
		bottomTopPanel.add(scoreLabel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.add(topPanel);
		mainPanel.add(board);
		frame.add(mainPanel);
		
		frame.pack();
	    frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	static void gameOver() {
		// TODO Auto-generated method stub
		System.out.println("Game over!");
		SnakeBoard.playing = false;
		informativeLabel.setText("Game Over!");
	}
	static void gameWon() {
		System.out.println("Game Won!");
		SnakeBoard.playing = false;
		informativeLabel.setText("Game Won!");
	}
}
