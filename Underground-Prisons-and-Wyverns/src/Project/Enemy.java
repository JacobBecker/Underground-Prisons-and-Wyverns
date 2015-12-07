package Project;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Enemy 
{
	int boundx1;
	int boundx2;
	int boundy1;
	int boundy2;
	int move_y;
	int move_x;
	int start_x;
	int start_y;
	int current_x;
	int current_y;
	int armor;
	int HP;
	int numOfDice;
	int diceSides;
	String name;
	boolean isLiving = true;
	Texture pic;
	Texture deadPic;

	public void move(int character_x, int character_y, Character c, ArrayList<Location> locs)
	{

		int run = current_x-character_x;
		int rise = current_y-character_y;
		//boolean inbounds = current_x<=boundx2 && current_x>= boundx1 && current_y<=boundy2 && current_y>=boundy1;
		boolean check;
		boolean insight = ((Math.abs(run)<=3) && (Math.abs(rise)<=3));
		boolean adjacent = ((Math.abs(current_x-character_x)==1)&&(current_y==character_y))
				||((Math.abs(current_y-character_y)==1)&&(current_x==character_x));
		if(adjacent)
		{
			Utilities.charDefend(c, this);
		}
		else //enemy movement
		{
			if(insight)
			{
				if (Math.abs(rise) < Math.abs(run)|| run == 0)
				{
					if (rise < 0)
					{
						move_y = current_y+1;
						move_x = current_x;
					}
					else
					{
						move_y = current_y-1;
						move_x = current_x;
					}	
					
				}
			
				else 
				{
					if(run < 0)
					{
						move_x = current_x +1;
						move_y = current_y;
					}
					else
					{
						move_x = current_x-1;
						move_y = current_y;
					}
				}
			}
			else
			{
					move_y = current_y;
					move_x = current_x;
			}

			
			//current_x = move_x;
			//current_y = move_y;
			//System.out.println("enemy: " + current_x + " , "+ current_y +" yours: "+ character_x +" , " + character_y);
			for(Location place:locs)
			{		//System.out.println("1");
				if((place.x==move_x)&&(place.y==move_y) && move_x<=boundx2 && move_x>= boundx1 && move_y<=boundy2 && move_y>=boundy1 )
				{
					current_x = move_x;
					current_y = move_y;	
					//System.out.println(	"2");					
				}
				/*else
				{
					//find a new location to move to 
					move_x = current_x;
					move_y = current_y;
						
				}		*/			
			}									
		}
	}
}

