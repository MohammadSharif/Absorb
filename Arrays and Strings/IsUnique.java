/**
 * Created by Momo on 8/31/17
 */
import java.util.*;

public class IsUnique {
  public static void main(String[] args) {
    System.out.println(isUnique("Hello World"));
    System.out.println(isUnique("wubba lubba dub dub"));
    System.out.println(isUnique("Unique"));
    System.out.println(isUnique("asdfg"));
  }

  public static boolean isUnique(String toCheck) {
    // If the string's length is larger than the amount of characters
    // By the pigeonhole principle a character has to repeat
    if(toCheck.length() > 128) { return false; }
    // Create an array according to all possible characters
    boolean[] characters = new boolean[128];
    for(int i = 0; i < toCheck.length(); i++){
      int currentChar = toCheck.charAt(i);
      // If the current character has already been seen in the string
      if(characters[currentChar]){
        return false;
      }
      characters[currentChar] = true;
    }
    return true;
  }
}
