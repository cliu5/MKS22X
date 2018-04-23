import java.util.NoSuchElementException;
public class MyDeque<Type>{
private int start,end,size;
private Type[]ary;

  @SuppressWarnings("unchecked")
    public MyDeque(){
	ary = (Type[])new Object[10];
	
    }
    
@SuppressWarnings("unchecked")
public MyDeque(int initialCapacity){
		if(initialCapacity<0){
throw new IllegalArgumentException();
}
	ary = (Type[])new Object[initialCapacity];
	
}
	
	
public int size(){
  return size;
}
	
public void addFirst(Type element){
	if(element==null){
	throw new NullPointerException();
	}
	//if its too small//
else if(size == ary.length){
resize();
}
	//if its not full//
	else if(size==0){
	ary[start] = element;
	}
	//if start is at the very beginning, add to the end//
	else if (start == 0){
		ary[ary.length-1]=element; 
	start=ary.length-1;
	}
	//if its just in the middle, the one before it is element//
	    else{
      ary[start - 1] =element;
      start--;
    }
    size++;	
}
	
	
	
public void addLast(Type element){
	if(element==null){
	throw new NullPointerException();
	}
	
	//if its too small//
else if(size == ary.length){
resize();
}
	//if its not full//
	else if(size==0){
	ary[end] = element;
	}
else if (end == ary.length-1){
		ary[start]=element; 
	end=start;
	}
	
else{
	ary[end+1]=element;
	end++;
}
	size++;
}
	
	

	//Helpers
public boolean isFull()
    {
        return ((start == 0 && end == size-1)||
            start == end+1);
}

	
	
	
	
//These will retrieve and remove the element from the specified side.
public Type removeLast(){
	 if(isEmpty()||end<0){
		throw new NoSuchElementException();
	}

        Type ans = ary[end];
        ary[end] = null;
        if (end == 0) {
            end = ary.length - 1;
        }

        else {
            end--;
        }

        size--;
        return ans;
    }
	
	
	
	
	

public Type removeFirst(){
	if(isEmpty()||end<0){
		throw new NoSuchElementException();
	}
	 Type ans = ary[start];
        ary[start] = null;
        if (start == ary.length - 1) {
            start = 0;
        }
        else {
            start++;
        }

        size--;
        return ans;
		
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
