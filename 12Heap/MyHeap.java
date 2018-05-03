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
  
  public void add(String s){
  }
  public String remove(){
  }
  public String peek(){
  }
  
  
public int size(){
return size;
}
  

}
