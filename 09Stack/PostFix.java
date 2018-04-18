public class PostFix{

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
			
				S.push(first-second);
			}
			else if(tokens[i].equals("*")){
				double first=S.pop();
			double second=S.pop();
			
				S.push(first*second);
			}
			else if(tokens[i].equals("/")){
				double first=S.pop();
			double second=S.pop();
			
				S.push(first/second);
			}
			else if(tokens[i].equals("%")){
				double first=S.pop();
			double second=S.pop();
			
				S.push(first%second);
			}
		else{
			S.push(Double.parseDouble(tokens[i]));
		}
		
    }
    
	    return S.peek();
	    
    }
   
	public static void main(String[] args) 
    {
        
        System.out.println(PostFix.eval("10 2.0 +"));
	System.out.println(PostFix.eval("11 3 - 4 + 2.5 *"));
	System.out.println(PostFix.eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
