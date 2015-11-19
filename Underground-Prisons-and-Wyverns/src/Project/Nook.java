package Project;

public class Nook extends Enemy {

	public Nook(int x, int y)
	{
		start_x = x;
		start_y = y;
		hp = Utilities.rollDice(4, 8); 
		damage = Utilities.rollDice(2, 6); 
		defense = 3;
		name = "Nook";
		pic = "assets/nook.png";
		deadPic = "assets/roadkill.png";
	}
}