/**
 * Created by Momo on 9/5/17
 */
public class MaintainPointers{
  public static void main(String[] args){
    LinkedList myList = new LinkedList(5);
    System.out.println(myList.insertAfter(null, 4));
    System.out.println(myList.insertAfter(null, 3));
    System.out.println(myList.insertAfter(null, 2));
    System.out.println(myList.insertAfter(null, 1));
    System.out.println(myList.insertAfter(new Node(5), 4));
    System.out.println(myList.head.data);
    System.out.println(myList.tail.data);
    myList.printlist();
    System.out.println(myList.delete(new Node(5)));
    System.out.println(myList.delete(new Node(4)));
    System.out.println(myList.head.data);
    System.out.println(myList.tail.data);
    System.out.println(myList.delete(new Node(3)));
    myList.printlist();

  }

  /**
   * Represents a LinkedList Class with the methods to insert an element after
   * a specified elements, as well as delete the first occurence of a specific
   * element.
   *
   * This class also maintains a pointer to both the head of the list as well
   * as the tail of the list.
   */
  private static class LinkedList {
    Node head = null;
    Node tail = null;
    public LinkedList(int data){
      this.head = new Node(data);
    }

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
    
    public boolean insertAfter(Node element, int data){
      if(element == null){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        Node current = head;
        while(current.next != null){
          current = current.next;
        }
        tail = current;
        return true;
      } else {
        Node current = head;
        while(current.data != element.data && current != null){
          current = current.next;
        }
        if(current == null){
          return false;
        } else {
          Node temp = new Node(data);
          temp.next = current.next;
          current.next = temp;
          while(current.next != null){
            current = current.next;
          }
          tail = current;
          return true;
        }
      }
    }

    public boolean delete(Node element){
      Node current = head;
      while(current.next.data != element.data && current != null){
        current = current.next;
      }
      if(current.next.data == element.data){
        current.next = current.next.next;
        return true;
      } else {
        return false;
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
