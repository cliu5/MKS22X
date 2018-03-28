public class MyLinkedList{
    
  private Node first,last;
  private int length;

  public MyLinkedList() {
      length=0;
    first =null;
    last=null;
  }
 


  public String toString() {
      return "";
  }

  public int size() {
      return length  ;
  }

  public int get(int index) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    
    return 1;
  }

  public void set(int index, int newValue) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
  }
 
 public void add(int index,int value){
 }
 public void remove(int index){
 }
 
 









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
    public int getValue() {
      return data;
    }
     public String toString(){
	 return "[" + data + "]";
     }

    public void setNext(Node _next) {
      next = _next;
    }
    public void setPrev(Node _prev) {
      prev = _prev;
    }
    public void setValue(int _new) {
     
    
  }
}
}
