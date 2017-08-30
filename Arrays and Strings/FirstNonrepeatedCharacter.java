/**
 * Created by Momo on 8/29/17
 */
import java.util.*;

/**
 * The following class contains the necessary method to get the first non repeated
 * character within a string.
 */
public class FirstNonrepeatedCharacter {
  public static void main(String[] args){
    System.out.println(getFirstNonrepeatedChar("Wow"));
    System.out.println(getFirstNonrepeatedChar("Love"));
    System.out.println(getFirstNonrepeatedChar("Mississippi"));
    System.out.println(getFirstNonrepeatedChar("Ooooooo"));
  }

  public static String getFirstNonrepeatedChar(String word){
    int count;
    String currentLetter;
    String lowerCase = word.toLowerCase();
    Map<String, Integer> tempMap = new HashMap<>();
    // Loop through the word and add the count for each character
    // to a HashMap where the character is the key and the count is the
    // value.
    for(int i = 0; i < word.length(); i++){
      currentLetter = lowerCase.substring(i, i+1);
      if(tempMap.get(currentLetter) != null){
        count = tempMap.get(currentLetter);
        tempMap.replace(currentLetter, count+1);
      } else {
        tempMap.put(currentLetter, 1);
      }
    }
    // Loop back through the word and check the count of each letter
    // The first letter to appear with a count of one is the first non
    // repeated character.
    for(int i = 0; i < word.length(); i++){
      currentLetter = lowerCase.substring(i, i+1);
      if(tempMap.get(currentLetter) == 1)
        return currentLetter;
    }
    return "No non repeated characters.";
  }
  // The time complexity for this algorithm is O(n)
  // Two loops iterate over n elements O(2n)
  // As the limit of n increases towards infinity the 2 no longer matters
  // Hence, O(n)
}
