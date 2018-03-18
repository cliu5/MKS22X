public class Quick{

 
 public static int  duthPartition(int[]ary, int start, int end){
	 int randomIndex= (int)(Math.random()*(end-start+1)+start);
	 int var=data[var];
	 int lt=start;
	 int gt=end;
	 int i=start;
	 while(i<=gt){
		 if(ary[i]==var){
			 i++;
		 }
		 else if(ary[i]>var){
			 swap(ary,i,gt);
			 gt--;
		 }
		 else{
			 swap(ary,lt,i);
			 lt++;
			 i++;
		 }
	 }
	 int[]ans={lt,gt};
	 return ans;
 }

	
	
	 
	 
	 
 
  public static int quickSelect(int[] ary, int k){
	return quickHelper(ary, k, 0, ary.length - 1);
    }

    public static int quickHelper(int[] ary, int k, int start, int end){
        int pi = partition (ary, start ,end);
     //base case//
      	if (pi == k) {
        return ary[pi];
       }
     //if its more than k lower the end val//
	if (pi > k) {
  return quickHelper(ary, k, start, pi);
 }
     //if its too small, move up the start value//
	if (pi < k) {
  return quickHelper(ary, k, pi + 1, end);
 }
	return ary[k];
    }
 
 
 
  
    public static void quickSort(int[] ary){
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
	/*
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
 */
 
}
