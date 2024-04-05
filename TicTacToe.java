import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = '-';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = PLAYER_X;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private boolean isMoveValid(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == EMPTY_CELL;
    }

    private boolean checkWinner(char player) {
        // Check rows and columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Row
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Column
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Diagonal from top-left to bottom-right
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Diagonal from top-right to bottom-left
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false; // Board is not full
                }
            }
        }
        return true; // Board is full
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("Current board:");
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (isMoveValid(row, col)) {
                board[row][col] = currentPlayer;
                if (checkWinner(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameRunning = false;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameRunning = false;
                } else {
                    // Switch players
                    currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        System.out.println("Welcome to Tic-Tac-Toe!");
        game.playGame();
        System.out.println("Game Over.");
    }
}
