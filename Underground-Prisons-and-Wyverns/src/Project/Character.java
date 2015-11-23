package Project;

import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;

public class Character 
{
	String name;
	int strength;
	int constitution;
	int armor;

	public Character() 
	{
		name = JOptionPane.showInputDialog("What is your name, adventurer?");
		JOptionPane.showMessageDialog(null, "Now, you can choose your ability scores\n"
										+ "Your Strength affects your damage with melee weapons\n"
										+ "Your Constituation affects your Hit Points, or your health"
										+ "Your Armor affects how much damage you take");
		/*
		 * Character choice code can go here, I (Carly) will work on this. Similar to stat choice buttons
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
			System.out.println(preScores[i]);
		}

		int[] postScores = {0,0,0};
		for (int i = 0; i < postScores.length; i++) 
		{
			if(i == 0)
			{
				JOptionPane.showMessageDialog(null, "What is your strength " + name + "?");
			}
			if(i == 1)
			{
				JOptionPane.showMessageDialog(null, "What is your consitution " + name + "?");
			}
			if(i == 2)
			{
				JOptionPane.showMessageDialog(null, "What is your armor " + name + "?");
			}
			
			new RadioExample(preScores, postScores);
			while(postScores[i] == 0)
			{
				postScores[i] = RadioExample.getValue();
			}
		}
		
		strength = postScores[0];
		constitution = postScores[1];
		armor = postScores[2];
		
		System.out.println(strength + " " + constitution + " " + armor);
		
	}
}
