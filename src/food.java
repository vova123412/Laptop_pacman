	import java.awt.Graphics;
	import java.awt.Image;
	import java.io.IOException;
	import javax.swing.ImageIcon;

public class food 
{  		static int counter=0;
		private int number=0; 
		private int x;
		private int y;
		private Image icon;
		public food(int y,int x)
		{
			this.number=counter;
			this.counter++;
			this.y=y;
			this.x=x;
		    this.icon =new ImageIcon("dot.png").getImage();
		}
		
		
	 public void draw(Graphics g)
		  {
			  g.drawImage(icon, x, y, 20, 20, null);
		  }
		


}
