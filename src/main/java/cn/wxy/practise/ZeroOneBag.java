package cn.wxy.practise;

import cn.wxy.utils.AssertUtils;

import java.util.Arrays;

/**
 * 回溯算法的应用： 0-1背包问题
 */
public class ZeroOneBag {
  private int[] item;
  private int bagLoadWeight;
  private int[] trace; // 跟踪放置到背包的物品，值为物品编号
  private int index = 0;
  private int maxWeight = Integer.MIN_VALUE;

  public ZeroOneBag(int[] item, int bagLoadWeight) {
    this.item = item;
    this.bagLoadWeight = bagLoadWeight;
    trace = new int[(int) Math.pow(2, item.length)];
  }

  /**
   * 求背包能容纳的最大重量
   *
   * @return 最大重量
   */
  public int maxWeight() {
    put(item, item.length, 0, 0, bagLoadWeight);
    System.out.println(Arrays.toString(trace));
    return maxWeight;
  }

  /**
   * @param item          物品重量的数组，下标表示物品编号，值表示物品重量
   * @param length        数组长度
   * @param i             当前检索的物品编号，i>=0&&i<length
   * @param curWeight     当前背包中的物品重量
   * @param bagLoadWeight 背包的最大承重
   */
  private void put(int[] item, int length, int i, int curWeight, int bagLoadWeight) {
    if (i == length || curWeight == bagLoadWeight) { // 已考察完所有物品，或者背包中物品重力达到最大值
      if (curWeight > maxWeight) maxWeight = curWeight;
      return;
    }
    put(item, length, i + 1, curWeight, bagLoadWeight); // 当前物品不放入背包

    if (item[i] + curWeight <= bagLoadWeight) {
      trace[index++] = i;
      put(item, length, i + 1, curWeight + item[i], bagLoadWeight); // 当前物品放入背包
    }
  }

  public static void main(String[] args) {
    AssertUtils.assertEqual(7, new ZeroOneBag(new int[]{1, 2, 3, 4, 5}, 7).maxWeight());
    AssertUtils.assertEqual(9, new ZeroOneBag(new int[]{2, 2, 4, 6, 3}, 9).maxWeight());
  }
}
