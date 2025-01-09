class PieceFactory {
  public static Piece createPiece(String type) {
    switch (type) {
      case "King":
        return new KingPiece();
      default:
        return new RegularPiece();
    }
  }
}