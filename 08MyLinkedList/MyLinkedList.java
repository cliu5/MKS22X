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
    Integer ans=0;
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
         Integer ans= getNode(index).getValue();
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
    private Integer data;
 public Node(Integer value){
      data = value;
    }

	public Node(Integer a, Node b, Node c){
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
	
     /*
    public static void main(String[]args){
      MyLinkedList nums = new MyLinkedList();
      LinkedList<Integer> nums2 = new LinkedList<>();
      
      for(int i = 0; i < 2000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds");
      
      int max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        if(nums.remove(i)!=nums2.remove(i).intValue()){
          System.out.println("FAIL while removing index: "+i);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL consecutive removes");
          return;
        }
      }
      System.out.println("PASS consecutive removes");
      
      
      for(int i = 0; i < 1000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds phase 2");
      
      
      max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        int index = (int)(Math.random()*nums.size());
        if(nums.remove(index)!=nums2.remove(index).intValue()){
          System.out.println("FAIL while removing index: "+index);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL randomized removes");
          return;
        }
      }
      System.out.println("PASS randomized removes");
      
      //get-------------------
      try{
        nums.get(-3);
        System.out.println("FAIL get access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds negateive index ");
      }
      
      try{
        nums.get(nums.size());
        System.out.println("FAIL get access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds index too large");
      }
      
      
      //set-------------------
      try{
        nums.set(-3,5);
        System.out.println("FAIL set access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds negateive index ");
        
      }
      
      try{
        nums.set(nums.size(),5);
        System.out.println("FAIL set access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds index too large");
      }
      
      
      
      //add-------------------
      try{
        nums.add(nums.size()+1,5);
        System.out.println("FAIL add access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds index too large");
      }
      
      try{
        nums.add(-1,5);
        System.out.println("FAIL add access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds negative index");
      }
      
      
      
      //remove-------------------
      try{
        nums.remove(nums.size()+1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      try{
        nums.remove(-1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      
      //
      nums.clear();
      if(nums.size()==0){
        System.out.println("PASS clear");
      }else{
        System.out.println("FAIL clear");
        return;
      }
      
      
      
      //REMOVE BY VALUE (not index)
      nums.clear();
      for(int i = 0; i < 10; i++){
        nums.add(0,Integer.valueOf(i));
      }
      if(nums.remove(Integer.valueOf(0)) && nums.remove(Integer.valueOf(1)) &&
      nums.remove(Integer.valueOf(5)) && nums.remove(Integer.valueOf(3)) &&
      nums.remove(Integer.valueOf(8))&& nums.remove(Integer.valueOf(9)))  {
        try{
          int[]result = { 7, 6, 4, 2};
          for(int i = 0; i < nums.size();i++ ){
            if(result[i]!=nums.get(i).intValue()){
              System.out.println("FAIL to remove by value. Final State bad");
              return;
            }
          }
        }catch(Exception e){
          System.out.println("FAIL to remove by value. Exception thrown");
          return;
        }
      }else{
        System.out.println("FAIL to remove by value.");
        return;
      }
      System.out.println("PASS remove by values (Integer, not int).");
      
      nums.clear();
      long end,start = System.currentTimeMillis();
      
      System.out.println("#Adding to 100000 values to the front, and 100000 to the end, should be fast.\n#If the next line doesn't print right away you have some issues.");
      for(int i = 0; i < 100000; i++  ){
        nums.add(i);
        nums.add(nums.size(),i);
      }
      end = System.currentTimeMillis();
      //mine was 8msec on a laptop, so 250 should be fine!
      if(end - start > 250){
        System.out.println("FAIL! Should be much faster than "+(end-start)+"msec");
        return;
      }else{
        System.out.println("PASS "+ (end-start)+" msec current size: "+nums.size());
      
    }
    
    
    
  }
*/
}
