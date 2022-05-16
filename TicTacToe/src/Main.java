import java.util.*;
public class Main {
    // TicTacToe Game between Player and Computer
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Get player's names
        System.out.println(("Who is player 1?  "));
        String Player1 = in.next();
        System.out.println(("Who is player 2?  "));
        String Player2 = in.next();


        // 3x3 tic tac toe board
        // - for empty space
        // x player 1
        // o player 2
        char[][] board = new char[3][3];

        //Fill the board with dashes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        // keep track who's turn it is
        boolean isPlayer1 = true;
        boolean gameEnded = false;
        while(!gameEnded) {

        // draw the board
        drawBoard(board);

        //keep track of what symbol we are using to play

        char symbol = ' ';
        if (isPlayer1) {
            symbol = 'x';
        } else {
            symbol = 'o';
        }
        //print players turn
        if (isPlayer1) {
            System.out.println(Player1 + "'s Turn (x)");
        } else {
            System.out.println(Player2 + "'s Turn (o)");
        }

        //get row and col from user

        int row = 0;
        int column = 0;

        while (true) {
            System.out.print("Enter a row (0, 1, or 2): ");
            row = in.nextInt();
            System.out.print("Enter a column (0, 1, or 2): ");
            column = in.nextInt();
            // check if row and column are valid
            if (row < 0 || row > 2 || column < 0 || column > 2) {
                // row or column out of bounds
                System.out.println("Invalid input - Out of bounds");
            } else if (board[row][column] != '-') {
                //Someone already made a move there
                System.out.println("Someone has already made a move there!");
            } else {
                break;
            }
        }

        //setting position of board to player symbol
        board[row][column] = symbol;

        //check if a player has won
        if (hasWon(board) == 'x') {
            System.out.println(Player1 + " has won!");
            gameEnded = true;
        } else if (hasWon(board) == 'o') {
            System.out.println(Player2 + " has won!");
            gameEnded = true;
        } else {
            if (hasTied(board)) {
                System.out.println("It's a tie!");
            } else {
                //continue the game and is next players turn
                isPlayer1 = !isPlayer1;

            }

        }
    }
        drawBoard(board);

}

    // Function to print the board
    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char hasWon(char[][] board) {
        //row
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }
        // column
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }
        // diagonal
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }
        //Nobody won
        return '-';
    }

// Function for when the game has a scenario that ends in a tie
    public static boolean hasTied(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
