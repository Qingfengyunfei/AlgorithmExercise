package com.FirstLeetcode.Array.Medium;

public class MaxArea_11 {
    public static int maxArea(int[] height) {
        //1.暴力法  时间复杂度 O(n^2)
//        int maxArea = 0;
//        for(int i=0;i<height.length-1;i++){
//            for(int j=i+1;j<height.length;j++){
//                int result = (j-i)*(height[i]>height[j]?height[j]:height[i]);
//                maxArea = maxArea>result?maxArea:result;
//            }
//        }
//        return maxArea;

        //2.双指针法   时间复杂度 O(n)

        int maxArea = 0;
        int left = 0;
        int right = height.length -1;
        while(left<right){
            maxArea = Math.max(maxArea, ((right-left)*Math.min(height[left],height[right])));
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4};
        System.out.println(maxArea(height));
    }
}
