package cn.wxy.practise;

import cn.wxy.utils.AssertUtils;

/**
 * 动态规划，解决 0-1背包问题
 */
public class ZeroOneBag2 {

  public int getMaxWeight(int[] itemWeight, int bagLoadWeight) {
    return doGetMaxWeight(itemWeight, itemWeight.length, bagLoadWeight);
  }

  /**
   * @param itemWeight    物品重量数组
   * @param n             物品个数
   * @param bagLoadWeight 背包的载重
   * @return 背包内能放置的物品的最大重量
   */
  private int doGetMaxWeight(int[] itemWeight, int n, int bagLoadWeight) {
    boolean[][] states = new boolean[n][bagLoadWeight + 1];
    states[0][0] = true;
    if (itemWeight[0] < bagLoadWeight) { // 处理第一行数据
      states[0][itemWeight[0]] = true;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= bagLoadWeight; j++) { // 第i个物品不放入背包
        if (states[i - 1][j]) states[i][j] = true;
      }
      for (int j = 0; j <= bagLoadWeight - itemWeight[i]; j++) { // 第i个物品放入背包
        if (states[i - 1][j]) states[i][j + itemWeight[i]] = true;
      }
    }

    for (int i = bagLoadWeight; i >= 0; i--) {
      if (states[n - 1][i])
        return i;
    }
    return 0;
  }


  public static void main(String[] args) {
    AssertUtils.assertEqual(6, new ZeroOneBag2().getMaxWeight(new int[]{1, 2, 3, 4, 5}, 6));
    AssertUtils.assertEqual(9, new ZeroOneBag2().getMaxWeight(new int[]{2, 2, 4, 6, 3}, 9));
  }
}
