package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Snake extends Enemy
{
	public Snake(int x, int y, int bx1, int bx2, int by1, int by2)
	{

		boundx1 = bx1;
		boundx2 = bx2;
		boundy1 = by1;
		boundy2 = by2;
		start_x = x;
		current_x=x;
		start_y = y;
		current_y=y;
		
		HP = Utilities.rollDice(1, 6) + 3; 
		numOfDice = 1;
		diceSides = 3;
		armor = 8;
		name = "Snake";
		gold = 7;
		exp  = 2;
		pic = new Texture(Gdx.files.internal("assets/Snake.png"));
		deadPic = new Texture(Gdx.files.internal("assets/snakeDead.png"));

	}
	
}

