class Board {
  private static Board instance;
  private final char[][] grid;
  private int size;

  public void setSize(int size) {
    this.size = size;
  }

  private Board(int size) {
    this.size = size;
    grid = new char[size][size]; // bord size is nu 10x10
    initializeBoard();
  }

  public static Board getInstance(int size) {
    if (instance == null) {
      instance = new Board(size);
    }
    return instance;
  }

  private void initializeBoard() {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i < ((size - 2) / 2) && (i + j) % 2 != 0) {
          grid[i][j] = 'B'; // Zwarte stukken
        } else if (i > ((size - ((size - 2) / 2)) - 1) && (i + j) % 2 != 0) {
          grid[i][j] = 'W'; // Witte stukken
        } else {
          grid[i][j] = '.'; // Leeg veld
        }
      }
    }
  }

  public void printBoard() {
    System.out.print("   ");
    for (int i = 0; i < size; i++) {
      System.out.print(i + " "); // kolom nummer
    }
    System.out.println();

    for (int i = 0; i < size; i++) {
      System.out.print(i + " "); // rij nummers
      if (i < 10)
        System.out.print(" "); // dit is voor uitlijning
      for (int j = 0; j < size; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }

  public boolean movePiece(int fromX, int fromY, int toX, int toY, State currentState) {
    if (!isWithinBounds(fromX, fromY) || !isWithinBounds(toX, toY)) {
      System.out.println("Invalid move: Coordinates out of bounds.");
      return false;
    }

    char piece = grid[fromX][fromY];
    String currentPlayer = (currentState).getName();

    // Controleer of het huidige stuk bij de speler hoort
    if ((currentPlayer.equals("White") && piece != 'W' && piece != 'K') ||
        (currentPlayer.equals("Black") && piece != 'B' && piece != 'k')) {
      return false;
    }

    // Controleer of het doelveld leeg is
    if (grid[toX][toY] != '.') {
      return false;
    }

    int dx = toX - fromX;
    int dy = toY - fromY;

    // Normale beweging voor een normaal stuk
    if ((piece == 'W' && dx == -1 && Math.abs(dy) == 1) ||
        (piece == 'B' && dx == 1 && Math.abs(dy) == 1)) {
      grid[toX][toY] = piece;
      grid[fromX][fromY] = '.';
      promoteToKing(toX, toY, currentPlayer);
      return true;
    }

    // Normale beweging voor een King
    if ((piece == 'K' || piece == 'k') && Math.abs(dx) == 1 && Math.abs(dy) == 1) {
      grid[toX][toY] = piece;
      grid[fromX][fromY] = '.';
      return true;
    }

    // Slaan
    if (Math.abs(dx) == 2 && Math.abs(dy) == 2) {
      int middleX = fromX + dx / 2;
      int middleY = fromY + dy / 2;

      char middlePiece = grid[middleX][middleY];
      if ((currentPlayer.equals("White") && (middlePiece == 'B' || middlePiece == 'k')) ||
          (currentPlayer.equals("Black") && (middlePiece == 'W' || middlePiece == 'K'))) {
            if (currentPlayer.equals("White")) {
              CheckersGame.blackPieces--;
            } else {
              CheckersGame.whitePieces--;
            }
        grid[toX][toY] = piece;
        grid[fromX][fromY] = '.';
        grid[middleX][middleY] = '.';
        promoteToKing(toX, toY, currentPlayer);
        return true;
      }
    }

    return false;
  }

  private boolean isWithinBounds(int x, int y) {
    return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
  }

  private void promoteToKing(int x, int y, String currentPlayer) {
    if (currentPlayer.equals("White") && x == 0) {
      grid[x][y] = 'K'; // Promote White to King
      System.out.println("White piece promoted to King!");
    } else if (currentPlayer.equals("Black") && x == grid.length - 1) {
      grid[x][y] = 'k'; // Promote Black to King
      System.out.println("Black piece promoted to King!");
    }
  }

}