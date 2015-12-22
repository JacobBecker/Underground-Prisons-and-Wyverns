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
	boolean looted = false;
	
	Texture pic;
	Texture deadPic;
	
	int gold = 0;
	int exp = 0;

	public void move(int character_x, int character_y, Character c, ArrayList<Location> locs, ArrayList<Enemy> enems)
	{

		int run = current_x-character_x;
		int rise = current_y-character_y;
		//boolean check;
		boolean in_sight = ((Math.abs(run)<=3) && (Math.abs(rise)<=3));
		boolean adjacent = ((Math.abs(current_x-character_x)==1)&&(current_y==character_y))
				||((Math.abs(current_y-character_y)==1)&&(current_x==character_x));
		if(adjacent)
		{
			Utilities.charDefend(c, this);
		}
		else //enemy movement
		{
			if(in_sight)
			{
				if ((rise !=0) && (Math.abs(rise) < Math.abs(run) || run == 0))
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

			for(Location place:locs)
			{		//System.out.println("1");
				if((place.x==move_x)&&(place.y==move_y)&& (move_x<=boundx2) && (move_x>= boundx1) && (move_y<=boundy2) && (move_y>=boundy1))
				{
					boolean valid = true;
					for(Enemy e:enems)
					{
						if((e.current_x==move_x)&&(e.current_y==move_y)&&(e.isLiving)&&(e!=this))
						{
							valid=false;
						}
					}
					if(valid)
					{
						current_x = move_x;
						current_y = move_y;
					}
					else
					{
						move_x = current_x;
						move_y = current_y;
					}
					//System.out.println("enemy: " + current_x + " , "+ current_y +" yours: "+ character_x +" , " + character_y);				
				}
		
			}									
		}
	}
}

