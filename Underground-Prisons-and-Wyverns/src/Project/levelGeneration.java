package Project;

import java.util.ArrayList;

public class levelGeneration 
{
	public static void generate(ArrayList<Location> locs)
	{
		int x;
		int y;
		
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
		
		//Miss-alligned room (Both)
		for(x=-6; x<=-4; x++)
		{
			for(y=4; y<=5; y++)
			{
				locs.add(new Location(x,y));
			}
		}
		
		//Rectangle & Staggered Room Connector
		for(y=8; y<=10; y++)
		{
			locs.add(new Location(-4,y));
		}
		
		for(x=-7; x<=-4; x++)
		{
			for(y=6; y<=7; y++)
			{
				locs.add(new Location(x,y));
			}
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
}
