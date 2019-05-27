package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class MajorityElement {
    //自己实现版本
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        if(nums.length == 1){
            return nums[0];
        }
        for(int num : nums){
            if(map.containsKey(num)){
                if(map.get(num) == nums.length/2){
                    result = num;
                }
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        return result;
    }

    //最优解法

    public int majorityElementBest(int[] nums){
        Arrays.sort(nums);           //排序之后  直接取中间的数
        return nums[nums.length/2];
    }
}
