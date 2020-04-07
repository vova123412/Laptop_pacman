import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Drawwalls 
{
	private Mypanel p;
	private Matrix My_matrix;
	private int x;
	private int y;
	private List<Wall> WallList;
	public Drawwalls(Mypanel panel,Matrix matrix)
	{
		this.p=panel;
		this.My_matrix=matrix;
		this.x=matrix.getSmall_x();
		this.y=matrix.getSmall_y();
		this.WallList = new ArrayList<>();
		init();
	}
	public void init()
	{
		for(int i=0;i<y;i++)
		{
			for(int b=0;b<x;b++)
			{
				if(this.My_matrix.getPlace()[i][b]==1)
				{
					WallList.add(new Wall(i*20,b*20));
				}
			}
		}
	}
	public void draw(Graphics g)//repaint()
    {
        for (Wall wall : WallList) 
        {
        	
            wall.draw(g);
        }
    }



}
