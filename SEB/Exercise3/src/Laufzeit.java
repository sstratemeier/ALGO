public class Laufzeit {
  public static void main(String[] args) {
    int n = 8;
    System.out.println(recursive5(n));
    System.out.println(direct5(n));
    System.out.println(recursive6(n));
    System.out.println(direct6(n));
  }

  public static double recursive5(int n) {
    return (n == 1)
        ? 1
        : (recursive5(n - 1) + Math.pow(n, 3) + 4 * n);
  }

  public static double direct5(int n) {
    double result = (Math.pow(n,2)*Math.pow(n+1, 2)/4) + (n*(n+1))*2 - 4;
    return result;
  }

  public static double recursive6(int n) {
    return (n == 1)
      ? 1
      : (recursive6(n - 1) + 3*Math.pow(n, 2));
  }

  public static double simple6(int n) {
    double result = (n*(n+1)*(2*n+1)/2)-2;
    return result;
  }

  public static double direct6(int n) {
    double result = (n*(n+1)*(2*n+1)/2)-2;
    return result;
  }
}
