// Name: Monisha Jain
// Qualification: MCA


// Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of all nodes of each level from left to right in separate sub-arrays.


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LeveLOrderTraversal {
    public List<List<Integer>> LeveLOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.remove();
                currentLevel.add(temp.val);
                if(temp.left != null) 
                    queue.add(temp.left);
                if(temp.right != null) 
                    queue.add(temp.right);
            }
            result.add(currentLevel);
        }

        return result;        
    }

    public static void main(String[] args) {
    LeveLOrderTraversal sol = new LeveLOrderTraversal();
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = sol.LeveLOrderTraversal(root);
    System.out.print("Level order traversal: " + result);
  }
}


//  TC -> The TC is O(N), where 'N' is the total number of nodes in the tree as we traverse each node oncel

// SC -> O(N) to return list containing the level order traversal. 
// we also need O(N) space for the queue. Since we can have a maximum of N / 2 nodes at any level at the lowest level, henceforth we will need O(N) space to store them in the queue.
