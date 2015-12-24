package Project;

import java.util.ArrayList;

public class levelGeneration 
{
	public static void generateYesNo(ArrayList<Location> locs)
	{
		locs.add(new Location(0,0));	
	}
	public static void generate(ArrayList<Location> locs)
	{
		int x;
		int y;
		//Secret room test
		for(y=5; y>=3; y--)
		{
			locs.add(new Location(7,y));
		}
		for(Location l: locs)
		{
			l.secret = true;
		}
		
		for(y=-2; y<=2; y++)
		{
			for(x=7; x<=15; x++)
			{
				locs.add(new Location(x,y));
			}
		}
		
		//Beginning room
		for(x=-1; x<=1; x++)
		{
			for(y=-1; y<=2; y++)
			{
				locs.add(new Location(x,y));
			}
		}
		
		//North Hallway
		for(y=3; y<=6; y++)
		{
			locs.add(new Location(0,y));
		}
		
		//T-Split
		for(x=-10; x<=7; x++)
		{
			locs.add(new Location(x,6));
		}
		
		//Bearing Right: 1st Up
		for(y=6; y<=20; y++)
		{
			locs.add(new Location(4,y));
		}
		
		//Bearing Right: 2nd Up
		for(y=6; y<=12; y++)
		{
			locs.add(new Location(7,y));
		}
		
		//2nd Horiz Hallway
		for(x=-10; x<=7; x++)
		{
			locs.add(new Location(x,12));
		}
		
		//3x3 Room
		for(x=3; x<=5; x++)
		{
			for(y=11; y<=13; y++)
			{
				locs.add(new Location(x,y));
			}
		}
		
		//Rectangular Room
		for(x=-8; x<=-2; x++)
		{
			for(y=11; y<=14; y++)
			{
				locs.add(new Location(x,y));
			}
		}
		
		//Left-most vert hallway
		for(y=6; y<=12; y++)
		{
			locs.add(new Location(-10,y));
		}
		
		//Ex-Miss Aligned Room
		for(x=-7; x<=-4; x++)
		{
			for(y=4; y<=7; y++)
			{
				locs.add(new Location(x,y));
			}
		}
		
		//Rectangle & Staggered Room Connector
		for(y=8; y<=10; y++)
		{
			locs.add(new Location(-4,y));
		}
		
		//Why did I do this to myself (Arrowhead)
		for(y=15; y<=17; y++)
		{
			locs.add(new Location(1,y));
			locs.add(new Location(7,y));
		}
		
		for(y=16; y<=18; y++)
		{
			locs.add(new Location(2,y));
			locs.add(new Location(6,y));

		}
		
		for(y=17; y<=19; y++)
		{
			locs.add(new Location(3,y));
			locs.add(new Location(5,y));
		}
		
		for(y=17; y<=20; y++)
		{
			locs.add(new Location(4,y));
		}
		
		//return locs;
	}
	public static void generate2(ArrayList<Location> locs)
	{
		for(int i=0; i<6; i++)
		{
			for(int j=0; j<6; j++)
			{
				locs.add(new Location(i,j));
			}
		}
	}
	public static void generate3(ArrayList<Location> locs)
	{
		int a;
		int b;
		 
		
		//Secret room 
		for(b=-12; b<=-10; b++)
		{
			locs.add(new Location(1,b));
		}
		for(Location l: locs)
		{
			l.secret = true;
		}
		
		
		for(a=0; a<=2; a++)
		{
			for(b=-16; b<=-13; b++)
			{
				locs.add(new Location(a,b));
			}
		}
		
		//spawning room
		for(a=-2; a<=2; a++)
		{
			for(b=-2; b<=2; b++)
					{
						locs.add(new Location(a,b));
					}
		}
		//hallway above spawn room
		for(b=3; b<=4; b++)
		{
			locs.add(new Location(0,b));
		}
		
		//rectangular room above spawn room
		for(a=-2; a<=3; a++)
		{
			for(b=5; b<=8; b++)
			{
				locs.add(new Location(a,b));
			}
		}
		
		//block long hallway leading to hallway above
		locs.add(new Location(-2,9));
		
		//hallway leading to left-most room
		for(a=-7; a<=-2; a++)
		{
			locs.add(new Location(a,10));
		}
		
		//left most room
		for(a=-11; a<=-8 ;a++)
		{
			for(b=8; b<=12; b++)
			{
				locs.add(new Location(a,b));
			}
		}
		
		//hallway below spawn room
		for(b=-5; b<=-3; b++)
		{
			locs.add(new Location(0,b));
		}
		
		//room below spawn room
		for(a=-2; a<=2; a++)
		{
			for(b=-9; b<=-6; b++)
			{
				locs.add(new Location(a,b));
			}
		}
		
		//hallway right of spawn room
		for(a=3; a<=4; a++)
		{
			locs.add(new Location(a,0));
		}
		
		//room to the right of the spawn room
		for(a=5; a<=9; a++)
		{
			for(b=-2; b<=2; b++)
			{
				locs.add(new Location(a,b));
			}
		}
		
		//hallway to portal room
		for(a=10; a<=12; a++)
		{
			locs.add(new Location(a,-1));
		}
		
		//portal room
		for(a=13; a<=17; a++)
		{
			for(b=-3; b<=1; b++)
			{
				locs.add(new Location(a,b));
			}
		}
		
		//vertical hallway leading to top right room
		for(b=3; b<=6; b++)
		{
			locs.add(new Location(7,b));
		}
		
		//horizontal hallway leading to top right room
		for(a=4; a<=9; a++)
		{
			locs.add(new Location(a,7));
		}
		
		//top right room
		for(a=10; a<=12; a++)
		{
			for(b=5; b<=9; b++)
			{
				locs.add(new Location(a,b));
			}
		}
	}
	public static void generate4(ArrayList<Location> locs)
	{
		//secret hallways first
				for(int i=-3; i<0; i++)
				{
					locs.add(new Location(i,8));
				}
				for(int i=1; i<4; i++)
				{
					locs.add(new Location(i,8));
				}
				locs.add(new Location(5,5));
				locs.add(new Location(6,5));
				//making them secret
				for(Location l: locs)
				{
					l.secret = true;
				}
				//first two rooms
				for(int i=-1; i<=1; i++)
				{
					//first room
					for(int j=0; j<=2; j++)
					{
						locs.add(new Location(i,j));
					}
					//second room
					for(int j=4; j<=6; j++)
					{
						locs.add(new Location(i,j));
					}
				}
				//tiny hallway
				locs.add(new Location(0,3));
				//longer hallway
				for(int j=7;j<=10;j++)
				{
					locs.add(new Location(0,j));
				}
				//horizontal hallway
				for(int i=-4; i<=4; i++)
				{
					locs.add(new Location(i,11));
				}
				//long right hallway
				for(int j=11; j>=0; j--)
				{
					locs.add(new Location(-4,j));
				}
				//long left hallway
				for(int j=11; j>=0; j--)
				{
					locs.add(new Location(4,j));
				}
				//tiny hallway
				locs.add(new Location(-5,5));
				//pocket rooms
				for(int j=4;j<=6;j++)
				{
					//left room
					for(int i = -7;i<=-6;i++)
					{
						locs.add(new Location(i,j));
					}
					//right room
					for(int i = 7;i<=8;i++)
					{
						locs.add(new Location(i,j));
					}
				}
				//bottom rooms
				for(int j =-1;j>=-3;j--)
				{
					//left room
					for(int i=-6; i<=-4; i++)
					{
						locs.add(new Location(i,j));
					}
					//right room
					for(int i=4; i<=6; i++)
					{
						locs.add(new Location(i,j));
					}
				}
				//bottom hallways
				locs.add(new Location(-3,-3));
				locs.add(new Location(-2,-3));
				locs.add(new Location(2,-3));
				locs.add(new Location(3,-3));
				//bottom middle room
				for(int j=-3;j<=-2;j++)
				{
					for(int i=-1; i<=1; i++)
					{
						locs.add(new Location(i,j));
					}
				}
	}
}
