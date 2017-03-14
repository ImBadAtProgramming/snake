package Snake;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;


class Square extends JComponent implements MouseListener{

	private static final long serialVersionUID = 1L;
	static final int width = 15;
	static final int height = 15;
	
	private char c = 'e';
	private int x = 0;
	private int y = 0;
	private boolean hasForward;
	private boolean hasBackward;
	private boolean hasUp;
	private boolean hasDown;
	private boolean hasFood;
	private boolean hasSnake;
	private SnakePic snakePic;
	
	public Square(int x, int y, SnakePic snakePic) {
		
		super();
		this.x = x;
		this.y = y;
		this.setPreferredSize(new Dimension(width, height));
		this.snakePic = snakePic;
		addMouseListener(this);
	}
	
	public Image getImage() {
		
		Image img = null;
		
		if (hasSnake) {
			img = snakePic.getImage(SnakePic.ImgType.SNAKE);
		}
		if (hasForward) {
			img = snakePic.getImage(SnakePic.ImgType.SNAKE);
		}
		return img;
	}

	public void toggleSnake() {
		// TODO Auto-generated method stub
		hasSnake = !hasSnake;
		repaint();
	}
	
	public void paintComponent(Graphics g)
    {	
        super.paintComponent(g);
        
        g.drawImage(getImage(), 0, 0, null);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		hasSnake = !hasSnake;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

