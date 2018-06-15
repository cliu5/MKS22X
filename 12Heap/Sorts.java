import java.util.*;
public class Sorts{
    
  public static void heapsort(Integer[] array){
	MyHeap<Integer> heap = heapify(array);
	int deleteIndex = array.length - 1;
	while(heap.size() > 0){
	    array[deleteIndex] = heap.remove();
	    deleteIndex--;
	}
    }
    
    public static MyHeap<Integer> heapify(Integer[] array){
	MyHeap<Integer> heap = new MyHeap<>();
	for(int i = 0; i < array.length; i++){
	    heap.add(array[i]);
	}
	return heap;
    }

   public void swap(Integer[]ary, int first, int second){
	Integer temp = ary[first];
	ary[first]=ary[second];
	ary[second]=temp;
}
   
}
