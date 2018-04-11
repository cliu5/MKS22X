import java.util.Iterator;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
	
	
	public Iterator<T> iterator(){
	return new MyLLIterator();
    }

    private class MyLLIterator implements Iterator<T>{

	Node curr;
	
	public MyLLIterator(){
	    curr = first;
	}
	
	public boolean hasNext(){
	    return curr != null;
		
	}
    

	public T next(){
	    if(hasNext()){
		T ans = curr.getValue();
		curr = curr.getNext();
		return ans;
	    }
	    return null;
	}
	
    }
	
	
	
 
	
	
	
	
	
	
	//thanks to crystals driver for endless agony + pain//
	// also to the senpais for bein pals and explaining stuff & helping me solve stuff//
	
   
    
  private Node first,last;
  private int size;
	
	public MyLinkedListImproved(){
		first = null;
	last = null;
	size = 0;
    }

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

	
	
	
  public T get(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    
    Node curr=first;
	  T ans = curr.getValue();
	  // for linked lists to find something you have to loop thru everything //
	  for(int i=0;i<index+1;i++){
		  
		 ans=curr.getValue();
		  curr=curr.getNext();
	  }
	  return ans;
  }

	
  public T set(int index, T newValue) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node curr=first;
	  //traversing to get to the index'd val//
	  for(int i=0;i<index;i++){
		  curr=curr.next;
	  }
	  T ans=curr.getValue();
	  getNode(index).setValue(newValue);
	  return ans;
  }
 public int indexOf(T value){
	 
	 Node curr = first;
	for(int i = 0; i<size; i++){
	    if(getNode(i).getValue().equals(value)){
		return i;
	    }
	    curr = curr.getNext();
	}
	return -1;
	 
 }
	
	
	

	
	
	
	public boolean add(T newData){
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
 public void add(int index, T value){
	 /*
	 if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    */
	 Node curr=new Node(value);
	 //if add to the front//
	if (index==0){
		//and its empty//
	    if (size==0){
		first=curr;
		last=curr;
	    }
		//otherwise repoint//
		else{
		first.setPrev(curr);
		curr.setNext(first);
		first=curr;
	    }
	}
	 //now if you're adding to the back//
	 else if(index==size){
	    last.setNext(curr);
	    curr.setPrev(last);
	    last=curr;
	}
	 // now genrally//
	 else{
	    curr.setPrev(getNode(index-1));
	    curr.setNext(getNode(index));
	    getNode(index).setPrev(curr);
	    getNode(index-1).setNext(curr);
	}
	size++;
    }
 
	
	
	public boolean remove(T value){
	
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
 public T remove(int index){
	 if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
	 //return what ur removing set as ans//
         T ans= getNode(index).getValue();
	 //if u remove from beginning
	 if (index==0){
		 Node curr=first.getNext();
		 first=curr;
	 }
	 // now if it's removing from the end u just change last to the one right before and the next to null
	 else if (index==size-1){
		 last=last.getPrev();
		 last.setNext(null);
	 }
	 //if it is any place in the middle, change the arrows to go over an area
	 else{
		 Node curr=getNode(index);
		 curr.getPrev().setNext(curr.getNext());
		 curr.getNext().setPrev(curr.getPrev());
	 }
	 size--;
	 return ans;
 }
 

 private class Node {

    private Node next,prev;
    private T data;
 public Node(T value){
      data = value;
    }

	public Node(T a, Node b, Node c){
	    this.next = b;
	    this.prev = c;
	    this.data = a;
	}
    public Node getNext() {
	    
      return this.next;
    }
    public Node getPrev() {
      return this.prev;
    }
    public T getValue() {
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
    public boolean setValue(T _new) {
	    data=_new;
	    return true;
     
    
  }
	 
    	
	
}
	
	 public int max(){ //return the index of the largest value or -1 if empty
	int ans = 0;
		 //if empty return -1
	if(size == 0){
	    return -1;
	}
	if(size() == 1){
	    return 0;
	}
	else{
	    for(T x : this){
		if(x.compareTo(get(ans)) > 0){
		    ans = indexOf(x);
		}
	    }
	}
	return ans;
    }

    public int min(){ //return the index of the smallest value or -1 if empty
	int ans = 0;
	if(size() == 0){
	    return -1;
	}
	if(size() == 1){
	    return 0;
	}
	else{
	    for(T x : this){
		if(x.compareTo(get(ans)) < 0){
		    ans = indexOf(x);
		}
	    }
	}
	return ans;
    }
}
