package Project;

import javax.swing.*;  
import java.awt.event.*;  

class RadioExample extends JFrame implements ActionListener
{  
	private static final long serialVersionUID = 1L;
	JRadioButton rb1,rb2,rb3;  
	JButton b; 
	
	int value = 0;
	
	int value1;
	int value2;
	int value3;
	
	int value4;
	int value5;
	int value6;
	
	RadioExample(int[] preScores, int[] postScores)
	{  			
			value1 = preScores[0];
			value2 = preScores[1];
			value3 = preScores[2];
			
			value4 = postScores[0];
			value5 = postScores[1];
			value6 = postScores[2];
			
			rb1=new JRadioButton(Integer.toString(preScores[0]));  
			rb1.setBounds(100,50,100,30);  
  
			rb2=new JRadioButton(Integer.toString(preScores[1]));  
			rb2.setBounds(100,100,100,30);  
			
			rb3=new JRadioButton(Integer.toString(preScores[2]));  
			rb3.setBounds(100,150,100,30);
  
			ButtonGroup bg=new ButtonGroup();  
			bg.add(rb1);bg.add(rb2);bg.add(rb3);  
  
			b=new JButton("click");  
			b.setBounds(100,200,80,30);  
			b.addActionListener(this);  
  
			add(rb1);add(rb2);add(rb3);add(b);  
  
			setSize(300,300);  
			setLayout(null);  
			setVisible(true);  
	}  
	
	public void actionPerformed(ActionEvent e)
	{  
		int tempValue = 0;
				{
			if(rb1.isSelected())
			{  
				tempValue = value1; 
			}  
			if(rb2.isSelected())
			{  
				tempValue = value2; 
			}  
			if(rb3.isSelected())
			{  
				tempValue = value3; 
			} 
		}
		
		if(tempValue != value4 && tempValue != value5 && tempValue != value6)
		{
			setVisible(false);
			value = tempValue;
		}	
	}  
	
	public int getValue()
	{
		System.out.println(value);
		return value;	
	}
}