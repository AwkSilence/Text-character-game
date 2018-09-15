//Jessica Chan
//111398795
//Course Project
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
public class ConnectFour {
	public static String[][] makeBoard(){
		String[][] board= new String[7][15]; //needs 7th row for ... and 15 column for |
		for (int i=0; i<7; i++) { //row
			for (int j=0;j<15;j++) {//column
				if (j%2==0)
					//System.out.print("|");
					board[i][j]="|";
				
				else
					//System.out.print(" ");
					board[i][j]=" ";
				if (i==6) //last row
					board[i][j]=".";
			}
			
		}
		return board;
	}
	public static void printBoard(String[][] board) {
		for (int i=0; i<board.length;i++) {
			for (int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]);
			}
			System.out.print("\n");
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to the game of Connect Four!");
		int counter=(int)(Math.random()*2); //random player starts first
		boolean GameEnded=false; 
		//System.out.print(makeBoard());
		String[][] board= makeBoard();
		printBoard(board);
		while (!GameEnded) {
			if (counter%2==0) {
				counter++;	//switch player turn
				DropR(board);
				if (CheckBoardRed(board)) {
					System.out.println("Player Red is the winner!");
					GameEnded=true;
				}
				else {
					continue;
				}
				if (!CheckDraw(board)) {
					continue;
				}
				else {
					System.out.println("Draw");
					GameEnded=true;
				}
				


				
			}
			if (counter%2!=0) {
				counter++; //switch player turn
				DropY(board);
				if (CheckBoardYellow(board)) {
					System.out.println("Player Yellow is the winner!");
					GameEnded=true;
					
				}
				else {
					continue;
				}
				if (!CheckDraw(board)) {
					continue;
				}
				else {
					System.out.println("Draw");
					GameEnded=true;

			}
			
		}
	}
		
		
		
	}
	public static boolean CheckDraw(String[][] board) {
		for (int i=0; i<=5;i++) {
			for (int j=1;j<15;j+=2) {
				if (board[i][j]==" ") {
					return false;
				}
				else continue;
			}
		}
		return true;
	}
	//Red Player's Turn
	public static void DropR(String[][] board) {
		Scanner input= new Scanner(System.in);
		boolean continueInput=true;
		while(continueInput) {
		try {
			System.out.println("Player Red's turn");
			System.out.println("Drop a red disk at column(0-6): ");
			int column= input.nextInt();
			//System.out.println(column);
			if (column>=0&&column<7) {
				continueInput=false;
				column=2*column+1; //take in account the lines and dots
				if (board[0][column]!=" ") {
					System.out.println("Column is full");
					DropR(board);
				}
				for (int i=5;i>0;i--) { //goes down each row
				if (board[i][column]==" ") {
					board[i][column]="R";
					break;
				}
				}
			}else {
				System.out.println("Please enter a column from 0-6");
				continue;
			}
			
			
		} catch(Exception ex){
			System.out.println("Please enter an INTEGER from 0-6");		
			input.nextLine();
			
		}
		printBoard(board);
	}
		
}

	//Yellow Player's Turn
	public static void DropY(String[][] board) {
		Scanner input= new Scanner(System.in);
		boolean continueInput=true;
		while(continueInput) {
		try {
			System.out.println("Player Yellow's turn");
			System.out.println("Drop a yellow disk at column(0-6): ");
			int column= input.nextInt();
			//System.out.println(dropY);
			if (column>=0&&column<7) {
				column= 2*column+1;
				if (board[0][column]!=" ") {
					System.out.println("Column is full");
					DropY(board);
				}
				for (int i=5;i>=0;i--) { //goes down each row
					if (board[i][column]==" ") {
						board[i][column]="Y";
						break;
					}
				}
				
				continueInput=false;

			}
			else {
				System.out.println("Please enter a column from 0-6");
				continue;
			}
		} catch(Exception ex){
			System.out.println("Please enter an INTEGER from 0-6");	
			input.nextLine();
			}
		}
		printBoard(board);
	}
	public static boolean CheckBoardRed(String[][] board) {
		boolean RWin=false;
		//check rows
				for (int a=0;a<6;a++) { 
					for (int b=0;b<7;b+=2) {
						if ((board[a][b+1]=="R")&&(board[a][b+3]=="R")&&(board[a][b+5]=="R")&&(board[a][b+7]=="R")) {
							RWin=true;
							return RWin;
						}
					}
				}
				//check columns
				for (int c=1;c<15;c+=2) { //cannot go out of index bounds
					for (int d=0;d<3;d++) {
						if ((board[d][c]=="R")&&(board[d+1][c]=="R")&&(board[d+2][c]=="R")&&(board[d+3][c]=="R")) {
							RWin=true;
							return RWin;
						}
					}
				}
				//check for diagonal
				for (int e=0;e<3;e++) {
					for (int f=1;f<=8;f+=2) {
						if ((board[e][f]=="R")&&(board[e+1][f+2]=="R")&&(board[e+2][f+4]=="R")&&(board[e+3][f+6]=="R")) {
							RWin=true;
							return RWin;
						}
					}
				}
				//check for diagonal in opposite direction
				for (int e=0;e<3;e++) {
					for (int f=7;f<15;f+=2) {
						if ((board[e][f]=="R")&&(board[e+1][f-2]=="R")&&(board[e+2][f-4]=="R")&&(board[e+3][f-6]=="R")) {
							RWin=true;
							return RWin;
						}
					}
				}
		return false;
	}
		
		
	public static boolean CheckBoardYellow(String[][]board) {
		boolean YWin=false;
		//check rows
				for (int a=0;a<6;a++) { 
					for (int b=0;b<7;b+=2) {
						if ((board[a][b+1]=="Y")&&(board[a][b+3]=="Y")&&(board[a][b+5]=="Y")&&(board[a][b+7]=="Y")) {
							YWin=true;
							return YWin;
						}
					}
				}
				//check columns
				for (int c=1;c<15;c+=2) { //cannot go out of index bounds
					for (int d=0;d<3;d++) {
						if ((board[d][c]=="Y")&&(board[d+1][c]=="Y")&&(board[d+2][c]=="Y")&&(board[d+3][c]=="Y")) {
							YWin=true;
							return YWin;
						}
					}
				}
				//check for diagonal
				for (int e=0;e<3;e++) {
					for (int f=1;f<=8;f+=2) {
						if ((board[e][f]=="Y")&&(board[e+1][f+2]=="Y")&&(board[e+2][f+4]=="Y")&&(board[e+3][f+6]=="Y")) {
							YWin=true;
							return YWin;
						}
					}
				}
				//check for diagonal in opposite direction
				for (int e=0;e<3;e++) {
					for (int f=7;f<15;f+=2) {
						if ((board[e][f]=="Y")&&(board[e+1][f-2]=="Y")&&(board[e+2][f-4]=="Y")&&(board[e+3][f-6]=="Y")) {
							YWin=true;
							return YWin;
						}
					}
				}
		return false;
	}

}


		
	
