import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class StopWatch implements Runnable, ActionListener
{
	JFrame frame;
	JPanel panel;
	int flag=1;
	int H=00,M=00,S=1;
	JButton stop, start, pause, lap;
	List lapList;
	JButton Display;
	Thread timethread;
	GridBagLayout GL;
	GridBagConstraints GC;
	Font F;
	
	public StopWatch() 
	{
		frame=new JFrame("Stop Watching");
		panel=new JPanel();
		start=new JButton("Start");
		stop=new JButton("Reset");
		pause=new JButton("Pause");
		lap=new JButton("Lap");
		lapList=new List();
		Display=new JButton("00:00:00");
		timethread=new Thread(this);
		
		F=new Font("Courier", Font.BOLD, 24);
		GL=new GridBagLayout();
		GC=new GridBagConstraints();
		
		Display.setFont(F);
		Display.setEnabled(false);
		panel.setLayout(GL);
		frame.add(panel);
		GC.insets=new Insets(6, 6, 6, 6);
		GC.gridx=1;
		GC.gridy=1;
		GC.gridwidth=4;
		GC.fill=GridBagConstraints.HORIZONTAL;
		panel.add(Display, GC);
		GC.gridx=1;
		GC.gridy=2;
		panel.add(lapList, GC);
		GC.gridx=2;
		GC.gridy=3;
		GC.gridwidth=1;
		GC.fill=GridBagConstraints.CENTER;
		panel.add(start, GC);
		GC.gridx=1;
		GC.gridy=3;
		panel.add(pause, GC);
		GC.gridx=3;
		GC.gridy=3;
		panel.add(stop, GC);
		GC.gridx=4;
		GC.gridy=3;
		panel.add(lap, GC);
		
		pause.setEnabled(false);
		stop.setEnabled(false);
		lap.setEnabled(false);
		
		start.addActionListener(this);
		pause.addActionListener(this);
		stop.addActionListener(this);
		lap.addActionListener(this);
		
		frame.setSize(400, 300);
		
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) 
	{
		new StopWatch();
	}

	@Override
	public void run() 
	{
		try
		{	
			while (true)
			{
				Display.setText(H+" : "+M+" : "+S);
				timethread.sleep(10);
				if (S<99)
				{
					S++;
				}
				else if(M<59)
				{
					M++;
					S=0;
				}
				else
				{
					H++;
					M=0;
				}
			}
		}
		catch(Exception e) {}
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==start)
		{
			
			
			if (flag==0)
			{
			timethread.resume();
			}
			else
			{
			timethread.start();
			}
			pause.setEnabled(true);
			stop.setEnabled(true);
			start.setEnabled(false);
			lap.setEnabled(true);
		}
		if (e.getSource()==pause)
		{
			if(flag==0)
			{
				flag=1;
			}
			else
			{
				flag=0;
			}
			if(flag==0)
			{
				pause.setText("resume");
				timethread.suspend();
				lap.setEnabled(false);
			}
			else
			{
				pause.setText("Pause");
				timethread.resume();
				lap.setEnabled(true);
			}
			
		}
		if (e.getSource()==stop)
		{
			timethread.suspend();
			start.setEnabled(true);
			pause.setEnabled(false);
			stop.setEnabled(false);
			lap.setEnabled(false);
			flag=0;
			H=M=S=0;
			Display.setText("00:00:00");
			lapList.removeAll();
		}
		if (e.getSource()==lap)
		{
			
			lapList.add(H+" : "+M+" : "+S);
			
		}
	}

}
