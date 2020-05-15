package com.FirstOfferV2;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题03. 数组中重复的数字 LCOF
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 *
 * 限制：
 *
 * 2 <= n <= 100000
 */
public class FindRepeatNumber {
    //思路1：

    /**
     * 时间复杂度：o(n)  空间复杂度 o(n)
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums){
        int result = -1;
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if(!set.add(i)){
                //Set 添加不成功 则是重复数据
                result = i;
                break;
            }
        }
        return result;
    }

    //思路2

    /**
     * 通过本身做哈希冲突检测
     * 时间复杂度：o(n)  空间复杂度 o(1)
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int j = nums.length;
        for(int i=0 ;i<j;i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
