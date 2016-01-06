package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Crab extends Enemy
{
	public Crab(int x, int y, int bx1, int bx2, int by1, int by2)
	{

		boundx1 = bx1;
		boundx2 = bx2;
		boundy1 = by1;
		boundy2 = by2;
		start_x = x;
		current_x=x;
		start_y = y;
		current_y=y;
		
		HP = Utilities.rollDice(1, 6) + 4;
	 	armor = 12;
	 	numOfDice = 1;
	 	diceSides = 3; 
	 	atkBonus = 1;
	 	name = "Crab";
	 	gold = 9;
	 	exp  = Utilities.rollDice(1, 2) + 2;
	 	
		pic = new Texture(Gdx.files.internal("assets/Crab.png"));
		deadPic = new Texture(Gdx.files.internal("assets/CrabDead.png"));

	}
	
}