import java.util.ArrayList;

public class DLXPentominoDTXY {
  static int width;
  static int height = 6;
  public static void main(String[] args) {
    int n = 4;
    width = n;
    //int[][] elements = createPositions();
    DLXNode h =  createDLXMatrix();
    DLXNode.search(0);
    System.out.println("Count: " + DLXNode.cnt);
  }

  public static DLXNode createDLXMatrix() {
    int matrixWidth = width * height;
    DLXNode[] columns = new DLXNode[matrixWidth];
    DLXNode h = DLXNode.h;

    // Create columnHeader row
    for (int column = 0; column < matrixWidth; column++) {
      DLXNode newColumn = new DLXNode("" + column);

      newColumn.R = h;
      newColumn.L = h.L;
      h.L.R = newColumn;
      h.L = newColumn;
      columns[column] = newColumn;
    }

    Polyomino[] polyominos = Polyomino.values();
    for(Polyomino polyomino : polyominos) {
      for (int i = 0; i <= width - polyomino.getWidth(); i++) {
        for (int j = 0; j <= height - polyomino.getHeight(); j++) {
          int[] fields = getFields(i, j, polyomino);

          DLXNode rowHead = null;
          for(int k = 0; k < fields.length; k++) {
            int field = fields[k];
            DLXNode columnHead = columns[field];
            DLXNode newNode = new DLXNode("R"+k+"F"+field);
            if (rowHead == null) rowHead = newNode;

            newNode.C = columnHead;
            newNode.U = columnHead.U;
            newNode.D = columnHead;
            newNode.L = rowHead.L;
            newNode.R = rowHead;

            columnHead.U.D = newNode;
            columnHead.U = newNode;
            rowHead.L.R = newNode;
            rowHead.L = newNode;
          }
        }
      }
    }
    return h;
  }


  static int[] getFields(int left, int top, Polyomino polyomino) {
    ArrayList<Integer> fields = new ArrayList<>();
    boolean[][] shape = polyomino.getShape();

    for (int j = 0; j < polyomino.getHeight(); j++) {
      for (int i = 0; i < polyomino.getWidth(); i++) {
        if(shape[j][i]) {
          fields.add(positionToNumber(i + left, j + top));
        }
      }
    }
    return fields.stream().mapToInt(i -> i).toArray();
  }

  static int positionToNumber(int x, int y) {
    return x + y * width;
  }
}