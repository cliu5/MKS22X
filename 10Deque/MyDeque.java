import java.util.NoSuchElementException;
public class MyDeque<Type>{
private int start,end,size;
private Type[]ary;

  @SuppressWarnings("unchecked")
    public MyDeque(){
	ary = (Type[])new Object[10];
	start = -1;
	end = 0;
	size = 10;
    }
    
@SuppressWarnings("unchecked")
MyDeque(int initialCapacity){
	ary = (Type[])new Object[initialCapacity];
	start = -1;
	end = 0;
	size = initialCapacity;    
}
public int size(){
  return size;
}
	//Helpers
public boolean isFull()
    {
        return ((start == 0 && end == size-1)||
            start == end+1);
    }
//These will add the element to the specified side. The deque will double capacity if there is no space left.
	/*
public void addFirst(Type element){
	if(element==null){
		throw new NullPointerException();
	}

        if (isFull())
        {
            resize();
	    }
 
        if (start == -1)
        {
            start = 0;
            end = 0;
        }
         
        // front is at first position of queue
        else if (start == 0)
            start = size - 1 ;
  
        else // decrement front end by '1'
            start = start-1;
  
        // insert current element into Deque
        ary[start] = element ;
    }
	
	
	
}
*/
public void addLast(Type element){
}
//These will retrieve and remove the element from the specified side.
public Type removeFirst(){
}
public Type removeLast(){
}
//These will retrieve but not remove the element from the specified side.
	public boolean isEmpty(){
		return (start == -1);
	}
public Type getFirst(){
	if(isEmpty() || end < 0)
        {
            throw new NoSuchElementException();
        }
        return ary[start];
}
public Type getLast(){
	if(isEmpty() || end < 0)
        {
            throw new NoSuchElementException();
        }
        return ary[end];
}
}
