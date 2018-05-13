package Tree;

import Tree.Binary.BinaryNode;

import java.util.*;

class TreeNode<Item>
{
    TreeNode<Item> parent;
    Item item;
    ArrayList<TreeNode<Item>> children = new ArrayList<>();

    static void printTreeLevels(TreeNode<? super String> tree) {
        int i = 1;
        Boolean isLevelEmpty;
        do {
            List<?> treeNodes = getTreeLevel(tree, i);
            ListIterator litr = treeNodes.listIterator();
            isLevelEmpty = !litr.hasNext();
            if(!isLevelEmpty) {
                StringBuilder builder = new StringBuilder(i + ". ");
                while (litr.hasNext()) {
                    builder.append(litr.next());
                    if (litr.hasNext()) {
                        builder.append(", ");
                    }
                }
                System.out.println(builder.toString());
            }
            i++;
        } while (!isLevelEmpty);
    }

    static List<?> getTreeLevel(TreeNode<?> tree, int level) {
        List<? super Object> nodeList = new ArrayList<>();
        if (level == 1) {
            nodeList.add(tree.item);
        } else if (level > 1) {
            tree.children.forEach(child -> {
                nodeList.addAll(getTreeLevel((TreeNode) child, level-1));
            });
        }
        return nodeList;
    }

    static void printTree(TreeNode<?> tree) {
        System.out.println(tree.item.toString());
        tree.children.forEach(child -> printTree(child, " "));
    }

    static void printTree(TreeNode<?> tree, String prefix) {
        System.out.println(prefix + tree.item.toString());
        tree.children.forEach(child -> printTree(child, prefix + " "));
    }

    static String getStartingWhitespaces(String string) {
        Boolean nonWhitespaceFound = false;
        Boolean allCharsQueried = false;
        StringBuilder whitespacePreload = new StringBuilder(" ");
        char[] itemChars = string.toCharArray();
        int i = 0;
        do {
            if(i < itemChars.length) {
                nonWhitespaceFound = itemChars[i] != ' ';
                if(!nonWhitespaceFound) {
                    i++;
                    whitespacePreload.append(" ");
                }
            } else {
                allCharsQueried = true;
            }
        } while (!allCharsQueried && !nonWhitespaceFound);
        return   whitespacePreload.toString();
    }

    static List<String> path(TreeNode<?> tree, String value) {
        ArrayList<String> pathElements = new ArrayList<>();
        if(tree.item.equals(value)) {
            pathElements.add(tree.item.toString());
        }
        for(Object node : tree.children) {
            if(!pathElements.isEmpty()) {
                pathElements.add(0, tree.item.toString());
                break;
            }
            pathElements.addAll(path((TreeNode)node, value));
        }
        return pathElements;
    }
}
