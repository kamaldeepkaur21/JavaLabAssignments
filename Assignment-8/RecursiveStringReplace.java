

/**
 * A class that has a methond to recursively replaces characters in a String.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class RecursiveStringReplace
{

    /**
     * replace - Replace all instances of one character by another.
     * 
     * @param  s   The string to do the replacement on.
     * @param  from   The character to be replaced.
     * @param  to   the character to change to.
     * @return     A new string with the appropriate characters replaced.
     */
    public String replace(String s, char from, char to)
    {
      String result = s;
      //IF STRING IS EMPTY RETURN NULL
      if(s=="")
    	  return null;
      //IF CHARACTER TO BE REPLACED IS NOT PRESENT RETURN STRING AS IT IS
      if(s.indexOf(from)==-1)
    	  return s ;
      
      	result=s.replaceFirst(from+"",to+"");
    	return replace(result,from,to);    	
    	  
    }


}

