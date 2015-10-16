package Project;

public class Bat extends Enemy 
{
	 public Bat()
	 {
		 hp = Utilities.rollDice(1, 8); 
		 damage = Utilities.rollDice(0, 0); 
		 defense = 6;
		 name = "Bat";
	 }
}
