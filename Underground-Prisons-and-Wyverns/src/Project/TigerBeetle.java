package Project;

public class TigerBeetle extends Enemy
{
	public TigerBeetle()
	{
		HP = Utilities.rollDice(2, 8); 
		numOfDice = 1;
		diceSides = 6;
		armor = 4;
		name = "TigerBeetle";
	}
}
