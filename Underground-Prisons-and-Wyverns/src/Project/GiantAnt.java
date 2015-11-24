package Project;

public class GiantAnt extends Enemy
{
	public GiantAnt()
	{
		HP = Utilities.rollDice(4, 8); 
		//damage = Utilities.rollDice(2, 6); 
		armor = 3;
		name = "GiantAnt";
	}

}
