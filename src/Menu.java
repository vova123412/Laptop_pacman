import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel  implements ActionListener
    {
		private int higth;
		private int width;
        private JButton play_button;
        private JButton continue_button;
        private JButton exit_button;
        private Mypanel pac;
        private Myframe  frame;
    	private Image image;
    	public Menu(Myframe frame) throws IOException
    	{
    		image=new ImageIcon("menu.png").getImage();
    		
    		
    		this.frame=frame;
    		frame.getContentPane().add(this,BorderLayout.CENTER);
    		this.setPreferredSize(new Dimension(200,200));
    		
    		
    		continue_button= new JButton("continue");
    		continue_button.setBounds(50,50, 100,100);
    		continue_button.addActionListener(this);
    		continue_button.setVisible(true);
	    	
    		play_button= new JButton("new game");
    		play_button.setBounds(50,50, 100,100);
    		play_button.addActionListener(this);
	    	play_button.setVisible(true);
	    	
    		exit_button= new JButton("exit");
    		exit_button.setBounds(50,50, 100,100);
    		exit_button.addActionListener(this);
	    	exit_button.setVisible(true);
	    	
	    	
	    	this.setBackground(Color.white);
	    	this.add(exit_button);
	    	this.add(play_button);
	    	this.add(continue_button);
	    	this.setFocusable(true);
	    
    	}
    	@Override
    	public void actionPerformed(ActionEvent e) 
    	{
    		if(e.getSource()==play_button) 
    		{
    			System.out.print("play");
	    		try
	    		{
					new_game();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    		}
    		if(e.getSource()==continue_button) 
    		{
          		
	    		try {
					continue_game();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    		
    		if(e.getSource()==exit_button&&pac!=null) 
    		{
          		
	    		exit_game();
    		}
    	}
    	public void new_game() throws IOException
    	{	
//    		if(pac!=null) 
//    		{
//    			pac.exit();
//    		}
    		pac=new Mypanel(620,560,this);
    		frame.getContentPane().add(pac,BorderLayout.CENTER);
    		frame.remove(this);
    		frame.invalidate();
    		frame.validate();
    		frame.repaint();
    	
    	}
    	public void hide_game()
    	{
    		image=new ImageIcon("pasue.png").getImage();
    		frame.getContentPane().add(this,BorderLayout.CENTER);
    		frame.remove(pac);
    		frame.invalidate();
    		frame.validate();
    		frame.repaint();
    
    	}
    	public void win_page()
    	{
    		image=new ImageIcon("winpage.jpg").getImage();
    		frame.getContentPane().add(this,BorderLayout.CENTER);
    		frame.remove(pac);
    		frame.invalidate();
    		frame.validate();
    		frame.repaint();
    
    	}
    	public void exit_game()
    	{
    		pac.exit();
    	
    	}
      	public void continue_game() throws IOException
    	{
      		if(pac!=null) 
      		{
      		pac.getGame().setGame(true);
    		frame.getContentPane().add(pac,BorderLayout.CENTER);
	   		frame.remove(this);
	    	frame.invalidate();
	    	frame.validate();
	    	frame.repaint();
	    	System.out.print("continue");
      		}
    	}
      	
        public void paintComponent(Graphics g) //from here i draw all creatures 
        {
        	g.drawImage( image, 0, 0, 640, 640, this);
        }



    }