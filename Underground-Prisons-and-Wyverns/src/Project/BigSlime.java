package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BigSlime extends Enemy {
	public BigSlime(int x, int y, int bx1, int bx2, int by1, int by2)
	{

		boundx1 = bx1;
		boundx2 = bx2;
		boundy1 = by1;
		boundy2 = by2;
		start_x = x;
		current_x=x;
		start_y = y;
		current_y=y;
		
		HP = Utilities.rollDice(1, 8) + 6;
	 	armor = 15;
	 	numOfDice = 1;
	 	diceSides = 4; 
	 	atkBonus = 1;
	 	name = "Big Slime";
	 	gold = 20;
	 	exp  = 10;
		pic = new Texture(Gdx.files.internal("assets/BigSlime2.png"));
		deadPic = new Texture(Gdx.files.internal("assets/slimeball.png"));

	}
}
