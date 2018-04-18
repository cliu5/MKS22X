public class PostFix{

    public static double eval(String exp){
        Stack S =new Stack();
	String[] str= exp.split(" ");
	   String temp = "";
	    for(String x:str){
		    temp+=x;}
	    char[] tokens= temp.toCharArray();
        for(int i=0;i<tokens.length;i++){
		if(Character.isDigit(tokens[i])){
			S.push(tokens[i]);
		}
		else{
			int first=S.pop();
			int second=S.pop();
			
			if(tokens[i]=='+'){
				return 1;
			}
			if(tokens[i]=='-'){
				return 1;
			}
			if(tokens[i]=='*'){
				return 1;
			}
			if(tokens[i]=='/'){
				return 1;
			}
			if(tokens[i]=='%'){
				return 1;
			}
			
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
