package com.leetcode;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        //获取行列式的行数
        int row = matrix.length;
        //行数组
        int[] rowlist = null;
        for(int i = 0;i<row;i++){
            rowlist = matrix[i];
            if(searchList(rowlist,target)){
                return true;
            }
        }
        return false;
    }

    /**
     * 二分法查找有序数组中的元素
     * @param list
     * @param target
     * @return
     */
    public static  boolean searchList(int[] list, int target){
        int start = 0;
        int end = list.length-1;
        int middle = 0;
        while (start <= end){
            middle = (start+end)/2;
            if(target > list[middle]){
                start = middle + 1;
            }else if(target < list[middle]){
                end = middle - 1;
            }else{
                return  true;
            }
        }
        return  false;
    }



    /*****************************************************************************/
    public boolean searchMatrixBest(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        //起点为最右上角的元素
        int row = 0, col = matrix[0].length - 1;
        //判断当前数组元素和target，如果当前大于target，往左走；小与target，往下走
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] < target){
                row++;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                return true;
            }
        }
        //走出边界了还没找到，说明不存在，返回false
        return false;
    }

}
