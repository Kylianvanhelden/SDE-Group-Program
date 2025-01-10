public class BlackPlays extends State {
    public BlackPlays() {
        super("Black");
    }
    @Override
    protected void play() {
        System.out.println(name + "'s turn.");
    }

    protected void endTurn() {
        WhitePlays whitePlays = new WhitePlays();
        setState(whitePlays);
    }

    @Override
    protected void gameOver() {
        System.out.println("Black has won, Game over!");
    }
}
