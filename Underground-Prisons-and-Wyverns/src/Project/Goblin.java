package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Goblin extends Enemy 
{
	 public Goblin(int x, int y, int bx1, int bx2, int by1, int by2, int lvl)
	 {
		 boundx1 = bx1;
		 boundx2 = bx2;
		 boundy1 = by1;
		 boundy2 = by2;
		 start_x = x;
		 current_x=x;
		 start_y = y;
		 current_y=y;

		 if(lvl == 1)
		 {
			HP = Utilities.rollDice(1, 3) + 1;
		 	armor = 7;
		 	numOfDice = 1;
		 	diceSides = 1; 
		 	name = "Goblin";
		 	gold = 4;
		 	exp  = 2;
		 }
		 
		 if(lvl == 4 || lvl == 5)
		 {
			HP = Utilities.rollDice(1, 6) + 4;
		 	armor = 13;
		 	numOfDice = 1;
		 	diceSides = 4; 
		 	atkBonus = 1;
		 	name = "Goblin";
		 	gold = 15;
		 	exp  = 5;
		 }
		 
		 pic = new Texture(Gdx.files.internal("assets/Goblin_Shaman.png"));
	   	 deadPic = new Texture(Gdx.files.internal("assets/Dead Goblin.png"));

	 }
}
