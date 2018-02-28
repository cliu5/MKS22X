public class KnightBoard{
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
	     if(board.length*board[ROW].length<10){
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
			     ans+=board[ROW][COLUMN]+ " ";
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
	for(int i=0; i<ROWMOVES.length;i++){
		if(solveH(row+ROWMOVES[i],col+COLUMNMOVES[i],level)){
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
	
	if(board[row][col]==0){
		board[row][col]=level;
		level++;
	}
	else{
		return 0;
	}
	for(int i=0;i<ROWMOVES.length;i++){
		if(level-1==board.length*board[row].length){
			board[row][col]=0;
			return 1;
		}
		ans+=countH(row+ROWMOVES[i], col+COLUMNMOVES[i],level);
	}
	board[row][col]=0;
	return ans;
}
	
	
	
	
	
	public static void main(String[] args){
    KnightBoard a = new KnightBoard(3,3);
    System.out.println(a);
   

    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (a.solve(i,j)){
          System.out.println("There is an error with your solve method");
        }
      }
    } //prints nothing

    System.out.println(a.countSolutions(0,0)); //prints 0



    KnightBoard b = new KnightBoard(5,5);
    System.out.println(b.solve(0,0)); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      KnightBoard b1 = new KnightBoard(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(0,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"



    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        KnightBoard abc = new KnightBoard(5,5);
        System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
      }
    }
    KnightBoard c = new KnightBoard(5,5);

    int totalSol = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        totalSol += c.countSolutions(i,j);
      }
    }

    System.out.println(totalSol); //prints 1728

    KnightBoard d = new KnightBoard(5,5);
    System.out.println(d.countSolutions(0,0)); //prints 304


    for(int i = 0; i < 4; i++){
      for (int j = 0; j < 4; j++){
        KnightBoard e = new KnightBoard(3,4);
        System.out.println(e.solve(i,j));
      }
    }
  }


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

 
