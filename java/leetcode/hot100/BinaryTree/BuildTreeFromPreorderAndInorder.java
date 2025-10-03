package hot100.BinaryTree;

import java.util.HashMap;

public class BuildTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return _buildTree(preorder, 0, preorder.length, 0, map);
    }

    private TreeNode _buildTree(int[] preorder, int p_start, int p_end, int i_start, HashMap<Integer, Integer> map) {
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int root_index = map.get(root_val);
        int leftNum = root_index - i_start;
        root.left = _buildTree(preorder, p_start + 1, p_start + leftNum + 1, i_start, map);
        root.right = _buildTree(preorder, p_start + leftNum + 1, p_end, root_index + 1, map);
        return root;
    }
}
