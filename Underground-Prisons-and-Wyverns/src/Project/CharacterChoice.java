//Similar to JRadioButtonPopup
package Project;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

//(Carly) Using this class eventually to display buttons for class choice
public class CharacterChoice extends JFrame
{
	
	private static final long serialVersionUID = 2L;
	
	static JRadioButton choice1;
	static JRadioButton choice2;
	static JRadioButton choice3;
	static JRadioButton choice4;
	static JRadioButton choice5;
	static JRadioButton choice6;
	
	public CharacterChoice(String[] classes)
	{
		super("Swing CharacterChoice");
		
		choice1 = new JRadioButton(classes[0]);
		choice2 = new JRadioButton(classes[1]);
		choice3 = new JRadioButton(classes[2]);
		choice4 = new JRadioButton(classes[3]);
		choice5 = new JRadioButton(classes[4]);
		choice6 = new JRadioButton(classes[5]);
		
		ButtonGroup nuevo = new ButtonGroup();
		nuevo.add(choice1);
		nuevo.add(choice2);
		nuevo.add(choice3);
		nuevo.add(choice4);
		nuevo.add(choice5);
		nuevo.add(choice6);
		setLayout(new FlowLayout());
		add(choice1);
		add(choice2);
		add(choice3);
		add(choice4);
		add(choice5);
		add(choice6);
		
		pack();
	}
	//this will not work until I finish CharRadio, it shouldn't affect run though
	public static String generation(final String[] classes)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new CharacterChoice(classes).setVisible(true);
			}
		});
		if(choice1.isSelected())
		{
			return classes[0];
		}
		else if(choice2.isSelected())
		{
			return classes[1];
		}
		else if(choice3.isSelected())
		{
			return classes[2];
		}
		else if(choice4.isSelected())
		{
			return classes[3];
		}
		else if(choice5.isSelected())
		{
			return classes[4];
		}
		else
		{
			return classes[5];
		}
	}
}