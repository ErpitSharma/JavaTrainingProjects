import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe_v2 implements ActionListener
{
	JFrame frame;
	JPanel MainPanel, GamePanel, ResultPanel;
	JLabel ResultLabel;
	JButton button[][], ResetButton;
	GridLayout GL;
	BorderLayout BL;
	int TimeFlag=0;
	int flag=0,flagX1=3,flagX21=3,flagX22=3,flagX23=3,flagX24=3,flagX25=3,flagX26=3,flagX3=3;
	int flag3[][];
	Font f;
	
	public TicTacToe_v2() 
	{
		frame=new JFrame("TicTacToe v2.0");
		MainPanel=new JPanel();
		GamePanel=new JPanel();
		ResultPanel=new JPanel();
		ResultLabel=new JLabel("...");
		ResetButton=new JButton("reset");
		
		BL=new BorderLayout();
		GL=new GridLayout(3, 3);
		f=new Font("Lucida Handwriting", Font.ITALIC, 60);
		
		MainPanel.setLayout(BL);
		GamePanel.setLayout(GL);
		
		button=new JButton[3][3];
		flag3=new int[3][3];
	
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				button[i][j]=new JButton("");
				GamePanel.add(button[i][j]);
				button[i][j].setBackground(Color.LIGHT_GRAY);
				button[i][j].addActionListener(this);
				button[i][j].setFont(f);
			}
		}
		
		ResultPanel.add(ResultLabel);
		
		MainPanel.add(GamePanel, BorderLayout.CENTER);
		MainPanel.add(ResultPanel, BorderLayout.SOUTH);
		
		frame.add(MainPanel);
		
		frame.setSize(400, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		new TicTacToe_v2();
	}

	public void actionPerformed(ActionEvent e) 
	{
		TimeFlag++;
		String str="X";
		if (flag==0)
		{
			str="X";
		}
		if(flag==1)
		{
			str="O";
		}
		for (int x=0;x<3;x++)
		{
			for (int y=0;y<3;y++)
			{
				if (e.getSource()==button[x][y])
				{
					button[x][y].setText(str);
					if(flag==0)
					{
						button[x][y].setBackground(Color.BLUE);
						flag=1;
						flag3[x][y]=1;
					}
					else
					{
						button[x][y].setBackground(Color.GREEN);
						flag=0;
						flag3[x][y]=0;
					}
					button[x][y].setEnabled(false);
					
					if (flag3[x][y]==1)
					{
						if (y==x)
						{
							flagX1++;			
						}
						if(x==0)
						{
							flagX21++;
						}
						if(x==1)
						{
							flagX22++;
						}
						if(x==2)
						{
							flagX23++;
						}
						if(y==0)
						{
							flagX24++;
						}
						if(y==1)
						{
							flagX25++;
						}
						if(y==2)
						{
							flagX26++;
						}
						if((x+y)==2)
						{
						flagX3++;
						}
					}
					if (flag3[x][y]==0)
					{
						if (y==x )
						{
							flagX1--;			
						}
						
						if(x==0)
						{
							flagX21--;
						}
						if(x==1)
						{
							flagX22--;
						}
						if(x==2)
						{
							flagX23--;
						}
						if(y==0)
						{
							flagX24--;
						}
						if(y==1)
						{
							flagX25--;
						}
						if(y==2)
						{
							flagX26--;
						}
						if((x+y)==2)
						{
						flagX3--;
						}
					}
				}
			}
		}
		if (flagX1==6 || flagX21==6 || flagX22==6 || flagX23==6 || flagX24==6 || flagX25==6 || flagX26==6 || flagX3==6)
		{
			Ending(6);
			ResultLabel.setText("X is winner");
			ResultPanel.add(ResultLabel);
			GameOver();
		}
		else if (flagX1==0 || flagX21==0 || flagX22==0 || flagX23==0 || flagX24==0 || flagX25==0 || flagX26==0 || flagX3==0)
		{
			Ending(0);
			ResultLabel.setText("O is winner");
			ResultPanel.add(ResultLabel);
			GameOver();
		}
		else if (TimeFlag==9)
		{
			ResultLabel.setText("Draw!!");
			ResultPanel.add(ResultLabel);
			GameOver();
		}
		
		if (e.getSource()==ResetButton)
		{
			Reset();
		}
	}

	private void Reset()
	{
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				button[i][j].setEnabled(true);
				button[i][j].setText("");
				flag=0;
				TimeFlag=0;
				flagX1=flagX21=flagX22=flagX23=flagX24=flagX25=flagX26=flagX3=3;
				button[i][j].setOpaque(true);
				button[i][j].setBackground(Color.LIGHT_GRAY);
			}
		}
	}

	private void Ending(int i) 
	{
		if (flagX1==i)
		{
			for (int x=0;x<3;x++)
			{
				for (int y=0;y<3;y++)
				{
					if (y==x)
					{
					button[x][y].setBackground(Color.YELLOW);
					}
				}
			}
		}
		if (flagX21==i)
		{
			for (int x=0;x<3;x++)
			{
				for (int y=0;y<3;y++)
				{
					if (x==0)
					{
					button[x][y].setBackground(Color.YELLOW);
					}
				}
			}
		}
		if (flagX22==i)
		{
			for (int x=0;x<3;x++)
			{
				for (int y=0;y<3;y++)
				{
					if (x==1)
					{
					button[x][y].setBackground(Color.YELLOW);
					}
				}
			}
		}
		if (flagX23==i)
		{
			for (int x=0;x<3;x++)
			{
				for (int y=0;y<3;y++)
				{
					if (x==2)
					{
					button[x][y].setBackground(Color.YELLOW);
					}
				}
			}
		}
		if (flagX24==i)
		{
			for (int x=0;x<3;x++)
			{
				for (int y=0;y<3;y++)
				{
					if (y==0)
					{
					button[x][y].setBackground(Color.YELLOW);
					}
				}
			}
		}
		if (flagX25==i)
		{
			for (int x=0;x<3;x++)
			{
				for (int y=0;y<3;y++)
				{
					if (y==1)
					{
					button[x][y].setBackground(Color.YELLOW);
					}
				}
			}
		}
		if (flagX26==i)
		{
			for (int x=0;x<3;x++)
			{
				for (int y=0;y<3;y++)
				{
					if (y==2)
					{
					button[x][y].setBackground(Color.YELLOW);
					}
				}
			}
		}
		if (flagX21==i)
		{
			for (int x=0;x<3;x++)
			{
				for (int y=0;y<3;y++)
				{
					if (x==0)
					{
					button[x][y].setBackground(Color.YELLOW);
					}
				}
			}
		}
		if (flagX22==i)
		{
			for (int x=0;x<3;x++)
			{
				for (int y=0;y<3;y++)
				{
					if (x==1)
					{
					button[x][y].setBackground(Color.YELLOW);
					}
				}
			}
		}
		if (flagX3==i)
		{
			for (int x=0;x<3;x++)
			{
				for (int y=0;y<3;y++)
				{
					if ((x+y)==2)
					{
					button[x][y].setBackground(Color.YELLOW);
					}
				}
			}
		}
	}

	private void GameOver()
	{
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				button[i][j].setEnabled(false);
			}
		}
		ResultPanel.add(ResetButton);
		ResetButton.addActionListener(this);
		
	}
}
