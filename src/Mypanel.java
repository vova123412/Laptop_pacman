
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
public class Mypanel extends JPanel  
{
	private int counter;
	private  boolean init_matrix;
	private	Matrix game;
	private Drawfoods foods;
	private Drawwalls walls;
	private Drawscore score_;
	private Drawghost ghosts;
	private Pacman pc;
	private Menu menu;
	int x;//size
	int y;//size
	public Mypanel(int x,int y,Menu menu) throws IOException
	{
		this.menu=menu;
		this.setPreferredSize(new Dimension(560+200,620+400));
		this.setLayout(null);// for label score
		this.setFocusable(true);
        this.requestFocusInWindow();
		this.x=x;
		this.y=y;
		this.game=new Matrix(31,28);
		this.counter=this.game.getCounter();

        
        walls=new Drawwalls(this,game);
		score_=new Drawscore(game,this);
		score_.start();
        
        foods=new Drawfoods(this,game);
        foods.start();
        
		pc=new Pacman(this,game);//give packman this panel
	 	this.addKeyListener(pc);
		pc.start();//start thread
		
		ghosts=new Drawghost(this,game);
		


		this.setBackground(Color.black);
		
		
		this.setVisible(true);
		
		
	}
	public void exit()
	{
		foods.interrupt();
		score_.interrupt();
		pc.interrupt();
		ghosts.exit();
		
	}
	

    public void paintComponent(Graphics g) //from here i draw all creatures 
    {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(this.game.isGame()) 
    	{
	        super.paintComponent(g);
	        score_.draw(g);
	        foods.draw(g);
	        walls.draw(g);
	        pc.draw(g);
	        ghosts.draw(g);
    	}
    	else {
    		if(foods.Get_counter()==0)
    		{
    			menu.win_page();
    		}
    		else
    		{
    			menu.hide_game();
    		}
    			
    		}
    	
    	
    	
    }

	public Matrix getGame() {
		return game;
	}


}
