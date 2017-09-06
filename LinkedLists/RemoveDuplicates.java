/**
 * Created by Momo on 9/5/17
 */
import java.util.*;

public class RemoveDuplicates{
  public static void main(String[] args){
    LinkedList myList = new LinkedList();
    myList.addToEnd(1);
    myList.addToEnd(3);
    myList.addToEnd(5);
    myList.addToEnd(2);
    myList.addToEnd(4);
    myList.addToEnd(6);
    myList.addToEnd(5);
    myList.addToEnd(3);
    myList.printlist();
    myList.removeDuplicates();
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

    public boolean addToEnd(int data){
      if(head == null){
        head = new Node(data);
      } else {
        Node current = head;
        while(current.next != null){
          current = current.next;
        }
        current.next = new Node(data);
      }
      return true;
    }

    /**
     * This is the key method within this class, it removes all duplicates
     * in a linked list.
     *
     * By utilizing a HashMap we can do this with an O(n) runtime. Since it
     * will only take one pass over the list, and we add an item to the Map
     * if it is the first time we are seeing it, otherwise we remove the item.
     */
    public void removeDuplicates(){
      Node current = head;
      Node previous = null;
      Map<Integer, Integer> listMap = new HashMap<>();
      while(current != null){
        if(listMap.get(current.data) != null){
          previous.next = current.next;
          current = current.next;
        } else {
          listMap.put(current.data, 1);
          previous = current;
          current = current.next;
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
