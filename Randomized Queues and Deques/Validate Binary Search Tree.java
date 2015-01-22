/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution{
	public boolean isValidBST(TreeNode root){
		if(root==null) return true;
		return isValidBST(root,Integer.MAX_VALUE,MIN_VALUE);
	}
	public boolean isValidBST(TreeNode root, int max, int min){
		if(root==null) return true;
		if(root.val>=max || root.val<=min) return false;
		return isValidBST(root.left,root.val,min)&&isValidBST(root.right,max,root.val);
	}
}