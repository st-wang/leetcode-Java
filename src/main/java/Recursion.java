import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.String.valueOf;

public class Recursion {

    // n! = 1 * 2 * ... * (n - 1) * n
    //    = (n - 1)! * n
    public int factorial (int n) {
        if (n == 0 || n == 1) return 1;

        return n * factorial(n - 1);
    }


    // F(1) = 1
    // F(2) = 2
    // F(n) = F(n - 2) + F(n - 1)
    public int fibonacci (int n) {
        if (n == 0 || n == 1) return n;

        return fibonacci(n - 2) + fibonacci(n - 1);
    }


    // 从n个不同的元素中任取m(m <= n)个, 按照一定的顺序排列起来,
    // 叫做从n个元素中取出m个元素的一个排列 -> Amn
    // 当m=n时,所有的排列情况叫做全排列 -> Ann
    // 1 permutation("abcd") = "a" + 1 permutation("bcd")
    //                       = "a" + "b" + 1 permutation("cd")
    //                       = "a" + "b" + "c" + permutation("d")
    //                       = "a" + "b" + "c" + "d"
    public List<String> permutation (String s) {
        if (s.length() == 1) {
            return Arrays.asList(s);
        }

        List<String> permutation = new ArrayList<>();
        List<String> latestPermutation = permutation(s.substring(0, s.length() - 1));
        String lastCharInString = String.valueOf(s.charAt(s.length() - 1));

        for (String permutedString: latestPermutation) {
            for (int i = 0; i < permutedString.length(); i++) {
                StringBuilder stringBuilder = (new StringBuilder(permutedString)) //
                        .insert(i, lastCharInString);
                permutation.add(stringBuilder.toString());
            }
            permutation.add(permutedString + lastCharInString);
        }

        return permutation;
    }


    // 从n个不同的元素中任取m(m <= n)个, 若不考虑顺序, 叫做从n个元素中取出m个元素的一个组合, 记为Cmn
    // combination("abc") = "a" ∏ combination("bc")
    //                    = "a" ∏ ("b" ∏ combination("c"))
    //                    = "a" ∏ ("b" ∏ ("c", "")))
    //                    = "a" ∏ ("b"("c", ""), ("c", ""))
    //                    = "a" ∏ ("bc", "b", "c", "")
    //                    = "a"("bc", "b", "c", ""), ("bc", "b", "c", "")
    //                    = "abc", "ab", "ac", "a", "bc", "b", "c", ""
    public List<String> combination(String s) {
        List<String> combination = new ArrayList<>();

        if (s.length() == 0) {
            combination.add("");
            return combination;
        }

        if (s.length() == 1) {
            combination.add(s);
            combination.add("");
            return combination;
        }

        List<String> latestCombination = combination(s.substring(1));
        combination.addAll(latestCombination);

        String firstCharInString = String.valueOf(s.charAt(0));

        for (String combinedString: latestCombination) {
            combination.add(firstCharInString + combinedString);
        }

        return combination;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }


    // Get depth of a BiTree
    public int getBiTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getBiTreeDepth(root.left) + 1, getBiTreeDepth(root.right) + 1);
    }


    // Find if a BiTree is balanced
    // 一颗平衡的二叉树是指其任意结点的左右子树深度之差不大于1
    public boolean isBiTreeBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (getDepthDiffOfChildren(root) > 1) {
            return false;
        }

        return isBiTreeBalanced(root.left) && isBiTreeBalanced(root.right);
    }

    private int getDepthDiffOfChildren (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepthDiffOfChildren(root.left) + 1;
        int rightDepth = getDepthDiffOfChildren(root.right) + 1;

        return Math.abs(leftDepth - rightDepth);
    }


    // Print reverse a string
    public String reverseString(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }

    public String reverseStringRecursion(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }

        String latestReverse = reverseStringRecursion(s.substring(1));
        return latestReverse + String.valueOf(s.charAt(0));
    }
}
