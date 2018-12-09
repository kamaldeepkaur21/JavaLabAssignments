
/**
 * A class holding different recursive metholds to compute fibonacci numbers.
 * 0, 1, 1, 2, 3, 5, 8, ...
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class RecursiveFibonacci
{


    /**
     * basic - The simple version of fibonacci.
     * 
     * @param  n   A positive integer. 
     * @return     The nth fibonacci number.
     */
    public long basic(long n)
    {
        long result = 1;
        
        if( n <= 0)
            result = 0;
        else if (n == 1)
            result = 1;
        else
            result = basic(n-1) + basic(n-2);
        
        return result;
    }
    
    
    /**
     * better - A better version of fibonacci. (Height Limited Double Recursion)
     * 
     * @param  n   A positive integer.
     * @return     The nth fibonacci number.
     */
    public long better(long n)
    {
 
        // IMPLEMENT THIS RECURSIVE METHOD
        if(n<=0) return 0;
              //TAKING AN EXTRA ARRAY F TO REMEMBER VALUES
        	    long f[] = new long[1000]; 
        	    int i; 
        	       
        	 
        	    f[0] = 0; 
        	    f[1] = 1; 
        	    
        	    //INITIALISE F ARRAY VALUES TO 0  
        	    for (i = 2; i <1000; i++) 
        	    { 
        	
        	        f[i] = -1;
        	       
        	    } 
        	    
        	    if(n==0||n==1)
        	    	return n;
        	    
        	    //FIBONACCI CALL
        	    else if(f[(int)n]==-1)
        	    	{
        	    	f[(int)n]=better(n-1)+better(n-2);
        	    	
        	    	}
        	       
        	    return f[(int)n]; 
        	   } 
         
    


    /**
     * tailRecursive - A tail recursive version of fibonacci. 
     *              (Height limited, Two problems per level)
     * 
     * @param  n   A positive integer. 
     * @return     Tge nth fibonacci number.
     */
    public long tailRecursive(long n)
    {
        // IMPLEMENT THIS METHOD USING A RECURSIVE HELPER FUNCTION
        // AND RETURN AN APPROPRIATE VALUE
    	if(n<=2)
    		return 1;
    	else 
    		return helper(0,1,n);
    			
         
    } 
   private long  helper(long a, long b, long count ) 
    {  
          
        if (count<=1) 
            return a; 
        else
        return helper(b,a+b,count-1); 
    } 
    

    /**
     * secondMSB - Determine the value of the second most significant bit.
     * 
     * @param  n   A positive integer 
     * @return     True if the second most significant bit is 1, false otherwise.
     */    
    public boolean secondMSB(long n)
    {
        // IMPLEMENT THIS METHOD AND RETURN AN APPROPRIATE VALUE
    	if (n <= 0) 
            return false; 
      //CALCULATING TOTAL NUMBER OF BITS AND STORING MOST SIGNIFICANT BIT IN msb
        long msb = 0; 
        while (n != 0) { 
            n = n / 2; 
            msb++; 
        } 
        //STORE SECOND SIGNIFICANT BIT IN secondsignificant
     long secondsignificant=(1<<(msb-2));
     
     //CHECKING IF SECOND SIGNIFICANT IS SET OR NOT
        return (n & secondsignificant)==0; 
  
    }


    /**
     * reduceBy2ndMSB - Reduce the number by removing the second most significant bit
     * from the representation.
     * 
     * @param  n   A positive integer > 1
     * @return     The integer value equivalent to removing the 2nd most significant bit
     *              from n.
     */    
    public long reduceBy2ndMSB(long n)
    {
        // IMPLEMENT THIS METHOD
        if (n <= 0) 
            return 0;
      //CALCULATING TOTAL NUMBER OF BITS AND STORING MOST SIGNIFICANT BIT IN msb
        long msb = 0; 
        while (n != 0) { 
            n = n / 2; 
            msb++; 
        } 
        //STORE SECOND SIGNIFICANT BIT IN secondsignificant
     long secondsignificant=(1<<(msb-2));
     
        if(secondsignificant==1)
        	secondsignificant=0;
        else secondsignificant=1;
        return n;
    }
    
    
}
