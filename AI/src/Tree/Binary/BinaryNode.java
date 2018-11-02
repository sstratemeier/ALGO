package Tree.Binary;

import java.util.*;

public class BinaryNode {
    String item;
    BinaryNode parent;
    BinaryNode left;
    BinaryNode right;

    public static void breadthFirst(Queue<BinaryNode> q) {
        BinaryNode current = q.poll();
        if(current == null) {
            return;
        } else {
            System.out.println(current.item);
            if(current.left != null)
                q.add(current.left);
            if(current.right != null)
                q.add(current.right);
            breadthFirst(q);
        }
    }

    public static void depthFirstIter(BinaryNode n) {
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(n);
        while (!stack.empty()) {
            BinaryNode current = stack.pop();
            System.out.println(current.item);

            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push(current.left);
        }
    }

    static boolean find(BinaryNode tree, String value) {
        boolean found = false;
        if(tree.item.equals(value)) {
            found = true;
        }
        if(tree.left != null && !found) {
            found = find(tree.left, value);
        }
        if(tree.right != null && !found) {
            found = find(tree.right, value);
        }
        return found;
    }

    static List<String> path(BinaryNode tree, String value) {
        List<String> pathElements = new ArrayList<>();
        if(tree.item.equals(value)) {
            pathElements.add(tree.item);
        }
        if(tree.left != null && pathElements.isEmpty()) {
            pathElements.addAll(path(tree.left, value));
            if(!pathElements.isEmpty()) {
                pathElements.add(0, tree.item);
            }
        }
        if(tree.right != null && pathElements.isEmpty()) {
            pathElements.addAll(path(tree.right, value));
            if(!pathElements.isEmpty()) {
                pathElements.add(0, tree.item);
            }
        }
        return pathElements;
    }
}
