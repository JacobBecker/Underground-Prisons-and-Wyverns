//similar to RadioExample
package Project;

import javax.swing.*;
import java.awt.event.*;

class CharRadio extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JRadioButton button1, button2, button3, button4, button5, button6;
	JButton button;
	
	String selectedClass = "null";
	
	String class1;
	String class2;
	String class3;
	String class4;
	String class5;
	String class6;
	
	CharRadio(String [] classes)
	{
		class1 = classes[0];
		class2 = classes[1];
		class3 = classes[2];
		class4 = classes[3];
		class5 = classes[4];
		class6 = classes[5];
		
		button1 = new JRadioButton(classes[0]);
		button1.setBounds(100, 50, 100, 30);
		
		button2 = new JRadioButton(classes[1]);
		button2.setBounds(100, 100, 100, 30);
		
		button3 = new JRadioButton(classes[2]);
		button3.setBounds(100, 150, 100, 30);
		
		button4 = new JRadioButton(classes[3]);
		button4.setBounds(100, 200, 100, 30);
		
		button5 = new JRadioButton(classes[4]);
		button5.setBounds(100, 250, 100, 30);
		
		button6 = new JRadioButton(classes[5]);
		button6.setBounds(100, 300, 100, 30);
		
		ButtonGroup groupie = new ButtonGroup();
		groupie.add(button1); 
		groupie.add(button2);
		groupie.add(button3);
		groupie.add(button4);
		groupie.add(button5);
		groupie.add(button6);
		
		button = new JButton("click");
		button.setBounds(100, 350, 100, 30);
		button.addActionListener(this);
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button);
		
		setSize(300, 600);
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
			if(button4.isSelected())
			{
				tempClass = class4;
			}
			if(button5.isSelected())
			{
				tempClass = class5;
			}
			if(button6.isSelected())
			{
				tempClass = class6;
			}
		}
		//Did not transcribe code from RadioExample because it was checking a second list of "post" values
		selectedClass = tempClass;
	}
	public String getClass() throws InterruptedException
	{
		Thread.sleep(500);
		return selectedClass;
	}

}