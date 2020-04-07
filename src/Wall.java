import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Wall 
{
	private int x;
	private int y;
	private Image icon;
	public Wall(int y,int x)
	{
		this.y=y;
		this.x=x;
	    this.icon =new ImageIcon("wall.png").getImage();
	}
	
	
	  public void draw(Graphics g)
	  {
		  g.drawImage(this.icon,this.x, this.y, 20, 20, null);
	  }
	


}
