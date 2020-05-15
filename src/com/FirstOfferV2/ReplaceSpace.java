package com.FirstOfferV2;

/**
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 */
public class ReplaceSpace {
    /**
     * 使用StringBuilder 拼接字符串替换空格
     * 时间复杂度：o(n)  空间复杂度：o(n)
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        StringBuilder stb = new StringBuilder();
        for(Character c : s.toCharArray()){
            if(c == ' ') stb.append("%20");
            else stb.append(c);
        }
        return stb.toString();
    }

    /**
     * 不使用额外string进行
     * 时间复杂度：o(n)  空间复杂度：o(n)
     */
    public String replaceSpace2(String s){
        char[] c = s.toCharArray();
        char[] cnew = new char[c.length*3];
        int size = 0;
        for(int i = 0;i<c.length;i++){
            if(c[i] == ' '){
                cnew[size++] = '%';
                cnew[size++] = '2';
                cnew[size++] = '0';
            }else {
                cnew[size++] = c[i];
            }
        }
        return new String(cnew ,0,size);
     }
}
