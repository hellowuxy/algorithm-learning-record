package cn.wxy.practise;

import cn.wxy.utils.AssertUtils;

/**
 * 0-1背包问题（物品具有价值），动态规划算法实现
 */
public class ZeroOneBagV2 {
  private int[] itemW;
  private int[] itemV;
  private int loadW;
  private int maxV = Integer.MIN_VALUE;

  public ZeroOneBagV2(int[] itemW, int[] itemV, int loadW) {
    this.itemW = itemW;
    this.itemV = itemV;
    this.loadW = loadW;
  }

  public int getMaxV() {
    int[][] states = new int[itemW.length][loadW + 1];
    for (int i = 0; i < itemW.length; i++) {
      for (int j = 0; j < loadW + 1; j++) {
        states[i][j] = -1;
      }
    }
    // 处理第一行数据
    states[0][0] = 0;
    if (itemW[0] < loadW) {
      states[0][itemW[0]] = itemV[0];
    }

    for (int i = 1; i < itemW.length; i++) {
      for (int j = 0; j <= loadW; j++) { // 第i个物品不放入背包
        if (states[i - 1][j] >= 0)
          states[i][j] = states[i - 1][j];
      }

      for (int j = 0; j <= loadW - itemW[i]; j++) { // 第i个物品放入背包
        if (states[i - 1][j] >= 0) {
          int v = states[i - 1][j] + itemV[i];
          if (v > states[i][j + itemW[i]])
            states[i][j + itemW[i]] = v;
        }
      }
    }

    for (int i = 0; i <= loadW; i++) {
      if (states[itemW.length - 1][i] > maxV)
        maxV = states[itemW.length - 1][i];
    }
    return maxV;
  }

  public static void main(String[] args) {
    AssertUtils.assertEqual(15, new ZeroOneBagV2(new int[]{1, 2, 3, 4, 5},
            new int[]{2, 1, 12, 8, 10}, 6).getMaxV());
  }
}
