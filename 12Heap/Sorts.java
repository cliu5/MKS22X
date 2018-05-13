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
    Integer[] reg = new Integer[25];
    Integer[] heap = new Integer[25];

    for(int i = 0; i < 25; i ++){
      int temp = (int)(Math.random() * 1000);
      reg[i] = temp;
      heap[i] = temp;
    }

    Arrays.sort(reg);
    Sorts.heapsort(heap);

    for(int i = 0; i < 25; i++){
      if(reg[i]!=(heap[i])){
        System.out.println("There is an error at index " + i);
        System.out.println("reg: " + Arrays.toString(reg));
        System.out.println("hea: " + Arrays.toString(heap));
      }
    }
  }

}
