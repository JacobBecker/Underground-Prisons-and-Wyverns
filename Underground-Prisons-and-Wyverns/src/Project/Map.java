package Project;

import java.util.*;

public class Map 
{
	ArrayList<Space> map;
	public Map()
	{
		map = new ArrayList<Space>();
	}
	public void add_room(Space room)
	{
		map.add(room);
	}
	public void show_map()
	{
		for(Space x: map)
		{
			if(x.visited==true)
			{
				//display room
				if(x.char_occupied==true)
				{
					//display character icon
				}
			}
		}
	}
	public void test(){
		System.out.println("hi");
	}
}
