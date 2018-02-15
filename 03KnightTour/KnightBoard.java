public class KnightBoard(){
    private int[][]board;
    public KnightBoard(int startingRows,int startingCols){
    if (startingRows<0||startingCols<0){
	throw new IllegalArgumentException();
    }
    board= new int[startingRows][startingCols];
    for (int i=0;i<startingRows;i++){
	for (int j=0;j<startingCols;j++){
	    board[i][j]=="0";
	}
    }
    }

public String toString() {
    ans=""
     for (int i=0;i<startingRows;i++){
	for (int j=0;j<startingCols;j++){
	    if(board[i][j]=="0"){
		ans+="_";
	    }
	}
     }
}

    



  public boolean solve(int startingRow, int startingCol){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] != 0){
          throw new IllegalStateException();
        }
      }
    }

    if (startingRow < 0 || startingCol < 0){
      throw new IllegalArgumentException();
    }
    return solveHelper(startingRow, startingCol, 1);
  }

  private boolean solveH(int row, int col, int level){
    int[][] coordinates = {{2,1},{1,2},{-2,1},{-1,2},
                           {2,-1},{1,-2},{-1,-2},{-2,-1}};
    if (level == board.length * board[0].length){
      board[row][col] = level;
      return true;
    }
    for(int[] x: coordinates){
      try{
        if (board[row + x[0]][col + x[1]] == 0){
          board[row][col] = level;
          if(solveH(row + x[0], col + x[1], level + 1)){
            return true;
          }
          else{
            board[row][col] = 0;
          }
        }
      }catch(Exception e){

      }
    }
    return false;
  }

  public int countSolutions(int startingRow, int startingCol){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] != 0){
          throw new IllegalStateException();
        }
      }
    }

    if (startingRow < 0 || startingCol < 0){
      throw new IllegalArgumentException();
    }
    return countHelp(startingRow, startingCol, 1);

  }

  public int countHelp(int row, int col, int level){
    int sol = 0;
    int[][] coordinates = {{2,1},{1,2},{-2,1},{-1,2},
                           {2,-1},{1,-2},{-1,-2},{-2,-1}};
    if (level == board.length * board[0].length){
      return 1;
    }
    for(int[] x: coordinates){
      if(row + x[0] < board.length && row + x[0] >= 0 &&
         col + x[1] < board[0].length && col + x[1] >= 0){
        if (board[row + x[0]][col + x[1]] == 0){
          board[row][col] = level;
          sol += countHelp(row + x[0], col + x[1], level + 1);
          board[row][col] = 0;
          }
      }
    //  System.out.println(sol);
    }
    return sol;
  }

  public static void main(String[] args){
    KnightBoard b = new KnightBoard(5,5);
    System.out.println(b);
    System.out.println(b.countSolutions(0,0));
  /*  for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        KnightBoard a = new KnightBoard(5,5);
        System.out.println(a.solve(i,j));
      }
    }*/

  }
}
see format for toString below
blank boards display 0's as underscores 
you get a blank board if you never called solve or 
when there is no solution 

@throws IllegalStateException when the board contains non-zero values.
@throws IllegalArgumentException when either parameter is negative 
 or out of bounds.
public boolean solve(int startingRow, int startingCol)

@throws IllegalStateException when the board contains non-zero values. 
@throws IllegalArgumentException when either parameter is negative 
 or out of bounds.
public int countSolutions(int startingRow, int startingCol)

Suggestion:
private boolean solveH(int row ,int col, int level) 
// level is the # of the knight
