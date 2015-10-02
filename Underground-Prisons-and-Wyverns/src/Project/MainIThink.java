package Project;

import javax.swing.JOptionPane;


public class MainIThink 
{
	public static void main (String args[])	
	{
		Character OC = new Character();		
		JOptionPane.showMessageDialog(null, OC.Name + "\n" + OC.Strength + "\n" + OC.Constitution);
	}
}

