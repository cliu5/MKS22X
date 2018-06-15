import java.util.*;
public class Sorts{
    
  public static void heapsort(Integer[] array){
	MyHeap<Integer> heap = heapify(array);
	int deleteIndex = size(array) - 1;
	while(heap.size() > 0){
	    array[deleteIndex] = heap.remove();
	    deleteIndex--;
	}
    }
    
    public static MyHeap<Integer> heapify(Integer[] array){
	MyHeap<Integer> heap = new MyHeap<>();
	for(int i = 0; i < size(array); i++){
	    heap.add(array[i]);
	}
	return heap;
    }

   public void swap(Integer[]ary, int first, int second){
	Integer temp = ary[first];
	ary[first]=ary[second];
	ary[second]=temp;
}
    
    public static int size(Integer[] array){
		int ans = 0;
	for(int i = 0; i < array.length; i++){
	    if(array[i] != null){
		size++;
	    }
	}
	return ans;

    }

}
