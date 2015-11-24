package Project;

public class Utilities 
{
	public static int rollDice(int diceNum, int sidedDice)
	{
		int sum = 0;
		
		for(int i = 0; i < diceNum; i++)
		{
			sum = sum + (int)(Math.random()*sidedDice)+1;
		}
		
		return sum;
	}
	
	public static void charAttack(Character character, Enemy enemy)
	{
		int atkRoll = Utilities.rollDice(1,  20) + character.strBonus;
		int damage = Utilities.rollDice(1,6);
		
		if(atkRoll >= enemy.armor)
		{
			enemy.HP = enemy.HP - damage;
			//Display hit/damage
			
			if(enemy.HP <= 0)
			{
				enemy.isLiving = false;
			}
		}
		else
		{
			//Display miss
		}
	}
	
	public static void charDefend(Character character, Enemy enemy)
	{
		int atkRoll = Utilities.rollDice(1,  20);
		int damage = Utilities.rollDice(enemy.numOfDice, enemy.diceSides);
		
		if(atkRoll >= character.armor)
		{
			character.liveHP = character.liveHP - damage;
			//Display hit/damage
			
			if(character.liveHP <= 0)
			{
				character.isLiving = false;
			}
		}
		else
		{
			//Display miss
		}
	}
}
