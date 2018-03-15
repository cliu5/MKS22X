public class Quick{

 
 
 
  public static int quickselect(int[] ary, int k){
	return quickHelper(ary, k, 0, ary.length - 1);
    }

    public static int quickHelper(int[] ary, int k, int start, int end){
        int pi = partition (ary, start ,end);
     //base case//
      	if (pi == k) {
        return ary[pi];
       }
     //if its more than k lower the end val//
	if (pivot > k) {
  return quickHelper(ary, k, start, pivot);
 }
     //if its too small, move up the start value//
	if (pivot < k) {
  return quickHelper(ary, k, pivot + 1, end);
 }
	return ary[k];
    }
 
 
 
  
    public static void quicksort(int[] ary){
	quickSortHelper(ary, 0, ary.length -1);
    }

    public static void quickSortHelper(int[] ary, int start, int end){
	if(end-start+1>1){
	    int p = partition(ary, start, end);
	    quickSortHelper(ary, start, p);
	    quickSortHelper(ary, p+1, end);
	}
    }

public static void swap(int[] ary, int i, int j){
	int temp=ary[i];
	ary[i] = ary[j];
	ary[j] = temp;
    }
 
 
 //pseudocode from class//
 public static int partition ( int [] data, int start, int end){
  int pi = (int) (Math.random()*(end-start+1)+start);
    int val = data[pi];
    int i = start + 1;
    int j = end;
    swap(data,pi,start);
    while (i <= j){
      if (data[i] <= val){
        i++;
      }
      else {
        swap(data,i,j);
        j--;
      }
    }
    swap(data,start,j);
    return j;
 }
 
 public static void main(String[] args){
    int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
    System.out.println(quickSelect( ary , 0 ));// would return 0
    System.out.println(quickSelect( ary , 1 ));//  would return 2
    System.out.println(quickSelect( ary , 2 ));//  would return 5
    System.out.println(quickSelect( ary , 3 ));//  would return 10
    System.out.println(quickSelect( ary , 4 ));//  would return 15
    System.out.println(quickSelect( ary , 5 ));//  would return 23
    quickSort(ary);
    System.out.println(java.util.Arrays.toString(ary));
  }
}
