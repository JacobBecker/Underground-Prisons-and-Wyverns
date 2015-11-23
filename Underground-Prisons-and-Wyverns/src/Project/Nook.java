package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Nook extends Enemy {

	public Nook(int x, int y)
	{
		start_x = x;
		start_y = y;
		hp = Utilities.rollDice(4, 8); 
		damage = Utilities.rollDice(2, 6); 
		defense = 3;
		name = "Nook";
		pic = new Texture(Gdx.files.internal("assets/nook.png"));
		deadPic = new Texture(Gdx.files.internal("assets/roadkill.png"));
		//pic = "assets/nook.png";
		//deadPic = "assets/roadkill.png";
	}
}