import java.util.*;
public class Sorts{
    
public static void heapsort(Integer[] ary){

	
	MyHeap<Integer> heap = new MyHeap<>();
		heap.heapify(ary);
	for ( int i = 0;i<ary.length;i++){
    Integer x = heap.remove();
	    ary[heap.size()] = x;

    }
    }
    
    
 
}
