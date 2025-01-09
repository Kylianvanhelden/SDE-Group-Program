class MoveProxy {
  private final Board board = Board.getInstance();

  public boolean makeMove(int fromX, int fromY, int toX, int toY, GameState currentState) {
    return board.movePiece(fromX, fromY, toX, toY, currentState);
  }
}
