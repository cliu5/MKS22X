public class Merge{
public static void mergesort(int[] data){
//sort the array from least to greatest value. This is a wrapper function that calls msort()//
}

//Suggestions - have your msort take both the data and temp arrays. Pre-allocate a temp array in your mergesort method//
private static void msort(int[]data, int[]temp, int lo, int hi){

msort:
  if lo >= hi :  return 
  copy   data[ lo ] through data[hi]    into    temp[lo] through temp[hi]
  calculate the midpoint  mid = ???
  call msort() on each half, but switch the temp and data!
      msort( ??? ) what parameters are needed?
      msort( ??? )
  call merge... which should copy from temp back to data!
      merge( ???  )  what parameters are needed?

}
private static void merge(int[]data,int[]temp, int[]final){
}
}


	

