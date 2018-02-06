
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
if (n==1){
	return secondNum;
}
    else{
      return FibHelper(n-1,secondNum,firstNum+secondNum);
    }
	  //below is just for me to sort/understand tail recursions plz ignore//
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



public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelper(n, n/2);
    }

    public double sqrtHelper(double n, double guess){
	    //base case is the percent error stuff//
	if(Math.abs(n-(guess * guess )) < .0001){
	    return guess;
	}
	    
	return sqrtHelper(n, (n / guess + guess) / 2);
	    
    }
//s/o to crystal for the test cases//
public static void main(String[] args){
    Recursion a = new Recursion();
    System.out.println(a.fact(0));
    System.out.println(a.fact(1));
    System.out.println(a.fact(2));
    System.out.println(a.fact(3));
    System.out.println(a.fact(4));
    System.out.println(a.fib(0));
    System.out.println(a.fib(1));
    System.out.println(a.fib(2));
    System.out.println(a.fib(3));
    System.out.println(a.fib(4));
    System.out.println(a.fib(5));
    System.out.println(a.fib(6));
    System.out.println(a.fib(7));
    System.out.println(a.fib(8));
    System.out.println(a.fib(9));
    System.out.println(a.sqrt(100.0));
    System.out.println(a.sqrt(1.0));
    System.out.println(a.sqrt(2.0));
    System.out.println(a.sqrt(4.0));
    System.out.println(a.sqrt(3.0));
    System.out.println(a.sqrt(64.0));
  }
}

