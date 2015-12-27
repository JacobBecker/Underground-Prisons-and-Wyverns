package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Hornet extends Enemy
{
	public Hornet(int x, int y, int bx1, int bx2, int by1, int by2)
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
		name = "Hornet";
		pic = new Texture(Gdx.files.internal("assets/hornet.png"));
		deadPic = new Texture(Gdx.files.internal("assets/hornetDead.png"));

	}
	
}