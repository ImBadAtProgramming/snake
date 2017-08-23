package Snake;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeBoard extends JPanel implements KeyListener, ActionListener {
	
	private static final long serialVersionUID = 1L;
	private char c;
	static final int width = 41;
	static final int height = 41;
	public static int start = 0;
	public static int snakeLength = 5;
	public static int snakeScore = 5;
	public static int level = 1;
	public static final int levels = 2;
	public static final int win = 50;
	public int totalCherry = 0;
	public int totalPepper = 0;
	private boolean forward = true;
	private boolean backward = false;
	private boolean up = false;
	private boolean down = false;
	public static boolean playing = true;
	public static boolean speed = true;
	public JFrame snake;
	Timer timer;
	Timer delay;

	static Square squares[][] = new Square[width][height];
	static Queue<Square> snakeQueue = new LinkedBlockingQueue<Square>();

	public SnakeBoard(JFrame snake) {
		this.snake = snake;
	}
	
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
		makeBoard();
		//add(background);
		addKeyListener(this);
		setFocusable(true);
		requestFocusInWindow();
		timer = new Timer(50, this);
		timer.start();
	}
	public void makeBoard() {
		// TODO Auto-generated method stub
		//*******\\
		//level 1\\
		//*******\\
		if (level == 1) {
			//top wall
			int y = 0;
			for (int x = 0; x < width; x++) {
				squares[x][y].setWall();
			}
			//bottom wall
			y = height - 1;
			for (int x = 0; x < width; x++) {
				squares[x][y].setWall();
			}
			//top left wall
			int x = 0;
			for (y = 0; y < (height / 2 - 3); y++) {
				squares[x][y].setWall();
			}
			//bottom left wall
			for (y = height - 1; y > (height / 2 + 3); y--) {
				squares[x][y].setWall();
			}
			//left portal
			for (y = (height / 2 - 3); y < (height / 2 + 4); y++) {
				squares[x][y].setPortal();
			}
			//top right wall
			x = width - 1;
			for (y = 0; y < (height / 2 - 3); y++) {
				squares[x][y].setWall();
			}
			//bottom right wall
			for (y = height - 1; y > (height / 2 + 3); y--) {
				squares[x][y].setWall();
			}
			//right portal
			for (y = (height / 2 - 3); y < (height / 2 + 4); y++) {
				squares[x][y].setPortal();
			}
		}
		
		//*******\\
		//level 2\\
		//*******\\
		if (level == 2) {
			//clears screen
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					squares[x][y].setBlank();
				}
			}
			int y = 0;
			int x = 0;
			//top wall
			for (x = 0; x < width; x++) {
				squares[x][y].setWall1();
			}
			//left wall
			x = 0;
			for (y = 0; y < height; y++) {
				squares[x][y].setWall1();
			}
			//right wall
			x = width - 1;
			for (y = 0; y < height; y++) {
				squares[x][y].setWall1();
			}
			//bottom wall
			x = 0;
			y = height - 1;
			for (x = 0; x < width; x++) {
				squares[x][y].setWall1();
			}
			//middle top wall
			x = (width / 2);
			for (y = 0; y < (3 * height / 4 - 2); y++) {
				squares[x][y].setWall1();
			}
			//middle bottom wall
			for (y = height - 1; y > (3 * height / 4 + 2); y--) {
				squares[x][y].setWall1();
			}
			//middle left wall
			y = (height / 2);
			for (x = 0; x < (width / 4 - 2); x++) {
				squares[x][y].setWall1();
			}
			//middle right wall
			for (x = (width - 1); x > (width / 4 + 2); x--) {
				squares[x][y].setWall1();
			}
			//top portal
			y = 0;
			for (x = 8; x < 13; x++) {
				squares[x][y].setPortal();
			}
			//bottom portal
			y = height - 1;
			for (x = (width / 2 + 8); x < (width / 2 + 13); x++) {
				squares[x][y].setPortal();
			}
			//left portal
			x = 0;
			for (y = (height / 2 + 8); y < (height / 2 + 13); y++) {
				squares[x][y].setPortal();
			}
			//right portal
			x = width - 1;
			for (y = (height / 2 - 12); y < (height / 2 - 7); y ++) {
				squares[x][y].setPortal();
			}
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		c = e.getKeyChar();
		if (c == 'd' && !backward) {
			forward = true;
			backward = false;
			up = false;
			down = false;
		}
		if (c == 'w' && !down) {
			forward = false;
			backward = false;
			up = true;
			down = false;
		}
		if (c == 's' && !up) {
			forward = false;
			backward = false;
			up = false;
			down = true;
		}
		if (c == 'a' && !forward) {
			forward = false;
			backward = true;
			up = false;
			down = false;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	int baseX = 2;
	int baseY = 2;
	int x = baseX;
	int y = baseY;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		speed = !speed;
		start = start + 1;
		
		if (snakeScore == win) {
			nextLevel();
			snakeQueue.clear();
		}
		if (levels < level) {
			Snake.gameWon();
			level = 0;
		}
		if (totalCherry == 0 && playing) {
			
			int x = (int) (width * Math.random());
			int y = (int) (height * Math.random());
			
			if (!squares[x][y].hasSnake() && !squares[x][y].hasWall() && !squares[x][y].hasWall1()
					&& !squares[x][y].hasPortal() && !squares[x][y].hasBadFood()) {
				squares[x][y].setFood();
				totalCherry = totalCherry + 1;		
			}
		}
		if (totalPepper == 0 && playing) {
				
			int x = (int) (width * Math.random());
			int y = (int) (height * Math.random());
				
			if (!squares[x][y].hasSnake() && !squares[x][y].hasWall() && !squares[x][y].hasWall1()
					&& !squares[x][y].hasPortal() && !squares[x][y].hasFood()) {
				squares[x][y].setBadFood();
				totalPepper = totalPepper + 1;
			}
		}
		if (playing && speed) {
			//level 1 movement conditions
			if (level == 1 && start > 19) {
				
				if (forward) {
					x = x + 1;
					if (x == width - 1) {
						x = 0;
					}
				}	
				if (up) {
					y = y - 1;
				}
				if (down) {
					y = y + 1;
				}
				if (backward) {
					x = x - 1;
					if (x == 0) {
						x = width - 1;
					}
				}
			}
			//level 2 movement conditions
			if (level == 2 && start > 19) {
				if (forward) {
					x = x + 1;
					if (x == width - 1) {
						x = 0;
						y = y + 20;
					}
				}
				if (up) {
					y = y - 1;
					if (y == 0) {
						y = height - 1;
						x = x + 20;
					}
				}
				if (down) {
					y = y + 1;
					if (y == height - 1) {
						y = 0;
						x = x - 20;
					}
				}
				if (backward) {
					x = x - 1;
					if (x == 0) {
						x = width - 1;
						y = y - 20;
					}
				}
			}
			if (squares[x][y].hasWall() || squares[x][y].hasWall1() || squares[x][y].hasSnake() && start > 19) {
				Snake.gameOver();
			}
			
			squares[x][y].setSnake();
			snakeQueue.add(squares[x][y]);
			
			if (squares[x][y].hasFood()) {
				squares[x][y].deSetFood();
				snakeLength = snakeLength + 5;
				snakeScore = snakeScore + 5;
				totalCherry = 0;
				totalPepper = 0;
			}
			if (squares[x][y].hasBadFood()) {
				squares[x][y].deSetBadFood();
				snakeScore = snakeScore - 10;
				snakeLength = snakeLength - 5;
				totalPepper = 0;
				if (snakeScore < 0) {
					snakeScore = 0;
				}
			}
			if (snakeLength < 5) {
				snakeLength = 5;
			}
			if (snakeScore < 0) {
				snakeScore = 0;
			}
			
			if (snakeQueue.size() > snakeLength) {
				Square square = snakeQueue.remove();
				square.deSetSnake();
			}
		
		Snake.lengthLabel.setText(Integer.toString(snakeLength));
		Snake.scoreLabel.setText(Integer.toString(snakeScore));
		}
		if (playing && (speed || !speed)) {
			if (snakeQueue.size() > snakeLength) {
				Square square = snakeQueue.remove();
				square.deSetSnake();
			}
		}
	}
	
	private void nextLevel() {
		// TODO Auto-generated method stub
			System.out.println("Level Completed!");
			Snake.informativeLabel.setText("Level Completed!");
			level = SnakeBoard.level + 1;
			snakeLength = 5;
			snakeScore = 5;
			start = 0;
			makeBoard();
			x = baseX;
			y = baseY;
			forward = true;
			backward = false;
			up = false;
			down = false;
	}
}

