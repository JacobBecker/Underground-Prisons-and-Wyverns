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
	String chosenclass = null;
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
	
	int gold = 0;
	int exp = 0;
	int nextLevel = 6;
	int level = 1;
	
	int hpNumOfDice = 2;
	int hpDiceSides = 4;
	
	int atkNumOfDice = 1;
	int atkDiceSides = 6;
	
	//these is for displaying line under name
	int nameLength;
	int counter = 1;
	String line = "_";
	
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
										+ "Your Defense affects how much damage you take");
		
		//name length and while loop are for displaying underline on scroll
		nameLength = name.length();
		while (counter <= nameLength-1)
		{
			line = line + "_";
		    counter ++;
		}
//Character choice code	start	
		String[] classchoices = {"Warrior", "Cleric", "Thief"};//class choices
		
		JOptionPane.showMessageDialog(null, "What class will you choose " + name + "?");
		CharRadio k = new CharRadio(classchoices);//displays choice buttons
		while(chosenclass == null)//while you have not chosen a class
		{
			chosenclass = k.getThis();//choose a class
		}
		JOptionPane.showMessageDialog(null, "You have chosen to become a " + chosenclass + ".");
		//character choice code end
		
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
		AbilityScoreRadio x = new AbilityScoreRadio (preScores, postScores);
		while(postScores[0] == 0)
		{
			postScores[0] = x.getValue();
		}
		
		JOptionPane.showMessageDialog(null, "What is your consitution " + name + "?");
		AbilityScoreRadio y = new AbilityScoreRadio (preScores, postScores);
		while(postScores[1] == 0)
		{
			postScores[1] = y.getValue();
		}
		
		JOptionPane.showMessageDialog(null, "What is your defense " + name + "?");
		AbilityScoreRadio z = new AbilityScoreRadio (preScores, postScores);
		while(postScores[2] == 0)
		{
			postScores[2] = z.getValue();
		}
		
		strength = postScores[0];
		constitution = postScores[1];
		defence = postScores[2];
		
		//Assigning str bonus
		if(chosenclass.equals("Thief"))
		{
			strBonus = 4;
		}
		else if(chosenclass.equals("Cleric"))
		{
			strBonus = 2;
		}
		else if(chosenclass.equals("Warrior"))
		{
			strBonus = 1;
		}
		
		//Assigning con bonus
		if(chosenclass.equals("Thief"))
		{
			conBonus = 1;
		}
		else if(chosenclass.equals("Cleric"))
		{
			conBonus = 4;
		}
		else if(chosenclass.equals("Warrior"))
		{
			conBonus = 2;
		}
		
		//Assigning armor bonus
		if(chosenclass.equals("Thief"))
		{
			armorBonus = 1;
		}
		else if(chosenclass.equals("Cleric"))
		{
			armorBonus = 2;
		}
		else if(chosenclass.equals("Warrior"))
		{
			armorBonus = 4;
		}
		
		//HP
		maxHP = Utilities.rollDice(hpNumOfDice, hpDiceSides) + conBonus;
		liveHP = maxHP;
		
		//Armor
		armor = 10 + armorBonus;
		
		strength = strength + strBonus;
	}
	
	void heal(){
		liveHP = maxHP;
	}
}

