package Tree;

import java.util.Arrays;
import java.util.List;

import static Tree.TreeNode.path;
import static Tree.TreeNode.printTree;
import static Tree.TreeNode.printTreeLevels;

public class Exercise4 {
    public static void main(String[] args) {
        // 4.1
        TreeNode<String> node0 = new TreeNode<>();
        TreeNode<String> node1 = new TreeNode<>();
        TreeNode<String> node2 = new TreeNode<>();
        TreeNode<String> node3 = new TreeNode<>();
        TreeNode<String> node4 = new TreeNode<>();
        TreeNode<String> node5 = new TreeNode<>();
        TreeNode<String> node6 = new TreeNode<>();
        TreeNode<String> node7 = new TreeNode<>();
        TreeNode<String> node8 = new TreeNode<>();
        TreeNode<String> node9 = new TreeNode<>();
        TreeNode<String> node10 = new TreeNode<>();
        node0.item = "Hochschule";
        node1.item = "Informatik";
        node2.item = "Bachelor";
        node3.item = "AI";
        node4.item = "Mobile";
        node5.item = "Psychologie";
        node6.item = "SE";
        node7.item = "Business";
        node8.item = "Embedded";
        node9.item = "Games";
        node10.item = "Technik";
        node0.children.add(node1);
        node0.children.add(node10);
        node1.children.add(node2);
        node2.children.add(node3);
        node2.children.add(node6);
        node3.children.add(node4);
        node3.children.add(node5);
        node6.children.add(node7);
        node6.children.add(node8);
        node6.children.add(node9);
        node1.parent = node0;
        node10.parent = node0;
        node2.parent = node1;
        node3.parent = node2;
        node6.parent = node2;
        node4.parent = node3;
        node5.parent = node3;
        node7.parent = node6;
        node8.parent = node6;
        node9.parent = node6;

        System.out.println("\nExercise 4.2");
        List<String> pathPsychology = path(node0, "Psychologie");
        System.out.println(Arrays.toString(pathPsychology.toArray()));

        System.out.println("\nExercise 4.3");
        printTree(node0);

        System.out.println("\nExercise 4.4");
        printTreeLevels(node0);
    }
}
