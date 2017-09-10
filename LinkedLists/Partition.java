/**
 * Created by Momo on 9/9/17
 */
import java.util.*;

public class Partition {
  public static void main(String[] args) {
    LinkedList myList = new LinkedList();
    Node a = new Node(3);
    Node b = new Node(5);
    Node c = new Node(8);
    Node d = new Node(5);
    Node e = new Node(10);
    Node f = new Node(2);
    Node g = new Node(1);
    myList.addToEnd(a);
    myList.addToEnd(b);
    myList.addToEnd(c);
    myList.addToEnd(d);
    myList.addToEnd(e);
    myList.addToEnd(f);
    myList.addToEnd(g);
    myList.printlist();
    myList.partition(5);
    myList.printlist();
  }

  private static class LinkedList {
    Node head = null;
    public void printlist(){
      Node current = head;
      StringBuilder sb = new StringBuilder();
      while(current != null){
        sb.append(current.data);
        sb.append(" ");
        current = current.next;
      }
      System.out.println(sb.toString());
    }

    public boolean addToEnd(Node element){
      if(head == null){
        head = element;
      } else {
        Node current = head;
        while(current.next != null){
          current = current.next;
        }
        current.next = element;
      }
      return true;
    }

    /**
     * I've implemented a partitioning algorithm which runs in O(n) time by using
     * two assistive stacks. We begin at the head of the linked list and iterate
     * over the linked list. If the element is < x we iterate over it, if the
     * element is x we push it to the xStack, if it is > x we push it to ther
     * greaterStack. Once we reach the end of the list we simply pop off any nodes
     * in the x stack and add them to the end of the list. Then we pop off from the
     * greaterStack and add them to the end of the list, creating the required
     * partition.
     * @param int x [the value specified for partitioning against]
     */
    public void partition(int x){
      Stack<Node> greaterStack = new Stack<>();
      Stack<Node> xStack = new Stack<>();
      boolean isPartitioned = false;
      Node current = head;
      Node previous = null;
      while(!isPartitioned){
        if(current.data >= x){
          if(current.data > x){
            greaterStack.push(current);
          } else if (current.data == x){
            xStack.push(current);
          }
          if(current == head){
            head = current.next;
            current = head;
          } else {
            previous.next = current.next;
            current = current.next;
          }
        } else {
          if(current.next == null){
            while(xStack.size() > 0){
              current.next = xStack.pop();
              current = current.next;
              current.next.next = null;
            }
            while(greaterStack.size() > 0){
              current.next = greaterStack.pop();
              current = current.next;
              current.next = null;
            }
            isPartitioned = true;
          } else {
            previous = current;
            current = current.next;
          }
        }
      }
    }

  }

  private static class Node {
    Node next = null;
    int data;
    public Node(int data){
      this.data = data;
    }
  }
}
