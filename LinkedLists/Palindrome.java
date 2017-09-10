/**
 * Created by Momo on 9/10/17
 */
import java.util.*;

public class Palindrome {
  public static void main(String[] args){
    LinkedList myList = new LinkedList();
    LinkedList secondList = new LinkedList();
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(3);
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
    System.out.println(myList.isPalindrome());
    secondList.addToEnd(new Node(1));
    secondList.addToEnd(new Node(2));
    secondList.addToEnd(new Node(3));
    secondList.addToEnd(new Node(5));
    secondList.addToEnd(new Node(6));
    secondList.addToEnd(new Node(3));
    secondList.addToEnd(new Node(1));
    secondList.printlist();
    System.out.println(secondList.isPalindrome());

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

    public boolean isPalindrome(){
      // Create a node that will represent our reversed list
      Node revHead = null;
      // Initialize a node to be the head
      Node current = head;
      // Iterate through each node in the list
      while(current != null){
        // If revHead hasn't been initialized yet, set it to the current node's data and
        if(revHead == null){
          revHead = new Node(current.data);
        } else {
          // otherwise create a temp Node to be the reversedHead
          // Set the reversed head to be the current node's data
          // set the next value of the reversed head to be temp
          Node temp = revHead;
          revHead = new Node(current.data);
          revHead.next = temp;
        }
        current = current.next;
      }
      // Start back at the beginning of the list
      current = head;
      // Iterate over the list
      while(current != null){
        // If any of the nodes are not the same, it means it is not a palindrome
        if(current.data != revHead.data){
          return false;
        }
        current = current.next;
        revHead = revHead.next;
      }
      // If the loop breaks out it means that we reached the end of the list without
      // any mismatches, hence we have a palindrome
      return true;
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
