package Project;

public class testingMain 
{
	public static void main(String args[])
	{
		Trump bat = new Trump(15, 20);
		Character jacob = new Character(15, 9, 14, "Jacob");
		
		while(bat.HP > 0)
		{
			Utilities.charAttack(jacob, bat);
			System.out.println(bat.HP);
			System.out.println(bat.isLiving);
		}
		
	}
}
