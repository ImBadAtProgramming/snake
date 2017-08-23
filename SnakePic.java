package Snake;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SnakePic {
	
		private Image snake;
		private Image cherry;
		private Image pepper;
		private Image wall;
		private Image portal;
		private Image wall1;
		private Image portal1;

		enum ImgType {
			SNAKE,
			CHERRY,
			PEPPER,
			WALL,
			PORTAL,
			WALL1,
			PORTAL1
		}
		
		public SnakePic() throws IOException {
			
			this.snake = ImageIO.read(new FileInputStream("Images/Snake/snake.png"));
			this.cherry = ImageIO.read(new FileInputStream("Images/Snake/cherry.png"));
			this.wall = ImageIO.read(new FileInputStream("Images/Snake/wall.png"));
			this.portal = ImageIO.read(new FileInputStream("Images/Snake/portal.png"));
			this.wall1 = ImageIO.read(new FileInputStream("Images/Snake/wall1.png"));
			this.portal1 = ImageIO.read(new FileInputStream("Images/Snake/portal1.png"));
			this.pepper = ImageIO.read(new FileInputStream("Images/Snake/pepper.png"));
		}
		
		public Image getImage(ImgType imgType) {
			switch (imgType) {
			case SNAKE: 
				return snake;
			case CHERRY:
				return cherry;
			case WALL:
				return wall;
			case PORTAL:
				return portal;
			case WALL1:
				return wall1;
			case PORTAL1:
				return portal1;
			case PEPPER:
				return pepper;
			}
			return null;
		}
	}

