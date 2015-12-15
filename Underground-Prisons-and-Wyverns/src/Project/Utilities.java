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
		int damage = Utilities.rollDice(character.atkNumOfDice, character.atkDiceSides);
		
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
		int atkRoll = Utilities.rollDice(1,  20);
		int damage = Utilities.rollDice(enemy.numOfDice, enemy.diceSides);
		
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
		character.heal();//restores character to full health.
		character.nextLevel += 6;
		character.level++;
	}
	
	public static void upgradeArmor(Forge f, Character c)
	{
		c.gold -= f.cost;
		System.out.println("We need decide on armor numbers!");
	}
	
	public static void upgradeWeapon(Forge f, Character c)
	{
		c.gold -= f.cost;
		System.out.println("We need decide on weapon numbers!");
	}
}
