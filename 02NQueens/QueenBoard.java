public class QueenBoard{
    private int[][]board;
    public QueenBoard(int size){
	int[][] board= new int[size][size];
	for(int i=0;i<board.size;i++){
	    for(int j=0;j<board.size;j++){
		board[i][j]=0;
	    }
	}
    }
    private boolean addQueen(int r, int c){
	board[r][c]=-1;
	for (int i=0;i<board.size;i++){
	    for(int j=0;j<board.size;j++){
		if (i=r+1&&j=c+1){
		    board[i][j]=board[i][j]+1
			}
	    }
	}
    }
    private boolean removeQueen(int r, int c){
	board[r][c]=0;
    }
      /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q' 
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:  
  *Q _ _ _
  *_ _ Q _
  * etc.
  */
    public String toString(){
	int[][]ShowBoard=new int[size][size];
	
	for(int i=0;i<board.size;i++){
	    for(int j=0;j<board.size;j++){
		if(board[i][j]==-1){
		    ShowBoard[i][j]="Q";
		}
		else{
		    ShowBoard[i][j]="_";
		}
	    }
	}
    }
    
  
  /**
  *@return false when the board is not solveable and leaves the board filled with zeros; 

  *        true when the board is solveable, and leaves the board in a solved state

  *@throws IllegalStateException when the board starts with any non-zero value

  */
    public boolean solve(){
    }
    public boolean solveHelper(){
    }
    public int countSolutions(){
    }
}
