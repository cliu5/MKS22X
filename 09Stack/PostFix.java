public class PostFix{

    public static double eval(String exp){
        Stack<Integer> S=new Stack<>();
	String[] tokens= exp.split(" ");
        for(int i=0;i<tokens.length;i++){
		if(Character.isDigit(tockens[i])){
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
