import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Dictionary {
	
	public static void sort(String[] a) {
		  for (int i=0; i<a.length-1; i++) {
		     for (int j=i+1; j<a.length; j++) {
		        if (a[i].compareTo(a[j]) > 0) {
		           String temp=a[j]; a[j]=a[i]; a[i]=temp;
		        }
		     }
		  }
		}
	public static int binarySearch(String[] a, String x) {
	    int low = 0;
	    int high = a.length - 1;
	    int mid;

	    while (low <= high) {
	        mid = (low + high) / 2;

	        if (a[mid].compareTo(x) < 0) {
	            low = mid + 1;
	        } else if (a[mid].compareTo(x) > 0) {
	            high = mid - 1;
	        } else {
	            return mid;
	        }
	    }

	    return -1;
	}

	public static void main(String[] args)throws IOException ,Exception
	{ String str=null;
		String arr1[]=new String[16000];
		File dict=new File("G:\\java-lab\\HW2-dictionary.txt");
		if(!dict.exists())
		{
			System.out.println("file not found");
			System.exit(0);
		}
		BufferedReader in1 = new BufferedReader(new FileReader(dict));
        String str1;
        int i=0;
        while((str1 = in1.readLine()) != null){
                arr1[i] = str1;
                i++;
        }
        
        String arr2[]=new String[84];
		File keyword=new File("G:\\java-lab\\HW2-keywords.txt");
		
			
				if(!keyword.exists())
				{
					System.out.println("file not found");
					System.exit(0);
				}
			
		
		BufferedReader in2 = new BufferedReader(new FileReader(keyword));
        String str2;
        int j=0;
        while((str2 = in2.readLine()) != null){
                arr2[j] = str2;
        j++;
        }
        int count=0;
           sort(arr1);
        sort(arr2);
            File output=new File("G:\\java-output\\output-2.txt");
            FileWriter fw=new FileWriter(output);
            BufferedWriter bw=new BufferedWriter(fw);
            if(!output.exists())
            {
            	output.createNewFile();
            }
     for(int k=0;k<84;k++)
     {
    	int ans=binarySearch(arr1,arr2[k]); 
    	if(ans==-1)
    	{
    		str="Keyword not found : " + arr2[k] +"\n";
    		 bw.write(str);
    		 bw.newLine();
    		count++;
    	}
     }
     String xyz="Number of keywords not found ="+count;
     bw.newLine();
    bw.write(xyz);
        in1.close();
        in2.close();
        bw.close();
	}
 }

		
