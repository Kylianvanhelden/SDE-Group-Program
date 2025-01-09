public class Bord8x8 {
    private char[][] board = new char[8][8];

    private void printBoard()
    {
        for (int i=1 ; i<9 ; ++i)
        {
            System.out.print("   " + i) ;
        }
        System.out.print("\n  ") ;
        for (int i=0 ; i<8 ; ++i)
            System.out.print("+---") ;
        System.out.print("+\n") ;
        for (int i=0 ; i<8 ; ++i) {
            System.out.print((i+1) + " ") ;
            for (int j=0 ; j<8 ; ++j){
                System.out.print("| " + board[i][j] + " ") ;
            }
            System.out.print("|\n  ") ;
            for (int i2=0 ; i2<8 ; ++i2)
                System.out.print("+---") ;
            System.out.print("+\n") ;
        }
    }
}
