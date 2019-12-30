package cn.wxy.algorithms.datastructure.stack.app;

import cn.wxy.datastructure.stack.app.ExpressionEvaluation;
import org.junit.Assert;
import org.junit.Test;

public class TestExpressionEvaluation {

    @Test
    public void test() {
        ExpressionEvaluation evaluation = new ExpressionEvaluation();
        Assert.assertEquals(6, evaluation.compute("1+2+3"));
        Assert.assertEquals(2, evaluation.compute("1+2+3-4"));
        Assert.assertEquals(6, evaluation.compute("1*2*3"));
        Assert.assertEquals(1, evaluation.compute("1*2/2"));
        Assert.assertEquals(4, evaluation.compute("1+2*2-1"));
        Assert.assertEquals(4, evaluation.compute("1+2*2-1/1"));
    }
}
