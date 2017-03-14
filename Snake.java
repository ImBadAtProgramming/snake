package Snake;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake {
	
	static JPanel background;
	
	public static void main (String agr[]) throws IOException {
		SnakeBoard board = new SnakeBoard();
		board.createFrame();
		//board.add(SnakeBoard.background);
		
		JFrame frame = new JFrame("SnakeTester");
		
//		JPanel mainPanel = new JPanel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(board);
		
		frame.pack();
	    frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
