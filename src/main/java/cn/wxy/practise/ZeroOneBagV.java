package cn.wxy.practise;

import cn.wxy.utils.AssertUtils;

/**
 * 0-1背包问题（物品具有价值），回溯算法实现
 */
public class ZeroOneBagV {
  private int[] itemW;
  private int[] itemV;
  private int loadW;
  private int maxV = Integer.MIN_VALUE;

  public ZeroOneBagV(int[] itemW, int[] itemV, int loadW) {
    this.itemW = itemW;
    this.itemV = itemV;
    this.loadW = loadW;
  }

  public int getMaxV() {
    doGetMaxV(0, 0, 0);
    return this.maxV;
  }

  private void doGetMaxV(int i, int curW, int curV) {
    if (i == itemW.length || curW == loadW) {
      if (maxV < curV)
        maxV = curV;
      return;
    }
    doGetMaxV(i + 1, curW, curV); // 当前物品不放入背包
    if (curW + itemW[i] <= loadW) {
      doGetMaxV(i + 1, curW + itemW[i], curV + itemV[i]); // 当前物品不放入背包
    }
  }

  public static void main(String[] args) {
    AssertUtils.assertEqual(12, new ZeroOneBagV(new int[]{1, 2, 3, 4, 5},
            new int[]{2, 1, 6, 8, 10}, 6).getMaxV());
  }
}
