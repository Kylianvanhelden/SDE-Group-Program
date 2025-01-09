class Board {
  private static Board instance;
  private final char[][] grid;

  private Board() {
    grid = new char[10][10]; // bord size is nu 10x10
    initializeBoard();
  }

  public static Board getInstance() {
    if (instance == null) {
      instance = new Board();
    }
    return instance;
  }

  private void initializeBoard() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (i < 4 && (i + j) % 2 != 0) {
          grid[i][j] = 'B'; // Zwarte stukken
        } else if (i > 5 && (i + j) % 2 != 0) {
          grid[i][j] = 'W'; // Witte stukken
        } else {
          grid[i][j] = '.'; // Leeg veld
        }
      }
    }
  }

  public void printBoard() {
    System.out.print("   ");
    for (int i = 0; i < 10; i++) {
      System.out.print(i + " "); // kolom nummer
    }
    System.out.println();

    for (int i = 0; i < 10; i++) {
      System.out.print(i + " "); // rij nummers
      if (i < 10)
        System.out.print(" "); // dit is voor uitlijning
      for (int j = 0; j < 10; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }

  public boolean movePiece(int fromX, int fromY, int toX, int toY, GameState currentState) {
    char piece = grid[fromX][fromY];
    String currentPlayer = ((PlayerTurnState) currentState).getPlayer();

    // check of het een geldige player is
    if ((currentPlayer.equals("White") && piece != 'W') || (currentPlayer.equals("Black") && piece != 'B')) {
      return false;
    }

    // check of het veld leeg is
    if (grid[toX][toY] != '.') {
      return false;
    }

    int dx = toX - fromX;
    int dy = toY - fromY;

    // normale movement
    if (Math.abs(dx) == 1 && Math.abs(dy) == 1) {
      if ((currentPlayer.equals("White") && dx == -1) || (currentPlayer.equals("Black") && dx == 1)) {
        grid[toX][toY] = piece;
        grid[fromX][fromY] = '.';
        return true;
      }
    }

    // Slaan (2 tegels diagonaal)
    if (Math.abs(dx) == 2 && Math.abs(dy) == 2) {
      int middleX = fromX + dx / 2; // Coördinaat van de geslagen tegel (tussen de start en eindpositie)
      int middleY = fromY + dy / 2;

      char middlePiece = grid[middleX][middleY];

      // Controleer of er een tegenstander tussen ligt
      if ((currentPlayer.equals("White") && middlePiece == 'B')
          || (currentPlayer.equals("Black") && middlePiece == 'W')) {
        grid[toX][toY] = piece;
        grid[fromX][fromY] = '.';
        grid[middleX][middleY] = '.'; // Verwijder het geslagen stuk
        return true;
      }
    }

    // Ongeldige zet
    return false;
  }
}
