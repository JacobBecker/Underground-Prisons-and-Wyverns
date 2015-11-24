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
	
	public CharacterChoice(String[] classes)
	{
		super("Swing CharacterChoice");
		
		option1 = new JRadioButton(classes[0]);
		option2 = new JRadioButton(classes[1]);
		option3 = new JRadioButton(classes[2]);
	}
}