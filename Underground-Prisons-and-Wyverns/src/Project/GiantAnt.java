package Project;

public class GiantAnt extends Enemy
{
	public GiantAnt()
	{
		hp = Utilities.rollDice(4, 8); 
		damage = Utilities.rollDice(2, 6); 
		defense = 3;
		name = "GiantAnt";
	}

}
