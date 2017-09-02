/**
 * Created by Momo on 9/1/2017
 */
import java.util.*;

public class Conversions {

  public static void main(String[] args) {
    System.out.println("Testing String to Integer Conversion:");
    System.out.println(stringToInteger("-1008"));
    System.out.println(stringToInteger("546"));
    System.out.println(stringToInteger("-999"));
    System.out.println(stringToInteger("0"));

    System.out.println("Testing Integer to String Conversion");
    System.out.println(integerToString(56));
    System.out.println(integerToString(-1052));
    System.out.println(integerToString(809));
    System.out.println(integerToString(-1));

  }

  public static int stringToInteger(String toConvert){
    int currentValue = 0;
    int currentPwrOfTen = 0;
    String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    // Iterate over the string from end to beginning
    for(int i = toConvert.length() - 1; i >= 0; i--){
      // When we reach index 0 we have to check if it is a negative sign
      if(i == 0 && toConvert.substring(i, i+1).equals("-")){
        return currentValue * -1;
      }
      // For each value in the string we need to find it's corresponding
      // Index in our nums array
      for(int j = 0; j < nums.length; j++ ){
        if(nums[j].equals(toConvert.substring(i, i+1))){
          // Multiplying j with 10^(currentPwrOfTen) gives us the digit in
          // the correct place
          currentValue += Math.pow(10, currentPwrOfTen) * j;
          currentPwrOfTen++;
          break;
        }
      }
    }
    return currentValue;
    // This solution runs in O(n) time, where n is the length of the string
    // to convert, because although we iterate over the array of numbers within
    // our for loop, the size is fixed at 9 so as n approaches infinity 9n
    // becomes n
  }

  public static String integerToString(int toConvert){
    int currentDigit;
    boolean done = false;
    boolean isNegative = false;
    StringBuilder sb = new StringBuilder();
    String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    // If the value is negative we note it and convert it to positivee
    if(toConvert < 0){
      isNegative = true;
      toConvert *= -1;
    }
    while(!done){
      // The digit at the current ones place is extracted by using % 10
      currentDigit = toConvert % 10;
      toConvert /= 10;
      sb.append(nums[currentDigit]);
      if(toConvert == 0){
        // If we noted the value was negative, the last thing we do is append
        // a "-" sign to our string builder
        if(isNegative){
          sb.append("-");
        }
        done = true;
      }
    }
    // The reverse method is used here but could also be done by iterating over
    // the string backwards and appending it to another string builder
    sb.reverse();
    return sb.toString();
    // This solution runs in O(n) where n is the number of digits in our int
    // although we use an array of numbers here, accessing data is O(1) and does
    // not factor into our runtime
  }
}
