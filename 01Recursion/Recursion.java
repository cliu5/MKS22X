
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
  public static int FibHelper( int n, int firstNum, int secondNum){
    if (n==0){
      return firstNum;
    }
    else{
      return FibHelper(n-1,secondNum,firstNum+secondNum);
    }
    //the first param is changing n//
	//second param is the number ur passing down ie in the fib sequence 0,1,1,2,3,5 once u finish 1,1 you can throw the 1st one//
	//second param is the sum as you store it//
  }
  public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	return FibHelper(n, 0, 1);
    }

}
