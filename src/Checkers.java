public class Checkers {
  public static void main(String[] args) {
    
    int size = CheckersGame.boardSize();
    RendererBridge rendererBridge = new RendererBridge(new ConsoleRenderer(), size);
    rendererBridge.display();


    CheckersGame game = new CheckersGame();
    game.playGame();
  }
}
