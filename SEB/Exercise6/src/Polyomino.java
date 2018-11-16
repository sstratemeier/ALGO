/**
 * @author Niklas Kapelle 198980, Henri Bußmann 198632, Simon Stratemeier 199067
 */
public enum Polyomino{
  DOMINO1(new boolean[][] {
      { true, true }
  }),
  DOMINO2(new boolean[][] {
      { true },
      { true }
  }),
  T_PENTOMINO1(new boolean[][] {
      { true, true, true },
      { false, true, false },
      { false, true, false },
  }),
  T_PENTOMINO2(new boolean[][] {
      { false, true, false},
      { false, true, false },
      { true, true, true},
  }),
  T_PENTOMINO3(new boolean[][] {
      { true, false, false},
      { true, true, true},
      { true, false, false},
  }),
  T_PENTOMINO4(new boolean[][] {
      { false, false, true},
      { true, true, true},
      { false, false, true},
  }),
  X_PENTOMINO(new boolean[][] {
      { false, true, false},
      { true, true, true },
      { false, true, false },
  }),
  Y_PENTOMINO1(new boolean[][] {
      { false, true },
      { true, true },
      { false, true },
      { false, true },
  }),
  Y_PENTOMINO1F(new boolean[][] {
    { true, false },
    { true, true },
    { true, false },
    { true, false },
  }),
  Y_PENTOMINO2(new boolean[][] {
      { true, false },
      { true, false },
      { true, true },
      { true, false },
  }),
  Y_PENTOMINO2F(new boolean[][] {
      { false, true },
      { false, true },
      { true, true },
      { false, true},
  }),
  Y_PENTOMINO3(new boolean[][] {
      { true, true, true, true },
      { false, true, false, false },
  }),
  Y_PENTOMINO3F(new boolean[][] {
      { false, true, false, false },
      { true, true, true, true },
  }),
  Y_PENTOMINO4(new boolean[][] {
      { true, true, true, true },
      { false, false, true, false },
  }),
  Y_PENTOMINO4F(new boolean[][] {
      { false, false, true, false },
      { true, true, true, true },
  });

  // coverage matrix
  private final boolean[][] shape;

  Polyomino(boolean[][] shape){
    this.shape = shape;
  }

  public boolean[][] getShape() {
    return shape;
  }

  public int getWidth() {
    return getHeight() > 0 ? shape[0].length : 0;
  }

  public int getHeight() {
    return shape.length;
  }
}