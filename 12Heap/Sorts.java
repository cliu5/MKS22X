import java.util.*;
public class Sorts{
    
  public static void heapsort(int[] array){
	MyHeap<Integer> heap = heapify(array);
	int deleteIndex = array.length - 1;
	while(heap.size() > 0){
	    array[deleteIndex] = heap.remove();
	    deleteIndex--;
	}
    }
    
    public static MyHeap<Integer> heapify(int[] array){
	MyHeap<Integer> heap = new MyHeap<>();
	for(int i = 0; i < array.length; i++){
	    heap.add(array[i]);
	}
	return heap;
    }

   public void swap(int[]ary, int first, int second){
	int temp = ary[first];
	ary[first]=ary[second];
	ary[second]=temp;
}
   
  public static void main(String[]args){
    int[] ary = {5,4,3,2,1};
    Sorts.heapsort(ary);
    System.out.println(Arrays.toString(ary));
  }
}
