/**
 * Created by Momo on 9/13/17
 */
import java.util.*;

public class Preorder{
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
    g.addChild(h);
    g.addChild(i);
    d.addChild(e);
    d.addChild(f);
    b.addChild(d);
    c.addChild(g);
    a.addChild(b);
    a.addChild(c);
    Tree myTree = new Tree(a);
    myTree.printPreorder();
  }


  private static class Tree{
    Node root;
    public Tree(Node root){
      this.root = root;
    }

    public void printPreorder(){
      preorderHelper(this.root);
    }
    // This is the preorder traversal done using recursion
    public void preorderHelper(Node current){
      System.out.println(current.data);
      if(current.children != null){
        for(Node child: current.children){
          preorderHelper(child);
        }
      }
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
  }
}
