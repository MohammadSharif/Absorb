/**
 * Created by Momo on 9/18/17
 */

import java.util.*;

public class MinimalTree {
  public static void main(String[] args){
    int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8};
    Node a = minimalTree(myArray);
    Tree myTree = new Tree(a);
    System.out.println(myTree.getHeight());
  }

  public static Node minimalTree(int[] array){
    return minTreeHelper(0, array.length, array);
  }
  // This is the main portion of creating a min tree using an array
  // We do this with recursion, by using the same array with specified indices
  // To break the array down into two partitions. We do this until the array
  // is fully broken down using recursion, then we hit the base case where
  // the left index is greater than or equal to the right index. In that case
  // we return null as the value for the child. 
  public static Node minTreeHelper(int left, int right, int[] array){
    if(left >= right)
      return null;
    int nodeIndex = (left + right )/2;
    Node temp = new Node(array[nodeIndex]);
    temp.addLeftChild(minTreeHelper(left, nodeIndex, array));
    temp.addRightChild(minTreeHelper(nodeIndex+1, right, array));
    return temp;

  }

  /**
   * The following represents a Node class we will use to represent the tree.
   * I will make it so that the first value in the constructor is the data for
   * the node, and the array will be the children (for simplicity of creating a
   * tree)
   */
  private static class Tree{
    Node root;
    public Tree(Node root){
      this.root = root;
    }

    // For testing purposes we'll use the getHeight method from the TreeHeight.java
    // file, this way we can see if the height is minimal.
    public int getHeight(){
      return getHeightHelper(root);
    }

    public int getHeightHelper(Node current){
      if(current == null)
        return 0;
      int leftHeight = getHeightHelper(current.leftChild);
      int rightHeight = getHeightHelper(current.rightChild);
      int max = Math.max(leftHeight, rightHeight);
      return max + 1;
    }

    public void printTree(){
      printTreeHelper(this.root);
    }

    public void printTreeHelper(Node current){
      if(current == null)
        return;
      printTreeHelper(current.leftChild);
      System.out.println(current.data);
      printTreeHelper(current.rightChild);

    }
  }

  private static class Node{
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data){
      this.data = data;
      leftChild = null;
      rightChild = null;
    }

    public void addLeftChild(Node childNode){
      leftChild = childNode;
    }

    public void addRightChild(Node childNode){
      rightChild = childNode;
    }
  }
}
