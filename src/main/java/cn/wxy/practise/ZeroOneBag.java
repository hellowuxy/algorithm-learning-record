package cn.wxy.practise;

import cn.wxy.utils.AssertUtils;

import java.util.Arrays;

/**
 * 0-1背包问题
 */
public class ZeroOneBag {
  private int[] trace = new int[20]; // 跟踪放置到背包的物品，值为物品编号
  private int index = 0;
  private int maxWeight; // 背包中已放置的物品重量

  public int maxWeight(int[] item, int bagLoadWeight) {
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
    int[] item = {1, 2, 3, 4, 5};
    AssertUtils.assertEqual(7, new ZeroOneBag().maxWeight(item, 7));
  }
}
