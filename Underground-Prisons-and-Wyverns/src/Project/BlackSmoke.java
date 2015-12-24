package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlackSmoke extends Enemy
{
	public BlackSmoke(int x, int y, int bx1, int bx2, int by1, int by2)
	{

		boundx1 = bx1;
		boundx2 = bx2;
		boundy1 = by1;
		boundy2 = by2;
		start_x = x;
		current_x=x;
		start_y = y;
		current_y=y;
		
		HP = Utilities.rollDice(2, 1); 
		numOfDice = 1;
		diceSides = 1;
		armor = 6;
		name = "BlackSmoke";
		pic = new Texture(Gdx.files.internal("assets/blackSmoke.png"));
		deadPic = new Texture(Gdx.files.internal("assets/smokeDead.png"));

	}
	
}