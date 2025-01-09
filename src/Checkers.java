public class Checkers {
    static final int EMPTY = 0;
    static final int PLAYER1_PIECE = 1;
    static final int PLAYER2_PIECE = 2;

    static int[][] board = new int[8][8];

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        // Further game logic will follow
    }

    static void initializeBoard() {
        // Place Player 1's pieces
        for (int i = 0; i < 3; i++) {
            for (int j = (i % 2); j < 8; j += 2) {
                board[i][j] = PLAYER1_PIECE;
            }
        }

        // Place Player 2's pieces
        for (int i = 5; i < 8; i++) {
            for (int j = (i % 2); j < 8; j += 2) {
                board[i][j] = PLAYER2_PIECE;
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

