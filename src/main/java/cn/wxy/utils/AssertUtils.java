package cn.wxy.utils;

/**
 * @author hellowuxy
 * @create 2020-01-05
 */
public class AssertUtils {
  public static void assertEqual(int expected, int actual) {
    if (expected != actual) {
      throw new AssertionError("assert failed,expected is " + expected + ",but actual is " + actual);
    }
  }

  private static class AssertionError extends Error {
    public AssertionError() {
      super();
    }

    public AssertionError(String message) {
      super(message);
    }
  }
}
