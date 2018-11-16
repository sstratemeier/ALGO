import java.util.ArrayList;
import java.util.Scanner;

public class DLXPentominoDTXY {
  static int width;
  static int height = 6;
  public static void main(String[] args) {
    System.out.println("N einlesen");
    Scanner scanner = new Scanner(System.in);
    width = scanner.nextInt();

    createDLXMatrix();
    DLXNode.search(0);
    System.out.println("Count: " + DLXNode.cnt);
  }

  public static void createDLXMatrix() {
    DLXNode[] columns = createColumns();

    for(Polyomino polyomino : Polyomino.values()) {
      for (int dx = 0; dx <= width - polyomino.getWidth(); dx++) {
        for (int dy = 0; dy <= height - polyomino.getHeight(); dy++) {
          int[] fields = getFields(dx, dy, polyomino);

          DLXNode rowHead = new DLXNode();
          create(rowHead, rowHead, columns[fields[0]]);
          for(int column = 1; column < fields.length; column++) {
            DLXNode columnHead = columns[fields[column]];
            create(new DLXNode(), rowHead, columnHead);
          }
        }
      }
    }
  }

  static void create(DLXNode node, DLXNode rowHead, DLXNode columnHead) {
    node.C = columnHead;
    node.U = columnHead.U;
    node.D = columnHead;
    node.L = rowHead.L;
    node.R = rowHead;

    columnHead.U.D = node;
    columnHead.U = node;
    rowHead.L.R = node;
    rowHead.L = node;
  }

  static DLXNode[] createColumns() {
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

    return columns;
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