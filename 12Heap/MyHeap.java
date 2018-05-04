import java.io.*;
import java.util.*

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

  
  public T[] ary;
    public boolean ifMax;
    public int size;
 
    @SuppressWarnings("unchecked")
    public MyHeap(){
	ary = (T[]) new Comparable[10];
	size = 0;
	ifMax = true;
    }
  
  //construct empty max heap//

    @SuppressWarnings("unchecked")
    public MyHeap(boolean b){
	ary = (T[]) new Comparable[10];
	size = 0;
	ifMax = b;
    }

 //true ; construct empty max heap, false: construct empty min heap.
  
  public void add(T s){
	  ary[ary.length-1]=s;
	  pushUp();
  }
  public String remove(){
	T temp = ary[0];
	 //swap first and last
	  //remove last//
	pushDown();
	return temp;
    }

	  
  }
  public String peek(){
	  return ary[0];
  }
  
  
public int size(){
return size;
}
  
//helpers
public void pushUp(){
}
public void pushDown(){
}
public void swap(T[], T first, T second){
}
	@SuppressWarnings("unchecked")
    public void resize(){
	    //just copying over stuff
        T[] temp=(T[])new Comparable[size()*2];
	for(int i=0; i<size(); i++){
	    temp[i] = ary[i];
	}
	ary=temp;
    }
}
