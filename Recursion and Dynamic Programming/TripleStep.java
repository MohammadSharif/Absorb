/**
 * Created by Momo on 9/21/17
 */
import java.util.*;

public class TripleStep {
  public static void main(String[] args){
    System.out.println(tripleStep(1));
    System.out.println(tripleStep(2));
    System.out.println(tripleStep(3));
    System.out.println(tripleStep(4));
    System.out.println(tripleStep(5));
  }

  public static int tripleStep(int steps){
    return tripleStepHelper(steps, new HashMap<Integer, Integer>());
  }

  // The following is the memoization approach to the triple step problem
  // Since we would end up recalculating values we store them in a hashmap
  // that way if we need the same value it takes O(1) time to access it. 
  public static int tripleStepHelper(int steps, HashMap<Integer, Integer> memo){
    if(steps < 0)
      return 0;
    else if (steps == 0)
      return 1;
    else if (memo.get(steps) == null){
      memo.put(steps, (tripleStepHelper(steps - 1, memo) + tripleStepHelper(steps - 2, memo) + tripleStepHelper(steps - 3, memo)));
    }
    return memo.get(steps);
  }
}
