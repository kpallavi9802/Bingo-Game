/*BINGO GAME BY 18MCMC33 PALLAVI KUMARI
 * Rules and Regulation for Bingo
	 * Player1 can play at odd numbers of times only
	 * Player2 can play at even numbers of times only
	 * when Play button is clicked,two same players as before can play the game
	 * when Reset button is clicked,two different players as before can play the game
	 * Player1 Or player2 will win the Game only when
	  	*Any Row numbers will be completely clicked
		*Any Column numbers will be completely clicked
		*Any Diagonal numbers will be completely clicked
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class PlayBingo implements ActionListener,KeyListener
{
	JFrame fr;
	JPanel p1,p2,pn;
	JButton[][] bt1=new JButton[5][5];
	JButton[][] bt2=new JButton[5][5];
	JTextField tp1,tp2;
	JButton btnew,btexit,btreset;
	String Result;
	
	//Random rand=new Random();
	
	int x;
	int arr[]=new int[25];
	int[][] Arr1=new int[5][5];
	int[][] Arr2=new int[5][5];
	
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	Dimension dim=toolkit.getScreenSize();
	int h=(int)dim.getHeight();
	int w=(int)dim.getWidth();
	
	PlayBingo()
	{
		
		fr=new JFrame("Let's Play BINGO");
		pn=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("bingo.png").getImage(),0,0,w,h,null );
			}
		};
		pn.setBounds(0,0,w,h);
		pn.setLayout(null);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(5, 5));
		p1.setBounds(110,290,300,270);
		p1.setBackground(Color.gray);
		p1.setFont(new Font("Times New Roman",Font.BOLD,28));
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(5, 5));
		p2.setBounds(960,301,302,290);
		p2.setBackground(Color.gray);
		p2.setFont(new Font("Times New Roman",Font.BOLD,28));
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				Arr1[i][j]=0;
			}
		}
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				Arr2[i][j]=0;
			}
		}
		
		
		tp1=new JTextField();
		tp1.setBounds(255,150,190,40);
		tp1.setFont(new Font("Times New Roman",Font.BOLD,28));
		
		tp2=new JTextField();
		tp2.setBounds(1120,148,180,40);
		tp2.setFont(new Font("Times New Roman",Font.BOLD,28));
		
		btnew=new JButton("Play");
		btnew.setBounds(552,220,100,40);
		btnew.setFont(new Font("Times New Roman",Font.BOLD,28));
		btnew.setBorder(BorderFactory.createLineBorder(Color.black));
		btnew.setBackground(Color.white);
		
		btreset=new JButton("Reset");
		btreset.setBounds(660,220,100,40);
		btreset.setFont(new Font("Times New Roman",Font.BOLD,28));
		btreset.setBorder(BorderFactory.createLineBorder(Color.black));
		btreset.setBackground(Color.white);
		
		btexit=new JButton("Exit");
		btexit.setBounds(770,220,100,40);
		btexit.setFont(new Font("Times New Roman",Font.BOLD,28));
		btexit.setBorder(BorderFactory.createLineBorder(Color.black));
		btexit.setBackground(Color.white);
		
		pn.setLayout(null);
		pn.setBounds(0,0,w,h);
		
		int k=1;
		for(int r=0;r<5;r++)
		{
			for(int c=0;c<5;c++)
			{
				bt1[r][c]=new JButton();
				bt1[r][c].setBackground(Color.WHITE);
				bt1[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
				/*x=(int)(Math.random() * 25 + 1);
				bt1[r][c].setText(""+x);*/
				
				bt1[r][c].setText(""+k);
				p1.add(bt1[r][c]);
				k++;
			}
		}
		
		k=25;
		for(int r=0;r<5;r++)
		{
			for(int c=0;c<5;c++)
			{
				bt2[r][c]=new JButton();
				bt2[r][c].setBackground(Color.WHITE);
				bt2[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
				/*x=(int)(Math.random() * 25 + 1);
				bt2[r][c].setText(""+x); */
				
				bt2[r][c].setText(""+k);
				p2.add(bt2[r][c]);
				k--;
			}
		}
		
		for(int i=0;i<5;i++)
    	{
    		for(int j = 0; j<5;j++)
    		{
    			bt1[i][j].setEnabled(false);
    			bt2[i][j].setEnabled(false);
    		}
    	}
		
		fr.add(pn);
		
		pn.add(p1);
		pn.add(p2);
		pn.add(tp1);
		pn.add(tp2);
		pn.add(btnew);
		pn.add(btreset);
		pn.add(btexit);
		
		fr.setLayout(null);	
		fr.setResizable(false);
		fr.setSize(w,h);
		fr.setBackground(Color.yellow);
		fr.setVisible(true);
		
		btnew.addActionListener(this);
	    btreset.addActionListener(this);
	    btexit.addActionListener(this);
	    
		for(int r=0;r<5;r++)
		{
			for(int c=0;c<5;c++)
			{
				
				bt1[r][c].addActionListener(this);
			}
		}
		
		for(int r=0;r<5;r++)
		{
			for(int c=0;c<5;c++)
			{
				bt2[r][c].addActionListener(this);
			}
		}
		
		tp1.addKeyListener(this);
        tp2.addKeyListener(this);
		
	}
	
	public void keyTyped(KeyEvent ke)
	{
		    if(ke.getSource()==tp1)
		    {
		    	char ch=ke.getKeyChar();
		    	if(!Character.isLetter(ch))
		    	{
		    		JOptionPane.showMessageDialog(fr, "Name should be only of Character");
		    		ke.consume();
		    	}
		    }
		    else if(ke.getSource()==tp2)
		    {
		    	char ch=ke.getKeyChar();
		    	if(!Character.isLetter(ch))
		    	{
		    		JOptionPane.showMessageDialog(fr, "Name should be only of Character");
		    		ke.consume();
		    	}
		    }
	}
	public void keyPressed(KeyEvent ke) {}
	public void keyReleased(KeyEvent ke) {}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		try
		{
			int res=0;
			int counter=0;
			String str1,str2;
			
			//For First Table
			for(int r=0;r<=4;r++)
			{
				for(int c=0;c<=4;c++)
				{
					if(ae.getSource()==bt1[r][c])
					{
						Arr1[r][c]=1;
						bt1[r][c].setEnabled(false);
						str1=bt1[r][c].getText();
						counter = 1;
						
						for(int a=0;a<5;a++)
						{
							
							for(int b=0;b<5;b++)
							{
								str2=bt2[a][b].getText();
								
								if(str1.equals(str2))
								{
									
									Arr2[a][b]=1;
									bt2[a][b].setEnabled(false);
									break;
								}
							}
						}
						
						res=check(Arr1,r,c);
						if(res==1)
						{
							Result="Player1 Won";
							JOptionPane.showMessageDialog(fr,"Player1 won");
							//break;
						}
					}
				}
			}
			
			//For Second Table
			for(int r=0;r<5;r++)
			{
				for(int c=0;c<5;c++)
				{
					if(ae.getSource()==bt2[r][c])
					{
						Arr2[r][c]=1;
						bt2[r][c].setEnabled(false);
						str1=bt2[r][c].getText();
						counter = 2 ;
						
						for(int a=0;a<5;a++)
						{
							
							for(int b=0;b<5;b++)
							{
								str2=bt1[a][b].getText();
								
								if(str1.equals(str2))
								{
									
									Arr1[a][b]=1;
									bt1[a][b].setEnabled(false);
									break;
								}
							}
						}
						res=check(Arr2,r,c);
						if(res==1) 
						{
							Result="Player2 Won";
							JOptionPane.showMessageDialog(fr,"Player2 won");
							break;
						}
					}
				}
			}
				
			if(ae.getSource()==btnew)
	        {
				for(int i=0;i<5;i++)
		    	{
		    		for(int j = 0; j<5;j++)
		    		{
		    			Arr1[i][j]=0;
		    			Arr2[i][j]=0;
		    		}
		    	}
	        	if((tp1.getText().equals(""))||(tp2.getText().equals("")))
	        	{
	        		JOptionPane.showMessageDialog(fr,"Fill the Name Fields First");
				}
	        	else
		        {
	        		File data = new File("Bingo.txt");
		      		FileOutputStream fos = new FileOutputStream(data,true);
		      		PrintWriter pw = new PrintWriter(fos);
		      		pw.println("Player1  Player2  Result\n");
		        	
					String pl1=tp1.getText();
					String pl2=tp2.getText();
					pw.println(pl1+"   "+pl2+"   "+Result);
				
		      		pw.println();
		      		pw.flush();
		      		pw.close();
		      		
		            for(int i = 0; i < 5; i++)
		        	{
		        		   for(int j = 0; j< 5; j++)
		        		   {       
		        		       bt1[i][j].setEnabled(true);
		        		       bt2[i][j].setEnabled(true);
		        		       tp1.setEnabled(false);
		        		       tp2.setEnabled(false);
		        		   }
		        	}
		        		
		        }
	        }
	        if(ae.getSource()==btreset)
		    {
				    tp1.setText("");
		       		tp2.setText("");
			       	tp1.setEnabled(true);
			    	tp2.setEnabled(true);
			    	
			    	for(int i=0;i<5;i++)
			    	{
			    		for(int j = 0; j<5;j++)
			    		{
			    			bt1[i][j].setEnabled(false);
			    			bt2[i][j].setEnabled(false);
			    		}
			    	}
			    	
			    	for(int i=0;i<5;i++)
			    	{
			    		for(int j = 0; j<5;j++)
			    		{
			    			Arr1[i][j]=0;
			    			Arr2[i][j]=0;
			    		}
			    	}
		    }
			if(ae.getSource()==btexit)
		    {
		        	System.exit(0);
		    }
	        	
	    }
		catch(Exception exp)
		{
			System.out.println(exp);
		}
	}
	
	public int check(int[][] arr,int i,int j)
	{
		arr[i][j]=1;
		int s1=0,s2=0,s3=0,s4=0;
		for(int k = 0;k<5;k++)
		{
			s1 = s1+arr[k][j];
		}
		
		for(int k = 0;k<5;k++)
		{
			s2 = s2+arr[i][k];
		}
		if(i==j)
		{
			for(int k = 0;k<5;k++)
			{
				s3 = s3+arr[k][k];
			}
		}
		if(i+j == 4)
		{
			for(int k=0; k<5; k++)
			{
				s4 = s4+arr[k][4-k];
			}
		}
		
		if((s1 == 5) || (s2 == 5) || (s3 ==5) || (s4 ==5))
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
public class  Bingo
{
	public static void main(String[] args)
	{
		new PlayBingo();
	}
}

