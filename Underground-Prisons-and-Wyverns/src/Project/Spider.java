package Project;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Spider extends Enemy
{
	public Spider(int x, int y, int bx1, int bx2, int by1, int by2)
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
		numOfDice = 1;
		diceSides = 6;
		armor = 3;
		name = "TigerBeetle";
		pic = new Texture(Gdx.files.internal("assets/spider.png"));
		deadPic = new Texture(Gdx.files.internal("assets/skull.png"));

	}
	
}
