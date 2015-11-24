package Project;

public class GrayOoze extends Enemy
{

	public GrayOoze()
	{
		HP = Utilities.rollDice(3, 8); 
		numOfDice = 2;
		diceSides = 8;
		armor = 8;
		name = "GrayOoze";
	}
}
