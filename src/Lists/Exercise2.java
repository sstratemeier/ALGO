package Lists;

import java.sql.SQLOutput;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2_1.execute(null);
        Exercise2_2.execute(null);

        System.out.println("\nExercise: 2.3");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.append("hello");
        linkedList.append("world");
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.length());
        System.out.println(linkedList.elementAt(1));
        linkedList.prepend("first");
        linkedList.append("last");
        linkedList.insertAt(2, "middle");
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);

        System.out.println("\nExercise 2.4");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.append("hello");
        arrayList.append("world");
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.length());
        System.out.println(arrayList.elementAt(1));
        arrayList.prepend("first");
        arrayList.append("last");
        arrayList.insertAt(2, "middle");
        System.out.println(arrayList);
        arrayList.remove(2);
        System.out.println(arrayList);
    }
}
