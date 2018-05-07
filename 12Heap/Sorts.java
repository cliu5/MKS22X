import java.util.*;
public class Sorts{
    
    public static void heapsort(Integer[] ary){
	MyHeap<int> heap = heapify(ary);
	for ( int i = ary.length-1 ; i>0;i--){
    ary[i]=heap.remove();
    }
    }
    
    public static MyHeap<Integer> heapify(Integer[] ary){
	MyHeap<int> heap = new MyHeap<>();
	for(int i = 0; i < ary.length; i++){
	    heap.add(ary[i]);
	}
	return heap;
    }

 

  
}
