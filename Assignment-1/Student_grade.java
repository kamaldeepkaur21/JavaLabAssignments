import java.io.*;
import java.util.*;
public class Student_grade
{
	static int gradeno[]={0,0,0,0,0};
	static int ptsno=0;
	//calc function takes initial and ending index of array
	//and return sum from initial to ending index
	//this function also writes array elements in file
	static int calc(int arr[],int size,int a,BufferedWriter bw)throws IOException
	{
		int sum=0;
		for(int i=a;i<=size;i++)
		{
			if(arr[i]<10||(i==12&&arr[i]/100==0)||(i==13&&arr[i]/10==0))
				bw.write(" "+arr[i]+" ");
			else
				bw.write((arr[i])+" ");
			sum+=(arr[i]);
		}
		return sum;
	}
	//write function writes in file....and call sum function 
	//this function also calls grade function to calculate grade and write on file
	static void write(int arr[],BufferedWriter bw)throws IOException
	{
		bw.write(arr[0]+" ");
		int tot=calc(arr,10,1,bw);
		bw.write(tot+" ");
		int pts=arr[0]+tot+calc(arr,13,11,bw);
		bw.write(pts+" ");
		if(pts>ptsno)
			ptsno=pts;
		float n=((pts*100)/420);
		int pct=Math.round((n));
		bw.write(" "+pct+" ");
		char g=grade(pct);
		bw.write(g+" ");
		gradeno[g-'A']++;
	}
	//this function calculate grade of student by percentage as argument
	static char grade(int a)
	{
		if(a>=90)
			return 'A';
		else if(a>=78&&a<=89)
			return 'B';
		else if(a>=62&&a<=77)
			return 'C';
		else if(a>=46&&a<=61)
			return 'D';
		else
			return 'E';
		
	}
		public static void main(String args[])throws IOException
		{
			int arr[]=new int[18];
			File f1=new File("G:\\java-lab\\HW1-dictionary.txt");
			if(!f1.exists())
			{
				System.out.print("file not found");
				System.exit(0);
			}
			FileReader fr=new FileReader(f1);
			BufferedReader br=new BufferedReader(fr);
			File f2=new File("G:\\java-output\\output-1.txt");
			FileWriter fw=new FileWriter(f2);
			BufferedWriter bw=new BufferedWriter(fw);
			String str;
			str="Stdnt Id Ex ---------Assignments--------- Tot Mi Fin CL Pts Pct Gr";
			bw.write(str);
			bw.newLine();
			str="-------- -- ----------------------------- --- -- --- -- --- --- --";
			bw.newLine();
			bw.write(str);
			bw.newLine();
			while((str=br.readLine())!=null)
			{
				int i=0;
				StringTokenizer tok=new StringTokenizer(str);
				if(tok.hasMoreTokens())
					bw.write(tok.nextToken()+" ");
				while(tok.hasMoreTokens())
				{
					arr[i++]=Integer.parseInt(tok.nextToken());
				}
				write(arr,bw);
				bw.newLine();
			}
			char c='A';
			for(int i=0;i<5;i++)
			{
				bw.write("Number of "+c+"'s = "+gradeno[i]);
				c++;
				bw.newLine();
			}
			bw.newLine();
			bw.write("Maximum points = "+ptsno);
			br.close();
			bw.close();
		}
}
