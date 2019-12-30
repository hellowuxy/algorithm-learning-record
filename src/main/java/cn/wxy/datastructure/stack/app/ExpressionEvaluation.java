package cn.wxy.datastructure.stack.app;

import cn.wxy.datastructure.stack.ArrayStack;

/**
 * 栈的应用-表达式求值，假设运算符只有+ - * / 四种
 */
public class ExpressionEvaluation {
    /**
     * 表达式求值
     *
     * @param expression
     * @return
     */
    public int compute(String expression) {
        ArrayStack<Integer> digit = new ArrayStack<>();
        ArrayStack<Character> operator = new ArrayStack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= '0' && ch <= '9') {
                digit.push(ch - '0');
            } else if (ch == '+' || ch == '-') {
                Character op = operator.pop();
                // 第一个运算符必须进栈，因为此时操作数栈中只有1个数
                if (op == null) {
                    operator.push(ch);
                    continue;
                }

                int b = digit.pop();
                int a = digit.pop();
                digit.push(compute(a, b, op));

                operator.push(ch);
            } else if (ch == '*' || ch == '/') {
                Character op = operator.pop();
                // 第一个运算符必须进栈，因为此时操作数栈中只有1个数
                if (op == null) {
                    operator.push(ch);
                    continue;
                }

                if (op == '+' || op == '-') {
                    operator.push(op);
                } else {
                    int b = digit.pop();
                    int a = digit.pop();
                    digit.push(compute(a, b, op));
                }
                operator.push(ch);
            } else {
                throw new IllegalArgumentException("字符串不是有效的表达式");
            }
        }

        while (operator.size() != 0) {
            char op = operator.pop();
            int b = digit.pop();
            int a = digit.pop();
            digit.push(compute(a, b, op));
        }
        return digit.pop();
    }

    public int compute(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else if (op == '/') {
            return a / b;
        }
        throw new IllegalArgumentException("操作符非法，必须是[+ - * /]其中之一");
    }
}
