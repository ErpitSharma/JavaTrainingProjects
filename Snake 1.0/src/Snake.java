import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Snake implements KeyListener, Runnable, MouseListener
{
	JFrame frame;
	JPanel panel;
	JTextField input, Text[][];
	Thread Crawl;
	JLabel Score;
	JButton Reset;
	int a=0, size=1, gameOverFlag=0,speed=200;
	int flag=1,bugX,bugY,s;
	int x=5,y=5,xp[],yp[];
	
	GridBagLayout GL;
	GridBagConstraints GC;
	
	public Snake() 
	{
		frame=new JFrame("Snake v1.0");
		panel=new JPanel();
		Text=new JTextField[60][60];
		input=new JTextField("start!",10);
		Score=new JLabel("Score - 0");
		Reset=new JButton("");
		GL=new GridBagLayout();
		GC=new GridBagConstraints();
		panel.setLayout(GL);
		Crawl=new Thread(this);
		
		Reset.setEnabled(false);
		xp=new int[30];
		xp[0]=3;xp[1]=3;xp[2]=3;
		yp=new int[30];
		yp[0]=3;yp[1]=3;yp[2]=3;
		bugX=6;
		bugY=5;
		
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
		
		frame.add(panel);
		frame.setSize(800, 700);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) 
	{
		new Snake();
	}
	
	public void run() 
	{
		try
		{
			while(true)
			{
				
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
				if (x==bugX && y==bugY)   //caught a bug
				{
					Text[bugX][bugY].setText("");
					Random rand=new Random();
					bugX= rand.nextInt(28);
					Random rand1=new Random();
					bugY= rand1.nextInt(29);
					Score.setText("Score - "+s);
					s++;
					if (bugX<1 || bugX>28)
						bugX=2;
					if (bugY<1 || bugY>29)
						bugY=3;
					Text[bugX][bugY].setText("bug");
					size++;
					speed-=5;
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
				
				for (int i=size;i>0;i--)   //crashed
				{
					if (xp[i]==x && yp[i]==y)
					{
						gameOverFlag=1;
						Reset.setText("Game Over!!!");
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
		Text[x][y].setText("X");
		Text[xp[0]][yp[0]].setText("");
		Text[xp[0]][yp[0]].setBackground(Color.green);
		Text[xp[size-1]][yp[size-1]].setText("tail");
		Text[xp[size]][yp[size]].setText("");
		Text[xp[size]][yp[size]].setBackground(Color.white);
		for (int i=size;i>0;i--)
		{
			xp[i]=xp[i-1];
		}
		xp[0]=x;
		for (int i=size;i>0;i--)
		{
			yp[i]=yp[i-1];
		}
		yp[0]=y;
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
			{
			flag=3;
			}
		}
		if (e.getKeyCode()==39)     //right
		{
			if (flag!=2)
			{
			flag=1;
			}
		}
		if (e.getKeyCode()==40)     //down
		{
			if (flag!=3)
			{
			flag=4;
			}
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
					Text[i][j].setText("");
					Text[i][j].setBackground(Color.white);
					Text[bugX][bugY].setText("bug");					
				}
			}
			x=y=5;
			flag=1;
			for (int i=0;i<30;i++)
			{xp[i]=0;
			yp[i]=0;
			}
			if (gameOverFlag==1)
			{
				Crawl.resume();
				gameOverFlag=0;
			}
			s=1;
			Reset.setText("");
			size=2;
			speed=500;
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
