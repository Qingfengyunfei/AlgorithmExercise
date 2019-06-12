package com.FirstLeetcode.EasyQuestion;

/**
 * @author Administrator
 * @descirption 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @create 2019/6/12 23:05
 * @since 1.0.0
 */
public class Reverse_Integer_7 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

/**
 * 思路： %10 取出每一末尾数值 pop   计算rev 结果  rev = rev*10 + pop   此处可能会溢出 需要在其前面加判断
 * 判断  最大最小Intger 值 /10 后的值 如果rev超过  直接返回0  如果相等需要判断  下一位pop 是否 大于 或 小于 -8
 * MAX_VALUE ： 2147483647    MIN_VALUE：-2147483648
 */
