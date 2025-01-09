class PlayerTurn {

  private State state;

  public PlayerTurn(State beginState) {
    this.state = beginState;
  }

  public State getState() {
    return state;
  }

  public void changeState(State newState) {
    this.state = newState;
  }

  public void play() {
    this.state.play();
  }

  public void endTurn() {
    this.state.endTurn();
  }

  public void gameOver() {
    this.state.gameOver();
  }
}
