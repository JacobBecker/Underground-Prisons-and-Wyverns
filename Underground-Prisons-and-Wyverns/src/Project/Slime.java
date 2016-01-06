package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Slime extends Enemy
{
	public Slime(int x, int y, int bx1, int bx2, int by1, int by2, int lvl)
	{

		boundx1 = bx1;
		boundx2 = bx2;
		boundy1 = by1;
		boundy2 = by2;
		start_x = x;
		current_x=x;
		start_y = y;
		current_y=y;
		
		if(lvl == 2)
		{
			HP = Utilities.rollDice(1, 3) + 2; 
			numOfDice = 1;
			diceSides = 2;
			armor = 7;
			name = "Slime";
			gold = 5;
			exp  = 3;
		}
		
		if(lvl == 4)
		 {
			HP = Utilities.rollDice(1, 6) + 4;
		 	armor = 13;
		 	numOfDice = 1;
		 	diceSides = 3; 
		 	atkBonus = 1;
		 	name = "Slime";
		 	gold = 13;
		 	exp  = Utilities.rollDice(1, 2) + 3;
		 }
		
		if(lvl == 5)
		{
			HP = Utilities.rollDice(1, 6) + 6;
		 	armor = 15;
		 	numOfDice = 1;
		 	diceSides = 4; 
		 	atkBonus = 1;
		 	name = "Slime";
		 	gold = 16;
		 	exp  = 6;
		 }
		
		if(lvl == 5)
		{
			HP = Utilities.rollDice(1, 8) + 6;
		 	armor = 15;
		 	numOfDice = 1;
		 	diceSides = 4; 
		 	atkBonus = 1;
		 	name = "Slime";
		 	gold = 20;
		 	exp  = 10;
		 }
		
		pic = new Texture(Gdx.files.internal("assets/slime.png"));
		deadPic = new Texture(Gdx.files.internal("assets/slimeball.png"));

	}
	
}