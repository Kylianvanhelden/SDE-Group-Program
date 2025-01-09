public class BlackPlays extends State {
    public BlackPlays(int pieces, int turns) {
        super("Black", pieces, turns);
    }
    @Override
    protected void play() {
        System.out.println(name + "'s turn.");
    }

    protected void endTurn() {
        WhitePlays whitePlays = new WhitePlays(pieces, (turns - 1));
        whitePlays.setPlayerTurn(playerTurn);
        playerTurn.changeState(whitePlays);
        //setState(whitePlays);
    }

    @Override
    protected void gameOver() {
        // TODO Auto-generated method stub
        
    }
}
