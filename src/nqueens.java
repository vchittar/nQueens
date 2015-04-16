import java.util.*;

public class nqueens {
    static int chessboard[][];
    static int count = 0;
    static int NumberOfqueens;
    
    public static void placeQueens(int Queen_Number, int row, int coloumn) {
        
        int coloun;
        /*Breaking Condition*/
        if (Queen_Number <= NumberOfqueens) {
            
            for (coloun = coloumn; coloun < NumberOfqueens; coloun++) {
                
                if (validPosition(row, coloun)) {
                    
                    chessboard[row][coloun] = 1;
                    /*Recursive Call*/
                    placeQueens(Queen_Number + 1, row + 1, 0);
                    chessboard[row][coloun] = 0;
                    if (coloun < NumberOfqueens - 1) {
                    	/*Back Track*/
                        placeQueens(Queen_Number, row, coloun + 1);
                    } else {
                        if (Queen_Number == 1 && coloumn == NumberOfqueens - 1) {
                            System.out.println("No Solution");
                            System.exit(0);
                            
                        }
                        return;
                    }
                    break;
                    
                }
            }
            if (coloun >= NumberOfqueens - 1) {
                return;
            }
        } else {
            	/*Printing the solution*/
            for (int i = 0; i < NumberOfqueens; i++) {
                for (int j = 0; j < NumberOfqueens; j++) {
                    System.out.print(chessboard[i][j] + " ");
                }
                System.out.println(" ");
                
            }
            System.exit(0);
        }
        
    }
    
    /* Code to validate the position to place the queen */
    public static boolean validPosition(int row, int coloumn) {
        
        // Coloumn attack
        for (int i = row; i >= 0; i--) {
            {
                if (chessboard[i][coloumn] == 1)
                    return false;
            }
        }
        // Row attack
        for (int i = coloumn; i >= 0; i--) {
            {
                if (chessboard[row][i] == 1)
                    return false;
            }
        }
        
        // Left Diagonal
        for (int i = row, j = coloumn; i >= 0 && j >= 0; i--, j--) {
            {
                if (chessboard[i][j] == 1)
                    return false;
            }
        }
        
        // Right Diagonal
        for (int i = row, j = coloumn; i >= 0 && j < NumberOfqueens; i--, j++) {
            {
                if (chessboard[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
    
    
    public static void main(String args[]) {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Enter the number of queens on the chessboard and the size of the chessboard");
        int numberOfQueens = kbd.nextInt();
        NumberOfqueens = numberOfQueens;
        chessboard = new int[numberOfQueens][numberOfQueens];
        
        placeQueens(1, 0, 0);
        
    }
}