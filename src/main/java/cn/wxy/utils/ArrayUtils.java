package cn.wxy.utils;

/**
 * 操作数组的工具类
 *
 * @autor wxyidea
 * @create 2019-07-02
 **/
public class ArrayUtils {
    /**
     * 打印数组
     *
     * @param arrays
     */
    public static void printArray(int[] arrays) {
        if (arrays.length == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arrays.length; i++) {
            sb.append(arrays[i]).append(",");
        }
        sb.setCharAt(sb.lastIndexOf(","), ']');
        System.out.println(sb.toString());
    }

    /**
     * 打印指定长度的数组 arrays[0]~arrays[length-1]
     *
     * @param arrays 数组
     * @param length 长度
     */
    public static void printArray(int[] arrays, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length; i++) {
            sb.append(arrays[i]).append(",");
        }
        sb.setCharAt(sb.lastIndexOf(","), ']');
        System.out.println(sb.toString());
    }
}
