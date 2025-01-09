public class Checkers {
  public static void main(String[] args) {
    RendererBridge rendererBridge = new RendererBridge(new ConsoleRenderer());
    rendererBridge.display(10);

    CheckersGame game = new CheckersGame();
    game.playGame();
  }
}
