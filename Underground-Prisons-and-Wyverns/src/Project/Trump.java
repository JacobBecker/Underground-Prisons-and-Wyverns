package Project;

public class Trump extends Enemy {

	public Trump(int x, int y)
	{
		start_x = x;
		start_y = y;
		hp = Utilities.rollDice(4, 8); 
		damage = Utilities.rollDice(2, 6); 
		defense = 3;
		name = "Trump";
		pic = "assets/trump.png";
		deadPic = "assets/skull.png";
	}
}
