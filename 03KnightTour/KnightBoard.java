public class KnightBoard(){
    private int[][]board;
	private int[] ROWMOVES={2,2,1,-1,-2,-2,1,-1};
	private int[] COLUMNMOVES={1,-1,2,2,1,-1,-2,-2};
	
    public KnightBoard(int startingRows,int startingCols){
    if (startingRows<0||startingCols<0){
	throw new IllegalArgumentException();
    }    
    board= new int[startingRows][startingCols];
    }

public String toString() {
    String ans="";
     for (int ROW=0;ROW<board.length;ROW++){

     for (int COLUMN=0;COLUMN<board[ROW].length;COLUMN++){
	     if(board.length*board[row].length<10){
		     if(board[ROW][COLUMN]==0){
			      ans+="_";
		     }
		     else{
			      ans +=" " + board[ROW][COLUMN]+ " " ;
		     }
	     }
	     else{
		     if(board[ROW][COLUMN]<10){
			     if(board[ROW][COLUMN]==0){
				     ans+="_";
			     }
			     else{
				     ans+=" " + board[ROW][COLUMN]+" ";
			     }
		     }
		     else{
			     ans+=board[ROW][COL]+ " ";
		     }
	     }
     }
ans+= "\n";
     }
	return ans;
}

	
public boolean solve(int startingRow, int startingCol){
	if(startingRow<0||startingCol<0||startingRow>=board.length||startingCol>=board[startingRow].length){
		throw new IllegalArgumentException();
	}
	
for(int row=0;row<board.length;row++){
	for(int col=0;col<board[row].length;col++){
	if(board[row][col]!=0){
		throw new IllegalStateException();
	}
}
}
	return solveH(startingRow, startingCol, 1);
}

public boolean solveH(int row, int col, int level){
	if(row<0||row>=board.length||col<0||col>=board[row].length){
		return false;
	}
	if(board[row][col]==0){
		board[row][col]=level;
		level++;
	}
	else{
		return false;
	}
	for(int i=0; i<ROWMOVES.legnth;i++){
		if(SolveH(row+ROWMOVES[i],col+COLMOVES[i],level)){
			return true;
		}
	}
	if(level-1==board.length*board[row].length){
		return true;
	}
	board[row][col]=0;
	return false;
}

public int countSolutions(int startingRow,int startingCol){
	if(startingRow<0||startingCol<0||startingRow>=board.length||startingCol>=board[startingRow].length){
		throw new IllegalStateException();
	}
	for(int row=0;row<board.length;row++){
		for(int col=0;col<board[row].length;col++){
			if(board[row][col]!=0){
				throw new IllegalStateException();
			}
		}
	}
	return countH(startingRow,startingCol,1);
}
public int countH(int row, int col, int level){
	int ans=0;
	if(row<0||row>=board.length||col<0||col>=board[row].length){
		return 0;
	}
	if(level-1==board.length*board[row].length){
		return 1;
	}
	if(board[row][col]==0){
		board[row][col]=level;
		level++;
	}
	else{
		return 0;
	}
	for(int i=0;i<ROWMOVES.length;i++){
		ans+=countH(row+ROWMOVES[i], col+COLUMNMOVES[i],level);
	}
	board[row][col]=0;
	return ans;
}
}

 
