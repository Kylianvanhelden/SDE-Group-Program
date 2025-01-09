public class Dam {
    protected Kleur kleur;
    private int row;
    private int col;

    public Dam(Kleur kleur, int row, int col) {
        this.kleur = kleur;
        this.row = row;
        this.col = col;
    }

    public String getKleur() {
        return kleur.getKleur();
    }

    public String getChar() {
        return kleur.getCharacter();
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void movePiece(int row, int col) {
        if (this.row + kleur.getMove() == row) {
            if (this.col == col - 1 || this.col == col + 1) {
                this.col = col;
                this.row += kleur.getMove();
            }
        }
    }

    public void takePiece(int row, int col) {
        if (this.row + (kleur.getMove() * 2) == row) {
            if (this.col == col - 2 || this.col == col + 2) {
                this.col = col;
                this.row += (kleur.getMove() * 2);
            }
        }
    }
}
