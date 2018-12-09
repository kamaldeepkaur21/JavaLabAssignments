import java.io.*;
public class Student {
int id;
int lab_exercise;
int hw[]= new int[10];
int midterm;
int final_marks;
int extra_marks;

Student(int s_id,int s_lab_exercise,int s_hw[],int s_midterm,int s_final_marks,int s_extra_marks)
{
	id=s_id;
	lab_exercise=s_lab_exercise;
	hw=s_hw;
	midterm=s_midterm;
	final_marks=s_final_marks;
	extra_marks=s_extra_marks;
	
}

int TotalMarks(int lab_exercise,int hw[],int midterm,int final_marks,int extra_marks)
{
	int sum=0,total=0;
		for(int i=0;i<10;i++)
		{
			sum+=hw[i];
		}
			total=lab_exercise+sum+final_marks+extra_marks;
	return total;
}
int percentage(int s_total)
{
	int per=s_total/420;
	return per;
}
void Grade(int per)
{
	if(per>=90)
		System.out.println("A");                                                                                                                                                     
	else if(per>=78 && per<=89)
		System.out.println("B");
	else if(per>=62 && per<=77)
		System.out.println("C");
	else if(per>=46 && per<=61)
		System.out.println("D");
	else 
		System.out.println("F");
	
}
}
