public class KthToLast{
  public static void main(String[] args){
    LinkedList myList = new LinkedList();
    myList.addToEnd(1);
    myList.addToEnd(2);
    myList.addToEnd(3);
    myList.addToEnd(4);
    myList.addToEnd(5);
    myList.addToEnd(6);
    myList.addToEnd(7);
    myList.addToEnd(8);
    myList.addToEnd(9);
    myList.addToEnd(10);
    System.out.println(myList.getKthToLast(2).data);
    System.out.println(myList.getKthToLast(5).data);
    System.out.println(myList.getKthToLast(10).data);
    System.out.println(myList.getKthToLast(11));
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
     * Gets the Kth to last element in a linked list
     * Runs in O(n) time using the runner method, in which a pointer runs
     * until the kth element and then another pointer is set to point at the
     * head of the list. From there we increment both until the initial pointer
     * reaches the end of the list. This will leave the second pointer at the
     * kth to last element of the list.
     * @param  int k             
     * @return     Kth to Last Element or Null
     */
    public Node getKthToLast(int k){
      if(k <= 0){
        return null;
      }
      Node initial = head;
      Node kth = null;
      int count = 0;
      while(initial != null){
        initial = initial.next;
        count++;
        if(count == k){
          kth = head;
        } else if(count > k){
          kth = kth.next;
        }
      }
      return kth;
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
