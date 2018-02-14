public class QueenBoard{
    private int[][]board;
    private int size;
    public QueenBoard(int size){
	    if(size<0){
		    throw new IllegalArgumentException();
	    }
	    
	board= new int[size][size];
	    this.size=size;
	
    }
	
	//thanks to kristen at the dojo for helping me with understanding the algorithm and debugging addQueen & removeQueen//
	
    private boolean addQueen(int r, int c){
	if(board[r][c]==0){
	    board[r][c]=-1;
	    for(int i=1 ; c+i<size; i++){
		
		board[r][c+i]+=1;
			
	if(r+i<size){
		//diagonals//
		board[r+i][c+i]+=1;
	}
		if (r-i>=0){
			board[r-i][c+i]+=1;
		}
	
	    return true; 
	    }
    }
	   return false;
}
    
    
    private boolean removeQueen(int r, int c){
	if(board[r][c]==0){
		board[r][c]+=1;
		for(int i=1;c+i<size;i++){
			board[r][c+i]-=1;
			if(r+i<size){
				board[r+i][c+i]-=1;
			}
			if(r-i>=0){
				board[r-i][c+i]-=1;
			}
		}
		return true;
	}
	    return false;
    }

     

    public String toString(){
	    String ans="";
	for(int i=0;i<size;i++){
	    for(int j=0;j<size;j++){
		    if(board[i][j]!=-1){
			    ans+="_";
		    }
		else{
		    ans+="Q";
		}
	    }
	}
	    return ans;
    }
    
  
  
    public boolean solve(){
    for(int i=0;i<size;i++){
	    for(int j=0;j<size;j++){
		    if(board[i][j]!=0){
			    throw new IllegalStateException();
		    }
	    }
    }
	    return solveHelper(0);
    }
	    
    public boolean solveHelper(int COLUMN){
	    if(COLUMN==size){
		    return true;
	    }
	    //once the amt of queens is equal to the size of the board u solved it thats the base case//
	    for (int i=0;i<size; i++){
		    //loop thru and check if you can add a queen//
		    if(addQueen(i,COLUMN)){
			    //if u can u add 1 to the column and move on//
			    if(solveHelper(COLUMN+1)){
				    return true;
			    }
			    // if you can't you remove first then back track and delete//
			    removeQueen(i,COLUMN);
		    }
	    }
	    return false;
    }
	    
	    
    
    public int countSolutions(){
	    for(int i=0;i<size;i++){
		    for(int j=0;j<size;j++){
		    if(board[i][j]!=0){
			    throw new IllegalStateException();
		    }
		    }
	    }
	    
	    return countSolutionsHelper(0);
    
    }
	
	    public int countSolutionsHelper(int COLUMN){
		    int ans=0;
		    if(COLUMN==size){
			    return 1;
		    }
		    //get to end means 1 solution//
		    for(int i=0;i<size;i++){
			    if(addQueen(i,COLUMN)){
				    ans+=countSolutionsHelper(COLUMN+1);
				    //if u cant u backtrack and remove!!//
				    removeQueen(i,COLUMN);
			    }
		    }
		    return ans;
	    }
	
	//crystal's driver//
	public static void main(String[] args){
    QueenBoard b = new QueenBoard(4);

    System.out.println(b.solve()); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    for (int i = 0; i < 12; i++){
      QueenBoard a = new QueenBoard(i);
      System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
      /*          Expected Values
       i --> # of Solutions   i --> # of Solutions
      0 --> 1                      6 --> 4
      1 --> 1                      7 --> 40
      2 --> 0                      8 --> 92
      3 --> 0                      9 --> 352
      4 --> 2                    10 --> 724
      5 --> 10                  11 --> 2680
      */
      System.out.println(a); //prints out an empty i by i grid of underscores
}
	}}
	
	
    

