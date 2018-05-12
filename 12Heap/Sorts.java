import java.util.*;
public class Sorts{
	//USED BRITNI'S DRIVER//
    
public static void heapsort(Integer[] ary){

	
	MyHeap<Integer> heap = new MyHeap<>();
		heap.heapify(ary);
	for ( int i = 0;i<ary.length;i++){
    Integer x = heap.remove();
	    ary[heap.size()] = x;

    }
    }
    
    
  public static void main(String[] args){
	Integer[] A = new Integer[Integer.parseInt(args[0])];
	Integer[] B = new Integer[A.length];
	Random r = new Random();
	for(int i = 0; i < A.length; i++){
	    Integer n = Integer.valueOf(r.nextInt(10000));
	    B[i] = n;
	    A[i] = n;
	}
	System.out.println(Arrays.toString(A));
	heapsort(A);
	Arrays.sort(B);
	for(int i = 0; i < A.length; i++){
	    if(!A[i].equals(B[i])){
		System.out.println("ERROR");
	    }
	}
	System.out.println(Arrays.toString(A));
    }

}
