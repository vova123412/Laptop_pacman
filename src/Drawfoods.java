import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Drawfoods extends Thread 
{
	private Mypanel p;
	private Matrix My_matrix;
	private List<food> FoodList;
	private int x;
	private int y;
	private int counter;
	public Drawfoods(Mypanel panel,Matrix matrix)
	{
		counter=0;
		p=panel;
		this.My_matrix=matrix;
		this.x=matrix.getSmall_x();
		this.y=matrix.getSmall_y();
	}
	public int Get_counter()
	{
		return counter;
	}

	public void draw(Graphics g)//repaint()
    {
		
		counter=0;
		for(int i=0;i<y;i++)
		{
			
			for(int b=0;b<x;b++)
			{
				if(this.My_matrix.getPlace()[i][b]==0||this.My_matrix.getPlace()[i][b]==4)
				{
					if(this.My_matrix.getPlace()[i][b]==0)
					{
						counter++;
					}
					new food(i*20,b*20).draw(g);
				}
			}
		}
		if(counter==0)
		{
			this.My_matrix.setGame(false);
		}
    }
	public Mypanel getP() {
		return p;
	}
	public void setP(Mypanel p) {
		this.p = p;
	}
	public Matrix getMy_matrix() {
		return My_matrix;
	}
	public void setMy_matrix(Matrix my_matrix) {
		My_matrix = my_matrix;
	}
	public List<food> getFoodList() {
		return FoodList;
	}
	public void setFoodList(List<food> foodList) {
		FoodList = foodList;
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
	public void run()
	{

	}

	
}
