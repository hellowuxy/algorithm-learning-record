package cn.wxy.algorithms.datastructure.stack.app;

import cn.wxy.datastructure.stack.app.BracketMatch;
import org.junit.Assert;
import org.junit.Test;

public class TestBracketMatch {
    @Test
    public void test() {
        BracketMatch match = new BracketMatch();
        Assert.assertFalse(match.match("{"));
        Assert.assertTrue(match.match("{}"));
        Assert.assertFalse(match.match("{["));
        Assert.assertTrue(match.match("{[]}"));
        Assert.assertFalse(match.match("{[(]}"));
        Assert.assertTrue(match.match("{[()]}"));
        Assert.assertTrue(match.match("{[(213213)]}"));
        Assert.assertTrue(match.match("[[{((((((213213))))))}]]"));
        Assert.assertTrue(match.match(""));
    }
}
