//similar to RadioExample
package Project;

import javax.swing.*;
import java.awt.event.*;

class CharRadio extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 2L;
	JRadioButton button1, button2, button3;
	JButton button;
	
	String selectedClass = null;
	
	String class1;
	String class2;
	String class3;

	CharRadio(String [] classes)
	{
		class1 = classes[0];
		class2 = classes[1];
		class3 = classes[2];
		button1 = new JRadioButton(classes[0]);
		button1.setBounds(100, 50, 100, 30);
		
		button2 = new JRadioButton(classes[1]);
		button2.setBounds(100, 100, 100, 30);
		
		button3 = new JRadioButton(classes[2]);
		button3.setBounds(100, 150, 100, 30);

		ButtonGroup groupie = new ButtonGroup();
		groupie.add(button1); 
		groupie.add(button2);
		groupie.add(button3);
		
		button = new JButton("click");
		button.setBounds(100, 200, 100, 30);
		button.addActionListener(this);
		
		add(button1);
		add(button2);
		add(button3);

		add(button);
		
		setSize(300, 300);
		setLayout(null);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent j)
	{
		String tempClass = "null";
		{
			if(button1.isSelected())
			{
				tempClass = class1;
			}
			if(button2.isSelected())
			{
				tempClass = class2;
			}
			if(button3.isSelected())
			{
				tempClass = class3;
			}
		}
		//Did not transcribe code from RadioExample because it was checking a second list of "post" values
		setVisible(false);
		selectedClass = tempClass;
	}
	public String getThis() throws InterruptedException
	{
		Thread.sleep(500);
		return selectedClass;
	}

}