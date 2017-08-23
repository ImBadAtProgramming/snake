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
	private boolean hasFood = false;
	private boolean hasSnake = false;
	private boolean hasWall = false;
	private boolean hasWall1 = false;
	private boolean hasPortal = false;
	private boolean hasPepper = false;
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
		if (hasFood) {
			img = snakePic.getImage(SnakePic.ImgType.CHERRY);
		}
		if (hasPepper) {
			img = snakePic.getImage(SnakePic.ImgType.PEPPER);
		}
		if (hasWall) {
			img = snakePic.getImage(SnakePic.ImgType.WALL);
		}
		if (hasWall1) {
			img = snakePic.getImage(SnakePic.ImgType.WALL1);
		}
		if (hasPortal) {
			img = snakePic.getImage(SnakePic.ImgType.PORTAL);
		}
		return img;
	}
	public boolean hasBadFood() {
		return hasPepper;
	}
	public void deSetBadFood() {
		hasPepper = false;
	}
	public void setBadFood() {
		hasPepper = true;
		repaint();
	}
	public void setBlank() {
		hasFood = false;
		hasPepper = false;
		hasSnake = false;
		hasWall = false;
		hasWall1 = false;
		hasPortal = false;
	}
	public void setWall1() {
		hasWall1 = true;
	}
	public boolean hasWall1() {
		return hasWall1;
	}
	public void setPortal() {
		hasPortal = true;
		hasWall = false;
		hasWall1 = false;
	}
	public boolean hasPortal() {
		return hasPortal;
	}
	public boolean hasWall() {
		return hasWall;
	}
	public void setWall() {
		hasWall = true;
	}
	public void setFood() {
		hasFood = true;
		repaint();
	}
	public void deSetFood() {
		hasFood = false;
	}
	public boolean hasFood() {
		return hasFood;
	}
	public boolean hasSnake() {
		return hasSnake;
	}
	public void setSnake() {
		hasSnake = true;
		repaint();
	}
	public void deSetSnake() {
		// TODO Auto-generated method stub
		hasSnake = false;
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

