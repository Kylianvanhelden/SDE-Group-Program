public class DamWit implements Kleur {
    private int column;
    private int row;
    private String character = "w";
    private String kleur = "wit";

    public DamWit(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public void move(int column, int row) {
        if (column >= 0 && column <=7) {
            if (row == this.row - 1 && (column == this.column + 1 || column == this.column - 1)) {
                this.row = row;
                this.column = column;
            }
        }
        if (row == 7) {
            this.promote();
        }
    }

    public void take(int column, int row) {
        if (column >= 0 && column <=7) {
            if (row == this.row - 2 && (column == this.column + 2 || column == this.column - 2)) {
                this.row = row;
                this.column = column;
            }
        }
        if (row == 7) {
            this.promote();
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

    public void promote() {
        int i = 0;
    }

    public String getKleur() {
        return kleur;
    }
}
