/*
 * @lc app=leetcode id=772 lang=java
 *
 * [772] Basic Calculator III
 *
 * https://leetcode.com/problems/basic-calculator-iii/description/
 *
 * algorithms
 * Hard (43.48%)
 * Total Accepted:    12.8K
 * Total Submissions: 29.4K
 * Testcase Example:  '"1 + 1"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces  .
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators , open ( and closing parentheses ) and empty spaces  . The integer
 * division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid. All intermediate
 * results will be in the range of [-2147483648, 2147483647].
 * 
 * Some examples:
 * 
 * 
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 * 
 * 
 * 
 * 
 * Note: Do not use the eval built-in library function.
 * 
 */
import java.util.*;
class Solution {
    public int calculate(String s) {
        int result = 0;
        if(s.length() == 0 || s == null)
            return 0;
        String str = s.replaceAll(" ", "");
        char[] strArray = str.toCharArray();
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i = 0; i < strArray.length; i++){
            if(strArray[i] == '('){
                operator.push('(');
                continue;
            }else if(strArray[i] == '-' || strArray[i] == '+'){
                if(operator.peek() == '*' || operator.peek() == '/'){

                }else{
                    operator.push(strArray[i]);
                }
            }else if(strArray[i] - '0' <= 9){
                while(strArray[i+1] - '0')
                operator.push(strArray[i]);
            }
        }
        return result;
    }



    
}

