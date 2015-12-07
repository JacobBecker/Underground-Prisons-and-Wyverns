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
	
	public CharacterChoice(String[] classes)
	{
		super("Swing CharacterChoice");
		
		choice1 = new JRadioButton(classes[0]);
		choice2 = new JRadioButton(classes[1]);
		choice3 = new JRadioButton(classes[2]);
		
		ButtonGroup nuevo = new ButtonGroup();
		nuevo.add(choice1);
		nuevo.add(choice2);
		nuevo.add(choice3);
		setLayout(new FlowLayout());
		add(choice1);
		add(choice2);
		add(choice3);
		
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
		else
		{
			return classes[2];
		}
	}
}