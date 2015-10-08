package Project;

import javax.swing.JOptionPane;

public class Character 
{
	String Name;
	int Strength;
	int Constitution;
	int selected;

	public Character() 
	{
		Name = JOptionPane.showInputDialog("What is your name, adventurer?");
		JOptionPane.showMessageDialog(null, "Now, you can choose your ability scores\n"
										+ "Your Strength affects your damage with melee weapons\n"
										+ "Your Constituation affects your Hit Points, or your health");
		int[] scores = new int[2];

		for (int i = 0; i < scores.length; i++) 
		{
			scores[i] = 0;
			while (scores[i] < 9) 
			{
				scores[i] = Utilities.rollDice(3, 6);
				System.out.println(scores[i]);
			}
		}
		
		ScoreAssignment(scores, "strength", 0);
		ScoreAssignment(scores, "Constitution", 1);
		Strength = scores[0];
		Constitution = scores[1];		
	}

	public int[] ScoreAssignment(int[] scoreValues, String ability, int position) 
	{
		int value = 0;
			while (value != scoreValues[0] && value != scoreValues[1]) 
			{
				String strValue = "filler";
				boolean isValueAnInt = false;
				while (!isValueAnInt) 
				{
					isValueAnInt = true;
					try {
						value = Integer.parseInt(strValue);
					} catch (java.lang.NumberFormatException e) {
						strValue = JOptionPane.showInputDialog("What will be your " +
										ability + " value? \n" +
										scoreValues[0] + "\n" +
										scoreValues[1] + "\n" +
										"Please type just the number" + 
										"correlating to the score \n" +
										"and ignore any value of null");
						isValueAnInt = false;
					}
				}
			}
		
		int i;
		for(i = 0; value != scoreValues[i]; i++)
		{
			
		}
		
		int storage;
		storage = scoreValues[i];
		scoreValues[i] = scoreValues[position];
		scoreValues[position] = storage;
		
		return scoreValues;		
	}
}
