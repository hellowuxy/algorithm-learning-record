package cn.wxy.selectsort;

/**
 * 选择排序算法，算法思想如下：
 * <p>（1）找到数组中最小的元素，和数组中第一个位置的元素交换；</p>
 * <p>（2）从剩余元素中找到最小的元素，和数组中第二个位置的元素交换；</p>
 * <p>（3）如此重复，直到整个数组有序。</p>
 *
 * 该算法时间复杂度为<tt>O(n^2)</tt>，空间复杂度为<tt>O(1)</tt>
 *
 * @autor Wuxiaoyuan
 * @create 2019-06-28
 **/
public class SelectSort {

  /**
   * 使用选择排序法，将数组<tt>array</tt>按照从小到大的顺序排序
   *
   * @param array 待排序的数组
   */
  public static void selectSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      // 本轮比较中最小的元素
      int min = array[i];
      // 本轮比较中最小的元素对应的下标
      int minIndex = i;

      for (int j = i + 1; j < array.length; j++) {
        if (min > array[j]) {
          min = array[j];
          minIndex = j;
        }
      }
      int temp = array[i];
      array[i] = min;
      array[minIndex] = temp;
    }
  }

  public static void main(String[] args) {
    int[] array = {3, 1, 6, 2, 0, 9, 20, 10, 11};
    selectSort(array);
    StringBuilder sb = new StringBuilder();
    for (int cur : array) {
      sb.append(cur).append(",");
    }
    System.out.println(sb.toString().substring(0, sb.toString().length() - 1));

  }

}
