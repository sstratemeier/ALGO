package Tree.Binary;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Tree.Binary.BinaryNode.find;
import static Tree.Binary.BinaryNode.path;

class Exercise3 {
    public static void main(String[] args) {
        // 3.1a
        BinaryNode a0 = new BinaryNode();
        BinaryNode a1 = new BinaryNode();
        BinaryNode a2 = new BinaryNode();
        a0.item = "+";
        a1.item = "2";
        a2.item = "3";
        a0.left = a1;
        a0.right = a2;
        a1.parent = a0;
        a2.parent = a0;

        // 3.1b1
        BinaryNode b0 = new BinaryNode();
        BinaryNode b1 = new BinaryNode();
        BinaryNode b2 = new BinaryNode();
        BinaryNode b3 = new BinaryNode();
        BinaryNode b4 = new BinaryNode();
        b0.item = "*";
        b1.item = "5";
        b2.item = "+";
        b3.item = "2";
        b4.item = "3";
        b0.left = b1;
        b0.right = b2;
        b2.left = b3;
        b2.right= b4;
        b1.parent = b0;
        b2.parent = b0;
        b3.parent = b2;
        b4.parent = b2;

        // 3.1b2
        BinaryNode c0 = new BinaryNode();
        BinaryNode c1 = new BinaryNode();
        BinaryNode c2 = new BinaryNode();
        BinaryNode c3 = new BinaryNode();
        BinaryNode c4 = new BinaryNode();
        BinaryNode c5 = new BinaryNode();
        BinaryNode c6 = new BinaryNode();
        c0.item = "2";
        c1.item = "*";
        c2.item = "3";
        c3.item = "+";
        c4.item = "4";
        c5.item = "*";
        c6.item = "5";
        c3.left = c1;
        c3.right = c5;
        c1.left = c0;
        c1.right = c2;
        c5.left = c4;
        c5.right = c6;
        c1.parent = c3;
        c5.parent = c3;
        c0.parent = c1;
        c2.parent = c1;
        c4.parent = c5;
        c6.parent = c5;

        // 3.1c
        BinaryNode d0 = new BinaryNode();
        BinaryNode d1 = new BinaryNode();
        BinaryNode d2 = new BinaryNode();
        BinaryNode d3 = new BinaryNode();
        BinaryNode d4 = new BinaryNode();
        BinaryNode d5 = new BinaryNode();
        BinaryNode d6 = new BinaryNode();
        d0.item = "2";
        d1.item = "*";
        d2.item = "3";
        d3.item = "+";
        d4.item = "4";
        d5.item = "*";
        d6.item = "5";
        d1.left = d0;
        d1.right = d5;
        d5.left = d3;
        d5.right = d6;
        d3.left = d2;
        d3.right = d4;
        d0.parent = d1;
        d5.parent = d1;
        d3.parent = d5;
        d6.parent = d6;
        d2.parent = d3;
        d4.parent = d4;


        System.out.println("\n Exercise 3.2");
        System.out.println(find(d1, "+"));
        System.out.println(find(d4, "+"));

        System.out.println("\n Exercise 3.3");
        List<String> path1 = path(d1, "4");
        System.out.println(Arrays.toString(path1.toArray()));
        List<String> path2 = path(d1, "*");
        System.out.println(Arrays.toString(path2.toArray()));
        List<String> path3 = path(d1, "nonExistentElement");
        System.out.println(Arrays.toString(path3.toArray()));

        Queue<BinaryNode> q = new LinkedList<>();
        q.add(c3);
    }
}

