import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CalC implements ActionListener
	{
		int flag=0,flag2=1,flag3=0;
		JFrame frame;
		JPanel MainPanel,DisplayPanel, ButtonPanel;
		float temp,temp1;
		JLabel buttonResult;
		JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
		JButton buttonEqual, buttonPlus, buttonMinus,buttonPoint,buttonMultiply,buttonDivide, buttonClear, buttonBack;
		BorderLayout BL;
		GridBagConstraints GC;
		GridBagLayout GL;
		Font f;
		
		public CalC() 
		{
			frame=new JFrame("Calculator");
			MainPanel=new JPanel();
			ButtonPanel=new JPanel();
			DisplayPanel=new JPanel();
			
			BL=new BorderLayout();
			GL=new GridBagLayout();
			GC=new GridBagConstraints();
			MainPanel.setLayout(BL);
			ButtonPanel.setLayout(GL);
			DisplayPanel.setLayout(GL);
			
			button1=new JButton("1");
			button2=new JButton("2");
			button3=new JButton("3");
			button4=new JButton("4");
			button5=new JButton("5");
			button6=new JButton("6");
			button7=new JButton("7");
			button8=new JButton("8");
			button9=new JButton("9");
			button0=new JButton("0");
			buttonResult=new JLabel("0");
			buttonEqual=new JButton("=");
			buttonPlus=new JButton("+");
			buttonMinus=new JButton("-");
			buttonPoint=new JButton(".");
			buttonMultiply=new JButton("x");
			buttonDivide=new JButton("/");
			buttonClear=new JButton("C");
			buttonBack=new JButton("<-");
			f=new Font("Small Fonts", Font.PLAIN, 30);
			buttonResult.setForeground(Color.BLACK);
			buttonResult.setFont(f);
			MainPanel.add(DisplayPanel, BorderLayout.NORTH);
			MainPanel.add(ButtonPanel, BorderLayout.CENTER);
	
			DisplayPanel.add(buttonResult);
			
			GC.insets=new Insets(6,6,6,6);
			GC.ipadx=4;
			GC.ipady=4;
			GC.gridy=0;
			GC.gridx=0;
			ButtonPanel.add(buttonClear,GC);
			GC.gridy=3;
			GC.gridx=0;
			ButtonPanel.add(button1,GC);
			GC.gridy=3;
			GC.gridx=1;
			ButtonPanel.add(button2,GC);
			GC.gridy=3;
			GC.gridx=2;
			ButtonPanel.add(button3,GC);
			GC.gridy=2;
			GC.gridx=0;
			ButtonPanel.add(button4,GC);
			GC.gridy=2;
			GC.gridx=1;
			ButtonPanel.add(button5,GC);
			GC.gridy=2;
			GC.gridx=2;
			ButtonPanel.add(button6,GC);
			GC.gridy=1;
			GC.gridx=0;
			ButtonPanel.add(button7,GC);
			GC.gridy=1;
			GC.gridx=1;
			ButtonPanel.add(button8,GC);
			GC.gridy=1;
			GC.gridx=2;
			ButtonPanel.add(button9,GC);
			GC.gridy=4;
			GC.gridx=1;
			ButtonPanel.add(button0,GC);
			GC.gridy=0;
			GC.gridx=1;
			ButtonPanel.add(buttonBack,GC);
			GC.gridy=1;
			GC.gridx=3;
			ButtonPanel.add(buttonPlus, GC);
			GC.gridy=2;
			GC.gridx=3;
			ButtonPanel.add(buttonMinus, GC);
			GC.gridy=4;
			GC.gridx=0;
			ButtonPanel.add(buttonPoint, GC);
			GC.gridy=0;
			GC.gridx=2;
			ButtonPanel.add(buttonMultiply, GC);
			GC.gridy=0;
			GC.gridx=3;
			ButtonPanel.add(buttonDivide, GC);
			GC.gridheight=2;
			GC.gridy=3;
			GC.gridx=3;
			GC.fill=GridBagConstraints.VERTICAL;
			ButtonPanel.add(buttonEqual, GC);
			
			DisplayPanel.setBackground(Color.white);
			//buttonResult.setEnabled(false);
			
			button1.addActionListener(this);
			button2.addActionListener(this);
			button3.addActionListener(this);
			button4.addActionListener(this);
			button5.addActionListener(this);
			button6.addActionListener(this);
			button7.addActionListener(this);
			button8.addActionListener(this);
			button9.addActionListener(this);
			button0.addActionListener(this);
			buttonPlus.addActionListener(this);
			buttonEqual.addActionListener(this);
			buttonMinus.addActionListener(this);
			buttonPoint.addActionListener(this);
			buttonMultiply.addActionListener(this);
			buttonDivide.addActionListener(this);
			buttonClear.addActionListener(this);
			buttonBack.addActionListener(this);
			
			frame.setLocation(300,300);
			frame.add(MainPanel);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(300,300);
			frame.setVisible(true);
		}

		public static void main(String[] args) 
		{
			new CalC();
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource()==buttonClear)
			{
				buttonResult.setText("0");
				temp=temp1=flag3=0;
				flag2=1;
			}
			if (e.getSource()==buttonBack)
			{
				String str=buttonResult.getText();
				int i=str.length();
				if (flag2==0 && str.length()>1)
				{
					str=str.substring(0, i-1);
					buttonResult.setText(str);
				}
				if (str.length()==1)
				{
					buttonResult.setText("0");
				}
			}
			if (e.getSource()==button1)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+"1");
			}
			if (e.getSource()==button2)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+"2");
			}
			if (e.getSource()==button3)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+"3");
			}
			if (e.getSource()==button4)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+"4");
			}
			if (e.getSource()==button5)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+"5");
			}
			if (e.getSource()==button6)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+"6");
			}
			if (e.getSource()==button7)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+"7");
			}
			if (e.getSource()==button8)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+"8");
			}
			if (e.getSource()==button9)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+"9");
			}
			if (e.getSource()==button0)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+"0");
			}
			if (e.getSource()==buttonPoint)
			{
				if (flag2==1)
				{
					buttonResult.setText("");
					flag2=0;
				}
				String str=buttonResult.getText();
				buttonResult.setText(str+".");
			}
			if (e.getSource()==buttonPlus)
			{
				if (flag2==0 && flag3==0)
				{
					String str=buttonResult.getText();
					temp=Float.parseFloat(str);
				}
				if (flag3==1)
				{	
					String str1=buttonResult.getText();
					temp1=Float.parseFloat(str1);
					
					if(flag==1)
					{
						temp1=temp+temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==2)
					{
						temp1=temp-temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==3)
					{
						temp1=temp*temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==4)
					{
						temp1=temp/temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					temp=temp1;
				}
				flag2=flag3=1;
				flag=1;
			}
			if (e.getSource()==buttonMinus)
			{
				if (flag2==0 && flag3==0)
				{
					String str=buttonResult.getText();
					temp=Float.parseFloat(str);
				}
				if (flag3==1)
				{	
					String str1=buttonResult.getText();
					temp1=Float.parseFloat(str1);
					
					if(flag==1)
					{
						temp1=temp+temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==2)
					{
						temp1=temp-temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==3)
					{
						temp1=temp*temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==4)
					{
						temp1=temp/temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					temp=temp1;
				}
				flag2=flag3=1;
				flag=2;
			}
			if (e.getSource()==buttonMultiply)
			{
				if (flag2==0 && flag3==0)
				{
					String str=buttonResult.getText();
					temp=Float.parseFloat(str);
				}
				if (flag3==1)
				{	
					String str1=buttonResult.getText();
					temp1=Float.parseFloat(str1);
					
					if(flag==1)
					{
						temp1=temp+temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==2)
					{
						temp1=temp-temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==3)
					{
						temp1=temp*temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==4)
					{
						temp1=temp/temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					temp=temp1;
				}
				flag2=flag3=1;
				flag=3;
			}
			if (e.getSource()==buttonDivide)
			{
				if (flag2==0 && flag3==0)
				{
					String str=buttonResult.getText();
					temp=Float.parseFloat(str);
				}
				if (flag3==1)
				{	
					String str1=buttonResult.getText();
					temp1=Float.parseFloat(str1);
					
					if(flag==1)
					{
						temp1=temp+temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==2)
					{
						temp1=temp-temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==3)
					{
						temp1=temp*temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					if(flag==4)
					{
						temp1=temp/temp1;
						flag=0;
						buttonResult.setText(temp1+"");
					}
					temp=temp1;
				}
				flag2=flag3=1;
				flag=4;
			}
			if (e.getSource()==buttonEqual)
			{
				String str1=buttonResult.getText();
				temp1=Float.parseFloat(str1);
				
				if(flag==1)
				{
					temp1=temp+temp1;
					flag=0;
					buttonResult.setText(temp1+"");
				}
				if(flag==2)
				{
					temp1=temp-temp1;
					flag=0;
					buttonResult.setText(temp1+"");
				}
				if(flag==3)
				{
					temp1=temp*temp1;
					flag=0;
					buttonResult.setText(temp1+"");
				}
				if(flag==4)
				{
					temp1=temp/temp1;
					flag=0;
					buttonResult.setText(temp1+"");
				}
				temp=temp1;
				flag2=1;
				flag3=0;
			}	
		}
}
