import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Myframe extends JFrame 
{

	private int higth;
	private int width;
	private Mypanel pac;
	private JFrame frame;
	private Menu menu;
	public Myframe() throws IOException 
	{
		this.setTitle("pacman");
	    higth=560+80;
		width=620+20;
		this.setSize((width), (higth));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu=new Menu(this);
		this.setVisible(true);
		

	}

 


  



}
