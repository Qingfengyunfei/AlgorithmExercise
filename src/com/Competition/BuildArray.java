package com.Competition;


import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 *
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 *
 * 请使用下述操作来构建目标数组 target ：
 *
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 *
 * 请返回构建目标数组所用的操作序列。
 *
 * 题目数据保证答案是唯一的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 * 示例 2：
 *
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 * 示例 3：
 *
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 * 示例 4：
 *
 * 输入：target = [2,3,4], n = 4
 * 输出：["Push","Pop","Push","Push","Push"]
 *  
 *
 * 提示：
 *
 * 1 <= target.length <= 100
 * 1 <= target[i] <= 100
 * 1 <= n <= 100
 * target 是严格递增的
 *
 */
public class BuildArray {
    /**
     * 因为是按照顺序的target 指针(下标)j 和 长度为n的 nlist 指针(下标) i
     * 顺寻遍历后者 两个数组中对应元素 target的位置j元素只能大于或者等于nlist对应i位置
     *
     * 1.如果大于 则说明当前nlist对应i位置等元素 不在target数组中 需要进行Push 之后 Pop
     * 2.如果等于 则说明在target数组中 仅需要Push即可 然后将target的指针j 向后移动一位
     * 3.判断终止条件 j是不是已经到了target最后一位
     *
     * 因为是j++操作最后一次多加了1次 所以判断 j = target.length 而不是 target.length-1
     * 时间复杂度 O(n) 空间复杂度O(1)
     * @param target
     * @param n
     * @return
     */
    public List<String> buildArray(int[] target, int n) {
        int l = target.length;
        List<String> sl = new ArrayList<String>();
        int j = 0;
        for(int i = 1; i<=n;i++){
            if(i < target[j] ){  // 1.不在target中
                sl.add("Push");
                sl.add("Pop");
            }else{    //2.在target中
                sl.add("Push");
                j++;
                if(j == l){ //3. 终止条件
                    break;
                }
            }
        }
        return sl;
    }

}
