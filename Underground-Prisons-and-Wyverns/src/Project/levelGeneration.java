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
}
