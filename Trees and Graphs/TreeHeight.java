/**
 * Created by Momo on 9/11/17
 */
import java.util.*;

public class TreeHeight {
  public static void main(String[] args){
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);
    Node g = new Node(7);
    Node h = new Node(8);
    Node i = new Node(9);
    h.addChild(i);
    f.addChild(g);
    f.addChild(h);
    e.addChild(f);
    b.addChild(c);
    b.addChild(d);
    a.addChild(b);
    a.addChild(e);
    a.printTree();
    Tree myTree = new Tree(a);
    System.out.println(myTree.getHeight());
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

    public int getHeight(){
      return getHeightHelper(root);
    }

    /**
     * The following method uses recursion to get the height from any node
     * @param  Node current
     * @return      the height of this subtree
     */
    public int getHeightHelper(Node current){
      // If the current node has no children return 1
      if(current.children.size() == 0)
        return 1;
      // We set the size of our array based off the size of the children
      // Since this is for a "tree" and not necessarily a binary search tree
      // We cannot assume the value is 2
      int[] temp = new int[current.children.size()];
      // We will go to each child and recursively call the getHeightHelper method
      // and assign it to each index in our temp array
      for(int i = 0; i < current.children.size(); i++){
        temp[i] = 1 + getHeightHelper(current.children.get(i));
      }
      // Now we will find the maximum value within the array and then return it
      // This max value is the height of the subtree
      int max = temp[0];
      for(int i = 1; i < temp.length; i++){
        if(temp[i] > max)
          max = temp[i];
      }
      return max;
    }
  }
  private static class Node{
    int data;
    ArrayList<Node> children;

    public Node(int data){
      this.data = data;
      children = new ArrayList<>();
    }

    public void addChild(Node childNode){
      children.add(childNode);
    }

    public void printTree(){
      System.out.println(data);
      for(Node child: children){
        child.printTree();
      }
    }
  }
}
