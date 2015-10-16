package Project;

public class GiantFerret extends Enemy
{
	public GiantFerret()
	{
		hp = Utilities.rollDice(2, 8); 
		damage = Utilities.rollDice(2, 4); 
		defense = 5;
		name = "GiantFerret";
	}
}
