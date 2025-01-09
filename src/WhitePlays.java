public class WhitePlays extends State {

    public WhitePlays(int pieces, int turns) {
        super("White", 20, 20);
    }
    @Override
    protected void play() {
        System.out.println(player + "'s turn.");
    }

    protected void endTurn() {
        BlackPlays blackPlays = new BlackPlays(pieces, turns);
        setState(blackPlays);
        blackPlays.play();
    }

    @Override
    protected void gameOver() {
        // TODO Auto-generated method stub
        
    }
}
