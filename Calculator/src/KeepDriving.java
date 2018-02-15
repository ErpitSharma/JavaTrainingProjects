import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class KeepDriving implements KeyListener, Runnable, MouseListener
{
	JFrame frame;
	JPanel panel;
	JTextField input, Text[][];
	Thread Crawl;
	JLabel Score, FuelLabel;
	JButton Reset;
	int a=0, size=1, gameOverFlag=0,speed=100;
	int flag=1,FuelX,FuelY,s,Time=0;
	int x=5,y=5,xp=0,xp1=0,yp1=0,yp=0;
	
	GridBagLayout GL;
	GridBagConstraints GC;
	
	public KeepDriving() 
	{
		frame=new JFrame("Don't Stop the Car");
		panel=new JPanel();
		Text=new JTextField[60][60];
		input=new JTextField("start!",10);
		Score=new JLabel("Score - 0");
		FuelLabel=new JLabel("Fuel -");
		Reset=new JButton("IIIIIIIIIIIIII");
		GL=new GridBagLayout();
		GC=new GridBagConstraints();
		panel.setLayout(GL);
		Crawl=new Thread(this);
		
		Reset.setEnabled(false);
		
		FuelX=6;
		FuelY=5;
		
		for (int i=1;i<29;i++)
		{
			for (int j=0;j<30;j++)
			{
				GC.gridwidth=1;
				GC.gridx=i;
				GC.gridy=j;
				Text[i][j]=new JTextField(2);
				panel.add(Text[i][j],GC);
				Text[i][j].setBackground(Color.white);
				Text[i][j].setEditable(false);
			}
		}
		for (int j=0;j<30;j++)
		{
			
			Text[29][j]=new JTextField(2);
			Text[0][j]=new JTextField(2);
			Text[29][j].setEditable(false);
		}
		input.addMouseListener(this);
		input.addKeyListener(this);
		
		GC.gridwidth=6;
		GC.gridx=0;
		GC.gridy=31;
		panel.add(input,GC);
		GC.gridwidth=4;
		GC.gridx=6;
		GC.gridy=31;
		panel.add(Score,GC);
		GC.gridwidth=4;
		GC.gridx=23;
		GC.gridy=31;
		panel.add(Reset,GC);
		GC.gridwidth=4;
		GC.gridx=20;
		GC.gridy=31;
		panel.add(FuelLabel,GC);
		
		frame.add(panel);
		frame.setSize(800, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) 
	{
		new KeepDriving();
	}
	
	public void run() 
	{
		try
		{
			while(true)
			{
				Time++;
				
				if (y==30)                 //wall through
				{
					y=0;
				}
				 if (y<0) 
				{
					y=29;
				}
				 if (x==29) 
					{
						x=1;
					}
					if (x<1) 
					{
						x=28;
					}
					if (x==FuelX && y==FuelY)   // ReFuel
					{
						Text[FuelX][FuelY].setText("");
						Random rand=new Random();
						FuelX= rand.nextInt(28);
						Random rand1=new Random();
						FuelY= rand1.nextInt(29);
						Score.setText("Score - "+s);
						s++;
						if (FuelX<1 || FuelX>28)
							FuelX=2;
						if (FuelY<1 || FuelY>29)
							FuelY=3;
						Text[FuelX][FuelY].setText("Fuel");
						Reset.setText("IIIIIIIIIIIIII");
						Time=0;
						
					}
					
				if (flag==1)                //Direction of motion
				{
					SnakeMotion();
					x++;
					Crawl.sleep(speed);
				}
				if (flag==2) 
				{
					SnakeMotion();
					x--;
					Crawl.sleep(speed);
				}
				if (flag==3) 
				{
					SnakeMotion();
					y--;
					Crawl.sleep(speed);
				}
				if (flag==4) 
				{
					SnakeMotion();
					y++;
					Crawl.sleep(speed);
				}
				
				if (Time==3)
				{
					String str=Reset.getText();
					int i=str.length();
					str=str.substring(0, i-1);
					Reset.setText(str);
					Time=0;
					if (i==1) 
					{
						Reset.setText("Fuel Over!!");
						gameOverFlag=1;
						Crawl.suspend();
					}
				}
				
			}
		}
		catch(Exception e){}
	}

	private void SnakeMotion() 
	{
		Text[x][y].setBackground(Color.black);
		Text[xp][yp].setBackground(Color.white);
		xp=xp1;
		xp1=x;
		yp=yp1;
		yp1=y;
	}

	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode()==37)  //left
		{
			if (flag!=1)
			{
			flag=2;
			}
		}
		if (e.getKeyCode()==38)   //up
		{
			if (flag!=4)
			flag=3;
		}
		if (e.getKeyCode()==39)     //right
		{
			if (flag!=2)
			flag=1;
		}
		if (e.getKeyCode()==40)     //down
		{
			if (flag!=3)
			flag=4;
		}
		
	}
	

	public void keyReleased(KeyEvent e) 
	{
		
	}

	public void keyTyped(KeyEvent e) 
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		input.setText("Restart");
		if (a==0) 
		{
			Crawl.start();
			a++;
		}
		else 
		{
			for (int i=0;i<29;i++)
			{
				for (int j=0;j<30;j++)
				{
					
					Text[i][j].setBackground(Color.white);
									
				}
			}
			x=y=5;
			flag=1;
			xp=0;
			xp1=0;
			yp1=0;
			yp=0;
			Reset.setText("IIIIIIIIIIIIII");
			if (gameOverFlag==1)
			{
				Time=0;
				gameOverFlag=0;
				Crawl.resume();
			}
			s=1;
			size=2;
			speed=100;
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
