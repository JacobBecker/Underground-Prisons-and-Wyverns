/*
 * Explaining stats
 * 
 * Combat: 
 * 		Roll 1d20 to see if you hit
 * 		Strength gives bonus to hit roll
 * 		Armor = How hard you are to hit
 * 		Base 10 Armor, without bonuses
 * 		Armor = Min roll # to hit
 * 		Armor scores gives bonus to armor
 * 		Maybe include class based bonus to armor?
 * 
 * DAMAGE
 * -Right now: Uniform 1d6
 * -Suggest making damage vary between classes
 * -Ideally, damage should change based upon weapon
 * 
 * HIT POINTS
 * -Right now: Uniform 2d4 (2-8) + Con bonus
 * -Later: Depend upon Class + Con bonus
 * -If levels: HP increases upon level
 * 
 * NOTE: DAMAGE & ARMOR CALCUATIONS WILL 
 * 		CHANGE IF WE IMPLIMENT EQUIPTMENT
 * 	
 * STRENGTH & CONSITUTION
 * 9-12: No bonus
 * 13-15: +1
 * 16-17: +2
 * 18: +3
 * 
 * ARMOR
 * 9-12: No bonus
 * 13-15: +2
 * 16-17: +4
 * 18: +6 			
 * 
 * 
 */

package Project;

import javax.swing.JOptionPane;

public class Character
{
	String name;
	String chosenclass;
	boolean isLiving = true;
	boolean hurt = false;
	
	int strength;
	int constitution;
	int defence;
	
	int strBonus;
	int conBonus;
	int armorBonus;
	
	int maxHP;
	int liveHP;
	int armor;

	
	//This is for generation of a test character w/o going through all the Dialog
	//Solely for testing purposes
	public Character(int str, int con, int arm, String nam)
	{
		name = nam;
		strength = str;
		constitution = con;
		defence = arm;
		
		//Assigning str bonus
		if(strength < 13)
		{
			strBonus = 0;
		}
		else if(strength < 15)
		{
			strBonus = 1;
		}
		else if(strength < 18)
		{
			strBonus = 2;
		}
		else
		{
			strBonus = 3;
		}
		
		//Assigning con bonus
		if(constitution <13)
		{
			conBonus = 0;
		}
		else if(constitution < 15)
		{
			conBonus = 1;
		}
		else if(constitution < 18)
		{
			conBonus = 2;
		}
		else
		{
			conBonus = 3;
		}
		
		//Assigning armor bonus
		if(defence <13)
		{
			armorBonus = 0;
		}
		else if(defence < 15)
		{
			armorBonus = 2;
		}
		else if(defence < 18)
		{
			armorBonus = 4;
		}
		else
		{
			armorBonus = 6;
		}
		
		//HP
		maxHP = Utilities.rollDice(2,4) + conBonus;
		liveHP = maxHP;
		
		//Armor
		armor = 10 + armorBonus;
	}
	
	public Character() throws InterruptedException
	{
		name = JOptionPane.showInputDialog("What is your name, adventurer?");
		JOptionPane.showMessageDialog(null, "Now, you can choose your ability scores\n"
										+ "Your Strength affects your damage with melee weapons\n"
										+ "Your Constituation affects your Hit Points, or your health\n"
										+ "Your Defence affects how much damage you take");
		/*
		 * Character choice code can go here, I (Carly) will work on this. Similar to stat choice buttons
		 */
		/*
		String[] classchoices = {"Warrior", "Cleric", "Thief", "Mage", "Ranger", "Bard"};
		
		JOptionPane.showMessageDialog(null, "What class will you choose " + name + "?");
		CharRadio instance = new CharRadio(classchoices);
		chosenclass = instance.getClass();
		JOptionPane.showMessageDialog(null, "You have chosen to become a " + chosenclass + ".");
		*/
		
		int[] preScores = {0,0,0};

		for (int i = 0; i < preScores.length; i++) 
		{
			int value0 =  preScores[0];
			int value1 =  preScores[1];
			int value2 =  preScores[2];
			while (preScores[i] < 9 || preScores[i] == value0 || preScores[i] == value1 || preScores[i] == value2) 
			{
				preScores[i] = Utilities.rollDice(3, 6);
			}
		}

		int[] postScores = {0,0,0};
		
		JOptionPane.showMessageDialog(null, "What is your strength " + name + "?");
		RadioExample x = new RadioExample (preScores, postScores);
		while(postScores[0] == 0)
		{
			postScores[0] = x.getValue();
		}
		
		JOptionPane.showMessageDialog(null, "What is your consitution " + name + "?");
		RadioExample y = new RadioExample (preScores, postScores);
		while(postScores[1] == 0)
		{
			postScores[1] = y.getValue();
		}
		
		JOptionPane.showMessageDialog(null, "What is your defence " + name + "?");
		RadioExample z = new RadioExample (preScores, postScores);
		while(postScores[2] == 0)
		{
			postScores[2] = z.getValue();
		}
		
		strength = postScores[0];
		constitution = postScores[1];
		defence = postScores[2];
		
		//Assigning str bonus
		if(strength < 13)
		{
			strBonus = 0;
		}
		else if(strength < 15)
		{
			strBonus = 1;
		}
		else if(strength < 18)
		{
			strBonus = 2;
		}
		else
		{
			strBonus = 3;
		}
		
		//Assigning con bonus
		if(constitution <13)
		{
			conBonus = 0;
		}
		else if(constitution < 15)
		{
			conBonus = 1;
		}
		else if(constitution < 18)
		{
			conBonus = 2;
		}
		else
		{
			conBonus = 3;
		}
		
		//Assigning armor bonus
		if(defence <13)
		{
			armorBonus = 0;
		}
		else if(defence < 15)
		{
			armorBonus = 2;
		}
		else if(defence < 18)
		{
			armorBonus = 4;
		}
		else
		{
			armorBonus = 6;
		}
		
		//HP
		maxHP = Utilities.rollDice(2,4) + conBonus;
		liveHP = maxHP;
		
		//Armor
		armor = 10 + armorBonus;
		
	}
}

