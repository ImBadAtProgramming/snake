package Snake;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SnakePic {
	
		private Image snake;

		enum ImgType {
			SNAKE
		}
		
		public SnakePic() throws IOException {
			
			this.snake = ImageIO.read(new FileInputStream("Images/snake.png"));
		}
		
		public Image getImage(ImgType imgType) {
			switch (imgType) {
			case SNAKE: 
				return snake;
			}
			return null;
		}
	}

