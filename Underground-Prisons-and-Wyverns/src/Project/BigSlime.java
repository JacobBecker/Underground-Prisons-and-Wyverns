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
		
		HP = Utilities.rollDice(3, 14); 
		numOfDice = 5;
		diceSides = 3;
		armor = 9;
		name = "Big Slime";
		gold = 50;
		 exp  = 10;
		pic = new Texture(Gdx.files.internal("assets/BigSlime2.png"));
		deadPic = new Texture(Gdx.files.internal("assets/slimeball.png"));

	}
}
