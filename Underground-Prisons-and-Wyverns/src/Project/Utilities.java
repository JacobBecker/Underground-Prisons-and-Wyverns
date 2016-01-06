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
		int damage = Utilities.rollDice(character.atkNumOfDice, character.atkDiceSides) + character.atkBonus;
		
		if(atkRoll >= enemy.armor)
		{
			enemy.HP = enemy.HP - damage;
			//Display hit/damage
			
			if(enemy.HP <= 0)
			{
				enemy.isLiving = false;
				if(enemy.looted==false)
				{
					character.gold += enemy.gold;
					character.exp += enemy.exp;
					enemy.looted = true;
				}
				if(character.exp >= character.nextLevel)
				{
					levelup(character);
				}
			}
		}
		else
		{
			//Display miss
		}
	}
	
	public static void charDefend(Character character, Enemy enemy)
	{
		int atkRoll = Utilities.rollDice(1, 20);
		int damage = Utilities.rollDice(enemy.numOfDice, enemy.diceSides) + enemy.atkBonus;
		
		if(atkRoll >= character.armor)
		{
			character.liveHP = character.liveHP - damage;
			character.hurt = true;
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
	
	public static void levelup(Character character)
	{
		character.maxHP += rollDice(character.hpNumOfDice, character.hpDiceSides) + character.conBonus;

		if (character.level == 1)
		{
			character.nextLevel = 10;
		}
		else if (character.level == 2)
		{
			character.nextLevel = 40;
		}		
		else if (character.level == 3)
		{
			character.nextLevel = 90;
		}		
		else if (character.level == 4)
		{
			character.nextLevel = 200;
		}		
		else if (character.level == 5)
		{
			character.nextLevel = 500;
		}		
		else if (character.level == 6)
		{
			character.nextLevel = 1000;
		}
				
		character.level++;
	}
	
	public static void upgradeArmor(Forge f, Character c)
	{
		c.gold -= f.cost;
		c.defence+=f.benefit;
	}
	
	public static void upgradeWeapon(Forge f, Character c)
	{
		c.gold -= f.cost;
		c.atkDiceSides += f.benefit;
	}
	public static void heal(Character character)
	{
		character.liveHP = character.maxHP;
	}
}
