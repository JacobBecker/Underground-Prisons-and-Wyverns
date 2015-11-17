package Project;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class JRadioButtonPopup extends JFrame {
	
	private static final long serialVersionUID = 1L;
	static JRadioButton option1;
	static JRadioButton option2;
	static JRadioButton option3;
	
	public JRadioButtonPopup(int[] scores) {
		super("Swing JRadioButton Demo");

		option1 = new JRadioButton(Integer.toString(scores[0]));
		option2 = new JRadioButton(Integer.toString(scores[1]));
		option3 = new JRadioButton(Integer.toString(scores[2]));
		
		ButtonGroup group = new ButtonGroup();
		group.add(option1);
		group.add(option2);
		group.add(option3);
		
		setLayout(new FlowLayout());
		
		add(option1);
		add(option2);
		add(option3);
		
		pack();
	}
	
	public static int generate(final int[] scores) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			new JRadioButtonPopup(scores).setVisible(true);
			}
		});
		
		if(option1.isSelected())
			{
				return scores[0];
			}
		
		else if(option2.isSelected())
		{
			return scores[2];
		}
		
		else
		{
			return scores[3];
		}
		
		}
	
	}
	
