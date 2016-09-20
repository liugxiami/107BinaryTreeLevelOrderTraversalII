package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    TreeNode root=buildTree();
        List<List<Integer>> res=levelOrderBottom(root);
    }
    //Given a binary tree,return the bottom-up level order traversal of its nodes' values.(ie,from left to right,
    //level by level from leaf to root).
    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> level=new LinkedList<>();
        queue.offer(root);
        level.offer(0);
        int tempLevel=-1;
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            Integer currLevel=level.poll();

            if(tempLevel!=currLevel){
                result.add(new ArrayList<>());
                tempLevel=currLevel;
            }
            result.get(currLevel).add(curr.val);


            if(curr.left!=null){
                queue.offer(curr.left);
                level.offer(currLevel+1);
            }
            if(curr.right!=null){
                queue.offer(curr.right);
                level.offer(currLevel+1);
            }
        }
        Stack<List<Integer>> stack=new Stack<>();
        for (int i = 0; i < result.size(); i++) {
            stack.push(result.get(i));
        }
        for (int i = 0; i < result.size(); i++) {
            result.set(i,stack.pop());
        }

        return result;
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        return root;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
