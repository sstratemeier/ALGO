package Lists;

public class LinkedList<Item> {
    private Node<Item> first;
    private Node<Item> last;

    class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> previous;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int length() {
        int length = 0;
        Node<Item> currentNode = first;
        while (currentNode != null) {
            currentNode = currentNode.next;
            length++;
        }
        return length;
    }

    public Item elementAt(int index) {
        return nodeAt(index).item;
    }

    private Node<Item> nodeAt(int index) {
        Node<Item> currentNode = first;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return  currentNode;
    }

    public void prepend(Item e) {
        Node<Item> node = new Node<>();
        node.item = e;
        if(isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.previous = node;
            first = node;
        }
    }

    public void append(Item e) {
        Node<Item> node = new Node<>();
        node.item = e;
        if(isEmpty()) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            last.next = node;
            last = node;
        }
    }

    public void insertAt(int index, Item e) {
        Node<Item> currentNode = nodeAt(index);
        if(currentNode == first) {
            prepend(e);
        } else {
            Node<Item> newNode = new Node<>();
            newNode.item = e;
            newNode.previous = currentNode.previous;
            newNode.next = currentNode;
            currentNode.previous.next = newNode;
            currentNode.previous = newNode;
        }
    }

    public void remove(int index) {
        Node<Item> currentNode = nodeAt(index);
        if(currentNode == first) {
            currentNode.next.previous = null;
            first = currentNode.next;
        } else if (currentNode == last) {
            currentNode.previous.next = null;
            last = currentNode.previous;
        } else {
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<Item> node = first;
        while (node != null) {
            builder.append(node.item);
            builder.append(" ");
            node = node.next;
        }
        return builder.toString();
    }
}
