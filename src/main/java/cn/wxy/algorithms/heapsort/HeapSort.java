package cn.wxy.algorithms.heapsort;

import cn.wxy.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author hellowuxy
 * @create 2020-02-10
 */
public class HeapSort {
  private int[] data;
  private int capacity;
  private int index;

  public HeapSort(int capacity) {
    this.capacity = capacity;
    data = new int[this.capacity];
  }

  public void insert(int ele) {
    if (index == capacity - 1) {
      return;
    }
    data[++index] = ele;

    int i = index;
    while (i > 0 && i / 2 > 0 && data[i] > data[i / 2]) {
      int tmp = data[i];
      data[i] = data[i / 2];
      data[i / 2] = tmp;

      i = i / 2;
    }
  }

  public int[] sort() {
    while (index > 1) {
      int tmp = data[index];
      data[index] = data[1];
      data[1] = tmp;
      index--;

      heapify(data, index);
    }
    return Arrays.copyOfRange(data, 1, capacity);
  }

  private void heapify(int[] data, int index) {
    int i = 1;
    while (true) {
      int maxPos = i;
      if (i * 2 <= index && data[i] < data[i * 2]) {
        maxPos = i * 2;
      }
      if (i * 2 + 1 <= index && data[maxPos] < data[i * 2 + 1]) {
        maxPos = i * 2 + 1;
      }

      if (maxPos == i) {
        break;
      }

      // swap
      int tmp = data[maxPos];
      data[maxPos] = data[i];
      data[i] = tmp;
      i = maxPos;
    }
  }

  public static void main(String[] args) {
    HeapSort heapSort = new HeapSort(10);
    for (int i = 1; i <= 10; i++) {
      heapSort.insert(i);
    }

    int[] sortedData = heapSort.sort();
    ArrayUtils.printArray(sortedData);
  }
}
