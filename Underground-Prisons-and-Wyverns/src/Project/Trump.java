package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Trump extends Enemy {

	public Trump(int x, int y)
	{
		start_x = x;
		current_x=x;
		start_y = y;
		current_y=y;
		HP = Utilities.rollDice(4, 8); 
		numOfDice = 2;
		diceSides = 6;
		armor = 3;
		name = "Trump";
		pic = new Texture(Gdx.files.internal("assets/trump.png"));
		deadPic = new Texture(Gdx.files.internal("assets/skull.png"));
		//pic = "assets/trump.png";
		//deadPic = "assets/skull.png";
	}
}
