package cn.wxy.practise;

import cn.wxy.utils.AssertUtils;

import java.util.Arrays;

/**
 * 贪心算法的应用： 0-1背包问题.
 * 更加高效地一种解法
 */
public class ZeroOneBag1 {

  private int[] item;
  private int bagLoadWeight;
  private int[] trace;
  private int traceIndex = 0;
  private int maxWeight = Integer.MIN_VALUE;
  private boolean[][] note;

  public ZeroOneBag1(int[] item, int bagLoadWeight) {
    this.item = item;
    this.bagLoadWeight = bagLoadWeight;
    trace = new int[(int) Math.pow(2, item.length)];
    note = new boolean[item.length][bagLoadWeight + 1];
  }

  /**
   * 求背包能容纳的最大重量
   *
   * @return 最大重量
   */
  public int maxWeight() {
    put(item, 0, 0, bagLoadWeight);
    System.out.println(Arrays.toString(trace));
    return maxWeight;
  }

  private void put(int[] item, int itemIndex, int currentWeight, int bagLoadWeight) {
    if (itemIndex == item.length || currentWeight == bagLoadWeight) {
      if (maxWeight < currentWeight)
        maxWeight = currentWeight;
      return;
    }

    if (note[itemIndex][currentWeight])
      return;

    note[itemIndex][currentWeight] = true;

    put(item, itemIndex + 1, currentWeight, bagLoadWeight);
    if (currentWeight + item[itemIndex] <= bagLoadWeight) {
      trace[traceIndex++] = itemIndex;
      put(item, itemIndex + 1, currentWeight + item[itemIndex], bagLoadWeight);
    }
  }

  public static void main(String[] args) {
    AssertUtils.assertEqual(7, new ZeroOneBag1(new int[]{1, 2, 3, 4, 5}, 7).maxWeight());
    AssertUtils.assertEqual(9, new ZeroOneBag1(new int[]{2, 2, 4, 6, 3}, 9).maxWeight());
  }
}
