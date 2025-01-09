class PlayerTurnState implements GameState {
  private final String player; // "White" of "Black"

  public PlayerTurnState(String player) {
    this.player = player;
  }

  public String getPlayer() {
    return player;
  }

  @Override
  public void play() {
    System.out.println(player + "'s turn.");
  }
}
