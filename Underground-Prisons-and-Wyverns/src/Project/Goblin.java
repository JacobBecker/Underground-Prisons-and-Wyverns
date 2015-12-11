package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Goblin extends Enemy 
{
	 public Goblin(int x, int y, int bx1, int bx2, int by1, int by2)
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
		 armor = 7;
		 numOfDice = 1;
		 diceSides = 3; //Deals 1 damage
		 name = "Goblin";
		 gold = 6;
		 exp  = 5;
		 pic = new Texture(Gdx.files.internal("assets/Goblin_Shaman.png"));
	   	 deadPic = new Texture(Gdx.files.internal("assets/Dead Goblin.png"));

	 }
}
