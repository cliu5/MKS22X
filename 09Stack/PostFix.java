public class PostFix{

    public static double eval(String exp){
        Stack<Integer> S=new Stack<>();
	String[] tokens= exp.split(" ");
	   String temp = "";
	    for(String x:tokens){
		    temp+=x;}
	    char[] C= temp.toCharArray();
	    

	    
	   
        for(int i=0;i<tokens.length;i++){
		if(Character.isDigit(tokens[i])){
			return 1;
		}
          
    }
    }
	public static void main(String[] args) 
    {
        String exp="2 3 *";
        System.out.println(eval(exp));
    }
}
