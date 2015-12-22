package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Slime extends Enemy
{
	public Slime(int x, int y, int bx1, int bx2, int by1, int by2)
	{

		boundx1 = bx1;
		boundx2 = bx2;
		boundy1 = by1;
		boundy2 = by2;
		start_x = x;
		current_x=x;
		start_y = y;
		current_y=y;
		
		HP = Utilities.rollDice(1, 7); 
		numOfDice = 1;
		diceSides = 3;
		armor = 7;
		name = "Slime";
		pic = new Texture(Gdx.files.internal("assets/slime.png"));
		deadPic = new Texture(Gdx.files.internal("assets/slimeball.png"));

	}
	
}