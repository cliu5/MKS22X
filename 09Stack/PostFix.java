public class PostFix{

    public static double eval(String exp){
        Stack S =new Stack();
	String[] tokens= exp.split(" ");
	   
        for(int i=0;i<tokens.length;i++){
		
				
		if(tokens[i]=="+"){
			double first=S.pop();
			double second=S.pop();
			
				S.push(first+second);
			}
			if(tokens[i]=="-"){
				double first=S.pop();
			double second=S.pop();
			
				S.push(first-second);
			}
			if(tokens[i]=="*"){
				double first=S.pop();
			double second=S.pop();
			
				S.push(first*second);
			}
			if(tokens[i]=="/"){
				double first=S.pop();
			double second=S.pop();
			
				S.push(first/second);
			}
			if(tokens[i]=="%"){
				double first=S.pop();
			double second=S.pop();
			
				S.push(first%second);
			}
		else{
			S.push(Double.parseDouble(tokens[i]));
		}
		
    }
	    return 1;
    }
	public static void main(String[] args) 
    {
        String exp="2 3 *";
        System.out.println(eval(exp));
    }
}
