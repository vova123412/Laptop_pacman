
import java.util.ArrayList; 
public class Matrix 
{
	private int pac_x;
	private int pac_y;
	private boolean game;
	private int counter;
	private  int [][] place;
	private int small_x;
	private int small_y;
	private int health;
	private int ghost_number;
	private ArrayList<Integer> ghost_list;
	public Matrix(int y,int x)
	{ 
		ghost_number=1;
		pac_x=1;
		pac_y=1;
		game=true;
		health=3;
		counter=1;
		this.small_x=31;
		this.small_y=28;
		this.place=new int[this.small_y][this.small_x];
		init();
	
	}


	public boolean isGame() {
		  synchronized (this) 
		  {
			  return game;
			  
		   }
		
	}


	public void setGame(boolean game) {
		  synchronized (this) 
		  {
			  this.game = game;
			  
		   }
		
	}

	public int getCounter() {
		  synchronized (this) 
		  {
			 	return counter;
		   }
	
	}

	public void setCounter(int counter) 
	{
		  synchronized (this) 
		  {
			  	this.counter = counter;
		  }
			
    }


	public int[][] getPlace() {
		  synchronized (this) 
		  {
			  	return place;
		  }
	}

	public void setPlace(int[][] place) {
		  synchronized (this) 
		  {
			  this.place = place;
		  }
	}

	public int getSmall_x() {
		return small_x;
	}

	public int getPac_x() 
	{
		  synchronized (this) 
		  {
		return pac_x;
		  		}
	}

	public int getPac_y() {
	synchronized (this) 
		{
		return pac_y;
		}
	}

	public void setSmall_x(int small_x) {
		this.small_x = small_x;
	}

	public int getSmall_y() {
		return small_y;
	}

	public void setSmall_y(int small_y) {
		this.small_y = small_y;
	}

	public int getHealth() {
		  synchronized (this) 
		  {
			  return health;
		  }
	}

	public void setHealth(int health)
	{
		  synchronized (this) 
		  {
			  this.health = health;
		  }
	}

	public void init()
	{

		
   		int [][]amir= {
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}	};
		this.place=amir;
	}
	

	
	public boolean getwall(int y_left,int x_left,int y_right,int x_right )//(left,right)
	{
		 // synchronized (this) 
		 // {
			if(this.place[get_place(y_left)][get_place(x_left)]==1)return false;
			if(this.place[get_place(y_right)][get_place(x_right)]==1)return false; 
			return true;  // true =no wall 
		 // }
	}
	public boolean get_ghost(int x,int y)
	{
		if(this.health<=0) {this.game=false;}
		if(this.place[get_place(y)][get_place(x)]==4||this.place[get_place(y)][get_place(x)]==2) {this.health=this.health-1; return false;}
		if(this.place[get_place(y+19)][get_place(x+19)]==4||this.place[get_place(y+19)][get_place(x+19)]==2) {this.health=this.health-1;return false;}
		if(this.place[get_place(y+19)][get_place(x)]==4||this.place[get_place(y+19)][get_place(x)]==2) {this.health=this.health-1;return false;}
		if(this.place[get_place(y)][get_place(x+19)]==4||this.place[get_place(y)][get_place(x+19)]==2) {this.health=this.health-1;return false;}
		return true; // true = no ghost
	}
	public void update_location(int x_pac,int y_pac )
	{
		this.pac_x=get_place(x_pac);
		this.pac_y=get_place(y_pac);
		if(this.place[get_place(y_pac)][get_place(x_pac)]==0)counter++;
		this.place[get_place(y_pac)][get_place(x_pac)]=3; // 5 empty place 4 ghost 3 pacman 0 food
	}
	
	public void update_ghost_location(int x_ghost,int y_ghost,int xpre_ghost,int ypre_ghost )
	{

		
	synchronized (this) 
	{
//
		if(this.place[get_place(ypre_ghost)][get_place(xpre_ghost )]==4||this.place[get_place(ypre_ghost)][get_place(xpre_ghost )]==0)
		{
			this.place[get_place(ypre_ghost)][get_place(xpre_ghost )]=0;
		}
		else 
		{
			this.place[get_place(ypre_ghost)][get_place(xpre_ghost )]=5;
		}
		
				
		if(this.place[get_place(y_ghost)][get_place(x_ghost)]==0 || this.place[get_place(y_ghost)][get_place(x_ghost)]==4)
		{
			this.place[get_place(y_ghost)][get_place(x_ghost)]=4;
		}
		else
		{
			this.place[get_place(y_ghost)][get_place(x_ghost)]=2;
		}
	}
		
		


		
	}
	
	
	public void update_empty_place(int x,int y)
	{
		 
			  	this.place[get_place(y)][get_place(x)]=5;
		  
	}
	
	public void update_ghost_place(int x,int y)
	{
		  synchronized (this) 
		  {
			  	this.place[get_place(y)][get_place(x)]=4;
		  }
	}
	
	public int get_place(int x)
	{
		  synchronized (this) 
		  {
			float siz_x=((float)(x)/20);
			int int_x=(int)(siz_x);
			return int_x;
		  }
	}

	

}
