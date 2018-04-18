public class PostFix{

    public static double eval(String exp){
        Stack<Integer> S=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isDigit(c))
            S.push(c+' ');
           
            else
            {
                int val1 = S.pop();
                int val2 = S.pop();
                 
                switch(c)
                {
                    case '+':
                    S.push(val2+val1);
                    break;
                     
                    case '-':
                    S.push(val2- val1);
                    break;
                     
                    case '/':
                    S.push(val2/val1);
                    break;
                     
                    case '*':
                    S.push(val2*val1);
                    break;
              }
            }
        }
        return S.pop();    
    }
	
}
