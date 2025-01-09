class MoveProxy {
  private int size;

  private final Board board = Board.getInstance(size);

  public MoveProxy(int size) {
    this.size = size;
  }

  public boolean makeMove(int fromX, int fromY, int toX, int toY, State currentState) {
    return board.movePiece(fromX, fromY, toX, toY, currentState);
  }
}
