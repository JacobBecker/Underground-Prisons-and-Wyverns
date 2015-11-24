package Project;

public class GiantFerret extends Enemy
{
	public GiantFerret()
	{
		HP = Utilities.rollDice(2, 8); 
		//damage = Utilities.rollDice(2, 4); 
		armor = 5;
		name = "GiantFerret";
	}
}
