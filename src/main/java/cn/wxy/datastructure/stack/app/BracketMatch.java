package cn.wxy.datastructure.stack.app;

import cn.wxy.datastructure.stack.ArrayStack;

/**
 * 栈的应用-括号匹配，假设只有{}[]()三种括号
 */
public class BracketMatch {
    /**
     * 括号匹配，假设只有{}[]()三种括号
     *
     * @param bracketExpr
     * @return true-匹配, false-不匹配
     */
    public boolean match(String bracketExpr) {
        ArrayStack<Character> stack = new ArrayStack<>(bracketExpr.length());
        for (int i = 0; i < bracketExpr.length(); i++) {
            char ch = bracketExpr.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}') {
                Character last = stack.pop();
                if (last == null) {
                    return false;
                }
                if (last != '{') {
                    return false;
                }
            } else if (ch == ']') {
                Character last = stack.pop();
                if (last == null) {
                    return false;
                }
                if (last != '[') {
                    return false;
                }
            } else if (ch == ')') {
                Character last = stack.pop();
                if (last == null) {
                    return false;
                }
                if (last != '(') {
                    return false;
                }
            }
        }

        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
