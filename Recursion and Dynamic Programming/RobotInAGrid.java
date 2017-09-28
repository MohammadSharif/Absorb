/**
 * Created by Momo on 9/27/17
 */

import java.util.*;

public class RobotInAGrid {
  public static void main(String[] args) {
    int[][] a = new int[5][10];
    a[0][1] = 1;
    a[1][0] = 1;
    int[][] b = new int[5][10];

    int[][] c = new int[10][10];

    int[][] d = new int[10][10];
    d[3][5] = 1;
    d[2][1] = 1;
    d[5][5] = 1;
    d[3][6] = 1;

    int[][] e = new int[8][8];
    e[1][2] = 1;
    e[3][0] = 1;
    e[3][2] = 1;
    e[4][2] = 1;
    e[2][4] = 1;
    e[1][6] = 1;
    e[3][5] = 1;
    e[5][3] = 1;
    e[5][4] = 1;
    e[5][6] = 1;
    e[6][1] = 1;
    e[6][5] = 1;

    System.out.println(numOfPaths(a));
    System.out.println(numOfPaths(b));
    System.out.println(numOfPaths(c));
    System.out.println(numOfPaths(d));
    System.out.println(numOfPaths(e));
  }

  public static int numOfPaths(int[][] grid) {
    int rows = grid.length;
    int columns = grid[0].length;
    return numPathsHelper(grid, new int[rows][columns], 0, 0);
  }

  // Recursion using memoization for efficiency
  public static int numPathsHelper(int[][] grid, int[][] temp, int row, int column){
    if(row == grid.length - 1 && column == grid[0].length - 1)
      return 1; // If it is the last element return 1
    if(row >= grid.length || column >= grid[0].length || grid[row][column] == 1)
      return 0; // If we are out of bounds or blocked return 0;
    if(temp[row][column] == 0) // If we haven't memoized this cell, memoize it
      temp[row][column] = numPathsHelper(grid, temp, row + 1, column) + numPathsHelper(grid, temp, row, column + 1);
    return temp[row][column]; // Return the memoized value
  }
}
