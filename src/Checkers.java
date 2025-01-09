public class Checkers {
  public static void main(String[] args) {
    
    int size = CheckersGameSize8.boardSize();
    RendererBridge rendererBridge = new RendererBridge(new ConsoleRenderer(), size);
    rendererBridge.display();


    GameTemplate game = new CheckersGameSize8();
    game.playGame();
  }
}
