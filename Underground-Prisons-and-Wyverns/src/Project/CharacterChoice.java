package Project;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

//(Carly) Using this class eventually to display buttons for class choice
public class CharacterChoice extends JFrame
{
	private static final long serialVersionUID = 1L;
	static JRadioButton option1;
	static JRadioButton option2;
	static JRadioButton option3;
	static JRadioButton option4;
	static JRadioButton option5;
	static JRadioButton option6;
	
	public CharacterChoice(String[] classes)
	{
		super("Swing CharacterChoice");
		
		option1 = new JRadioButton(classes[0]);
		option2 = new JRadioButton(classes[1]);
		option3 = new JRadioButton(classes[2]);
		option4 = new JRadioButton(classes[3]);
		option5 = new JRadioButton(classes[4]);
		option6 = new JRadioButton(classes[5]);
		
		ButtonGroup nuevo = new ButtonGroup();
		nuevo.add(option1);
		nuevo.add(option2);
		nuevo.add(option3);
		nuevo.add(option4);
		nuevo.add(option5);
		nuevo.add(option6);
		setLayout(new FlowLayout());
		add(option1);
		add(option2);
		add(option3);
		add(option4);
		add(option5);
		add(option6);
		
		pack();
	}
	public static String generate(final String[] classes)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new CharacterChoice(classes).setVisible(true);
			}
		});
		if(option1.isSelected())
		{
			return classes[0];
		}
		else if(option2.isSelected())
		{
			return classes[1];
		}
		else if(option3.isSelected())
		{
			return classes[2];
		}
		else if(option4.isSelected())
		{
			return classes[3];
		}
		else if(option5.isSelected())
		{
			return classes[4];
		}
		else if(option6.isSelected())
		{
			return classes[5];
		}
	}
}