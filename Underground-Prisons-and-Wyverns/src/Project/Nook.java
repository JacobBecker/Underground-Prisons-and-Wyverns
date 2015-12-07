package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Nook extends Enemy {

	public Nook(int x, int y, int bx1, int bx2, int by1, int by2)
	{
		boundx1 = bx1;
		boundx2 = bx2;
		boundy1 = by1;
		boundy2 = by2;
		start_x = x;
		current_x=x;
		start_y = y;
		current_y=y;
		HP = Utilities.rollDice(4, 8); 
		numOfDice = 2;
		diceSides = 6;
		armor = 3;
		name = "Nook";
		pic = new Texture(Gdx.files.internal("assets/nook.png"));
		deadPic = new Texture(Gdx.files.internal("assets/roadkill.png"));
		//pic = "assets/nook.png";
		//deadPic = "assets/roadkill.png";
	}
}