/**
 * Created by Momo on 9/13/17
 */
import java.util.*;

public class PreorderNoRecursion{
  public static void main(String[] args){
    // I've essentially reused a lot of the code from Preorder.java, this is
    // because I will check against Preorder.java to make sure the nonrecursive
    // preorder traversal prints in the proper order.
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

    /**
     * The Following method does a preorder traversal of the Tree without the use
     * of recursion.
     */
    public void printPreorder(){
      // We use a stack as a way to keep track of the parent to the current node
      Stack<Node> myStack = new Stack<>();
      boolean isDone = false;
      Node current = root;
      while(!isDone){
        // If the current node has not been visited we print it
        if(!current.visited){
          System.out.println(current.data);
          current.visited = true;
        }
        // If the current node does not have children we return to the parent
        if(current.children.size() == 0){
          current = myStack.pop();
        }
        // Check all of the current node's children, if one is not visited
        // Visit it and print the value
        for(int i = 0; i < current.children.size(); i++){
          Node child = current.children.get(i);
          if(!child.visited){
            myStack.push(current);
            current = child;
            break;
          } else if(i == current.children.size() - 1){
          // If we reach the last child and it has been visited we check if the
          // stack is empty. If it is empty it means we have traversed the entire
          // tree. Otherwise we set the current node to the parent in the stack.
            if(myStack.isEmpty()){
              isDone = true;
            } else {
              current = myStack.pop();
            }
          }
        }
      }
    }

  }
  private static class Node{
    int data;
    ArrayList<Node> children;
    boolean visited = false;
    public Node(int data){
      this.data = data;
      children = new ArrayList<>();
    }

    public void addChild(Node childNode){
      children.add(childNode);
    }
  }
}
