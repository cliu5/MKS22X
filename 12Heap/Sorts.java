import java.util.*;
public class Sorts{
    
  public static void heapsort(Integer[] array){
	MyHeap<Integer> heap = heapify(array);
	int counter = size(array) - 1;
	while(heap.size() > 0){
	    array[counter] = heap.remove();
	    counter--;
	    //System.out.println(print(array));
	    //System.out.println("..." + heap);
	}
    }
    
    public static MyHeap<Integer> heapify(Integer[] array){
	MyHeap<Integer> heap = new MyHeap<>();
	for(int i = 0; i < size(array); i++){
	    heap.add(array[i]);
	}
	//System.out.println(heap);
	return heap;
    }

    public static void swap(int index1, int index2, Integer[] array){
	Integer storage = array[index1];
	array[index1] = array[index2];
	array[index2] = storage;
    }
    
    public static int size(Integer[] array){
	return array.size();
    }

}
