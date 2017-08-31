/**
 * Created by Momo on 8/30/17
 */
import java.util.*;

public class RemoveSpecifiedCharacters {
  public static void main(String[] args){
    String str = "Battle of the Vowels: Hawaii vs. Grozny";
    String remove = "aeiou";
    System.out.println(removeSpecifiedChars(str, remove));
  }

  // This method will handle removing the characters in "remove" from the String
  // "toRemoveFrom"
  public static String removeSpecifiedChars(String toRemoveFrom, String remove){
    Map<String, Integer> removeMap = new HashMap<>();
    StringBuilder toReturn = new StringBuilder();
    // Looping through each letter in remove and adding it to the map
    for(int i = 0; i < remove.length(); i++){
      removeMap.put(remove.substring(i, i+1), 1);
    }
    // Looping through each letter in toRemoveFrom and only append to "toReturn"
    // if that letter is not in the removeMap
    String currentChar;
    for(int i = 0; i < toRemoveFrom.length(); i++){
      currentChar = toRemoveFrom.substring(i, i + 1);
      if(removeMap.get(currentChar) == null){
        toReturn.append(currentChar);
      }
    }
    return toReturn.toString();
  }
}
