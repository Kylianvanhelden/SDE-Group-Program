public class Koning extends Dam {
    public Koning(Kleur kleur, int row, int col) {
        super(kleur, row, col);
    }

    @Override
    public void movePiece(int row, int col) {
        if (this.getRow() == row - 1 || this.getRow() == row + 1) {

        }
    }
}
