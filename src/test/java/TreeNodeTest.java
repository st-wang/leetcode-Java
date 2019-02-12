import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeNodeTest {
    TreeNode tree = new TreeNode(10);

    @Test
    public void can_create_a_bst_root() {

        assertThat(tree).isNotNull();
    }

    @Test
    public void can_create_a_bst() {
        TreeNode treeNode = init(tree);

        treeNode.inOrderTraversal(tree);

        assertThat(tree).isNotNull();
    }


    @Test
    public void can_list_node_values() {
        TreeNode treeNode = init(tree);
        List<Integer> nodeList = treeNode.inOrderTraversalIntoList(treeNode);

        for (Integer i : nodeList) {
            System.out.println(i);
        }

        assertThat(nodeList.isEmpty()).isFalse();
    }

    @Test
    public void widthFirstTraversal() {
        TreeNode treeNode = init(tree);
        List<Integer> nodeList = treeNode.widthFirstTraversal(treeNode);

        for (Integer i : nodeList) {
            System.out.println(i);
        }
    }

    @Test
    public void can_delete_a_node() {
        TreeNode treeNode = init(tree);

        treeNode.deleteNode(tree, 3);

        treeNode.inOrderTraversal(tree);

        assertThat(tree).isNotNull();
    }

    private TreeNode init(TreeNode tree) {
        tree.insertNode(tree, 5);
        tree.insertNode(tree, 2);
        tree.insertNode(tree, 7);
        tree.insertNode(tree, 19);
        tree.insertNode(tree, 11);
        tree.insertNode(tree, 3);

        return tree;
    }

}