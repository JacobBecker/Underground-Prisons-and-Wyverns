package Project;
import javax.swing.JOptionPane;
public class Thief
{
	private String name;
	private int strength;//mid to higher strength
	private int constitution;//mid to low health
	private int armor;//light armor
	//these things are all in the character class, we can move them around later
	public Thief()
	{
		int[] preScores = {0, 0, 0};
		
		for(int i = 0; i < preScores.length; i++)//for each prescore
		{
			//preScore seems to be the choices as of now
			int value0 = preScores[0];
			int value1 = preScores[1];
			int value2 = preScores[2];
	
			while(preScores[i] < 9 || preScores[i] == value0 || preScores[i] == value1 || preScores[i] == value2)
			{
				//We need to make it so that choices for each stat are different, changing this part and above
				preScores[i] = Utilities.rollDice(3,  6);
			}
			System.out.println(preScores[i]);
		}
		int[] postScores = {0, 0, 0};
		for(int j = 0; j < postScores.length; j++)//for each postScore (what user chooses)
		{
			if(j == 0)//Strength
			{
				JOptionPane.showMessageDialog(null, "What is your strength " + name + "?");
			}
			if(j == 1)//Constitution
			{
				JOptionPane.showMessageDialog(null,  "What is your constitution " + name + "?");
			}
			if(j == 2)//Armor
			{
				JOptionPane.showMessageDialog(null, "What is your armor " + name + "?");
			}
			new RadioExample(preScores, postScores);
			while(postScores[j] == 0)
			{
				postScores[j] = RadioExample.getValue();
			}
		}
	}
	
}