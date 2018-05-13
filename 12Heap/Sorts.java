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
    
    
 public static void main(String[] args){
	Integer[] test = new Integer[5];
	test[0] = 4;
	test[1] = 7;
	test[2] = 10;
	test[3] = 5;
	test[4] = 3;
	heapsort(test);
	System.out.println(Arrays.toString(test));
    }

}
