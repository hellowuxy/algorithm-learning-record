package cn.wxy.datastructure.tree.app;

import cn.wxy.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆的应用： top N 问题
 *
 * @author hellowuxy
 * @create 2020-02-11
 */
public class TopN {

  /**
   * 求静态数据的 top 5
   *
   * @param array
   * @return
   */
  public static int[] top5OfStaticData(int[] array) {
    int[] heap = new int[6];
    int index = 0;

    for (int value : array) {
      if (index < 5) {
        heap[++index] = value;

        // 构建小顶堆
        int m = index;
        while (m / 2 > 0 && heap[m] < heap[m / 2]) {
          int tmp = heap[m];
          heap[m] = heap[m / 2];
          heap[m / 2] = tmp;
          m = m / 2;
        }

        continue;
      }

      if (value > heap[1]) {
        heap[1] = value;
        // 构建小顶堆
        int m = 1;
        while (true) {
          int minPos = m;
          if (m * 2 < 6 && heap[m] > heap[m * 2]) minPos = m * 2;
          if (m * 2 + 1 < 6 && heap[minPos] > heap[m * 2 + 1]) minPos = m * 2 + 1;

          if (m == minPos) break;

          int tmp = heap[minPos];
          heap[minPos] = heap[m];
          heap[m] = tmp;

          m = minPos;
        }
      }
    }

    return Arrays.copyOfRange(heap, 1, 6);
  }

  /**
   * 求动态变化的数据 top 5
   *
   * @param value
   */
  public static void top5OfDynamicData(int[] heap, int value) {
    if (heap[1] < value) {
      heap[1] = value;
    } else {
      return;
    }

    // 重构小顶堆
    int i = 1;
    while (true) {
      int minPos = i;
      if (i * 2 < heap.length && heap[i] > heap[i * 2]) minPos = i * 2;
      if (i * 2 + 1 < heap.length && heap[i * 2 + 1] < heap[minPos]) minPos = i * 2 + 1;

      if (minPos == i) {
        break;
      }

      int tmp = heap[minPos];
      heap[minPos] = heap[i];
      heap[i] = tmp;

      i = minPos;
    }
  }

  public static void main(String[] args) {
    Random random = new Random();
    int[] array = new int[50];
    // 构建一个大小为50的数组
    for (int i = 0; i < 50; i++) {
      array[i] = random.nextInt(100);
    }
    ArrayUtils.printArray(array);

    // 静态数据top5
    int[] data = top5OfStaticData(array);
    ArrayUtils.printArray(data);

    // 动态数据top5
    int[] heap = new int[6];
    System.arraycopy(data, 0, heap, 1, 5);
    for (int i = 0; i < 10; i++) {
      int value = random.nextInt(100);
      System.out.println(value);
      top5OfDynamicData(heap, value);
      ArrayUtils.printArray(Arrays.copyOfRange(heap, 1, 6));
    }

  }
}
