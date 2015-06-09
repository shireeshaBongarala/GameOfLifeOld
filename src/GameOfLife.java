import java.util.*;

public class GameOfLife
{
	public static void main(String args[])
	{
		Scanner scan= new Scanner(System.in);
		int live=1;
		int generation[][]=new int[10][10];
		
		//generation[][4]={1,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1};
		int m=scan.nextInt();
		int n=scan.nextInt();
		for(int i=0;i<m;i++)
		
		{	for(int j=0;i<n;j++)
				generation[i][j]=scan.nextInt();
			System.out.println();
		}

		int count=0;
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{	
					
				count=0;	
					if(i>0&& j!=n-1)
					{
					count=count+generation[i-1][j]+generation[i][j+1];
					}
					if(j>0&&i!=m-1)
					{
					count=count+generation[i][j-1]+generation[i+1][j-1]+generation[i+1][j];
					}
					if(i>0&& j>0)
					{
					count+=generation[i-1][j-1];
					}	
					if(i!=m-1 && j!=n-1)
						count=count+generation[i+1][j+1];
			
					count=count+generation[i+1][j]+generation[i+1][j+1]+generation[i][j-1];
				if(generation[i][j]==live)
				{
					if(count<2) generation[i][j]=0;
					else if(count==2|| count==3) generation[i][j]=1;
					else if(count>3) generation[i][j]=0;
					
				}
				else
				{
					if(count==3) generation[i][j]=1;
				}
			}

			for(int i=0;i<m;i++)
				for(int j=0;i<n;j++)
					System.out.print(generation[i][j]);


	}
}
