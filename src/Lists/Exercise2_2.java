package Lists;

class Exercise2_2 {
    public static void execute(String[] args) {
        class Node<Item> {
            Item item;
            Node<Item> next;
            Node<Item> previous;
        }

        System.out.println("\nExercise 2.2");
        Node<Integer> n1 = new Node<Integer>();
        Node<Integer> n3 = new Node<Integer>();
        Node<Integer> n4 = new Node<Integer>();
        n1.item = 1;
        n3.item = 3;
        n4.item = 4;
        n1.next = n3;
        n3.next = n4;
        n4.next = null;
        n1.previous = null;
        n3.previous = n1;
        n4.previous = n3;
        System.out.println(n4.previous.previous.item);
        System.out.println(n4.previous.item);
        System.out.println(n4.item);
        System.out.println();

        Node<Integer> n2 = new Node<Integer>();
        n2.item = 2;
        n2.next = n3;
        n2.previous = n1;
        n1.next = n2;
        n3.previous = n2;
        System.out.println(n4.previous.previous.previous.item);
        System.out.println(n4.previous.previous.item);
        System.out.println(n4.previous.item);
        System.out.println(n4.item);
        System.out.println();

        n2.next = n4;
        n4.previous = n2;
        System.out.println(n4.previous.previous.item);
        System.out.println(n4.previous.item);
        System.out.println(n4.item);
        System.out.println();
    }
}
