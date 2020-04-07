import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.geom.AffineTransform;  

public class Pacman extends Thread implements KeyListener
{
	private Matrix My_matrix;
	private char buffer_2;
	private char buffer;
	private Mypanel p;
	private int x;
	private int last_x;
	private int last_y;
	private int y;
	private Image icon;
	private Image left_image;
	private Image up_image;
	private Image down_image;
	private Image right_image;
	private Matrix cheak;
	
	public Pacman(Mypanel panel,Matrix rules) throws IOException
	{
		
		this.My_matrix=rules;
		this.cheak=rules;
		this.buffer='f';
		this.p=panel;
		this.x=20;
		this.y=20;
		this.right_image=new ImageIcon("l3k.gif").getImage();
		this.left_image=new ImageIcon("left.gif").getImage();
		this.up_image=new ImageIcon("up.gif").getImage();
		this.down_image=new ImageIcon("down.gif").getImage();
		this.icon =right_image;
		this.setName("pacman");
	    
	}



	public Matrix getMy_matrix() {
		return My_matrix;
	}

	public void setMy_matrix(Matrix my_matrix) {
		My_matrix = my_matrix;
	}

	public char getBuffer_2() {
		return buffer_2;
	}

	public void setBuffer_2(char buffer_2) {
		this.buffer_2 = buffer_2;
	}

	public char getBuffer() {
		return buffer;
	}

	public void setBuffer(char buffer) {
		this.buffer = buffer;
	}

	public Mypanel getP() {
		return p;
	}

	public void setP(Mypanel p) {
		this.p = p;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getIcon() {
		return icon;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}

	public Image getLeft_image() {
		return left_image;
	}

	public void setLeft_image(Image left_image) {
		this.left_image = left_image;
	}

	public Image getUp_image() {
		return up_image;
	}

	public void setUp_image(Image up_image) {
		this.up_image = up_image;
	}

	public Image getDown_image() {
		return down_image;
	}

	public void setDown_image(Image down_image) {
		this.down_image = down_image;
	}

	public Image getRight_image() {
		return right_image;
	}

	public void setRight_image(Image right_image) {
		this.right_image = right_image;
	}

	public Matrix getCheak() {
		return cheak;
	}

	public void setCheak(Matrix cheak) {
		this.cheak = cheak;
	}

	public void draw(Graphics g)//repaint()
	    {
	    g.drawImage( this.icon, x, y, 20, 20, p);
	    }


	public void run()
	{
	
		while(true) 
		{
			if(My_matrix.isGame())
			{
				last_x=x;
				last_y=y;
				switch(this.buffer_2) 
				{
				  case 'r':
					if(this.cheak.getwall(y,x+20  ,y+19,x+20)) 
				    this.buffer=buffer_2;
				    break;
				  case 'l':
					if(this.cheak.getwall(y,x-1  ,y+19,x-1)) 
						this.buffer=buffer_2;
				    break;
				  case 'u':
					    if(this.cheak.getwall(y-1,x  ,y-1, x+19))
					    this.buffer=buffer_2;
					    break;
				  case 'd':
					    if(this.cheak.getwall(y+20,x ,y+20, x+19)) 
					    this.buffer=buffer_2;
					    break;
				}
				
				//////////////////////////////////////////////////
				
				switch(buffer) 
				{
				  case 'r':
					if(this.cheak.getwall(y,x+20  ,y+19,x+20)) 
				    {icon=right_image;x=x+1;}
				    break;
				  case 'l':
					if(this.cheak.getwall(y,x-1  ,y+19,x-1)) 
					{icon=left_image;x=x-1;}
				    
				    break;
				  case 'u':
					    if(this.cheak.getwall(y-1,x  ,y-1, x+19))
					    {icon=up_image;y=y-1;}
					    break;
				  case 'd':
					    if(this.cheak.getwall(y+20,x ,y+20, x+19)) 
					  	{icon=down_image;y=y+1;}
					    break;
	
				}
				if(!(this.cheak.get_ghost(x,y))) {this.x=20;this.y=20;}
				this.cheak.update_empty_place(last_x, last_y);
				this.cheak.update_location(x, y);
				p.repaint();

			}
			
			else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		//System.out.print("p");

	
	}
	
	

	@Override
	public void keyTyped(KeyEvent e)
	{

    	switch(e.getKeyChar())
    	{
    	  case 'a':
			  if(this.cheak.getwall(y,x-1  ,y+19,x-1)) {this.buffer='l';this.buffer_2='l';}
			  else this.buffer_2='l';
    	    break;
    	  case 's':
    		  if(this.cheak.getwall(y+20,x ,y+20, x+19)) {this.buffer='d';this.buffer_2='d';}
    		  else this.buffer_2='d';
    		 break;
    	  case 'd':
				if(this.cheak.getwall(y,x+20  ,y+19,x+20)) {this.buffer='r';this.buffer_2='r';}
				else this.buffer_2='r';
    		  break;
    	  case 'w':
  				if(this.cheak.getwall(y-1,x  ,y-1, x+19)) {this.buffer='u';this.buffer_2='u';}
  				else this.buffer_2='u';
    	}
		if(e.getKeyChar()=='g')
		{
			My_matrix.setGame(false);
		}
	
	}
	
	

	public static void main(String[] args) throws IOException
	{
		Myframe f=new Myframe();
		System.out.print("main end");
	}

}
