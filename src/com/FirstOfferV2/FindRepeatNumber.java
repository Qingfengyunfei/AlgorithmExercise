package com.FirstOfferV2;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题03. 数组中重复的数字 LCOF
 */
public class FindRepeatNumber {
    //思路1：
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
