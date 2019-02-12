import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v) {
        this.val = v;
    }

    public TreeNode insertNode(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left = insertNode(root.left, value);
        } else if (value > root.val) {
            root.right = insertNode(root.right, value);
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.val) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.val) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            int minRightChildVal = root.val;
            TreeNode currentNode = root.right;

            while (currentNode.left != null) {
                minRightChildVal = currentNode.left.val;
                currentNode = currentNode.left;
            }

            root = deleteNode(root.right, minRightChildVal);
        }

        return root;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    public void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
        }
    }

    public List<Integer> inOrderTraversalIntoList(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        } else {
            list.addAll(inOrderTraversalIntoList(root.left));
            list.add(root.val);
            list.addAll(inOrderTraversalIntoList(root.right));
        }

        //nodeValueList.addAll(list);
        return list;
    }

    public List<Integer> widthFirstTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();

        if (root == null) {
            return nodeList;
        }

        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        TreeNode node;

        while (!queue.isEmpty()) {
            node = queue.poll();
            nodeList.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            else if (node.right != null) {
                queue.add(node.right);
            }
        }

        return nodeList;
    }
}
