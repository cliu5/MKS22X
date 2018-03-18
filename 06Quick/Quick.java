public class Quick{

 
 public static int[]  partition(int[]ary, int start, int end){
	 int randomIndex= (int)(Math.random()*(end-start+1)+start);
	 int var=ary[randomIndex];
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

	
	
	 
	 
	 
 
  public static int quickselect(int[] ary, int k){
	return quickHelper(ary, k, 0, ary.length - 1);
    }

    public static int quickHelper(int[] ary, int k, int start, int end){
        int[]pivot = partition(ary, start ,end);
     if(pivot[0]<=k-1&&pivot[1]>=k-1){
	     return ary[pivot[0]];
     }
     if(pivot[0]>k-1){
	     return quickHelper(ary,k,start,pivot[0]-1);
     }
     return quickHelper(ary,k,pivot[1]+1,end);
    }
 
 
 
  
    public static void quicksort(int[] ary){
	quickSortHelper(ary, 0, ary.length -1);
    }

    public static void quickSortHelper(int[] ary, int start, int end){
	if(start==end){
		return;
	}
	    int[]pivot=partition(ary,start,end);
	    if(pivot[0]!=start){
		    quickSortHelper(ary,start,pivot[0]-1);
	    }
	    if(pivot[1]!=end){
		    quickSortHelper(ary,pivot[1]+1,end);
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
