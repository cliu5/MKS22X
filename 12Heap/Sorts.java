import java.util.*;
public class Sorts{
    
    public static void heapsort(Integer[] ary){
	MyHeap<Integer> heap = heapify(ary);
	for ( int i = ary.size()-1 ; i>0;i--){
    ary[i]=heap.remove();
    }
    }
    
    public static MyHeap<Integer> heapify(Integer[] ary){
	MyHeap<Integer> heap = new MyHeap<>();
	for(int i = 0; i < ary.size(); i++){
	    heap.add(ary[i]);
	}
	return heap;
    }

 

  
    
    public static void main(String[] args){
	Integer[] a = new Integer[10];

	
	for(int i = 0; i < 10; i++){
	    a[i] = new Integer ((int)(Math.random() * 10));
	}

	System.out.println(a);
	heapsort(a);
	System.out.println(a);
	
    }
    
}
