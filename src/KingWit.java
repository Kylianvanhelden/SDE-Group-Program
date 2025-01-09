public class KingWit implements Kleur {
    private int column;
    private int row;
    private String character = "W";
    private String kleur = "wit";

    public KingWit(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public void move(int column, int row) {
        if (column >= 0 && column <=7 && row >= 0 && row <=7) {
            if ((row == this.row + 1 || row == this.row - 1) && (column == this.column + 1 || column == this.column - 1)) {
                this.column = column;
                this.row = row;
            }
        }
    }

    public void take(int column, int row) {
        if (column >= 0 && column <=7 && row >= 0 && row <=7) {
            if ((row == this.row + 2 || row == this.row - 2) && (column == this.column + 2 || column == this.column - 2)) {
                this.column = column;
                this.row = row;
            }
        }
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getCharacter() {
        return character;
    }

    public String getKleur() {
        return kleur;
    }
}
