import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Niklas Kapelle 198980, Henri Bußmann 198632, Simon Stratemeier 199067
 */
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
    // Create header row
    DLXNode[] columns = createColumns();

    // Create possibilities for each polyomino
    for(Polyomino polyomino : Polyomino.values()) {
      // Possibilities for shifted positions
      for (int dx = 0; dx <= width - polyomino.getWidth(); dx++) {
        for (int dy = 0; dy <= height - polyomino.getHeight(); dy++) {

          // Positions of polyomino
          int[] fields = getFields(dx, dy, polyomino);

          // Add initial node to row in DLX structure
          DLXNode rowHead = new DLXNode();
          link(rowHead, rowHead, columns[fields[0]]);
          // ... other nodes
          for(int column = 1; column < fields.length; column++) {
            DLXNode columnHead = columns[fields[column]];
            link(new DLXNode(), rowHead, columnHead);
          }
        }
      }
    }
  }

  static void link(DLXNode node, DLXNode rowHead, DLXNode columnHead) {
    // Connect node to environment
    node.C = columnHead;
    node.U = columnHead.U;
    node.D = columnHead;
    node.L = rowHead.L;
    node.R = rowHead;

    // Connect environment to node
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

    // check in shape matrix every field
    for (int j = 0; j < polyomino.getHeight(); j++) {
      for (int i = 0; i < polyomino.getWidth(); i++) {
        // add field to fields it is covered
        if(shape[j][i]) {
          fields.add((i + left) +  (j + top) * width);
        }
      }
    }
    return fields.stream().mapToInt(i -> i).toArray();
  }
}