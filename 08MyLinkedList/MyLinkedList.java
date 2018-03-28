public class MyLinkedList{

  private class Node {

    private Node next,prev;
    private int data;

    public Node (int value) {
      data = value;
      next = null;
      prev = null;
      
    }

    public Node getNext() {
      return next;
    }
    public Node getPrev() {
      return prev;
    }
    public int getCurrent() {
      return data;
    }

    public String toString() {
      return data + "";
    }

    public void setNext(Node _next) {
      next = _next;
    }
    public void setPrev(Node _prev) {
      prev = _prev;
    }
    public void setValue(int _new) {
     
    
  }

  private Node first,last;
  private int size;

  public MyLinkedList() {
    size = 0;
    first =null;
    last=null;
  }

  public String toString() {
   
  }

  public int size() {
    return size;
  }

  public int get(int index) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    
    
  }

  public void set(int index, int newValue) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    

}


}
