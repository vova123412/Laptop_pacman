import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Drawghost  
{
	private Mypanel p;
	private Matrix My_matrix;
	private List<Ghost> ghostList;
	public Drawghost(Mypanel panel,Matrix matrix) throws IOException
	{
		p=panel;
		this.My_matrix=matrix;
		ghostList = new ArrayList<>();
		init();
	}
	public void init() throws IOException
	{
		
		for(int i=1;i<4;i++)
		{
			ghostList.add(new Ghost(i*20+100,20,My_matrix,p));
		}
		for (int i = 0; i < ghostList.size(); i++) 
		{
			ghostList.get(i).start();
		}
		
		
		}
	public void draw(Graphics g)//repaint()
    {
		
		for (int i = 0; i < ghostList.size(); i++) 
		{
			ghostList.get(i).draw(g);;
		}
		
    }
	public void exit()
	{
		for (int i = 0; i < ghostList.size(); i++) 
		{
			ghostList.get(i).interrupt();
		}
		
	}


}
