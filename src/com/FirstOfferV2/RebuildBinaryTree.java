package com.FirstOfferV2;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class RebuildBinaryTree {

    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    //定义全局变量 减少递归函数入参
    int[] p;


    /**
     * 时间复杂度 O(N) ：N 为树的节点数量。初始化 HashMap 需遍历 inorder ，占用 O(N) ；递归共建立 N 个节点，每层递归中的节点建立、搜索操作占用 O(1) ，因此递归占用 O(N) 。
     * （最差情况为所有子树只有左节点，树退化为链表，此时递归深度 O(N) ；平均情况下递归深度 O(log_2 N)
     *
     * 空间复杂度 O(N) ： HashMap 使用 O(N)额外空间；递归操作中系统需使用 O(N)额外空间。

     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        p = preorder;
        //使用HashMap 存储中序遍历的元素 以及下标 方便查找对应下标
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTreeNode(0,0,inorder.length-1);

    }

    /**
     * 递归生成树
     * @param root  前序遍历的根节点下标
     * @param leftborder  子树的左边界
     * @param rightborder  子树的右边界
     * @return
     */
    TreeNode buildTreeNode (int root ,int leftborder, int rightborder){
        //左边界 大于 右边界终止
        if(leftborder > rightborder){
            return null;
        }
        //插入根节点
        TreeNode t = new TreeNode(p[root]);
        //根据根节点 查找对应中序遍历中对应根节点的下标
        int rootidx = map.get(p[root]);
        //左子树 根节点：前序遍历中当前根节点元素的 下一个元素
        //       左边界：当前中序遍历左边界
        //       右边界: 当前中序遍历中根节点下标的 前一个元素
        t.left = buildTreeNode(root+1,leftborder,rootidx-1);
        //右子树  根节点：前序遍历中当前根节点元素 + 左子树长度（左子树长度 = 中序遍历中根节点的下标序号 - 当前左子树边界） + 1
        //              （再加1才表示前序遍历中右子树的第一个元素 即右子树的根节点）
        //       左边界：当前中序遍历中根节点下标的 后一个元素
        //       右边界: 当前中序遍历右边界
        t.right = buildTreeNode(root+(rootidx-leftborder)+1,rootidx+1,rightborder);
        return t;

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
