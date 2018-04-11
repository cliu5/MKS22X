public class MyLinkedList{
	
	//thanks to crystals driver for endless agony + pain//
	// also to the senpais for bein pals and explaining stuff & helping me solve stuff//
    
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
	 if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException();
    }
	 //return what ur removing set as ans//
         int ans= getNode(index).getValue();
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
	
   public static void main(String[] args){
     MyLinkedList a = new MyLinkedList();

     System.out.println("Testing add(Integer value)");
     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
       System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
     } //adds the integers from 0 to 9 inclusive and prints out the LinkedList

     System.out.println("\nTesting get(int index)");
     for (int i = 0; i < 10; i++){
       System.out.println("index: " + i + " data: " + a.get(i));
     } //prints the integers from 0 to 9 inclusive

     System.out.println("\nTesting exception for get(int index)");
     try{
       System.out.println(a.get(10));
       System.out.println(a.size());
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.get(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
     }

     System.out.println("\nTesting indexOf(Integer value)");
     for (int i = 0; i < 10; i++){
       System.out.println("Value: " + i + " Index: " + a.indexOf(i));
     } //prints 0 to 9 inclusive

     System.out.println("\nTesting remove(Integer value)");
     for(int i = 0; i < 10; i++){
       a.remove(new Integer(i));
       System.out.println(a);
     } //removes first half of the LinkedList

     System.out.println("\nTesting set(int index, Integer value)");
     for (int i = 0; i < 10; i++){
       a.set(i, new Integer(i * 10));
       System.out.println(a);
     } //sets the data of each node to 10 * index

     System.out.println("\nTesting exceptions for set(int index, Integer value)");
     try{
       System.out.println(a.set(-1, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.set(10, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesing add(int index, Integer value)");
     for (int i = 0; i < 9; i++){
       a.add(i, new Integer(i * 3));
       System.out.println("index added: " + i + " LinkedList: " + a.toString());
     } //adds multiples of 3 up to 24 to the LinkedList at the beginning
     a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
     System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for add(int index, Integer value)");
     try{
       a.add(-1, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       a.add(21, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting remove(int index)");
     System.out.println("Original LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
     System.out.println("LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for remove(int index)");
     try{
       System.out.println(a.remove(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.remove(17));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting clear()");
     a.clear();
     System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
   }
}
