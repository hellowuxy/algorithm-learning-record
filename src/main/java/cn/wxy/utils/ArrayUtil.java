package cn.wxy.utils;

/**
 * 操作数组的工具类
 *
 * @autor wxyidea
 * @create 2019-07-02
 **/
public class ArrayUtil {
  /**
   * 打印数组
   *
   * @param arrays
   */
  public static void printArray(int[] arrays){
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int array : arrays) {
      sb.append(array).append(",");
    }
    sb.setCharAt(sb.lastIndexOf(","),']');
    System.out.println(sb.toString());
  }
}
