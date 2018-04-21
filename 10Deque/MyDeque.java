public class MyDeque<Type>{
private int start,end,size;
private Type[]ary;

  @SuppressWarnings("unchecked")
    public MyDeque(){
	ary = (Type[])new Object[10];
	start = 0;
	end = 0;
	size = 10;
    }
    
@SuppressWarnings("unchecked")
MyDeque(int initialCapacity){
	array = (Type[])new Object[initialCapacity];
	start = 0;
	end = 0;
	size = initialCapacity;    
}
public int size(){
  return size;
}
//These will add the element to the specified side. The deque will double capacity if there is no space left.
public void addFirst(E){
}
public void addLast(E){
}
//These will retrieve and remove the element from the specified side.
public E removeFirst(){
}
public E removeLast(){
}
//These will retrieve but not remove the element from the specified side.
public E getFirst(){
}
public E getLast(){
}
}
