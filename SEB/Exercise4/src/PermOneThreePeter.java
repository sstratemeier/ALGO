import java.util.*;

// Originally from https://github.com/JoCoaker/brute-force/blob/master/src/PermOneThree.java
/* FAILED
public class PermOneThreePeter {
  static List<List<Integer>> data;

  public static void main(String[] args) {
    data = new ArrayList<>();
    int n;
    Scanner input = new Scanner(System.in);

    System.out.print("Bitte geben Sie N ein: ");
    n = input.nextInt();
    long startTime = System.nanoTime();

    Set<Integer> values1 = new HashSet<>();
    Set<Integer> values2 = new HashSet<>();
    values1.add(2);
    values1.add(3);
    values2.add(3);
    System.out.println(values2.equals(values1));
    System.out.println(values1);


    LinkedList<LinkedList<Integer>> result = newstartPermute(n);
    result.forEach(System.out::println);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.
    //data.forEach(t -> System.out.println(t));
    System.out.println("Zeit: " + duration + "ms");
    System.out.println("Es gab genau "+ result.size() +" Permutationen der verlangten Art.");
  }

  private static LinkedList<LinkedList<Integer>> newstartPermute(int n) {
    LinkedList<LinkedList<Integer>> response = new LinkedList<>();
    Set<Integer> remaining = new HashSet<>();
    for(int i = 1; i <= n; i++) {
      remaining.add(i);
    }

    for(int i =1 ; i<=n;i++) {
      LinkedList<LinkedList<Integer>> result = newPermute(remaining, i, n);
      int finalI = i;
      result.forEach(integers -> integers.addFirst(finalI));
      response.addAll(result);
    }
    return response;
  }

  static HashMap<String, LinkedList<LinkedList<Integer>>> cache = new HashMap<>();

  private static LinkedList<LinkedList<Integer>> newPermute(Set<Integer> oldRemaining , int last, int n) {
    LinkedList<LinkedList<Integer>> response = new LinkedList<>();
    Set<Integer> remaining = new HashSet<>(oldRemaining);
    remaining.remove(last);
    if (remaining.size() <= 0) {
      LinkedList<Integer> result = new LinkedList<>();
      response.add(result);
    } else if (cache.containsKey(key(remaining, last))) {
      LinkedList<LinkedList<Integer>> values = cache.get(key(remaining, last));
      response = values;
    } else {
      int[] deltas = new int[]{-4, -1, 1, 4};
      for (int delta : deltas) {
        int possible = last + delta;
        Set<Integer> nextUsed = new HashSet<>(remaining);
        nextUsed.add(possible);
        if (remaining.contains(possible) && possible <= n && possible > 0) {
          LinkedList<LinkedList<Integer>> result = newPermute(nextUsed, possible, n);
          result.forEach(integers -> integers.addFirst(possible));
          response.addAll(result);
        }
      }
      cache.put(key(remaining, last), response);
    }
    return response;
  }

  static String key(Set<Integer> used, int previous) {
    return "" + used + previous ;
  }

  static class Key {
    Set<Integer> used;
    int lastUsed;
    public Key(Set<Integer> used, int lastUsed) {
      this.used = used;
      this.lastUsed = lastUsed;
    }

    @Override
    public int hashCode() {
      return Objects.hash(used, lastUsed);
    }

    @Override
    public boolean equals(Object obj) {
      Key other = (Key) obj;
      /*if(used.equals(other.used)) {
        System.out.println("");
      }
      if (other.lastUsed == this.lastUsed) {
        System.out.println("");
      }

      return used.equals(other.used) && other.lastUsed == this.lastUsed;
    }
  }
}
*/