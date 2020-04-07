import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Drawscore extends Thread {
	private int score_counter;
	private Matrix score;
	private Image Health_score;
	private int health_counter;
	
	private Image icon;
	private Mypanel p;
	private JLabel Label;
	public Drawscore(Matrix m,Mypanel panel) 
	{
		this.Health_score=new ImageIcon("l3k.gif").getImage();
		this.health_counter=3;
		this.Label=new JLabel("score   ");
		this.Label.setSize(300, 30);
		this.Label.setLocation(0, 550);
		this.p = panel;
		this.p.add(Label);
		this.score_counter=0;
		this.score=m;
		this.icon=new ImageIcon("score.jpg").getImage();
	}
	
	 public void draw(Graphics g)
	 {
		  g.drawImage(icon,0,560, 620, 50,p);
		  this.Label.setText("score " + this.score_counter);
		  
		  for(int i=0;i<health_counter;i++)
		  {
			  g.drawImage(this.Health_score,200+i*30,560, 20,20,this.p);
		  }
		 
		
	 }
	public void run()
	{
		while(true)
		{
			
			this.score_counter=score.getCounter();//not this 
			this.health_counter=score.getHealth();
			this.p.repaint();
			try 
			{
				Thread.sleep(30);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	
}
