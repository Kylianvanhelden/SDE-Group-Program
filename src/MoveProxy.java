class MoveProxy implements Move {
  private final int size;
  private final MoveValidator moveValidator;
  private final Board board;

  public MoveProxy(int size) {
    this.size = size;
    this.board = Board.getInstance(size); // Haal het bord op via de singleton
    this.moveValidator = new MoveValidator();
  }

  @Override
  public boolean makeMove(int fromX, int fromY, int toX, int toY, State state) {
    // Valideer de zet via de MoveValidator
    if (!moveValidator.isValidMove(fromX, fromY, toX, toY)) {
      System.out.println("Invalid move: Out of bounds or incorrect coordinates.");
      return false;
    }

    // Controleer of het stuk van de juiste speler is
    char piece = board.getGrid()[fromX][fromY];
    String currentPlayer = (state).getName();
    if ((currentPlayer.equals("White") && (piece != 'W' && piece != 'K')) ||
        (currentPlayer.equals("Black") && (piece != 'B' && piece != 'k'))) {
      System.out.println("Invalid move: Piece does not belong to the current player.");
      return false;
    }

    // Geef de controle door aan de werkelijke 'makeMove' methode van Board
    return board.movePiece(fromX, fromY, toX, toY, state);
  }
}
