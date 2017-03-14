package Snake;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class SnakeBoard extends JPanel implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	private char c = 'e';
	static final int width = 40;
	static final int height = 40;

	static Square squares[][] = new Square[width][height];

	public void createFrame() throws IOException {
		
		setLayout(new GridBagLayout());
		setBackground(Color.black);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(1,1,1,1);
		
		SnakePic snakePic = new SnakePic();
		c.gridx = 0;
		c.gridy = 0;
		
		for (int x = 0; x < width; x++) {
			c.gridx = x;
			for (int y = 0; y < height; y++) {
				c.gridy = y;
				squares[x][y] = new Square(x, y, snakePic);
				add(squares[x][y], c);
			}
		}
		int l = 5;
		for (int x = 5; x < 5 + l; x++) {
			 int y = 10;
			 squares[x][y].toggleSnake();
		 }
		//add(background);
		addKeyListener(this);
		setFocusable(true);
		requestFocusInWindow();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		c = e.getKeyChar();
			if (c == 'w') {
				squares[1][1].toggleSnake();
				System.out.println("asd");
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
