public class DLXPentominoDTXY {
  public static void main(String[] args) {
    int[][] matrix = new int[4][3];
    matrix[0][0] = 1;
    matrix[1][1] = 1;
    matrix[2][2] = 1;
    matrix[3][1] = 1;

    DLXNode dlxMatrix = createDLXMatrix(matrix);
    DLXNode.search(0);
    System.out.println("Count: " + DLXNode.cnt);

    System.out.println(dlxMatrix);
  }

  public static DLXNode createDLXMatrix(int[][] matrix) {
    DLXNode h = DLXNode.h;
    DLXNode[] columns = new DLXNode[matrix.length];

    // Create columnHeader row
    for (int column = 0; column < matrix[0].length; column++) {
      DLXNode newColumn = new DLXNode("" + column);

      newColumn.R = h;
      newColumn.L = h.L;
      h.L.R = newColumn;
      h.L = newColumn;
      columns[column] = newColumn;
    }

    for (int row = 0; row < matrix.length; row++) {
      DLXNode rowHead = null;
      for (int column = 0; column < matrix[0].length; column++) {
        DLXNode columnHead = columns[column];

        if (matrix[row][column] == 1) {
          DLXNode newNode = new DLXNode(row + "|" + column);
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
    return h;
  }
}


