package cn.wxy.datastructure.tree;

import cn.wxy.utils.ArrayUtils;

/**
 * @author hellowuxy
 * @create 2020-02-10
 */
public class Heap {
  private int[] data;
  private int capacity;
  private int index;

  public Heap(int capacity) {
    this.capacity = capacity + 1;
    data = new int[this.capacity];
  }

  public void insert(int ele) {
    if (index == capacity - 1) {
      // heap is full
      return;
    }
    data[++index] = ele;
    int i = index;
    while (i / 2 > 0 && data[i] > data[i / 2]) {
      int tmp = data[i];
      data[i] = data[i / 2];
      data[i / 2] = tmp;

      i = i / 2;
    }
  }

  /**
   * 移除堆定元素
   */
  public void removeTop() {
    if (index <= 0) {
      return;
    }
    data[1] = data[index];
    data[index--] = 0;

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

      int tmp = data[maxPos];
      data[maxPos] = data[i];
      data[i] = tmp;
      i = maxPos;
    }
  }

  public void print() {
    ArrayUtils.printArray(this.data);
  }

  public static void main(String[] args) {
    Heap heap = new Heap(10);
    for (int i = 1; i <= 12; i++) {
      heap.insert(i);
    }
    heap.print();

    heap.removeTop();
    heap.print();

    heap.removeTop();
    heap.print();
  }
}
