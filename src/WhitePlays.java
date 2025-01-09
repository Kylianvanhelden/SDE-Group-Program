public class WhitePlays extends State {

    public WhitePlays() {
        super("White");
    }
    @Override
    protected void play() {
        System.out.println("White's turn.");
    }

    protected void endTurn() {
        BlackPlays blackPlays = new BlackPlays();
        setState(blackPlays);
    }

    @Override
    protected void gameOver() {
        System.out.println("White has won, Game over!");
    }
}
