import java.util.*;
public class Sorts{
    
    public static void heapsort(int[] ary){
	MyHeap heap = heapify(ary);
	for ( int i = ary.length-1 ; i>0;i--){
    ary[i]=heap.remove();
    }
    }
    
    public static MyHeap<int> heapify(int[] ary){
	MyHeap heap = new MyHeap<>();
	for(int i = 0; i < ary.length; i++){
	    heap.add(ary[i]);
	}
	return heap;
    }

 
 public static void main(String[] args){
    int[] reg = new int[25];
    int[] heap = new int[25];

    for(int i = 0; i < 25; i ++){
      int temp = (int)(Math.random() * 1000);
      reg[i] = temp;
      heap[i] = temp;
    }

    Arrays.sort(reg);
    Sorts.heapsort(heap);

    for(int i = 0; i < 25; i++){
      if(reg[i] != heap[i]){
        System.out.println("There is an error at index " + i);
        System.out.println("reg: " + Arrays.toString(reg));
        System.out.println("hea: " + Arrays.toString(heap));
}
  
}
 }
}
