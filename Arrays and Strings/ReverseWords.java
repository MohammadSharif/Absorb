/**
 * Created by Momo on 8/30/17
 */
import java.util.*;

public class ReverseWords {
  public static void main(String[] args){
    System.out.println(reverse("Do or do not, there is no try."));
  }
  // Method to reverse the words in the string by using the space as a delimeter
  public static String reverse(String toReverse){
    // Initially set the end index to the end of the string
    int end = toReverse.length();
    StringBuilder toReturn = new StringBuilder();
    // Iterate over the string from end to beginning
    for(int i = toReverse.length() - 1; i >= 0; i--){
      // The case where we reach the beginning of the string is special
      // since we should not follow the appending of the word with a space
      if( i == 0 ){
        toReturn.append(toReverse.substring(i, end));
        break;
      }
      // If the current index is a space, append the substring from the character
      // after the space to what the set end of the word is
      if(toReverse.substring(i, i+1).equals(" ")){
        toReturn.append(toReverse.substring(i+1, end));
        toReturn.append(" ");
        // set our end index for the next word to be the index the pointer is 
        // currently at
        end = i;
      }
    }
    return toReturn.toString();
  }
}
