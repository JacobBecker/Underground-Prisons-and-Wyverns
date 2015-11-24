package Project;

import javax.swing.JOptionPane;

public class Character
{
	String name;
	int strength;
	int constitution;
	int armor;

	public Character() throws InterruptedException
	{
		name = JOptionPane.showInputDialog("What is your name, adventurer?");
		JOptionPane.showMessageDialog(null, "Now, you can choose your ability scores\n"
										+ "Your Strength affects your damage with melee weapons\n"
										+ "Your Constituation affects your Hit Points, or your health\n"
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
		
		JOptionPane.showMessageDialog(null, "What is your armor " + name + "?");
		RadioExample z = new RadioExample (preScores, postScores);
		while(postScores[2] == 0)
		{
			postScores[2] = z.getValue();
		}
		
		strength = postScores[0];
		constitution = postScores[1];
		armor = postScores[2];
	}
}
