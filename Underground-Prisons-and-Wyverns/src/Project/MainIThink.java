//This is testing push and pu;ll and git
//Hope you can see this
package Project;

import javax.swing.JOptionPane;
import com.badlogic.gdx.Gdx;



public class MainIThink 
{
	public static void main (String args[])	
	{
		
		
		MyTextInputListener listener = new MyTextInputListener();
		Gdx.input.getTextInput(listener, "Dialog Title", "Test Text", "String");
		//Character OC = new Character();		
		//JOptionPane.showMessageDialog(null, OC.Name + "\n" + OC.Strength + "\n" + OC.Constitution);
	}
}

