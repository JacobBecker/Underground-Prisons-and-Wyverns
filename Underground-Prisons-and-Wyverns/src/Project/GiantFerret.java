package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GiantFerret extends Enemy
{
	public GiantFerret()
	{
		HP = Utilities.rollDice(2, 8); 
		//damage = Utilities.rollDice(2, 4); 
		armor = 5;
		name = "GiantFerret";
	}
	public GiantFerret(int x, int y, int bx1, int bx2, int by1, int by2)
	{

		boundx1 = bx1;
		boundx2 = bx2;
		boundy1 = by1;
		boundy2 = by2;
		start_x = x;
		current_x=x;
		start_y = y;
		current_y=y;
		
		HP = Utilities.rollDice(1, 6) + 6;
	 	armor = 15;
	 	numOfDice = 1;
	 	diceSides = 4; 
	 	atkBonus = 1;
		gold = 17;
		exp  = 7;
		name = "GiantFerret"; 
		pic = new Texture(Gdx.files.internal("assets/ferret2.png"));
		deadPic = new Texture(Gdx.files.internal("assets/coat.png"));

	}
}
