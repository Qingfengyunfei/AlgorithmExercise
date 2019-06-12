package com.FirstLeetcode.EasyQuestion;

/**
 * @author Administrator
 * @descirption 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * @create 2019/6/13 0:15
 * @since 1.0.0
 */
public class Palindrome_Number_9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 ==0 && x != 0)) return false;
        int reverseNum = 0;
        while (x > reverseNum){
            int pop = x % 10;
            reverseNum = reverseNum * 10 + pop;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum /10;

    }
}

/**
 * 思路 ：负数：非回文
 *       末尾为0  只有 原数为0 才是回文
 *       对一半的数字进行翻转操作  当 一半的回文数字大于 原数多次/10之后的（剩余一半）大小 时跳出循环 说明已经算到一半了
 *       奇数 ： 多计算一次 x/10 后的数比较和回文是否相等  偶数 ： 直接比较是否相当
 *
 */

/**
 * 时间复杂度：O(log10(n))
 * 对于每次迭代，我们会将输入除以10，因此时间复杂度为 O(log10(n))
 * 空间复杂度：O(1)。
 */
