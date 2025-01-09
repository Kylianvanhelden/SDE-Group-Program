class MoveValidator {
  public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
    return fromX >= 0 && fromX < 8 && fromY >= 0 && fromY < 8 &&
        toX >= 0 && toX < 8 && toY >= 0 && toY < 8;
  }
}