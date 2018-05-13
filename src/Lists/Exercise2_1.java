package Lists;

public class Exercise2_1 {
    public static void execute(String[] args) {
        class Node<Item> {
            Item item;
            Node<Item> next;
        }

        System.out.println("\nExercise 2.1");
        Node<Integer> n1 = new Node<Integer>();
        Node<Integer> n3 = new Node<Integer>();
        Node<Integer> n4 = new Node<Integer>();
        n1.item = 1;
        n3.item = 3;
        n4.item = 4;
        n1.next = n3;
        n3.next = n4;
        n4.next = null;
        System.out.println(n1.item);
        System.out.println(n1.next.item);
        System.out.println(n1.next.next.item);
        System.out.println();

        Node<Integer> n2 = new Node<Integer>();
        n2.item = 2;
        n2.next = n3;
        n1.next = n2;
        System.out.println(n1.item);
        System.out.println(n1.next.item);
        System.out.println(n1.next.next.item);
        System.out.println(n1.next.next.next.item);
        System.out.println();

        n2.next = n4;
        System.out.println(n1.item);
        System.out.println(n1.next.item);
        System.out.println(n1.next.next.item);
    }
}

