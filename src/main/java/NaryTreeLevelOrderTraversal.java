import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

public class NaryTreeLevelOrderTraversal {

    // Given an n-ary tree, return the level order traversal of its nodes' values.
    // (ie, from left to right, level by level).
    // For example, given a 3-ary tree:
    // {"$id":"1","children":[{"$id":"2","children":[{"$id":"3","children":[],"val":5},
    // {"$id":"4","children":[],"val":6}],"val":3},{"$id":"5","children":[],"val":2},
    // {"$id":"6","children":[],"val":4}],"val":1}
    // We should return its level order traversal:
    //     [1],
    //     [3,2,4],
    //     [5,6]

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return asList();
        }

        List<List<Integer>> nodeList = new ArrayList<>();
        nodeList.add(asList(root.val));

        return addChildren(nodeList, root);
    }

    private List<List<Integer>> addChildren(List<List<Integer>> list, Node root) {
        if (root.children == null) {
            return list;
        } else {

            List<Integer> newLevel = root.children.stream().map(node -> node.val).collect(toList());

            //if (!newLevel.isEmpty()) {
                list.add(newLevel);
            //}

            List<Node> childrenOfChildren = new ArrayList<>();

            for (Node node: root.children) {
                childrenOfChildren.addAll(node.children);
            }

            for (Node node: childrenOfChildren) {
                return addChildren(list, node);
            }
        }

        return list;
    }

    public List<List<Integer>> realLevelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();

        if (root == null) {
            return asList();
        }

        List<List<Integer>> nodeList = new ArrayList<>();
        nodeList.add(asList(root.val));

        return addChildren(nodeList, root);
    }
}
