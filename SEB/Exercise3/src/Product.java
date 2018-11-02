import java.util.HashMap;

class Node {
  public int n;
  public int[] a;
  public int[] b;
  public int[] r;
  HashMap<String, Node> children = new HashMap<>();

  public String toDeepString() {
    return toDeepString("");
  }
  public String toDeepString(String indent) {
    StringBuilder builder = new StringBuilder();
    builder.append("(").append(toPolynomString(a)).append(")");
    builder.append("(").append(toPolynomString(b)).append(")");
    builder.append(" = ").append(toPolynomString(r));
    if (!children.isEmpty()) {
      builder.append("\n");
      builder.append(indent).append("= ");
      builder.append("(").append(toPolynomString(children.get("A").r)).append(")");
      builder.append(" + ").append("x²").append("(").append(toPolynomString(children.get("C").r)).append(")");
      builder.append(" + ").append("x⁴").append("(").append(toPolynomString(children.get("B").r)).append(")");
    }
    builder.append("\n");
    children.entrySet().forEach(stringNodeEntry -> {
      String name = stringNodeEntry.getKey();
      Node value = stringNodeEntry.getValue();
      builder.append(indent).append(name).append(": ").append(value.toDeepString(indent + " "));
    });
    return builder.toString();
  }

  public static String toPolynomString(int[] polynom) {
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < polynom.length - 1; i++) {
      if(polynom[i] < 0) {
        builder.append("(");
        builder.append(polynom[i]);
        builder.append(")");
      } else {
        builder.append(polynom[i]);
      }
      builder.append("x");
      builder.append(superscript(i+""));
      builder.append(superscript(" + "));
    }
    builder.append(polynom[polynom.length-1]);
    builder.append("x");
    builder.append(superscript(polynom.length-1+""));

    return builder.toString();
  }

  public static String superscript(String str) {
    str = str.replaceAll("0", "⁰");
    str = str.replaceAll("1", "¹");
    str = str.replaceAll("2", "²");
    str = str.replaceAll("3", "³");
    str = str.replaceAll("4", "⁴");
    str = str.replaceAll("5", "⁵");
    str = str.replaceAll("6", "⁶");
    str = str.replaceAll("7", "⁷");
    str = str.replaceAll("8", "⁸");
    str = str.replaceAll("9", "⁹");
    return str;
  }
}

public class Product {
  public static void main(String[] args) {
    int[] a = {3, -2, 4, -2};
    int[] b = {2, -4, -3, -2};
    Node result = prod(a, b);
    System.out.println(result.toDeepString());
  }

  public static Node prod (int[] a, int[] b) {
    Node result = new Node();
    result.n = a.length;
    result.a = a;
    result.b = b;
    int n = a.length, // Problemgroesse
        nh = n/2; // halbe Problemgroesse
    int[] r = new int [2*n]; // Ergebnisarray
    if (n==1) { // Kleines Teilproblem:
      r[0] = a[0] * b[0]; // Direkte Loesung
    } else { // sonst:
      int[] al = new int [nh], ar = new int [nh], // *******
          bl = new int [nh], br = new int [nh], // * *
          alr = new int [nh], blr = new int [nh]; // * *
      for (int i=0; i<nh; i++){ // ********* *
        alr [i] = al [i] = a [i]; // * *
        blr [i] = bl [i] = b [i]; // * *
        alr [i] += ar [i] = a [i+nh]; // * DIVIDE *
        blr [i] += br [i] = b [i+nh]; // * *
      } // ******************************** // ***************
      Node A = prod (al, bl); // ******** // ***************
      Node B = prod (ar, br); // * CONQUER *
      Node C = prod (alr, blr); // ******* // ***************

      result.children.put("A", A);
      result.children.put("B", B);
      result.children.put("C", C);

      for (int i=0; i<n; i++) { // ******** // ***************
        r [i] += A.r[i]; // * *
        r [i+nh] += C.r[i] - A.r[i] - B.r[i]; // * MERGE *
        r [i+n] = B.r[i]; // * *
      } // ******************************** // ***************
    }
    result.r = r;
    return result;
  }
}
