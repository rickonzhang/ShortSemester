package Mini_term;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Add_picture extends JPanel {
		Image image = null;
		
		public Add_picture() {
			URL imameUrl = Login.class.getResource("/images/java.png");
			try {
				image = ImageIO.read(imameUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		@Override
		protected void paintComponent(Graphics g)	{
			int width = this.getWidth();
			int height = this.getHeight();
			g.clearRect(0,0, width, height);
			g.drawImage(image,0,0,width,height,null);
		}
}

//JTable a = new Jtable(inquire.inquireA1,title);
