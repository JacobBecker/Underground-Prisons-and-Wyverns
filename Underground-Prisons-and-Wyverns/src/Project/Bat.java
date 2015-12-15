package Project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Bat extends Enemy 
{
	 public Bat(int x, int y, int bx1, int bx2, int by1, int by2)
	 {
		 boundx1 = bx1;
		 boundx2 = bx2;
		 boundy1 = by1;
		 boundy2 = by2;
		 start_x = x;
		 current_x=x;
		 start_y = y;
		 current_y=y;

		 HP = Utilities.rollDice(2, 1); //2HP
		 armor = 6;
		 numOfDice = 1;
		 diceSides = 1; //Deals 1 damage
		 name = "Bat";
		 gold = 10;
		 exp =4;
		 pic = new Texture(Gdx.files.internal("assets/Batman.png"));
	   	 deadPic = new Texture(Gdx.files.internal("assets/Dead Batman.png"));

	 }
}
