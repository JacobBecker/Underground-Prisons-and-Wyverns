package Project;

public class TigerBeetle extends Enemy
{
	public TigerBeetle()
	{
		hp = Utilities.rollDice(2, 8); 
		damage = Utilities.rollDice(1, 6); 
		defense = 4;
		name = "TigerBeetle";
	}
}
