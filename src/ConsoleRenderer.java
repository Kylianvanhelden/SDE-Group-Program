class ConsoleRenderer implements Renderer {
  @Override
  public void render() {
    Board.getInstance().printBoard();
  }
}