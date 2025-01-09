class ConsoleRenderer implements Renderer {
  
  @Override
  public void render(int size) {
    Board.getInstance(size).printBoard();
  }
}