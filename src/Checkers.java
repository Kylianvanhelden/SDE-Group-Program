public class Checkers {
  public static void main(String[] args) {
    RendererBridge rendererBridge = new RendererBridge(new ConsoleRenderer());
    rendererBridge.display();

    CheckersGame game = new CheckersGame();
    game.playGame();
  }
}
