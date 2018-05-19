public class Calculator{

    public static double eval(String exp){
        Stack S =new Stack();
	String[] tokens= exp.split(" ");
	  for(int i=0;i<tokens.length;i++){
		
				
		if(tokens[i].equals("+")){
			double first=S.pop();
			double second=S.pop();
			
				S.push(first+second);
			}
			else if(tokens[i].equals("-")){
				double first=S.pop();
			double second=S.pop();
			
				S.push(-1*(first-second));
			}
			else if(tokens[i].equals("*")){
				double first=S.pop();
			double second=S.pop();
			
				S.push(first*second);
			}
			else if(tokens[i].equals("/")){
				double first=S.pop();
			double second=S.pop();
			
				S.push(1/(first/second));
			}
			else if(tokens[i].equals("%")){
				
				
				double first=S.pop();
			double second=S.pop();
			
				S.push(second%first);
			}
		else{
			S.push(Double.parseDouble(tokens[i]));
		}
		
    }
    
	    return S.peek();
	    
    }
   public static void main(String[]args){
   
		   System.out.println(Calculator.eval("10 2.0 %"));
	  
	     System.out.println(Calculator.eval("4.0 3.0 %"));
	
	   
   }
	
}
