public class QuickDriver{
    public static void main(String[] args){

	
	//MOST IMPORTANT TEST........PARTITION!!!
	//(This could be more extensive ..... and better .... and A LOT MORE!)
	//(My Quick.partition returns the index num of PIVOT, and is inclusive of the last num)
	



	//Borrowed most from K
	int[] test = {1000, 993, 999};
	toString(test);	
	////SHOULD PRINT THE ARRAY IN ORDER FROM LEAST TO GREATEST
	System.out.println("\nPRINTING LEAST TO GREATEST");
	for (int i = 0; i < test.length; i++){
	    System.out.println(Quick.quickselect(test, i));;
	}
	System.out.println("DONE!\n");


	//Testing QuickSort
	System.out.println("TESTING QUICKSORT!");
	//General Case

	long start,end;
	start = System.currentTimeMillis();

	System.out.print("Before: ");
	int[] testy = {1000, 993,999};
	toString(testy);
	Quick.quicksort(testy);
	end = System.currentTimeMillis();

	System.out.print("aAfter: ");
	toString(testy);
	System.out.println("Time: " + (end-start) + "ms");

	//Edge Cases
	System.out.print("\nTESTING EDGY CASES!\n");

	int[] testz = {};
	System.out.print("Before: ");
	toString(testz);
	System.out.print("aAfter: ");
	Quick.quicksort(testz);
	toString(testz);
	System.out.println();

	int[] testa = {1};
	System.out.print("Before: ");
	toString(testa);
	System.out.print("aAfter: ");
	Quick.quicksort(testa);
	toString(testa);
	System.out.println();

	int[] testb = {1,1};
	System.out.print("Before: ");
	toString(testb);
	System.out.print("aAfter: ");
	Quick.quicksort(testb);
	toString(testb);
	System.out.println();

	int[] testc = {2,1};
	System.out.print("Before: ");
	toString(testc);
	System.out.print("aAfter: ");
	Quick.quicksort(testc);
	toString(testc);
	System.out.println();

	int[] testd = {1,2};
	System.out.print("Before: ");
	toString(testd);
	System.out.print("aAfter: ");
	Quick.quicksort(testd);
	toString(testd);
	System.out.println();
	
    }

    //Checks to see if pivot is correct
    //Given: ary, pivot
    private static boolean checkPivot(int[] ary, int pivot){
	for (int i = 0; i < pivot; i++){
	    if (ary[i] > ary[pivot]){
		return false;
	    }
	}
	for (int j = pivot + 1; j < ary.length; j++){
	    if (ary[j] < ary[pivot]){
		return false;
	    }
	}
	return true;
    }


    private static void toString(int[] parti){
	for (int k = 0; k < parti.length; k++){
	    System.out.print(parti[k] + ", ");
	}
	System.out.println();
    }
}
