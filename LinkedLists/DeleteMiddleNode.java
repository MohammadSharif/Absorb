public class DeleteMiddleNode {
  public static void main(String[] args){
    LinkedList myList = new LinkedList();
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);
    myList.addToEnd(a);
    myList.addToEnd(b);
    myList.addToEnd(c);
    myList.addToEnd(d);
    myList.addToEnd(e);
    myList.addToEnd(f);
    myList.printlist();
    myList.deleteFromMiddle(d);
    myList.printlist();
    myList.deleteFromMiddle(b);
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
     * Given only access to the node that needs to be deleted we simply set
     * its data to the data of the next node, and we set the next node to be
     * the next next node.
     * @param Node toDelete [description]
     */
    public void deleteFromMiddle(Node toDelete){
      toDelete.data = toDelete.next.data;
      toDelete.next = toDelete.next.next;
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
