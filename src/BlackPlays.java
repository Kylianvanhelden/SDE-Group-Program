public class BlackPlays extends State {
    public BlackPlays(int pieces, int turns) {
        super("Black", 20, 20);
    }
    @Override
    protected void play() {
        System.out.println(player + "'s turn.");
    }

    protected void endTurn() {
        WhitePlays whitePlays = new WhitePlays(pieces, turns);
        setState(whitePlays);
        whitePlays.play();
    }

    @Override
    protected void gameOver() {
        // TODO Auto-generated method stub
        
    }
}
