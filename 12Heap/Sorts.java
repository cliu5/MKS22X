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
	  public static String print(Integer[] array){
	String returnString = "[";
	for(int i = 0; i < array.length; i++){
	    returnString = returnString + array[i]  +", ";
	}
	returnString = returnString.substring(0, returnString.length() - 2);
	return returnString + "]";
    }
    
    public static void main(String[] args){
	Integer[] a = new Integer[10];

	
	for(int i = 0; i < 10; i++){
	    a[i] = new Integer ((int)(Math.random() * 10));
	}

	System.out.println("....." + print(a));
	heapsort(a);
	System.out.println("....." + print(a));
	
    }

}
