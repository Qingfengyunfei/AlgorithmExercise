package com.FirstLeetcode.EasyQuestion;

import java.util.Stack;

/**
 * @author Administrator
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @create 2019/6/13 15:17
 * @since 1.0.0
 */
public class Valid_Parentheses_20 {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length();i++){
            char a = s.charAt(i);
            if(st.isEmpty() || isLeftChar(a)){
                st.push(a);
            }else if(!isMatched(st.pop(),a)){
                return false;
            }
        }
        return st.isEmpty();
    }

    public static Boolean isLeftChar(char left){
        if(left == '(' || left=='[' || left=='{') return true;
        else return false;
    }

    public static Boolean isMatched(char left, char right){
        if(left == '(' && right==')'){
            return true;
        }else if(left == '[' && right==']'){
            return true;
        }else if(left == '{' && right=='}'){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * 思路：栈 完美解决
 */

/**
 时间复杂度：O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1)O(1) 的推入和弹出操作。
 空间复杂度：O(n)，当我们将所有的开括号都推到栈上时以及在最糟糕的情况下，我们最终要把所有括号推到栈上。
 */

/*一种容易理解的思路*/


/*public boolean isValid(String s) {

    while (s.contains("{}")||s.contains("[]")|| s.contains("()")){

        if(s.contains("{}")) s=s.replace("{}","");
        if(s.contains("()")) s=s.replace("()","");
        if(s.contains("[]")) s=s.replace("[]","");

    }

    return s.isEmpty();
}*/


/** map key反序放入 )]}  value ([{  判断字符是否是右括号  如果是  看栈是否为空 非空取出一个元素
 *  与map中对应key的value比较是否一致
 *
 * // Hash table that takes care of the mappings.
 *   private HashMap<Character, Character> mappings;
 *
 *   // Initialize hash map with mappings. This simply makes the code easier to read.
 *   public Solution() {
 *     this.mappings = new HashMap<Character, Character>();
 *     this.mappings.put(')', '(');
 *     this.mappings.put('}', '{');
 *     this.mappings.put(']', '[');
 *   }
 *
 *   public boolean isValid(String s) {
 *
 *     // Initialize a stack to be used in the algorithm.
 *     Stack<Character> stack = new Stack<Character>();
 *
 *     for (int i = 0; i < s.length(); i++) {
 *       char c = s.charAt(i);
 *
 *       // If the current character is a closing bracket.
 *       if (this.mappings.containsKey(c)) {
 *
 *         // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
 *         char topElement = stack.empty() ? '#' : stack.pop();
 *
 *         // If the mapping for this bracket doesn't match the stack's top element, return false.
 *         if (topElement != this.mappings.get(c)) {
 *           return false;
 *         }
 *       } else {
 *         // If it was an opening bracket, push to the stack.
 *         stack.push(c);
 *       }
 *     }
 *
 *     // If the stack still contains elements, then it is an invalid expression.
 *     return stack.isEmpty();
 *   }
 *
 */
