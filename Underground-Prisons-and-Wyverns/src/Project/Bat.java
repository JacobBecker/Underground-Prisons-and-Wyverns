package Project;

public class Bat extends Enemy 
{
	 public Bat()
	 {
		 HP = Utilities.rollDice(2, 1); //2HP
		 armor = 6;
		 numOfDice = 1;
		 diceSides = 1; //Deals 1 damage
		 name = "Bat";
	 }
}
