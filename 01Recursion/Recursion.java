
public class Recursion{
  public int fact(int n){
  if (n < 0){
      throw new IllegalArgumentException();
    }
    if(n==0){
    return 1;
    }
    else{
    return fact(n-1)*n;
    }
    }
//fib with helper//
  public static int Helper( int n, int First, int Second){
    if (n==0){
      return First;
    }
    else{
      return Helper(n-1,Second,First+Second);
    }
    //the first one is the number two before and the second one is the number one before//
    //this took somethinking but you recursively go thru and store frist+second//
    
  public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return Helper(n, 0, 1);
    }

   
