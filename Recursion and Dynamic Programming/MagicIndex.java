/**
 * Created by Momo on 9/27/17
 */

import java.util.*;

public class MagicIndex {
  public static void main(String[] args){
    int[] a = {1, 2, 3, 4, 5};
    int[] b = {0, 1, 3, 4, 5, 8, 9, 10, 11, 15, 17, 19};
    int[] c = {-2, -1, 1, 2, 3, 5, 8, 9, 10, 12, 13};
    int[] d = {-5, -4, -3, -2, -1};
    int[] e = {-5, -4, -3, -2, 4};

    System.out.println(magicIndex(a));
    System.out.println(magicIndex(b));
    System.out.println(magicIndex(c));
    System.out.println(magicIndex(d));
    System.out.println(magicIndex(e));

  }

  public static int magicIndex(int[] array){
    return magicIndexHelper(array, 0, array.length);
  }

  // Using an approach similar to binary search we can find the magic index
  public static int magicIndexHelper(int[] array, int start, int end){
    if(start >= end)
      return -1;
    int middle =  (start + end) / 2;
    if(middle == array[middle])
      return middle;
    if(middle < array[middle])
      return magicIndexHelper(array, start, middle - 1);
    else
      return magicIndexHelper(array, middle + 1, end);
  }
}
