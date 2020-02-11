package cn.wxy.datastructure.tree.app;

import java.util.Arrays;

/**
 * 堆的应用：求中位数
 *
 * @author hellowuxy
 * @create 2020-02-11
 */
public class Median {

  public static int median(int[] array) {
    int[] heap1, heap2;
    if (array.length % 2 == 0) {
      heap1 = new int[array.length / 2 + 1];
    } else {
      heap1 = new int[array.length / 2 + 1 + 1];
    }
    heap2 = new int[array.length / 2 + 1];

    // sort array
    Arrays.sort(array);

    int index1 = 1, index2 = 1;
    for (int i = 0; i < array.length; i++) {
      if (index1 < heap1.length) {
        heap1[index1] = array[i];

        // 构造大顶堆
        int m = index1;
        while (m / 2 > 0 && heap1[m] > heap1[m / 2]) {
          int tmp = heap1[m];
          heap1[m] = heap1[m / 2];
          heap1[m / 2] = tmp;

          m = m / 2;
        }

        index1++;
      } else {
        heap2[index2] = array[i];

        // 构造小顶堆
        int n = index2;
        while (n / 2 > 0 && heap2[n] < heap2[n / 2]) {
          int tmp = heap2[n];
          heap2[n] = heap2[n / 2];
          heap2[n / 2] = tmp;

          n = n / 2;
        }
        index2++;
      }
    }

    return heap1[1];
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4, 5};
    System.out.println(median(arr1));

    int[] arr2 = {1, 2, 3, 4, 5, 6};
    System.out.println(median(arr2));
  }
}
