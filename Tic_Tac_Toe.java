import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        displayInputBoard();

        char player = 'X';
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);
        int count = 0;
        while (!gameOver) {
            displayBoard(board);
            System.out.print("Player " + player + " Enter: ");
            char move = input.next().charAt(0);
            System.out.println();
            int rows = getRow(move);
            int cols = getCol(move);

            if (board[rows][cols] == ' ') {
                board[rows][cols] = player;
                if (count > 3) {
                    gameOver = winner(board, player);
                }
                if (gameOver) {
                    System.out.println("\t\t\tPlayer " + player + " Has Won.");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
                count++;
            } else {
                System.out.println("\t\t\tInvalid Move");
            }
            if (!gameOver && count == 9) {
                System.out.println("\t\t\tOops Tie!");
                break;
            }
        }
        displayBoard(board);

        input.close();
    }

    private static int getRow(char move) {
        int row = 0;
        switch (move) {
            case 'q' -> row = 0;
            case 'w' -> row = 0;
            case 'e' -> row = 0;
            case 'a' -> row = 1;
            case 's' -> row = 1;
            case 'd' -> row = 1;
            case 'z' -> row = 2;
            case 'x' -> row = 2;
            case 'c' -> row = 2;
            default -> System.out.println("\t\t\tInvalid Character");
        }

        return row;
    }

    private static int getCol(char move) {
        int col = 0;
        switch (move) {
            case 'q' -> col = 0;
            case 'w' -> col = 1;
            case 'e' -> col = 2;
            case 'a' -> col = 0;
            case 's' -> col = 1;
            case 'd' -> col = 2;
            case 'z' -> col = 0;
            case 'x' -> col = 1;
            case 'c' -> col = 2;
            default -> System.out.println("Invalid Character");
        }

        return col;
    }

    private static boolean winner(char[][] board, char player) {
        // check row and col
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                    return true;
                }
                if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                    return true;
                }
            }
        }

        // check diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private static void displayBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    private static void displayInputBoard() {
        char[][] board = new char[3][3];
        board[0][0] = 'q';
        board[0][1] = 'w';
        board[0][2] = 'e';
        board[1][0] = 'a';
        board[1][1] = 's';
        board[1][2] = 'd';
        board[2][0] = 'z';
        board[2][1] = 'x';
        board[2][2] = 'c';

        System.out.println("Give input in below format: ");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
