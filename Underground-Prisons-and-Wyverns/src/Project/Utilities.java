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
	
	public static void urMum()
	{
		//This is Jacob's method!
	}
	
	public static int blahahahahah()
	{
	 //yay
	}
}
