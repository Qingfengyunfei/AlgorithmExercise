package com.FirstOfferV2;

import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */
public class ReversePrint {

    /**
     * 复杂度分析：
     * 时间复杂度 O(N)： 入栈和出栈共使用 O(N) 时间。
     * 空间复杂度 O(N)： 辅助栈 stack 和数组 res共使用 O(N)的额外空间
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public int[] reversePrint(ListNode head) {
        Stack<Integer> st = new Stack<Integer>();
        while(head != null){
            st.push(head.val);
            head = head.next;
        }
        int[] res = new int[st.size()];
        for(int i = 0;i<st.size();i++){
            res[i] = st.pop();
        }
        return res;
    }
}
