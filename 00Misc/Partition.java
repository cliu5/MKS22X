public class Partition{
  public static void swap(int[] array, int first, int second){
    int temp = array[first];
    array[first]=array[second];
    array[second]=temp;
}

  public static int Partition(int[] data, int start, int end){
	if (start == end) {
    return start;
  }
  int pivotIndex = (int)(Math.random() * (end - start + 1)) + start;
  int value=data[pivotIndex];
	swap(data, end, pivotIndex);
	int pivot = start;
	for (int i = start; i < end; i ++){
	    if (data[i] < value){
		swap(data, pivot, i);
		pivot++;
	    }
	}
	swap(data, pivot, end);
	return pivot;
    }
}

