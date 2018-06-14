import java.util.*;

public class MyDeque<Type>{
private int start,end,size;
private Type[]data;

  
    public MyDeque(){
this(10);
    }
    
@SuppressWarnings("unchecked")
public MyDeque(int initialCapacity){
if(initialCapacity<0){
throw new IllegalArgumentException();
}
data = (Type[])new Object[initialCapacity];
  start=0;
  end=0;
  size=0;
}
public int size(){
  return size;
}
  
  
public void addFirst(Type element){
if(element==null){
throw new NullPointerException();
}
 
//if its too small//
 if(size == data.length){
resize();
}
      if (size != 0){
        start = (start-1+data.length) % data.length;
    }
    data[start] = element;
    size++;
  }

  

  
  
 public void addLast(Type element){
if(element==null){
throw new NullPointerException();
}
  if(size==data.length){
    resize();
  }
if(size!=0){
end=(end+1)%data.length;
data[end]=element;
size++;
}
} 
  
  
  public boolean isFull()
    {
        return ((start == 0 && end == size-1)||
            start == end+1);
}
  
  
  
  public Type removeLast(){
if(size<=0){
throw new NoSuchElementException();
}

        Type ans = data[end];
        data[end] = null;
if(size>1){
   end = (end-1+data.length)%data.length;
        }
size—;
return ans;
}

  
public Type removeFirst(){
if(size<=0){
throw new NoSuchElementException();
}
Type ans = data[start];
        data[start] = null;
       if(size>1){
            start = (start+1)%data.length;
       }
        size--;
        return ans;
}
  
  
  
  public Type getFirst(){
if(size<=0)
        {
            throw new NoSuchElementException();
        }
        return data[start];
}
public Type getLast(){
if(size<=0)
        {
            throw new NoSuchElementException();
        }
        return data[end];
}
  
  
  
  
  public boolean isEmpty(){
return (start == -1);
}

@SuppressWarnings("unchecked")
//copy into ans
public void resize(){
Type[] ans = (Type[])new Object[size * 2 +1];
for (int i = 0; i < data.length; i++){
   ans[i] = data[(start + i) % data.length];
}
start = 0;
end = size-1;
data = ans;
    }

}
