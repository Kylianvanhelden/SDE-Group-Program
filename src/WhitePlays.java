public class WhitePlays extends State {

    public WhitePlays(int pieces, int turns) {
        super("White", pieces, turns);
    }
    @Override
    protected void play() {
        System.out.println(name + "'s turn.");
    }

    protected void endTurn() {
        BlackPlays blackPlays = new BlackPlays(pieces, (turns - 1));
        setState(blackPlays);
    }

    @Override
    protected void gameOver() {
        // TODO Auto-generated method stub
        
    }
}
