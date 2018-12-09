package sortstack;

import java.io.*;
import java.util.*;

/**
 * StackSort is a program that will use two stacks to sort an array of integer values.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class StackSort {

    public static void main(String args[]) {

        int data[] = null;
        int result[] = null;

        Scanner input;
        input = new Scanner(System.in);

        System.out.println("This program sorts an array of integer values.");


        // Create an empty array of integers
        data = createArray(0, 1, 1);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with one integer
        data = createArray(1, 0, 9);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with two integers
        data = createArray(2, 0, 9);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with 10 integers
        data = createArray(10, 0, 9999);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with 20 integers
        data = createArray(20, 0, 9);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        System.out.println("Please enter the number of values to sort");
        int size = getInt("   It should be an integer value greater than or equal to 1.");
        // Create an array of the given size

        data = createArray(size, 0, 99);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();
        
        /*
         STEPS 1 TO 5
        
       VectorStack<Integer> lowerValues= new VectorStack<Integer> (size);
       VectorStack<Integer> upperValues= new VectorStack<Integer> (size);
       for(int i=0;i<size;i++)
    	   upperValues.push(data[i]);
       //TESTING : for(int i=0;i<size;i++)
       //             System.out.println(upperValues.peek());
    	  for(int i=0;i<size;i++)
       	   {result[i]=upperValues.pop();
       	            // Testing: System.out.println(result[i]);
       	   }
       	  //Testing : for(int i=0;i<size;i++)
    	  //  	         System.out.print(result[i]+" ");   
       
          */
    }


    /**
     * Use two stacks to sort the data in an array
     *
     * @param data An array of integer values to be sorted.
     * @return     An array of sorted integers. 
     */
    private static int[] doStackSort(int data[]) {

    int result[] = new int[data.length];

        
   //ADD CODE HERE TO SORT THE ARRAY USING TWO STACKS
   //CREATE TWO STACKS
    VectorStack<Integer> lowerValues=new VectorStack<Integer>(data.length);
    VectorStack<Integer> upperValues=new VectorStack<Integer>(data.length);
    
    //'LEN' VARIABLE STORES THE LENGHT OF DATA TO BE SORTED
    int len=data.length;
 
    
    for(int i=0;i<len;i++)
    {
    	//IF STACK IS EMPTY ALREADY ADD NEW ITEM WITHOUT COMPARISON INTO THE LEFT STACK
    	if(i==0)
    		lowerValues.push(data[i]);
    	
    	 //IF ELEMENT IS GREATER THAN TOP OF THE LEFT STACK
    	else if( data[i]>=lowerValues.peek())
         {	
    		//IF RIGHT STACK IS EMPTY ADD TO THE LEFT STACK
              if(upperValues.isEmpty())
        	     lowerValues.push(data[i]);
              else
              {
            	  //IF RIGHT STACK IS NOT EMPTY AND NEW ITEM IS LESS THAN TOP OF RIGHT STACK
            	  // THEN PUSH TO THE LEFT STACK
            	  if(data[i]<upperValues.peek())
            		  lowerValues.push(data[i]);
            	  
            	  //IF NEW ITEM IS GREATER THAN TOP OF THE RIGHT STACK
            	  //MOVE ALL ELEMENTS SMALLER THAN NEW ITEM FROM RIGHT STACK TO LEFT STACK AND PUSH THE NEW ITEM ON TOP OF RIGHT STACK
            	  else if(data[i]>upperValues.peek())
            	  { 
            		  while( !upperValues.isEmpty())
              		   {
            			  if(data[i]>upperValues.peek())
            			  {
              		           int a= upperValues.pop();
              		           lowerValues.push(a);
              		      }
            			  else
            				  break;
              		   }
            		 //PUSH THE NEW ITEM ON TOP OF THE RIGHT STACK
              		upperValues.push(data[i]);
            	  }
              }
         
         
         }
    	//IF NEW ITEM IS SMALLER THAN TOP OF THE LEFT STACK
    	//THEN SHIFT ALL ITEMS SMALLER THAN NEW ITEM FROM LEFT STACK TO THE RIGHT STACK AND PUSH NEW ITEM ON TOP OF THE LEFT STACK
    	else if( data[i]<lowerValues.peek())
    	{
    		while(!lowerValues.isEmpty())
    		{
    			if(data[i]<lowerValues.peek())
    			{
    			         int a= lowerValues.pop();
    			         upperValues.push(a);
    		    }
    			else
    				break;
    		}
    		// PUSH DATA ITEM ON TOP OF LEFT STACK
    		lowerValues.push(data[i]);
    	}
    }
    
    
   //STORING SORTED ARRAY FROM BOTH LEFT AND RIGHT STACK IN THE RESULT ARRAY
    while(!lowerValues.isEmpty())
    {
    	//MOVE ALL LEFT STACK ITEMS TO RIGHT STACK
      int a=lowerValues.pop();
      upperValues.push(a);  
    }
   //NOW RIGHT STACK IS THE SORTED STACK
    int i=0;
    
    //COPYING VALUES OF RIGHT STACK TO THE RESULT ARRAY ONE BY ONE
    while(!upperValues.isEmpty())
    {
    	result[i]=upperValues.pop();
    	i++;
    }
    
    //RETURN OUTPUT ARRAY
    return result;

    }

    /**
     * Load an array with data values
     *
     * @param size The number of data values to generate and place in the array.
     * @param min The minimum value to generate.
     * @param max The maximum value to generate.
     * @return     An array of randomly generated integers. 
     */
    private static int[] createArray(int size, int min, int max) {

        Random generator = new Random();

        // If we get a negative size, just make the size 1
        if (size < 0) {
            size = 1;
        }
        // We need max > min for the random number generator to be happy

        if (max <= min) {
            max = min + 1;
        }

        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = min + generator.nextInt(max - min);
        }

        return data;
    }

    /**
     * Create a string with the data values from an array
     *
     * @param data An array of integer values.
     * @return A string representation of the array.
     */
    private static String representationOfArray(int data[]) {
        String result = new String("< ");
        for (int i = 0; i < data.length; i++) {
            result += data[i] + " ";
        }
        result += ">";

        return result;
    }

    /**
     * Get an integer value
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt) {
        Scanner input;
        int result = 10;        //default value is 10
        try {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();

        } catch (NumberFormatException e) {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        } catch (Exception e) {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;

    }
}

