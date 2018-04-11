public class MyLinkedList{
    
  private Node first,last;
  private int size;

private Node getNode(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	Node curr=first;
	for(int i=0;i<index;i++){
		curr=curr.getNext();
	}
	return curr;
}
	
	

	
  public MyLinkedList() {
      size=0;
    first =null;
    last=null;
  }
 


  public String toString() {
       String ans="[";
	  Node curr=first;
	  while(curr!=null){
		  ans+=(curr.getValue()+",");
		  curr=curr.next;
	  }
	  ans+="]";
	  return ans;
  }
  public String toStringReverse(){
	  String ans="[";
	  Node curr=first;
	  while(curr!=null){
		  ans+=(curr.getValue()+",");
		  curr=curr.getPrev();
	  }
	  ans+="]";
	  return ans;
  }

	public void clear(){
		first=null;
		last=null;
		size=0;
	}
	
  public int size() {
      return size;
  }

	
	
	
  public Integer get(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    int ans=0;
    Node curr=first;
	  // for linked lists to find something you have to loop thru everything //
	  for(int i=0;i<index+1;i++){
		  ans=curr.getValue();
		  curr=curr.getNext();
	  }
	  return ans;
  }

	
  public Integer set(int index, Integer newValue) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node curr=first;
	  //traversing to get to the index'd val//
	  for(int i=0;i<index;i++){
		  curr=curr.next;
	  }
	  int ans=curr.getValue();
	  curr.getValue().setValue(newValue);
	  return ans;
  }
 
	public boolean add(Integer newData);{
	}
	
	//exceptions!//
 public void add(int index, Integer value){
 }
	
	
	public boolean remove(Integer value){
	}
	//returns value of what u removed//
 public Integer remove(int index){
 }
 
	
	

 private class Node {

    private Node next,prev;
    private int data;

	public Node(Integer data, Node prev, Node next){
	    this.next = next;
	    this.prev = prev;
	    this.data = data;
	}
    public Node getNext() {
	    
      return this.next;
    }
    public Node getPrev() {
      return this.prev;
    }
    public int getValue() {
      return this.data;
    }
     public String toString(){
	 return "[" + data + "]";
     }

    public boolean setNext(Node _next) {
      next = _next;
	    return true;
    }
    public boolean setPrev(Node _prev) {
      prev = _prev;
	    return true;
    }
    public boolean setValue(int _new) {
	    data=_new;
	    return true;
     
    
  }
}
}
