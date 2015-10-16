package Project;

public class GrayOoze extends Enemy
{
	public GrayOoze()
	{
		hp = Utilities.rollDice(3, 8); 
		damage = Utilities.rollDice(2, 8); 
		defense = 8;
		name = "GrayOoze";
	}
}
