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
	  Integer ans=curr.getValue();
	  getNode(index).setValue(newValue);
	  return ans;
  }
 public int indexOf(Integer value){
	 
	 Node curr = first;
	for(int i = 0; i<size; i++){
	    if(getNode(i).getValue().equals(value)){
		return i;
	    }
	    curr = curr.getNext();
	}
	return -1;
	 
 }
	
	
	

	
	
	
	public boolean add(Integer newData){
		Node curr=new Node(newData);
		if(size()==0){
			
			first=curr;
			
		}
		else{
			
			last.setNext(curr);
			curr.setPrev(last);
		}
			last=curr;
		
	size+=1;
		return true;

	}
	
	//exceptions!//
 public void add(int index, Integer value){
	 if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
	 Node curr=new Node(value);
	 //if add to the front//
	if (index==0){
		//and its empty//
	    if (size==0){
		start=curr;
		last=curr;
	    }
		//otherwise repoint//
		else{
		start.setPrev()=curr;
		curr.setNext()=start;
		start=curr;
	    }
	}
	 //now if you're adding to the back//
	 else if(index==size){
	    last.setNext()=curr;
	    curr.setPrev()=last;
	    last=curr;
	}
	 // now genrally//
	 else{
	    curr.setPrev()=getNode(index-1);
	    curr.setNext()=getNode(index);
	    getNode(index).setPrev()=curr;
	    getNode(index-1).setNext()=curr;
	}
	size++;
    }
 
	
	
	public boolean remove(Integer value){
	
	Node curr = first;
	for(int i = 0; i< size; i++){
	    if(curr.getValue().equals(value)){
		remove(i);
		return true;
	    }
	    curr = curr.getNext();
	}
	return false;
    }
	

	//returns value of what u removed//
 public Integer remove(int index){
	 
 }
 
	
	

 private class Node {

    private Node next,prev;
    private int data;
 public Node(Integer value){
      data = value;
    }

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
    public Integer getValue() {
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
