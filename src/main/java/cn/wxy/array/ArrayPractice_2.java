package cn.wxy.array;

import cn.wxy.utils.ArrayUtils;
import org.junit.Assert;

/**
 * 关于数组的一些练习2
 *
 * @autor wxyidea
 * @create 2019-07-03
 **/
public class ArrayPractice_2 {
  /*
     practice 1:
      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

      示例 1:
        给定数组 arrays = [1,2,2],函数应该返回新的长度 2, 并且原数组 arrays 的前两个元素被修改为 1, 2。
        注意：不需要考虑数组中超出新长度后面的元素。

      示例 2:
        给定 arrays = [0,0,1,1,2,2,3,3,4],函数应该返回新的长度 5, 并且原数组 arrays 的前五个元素被修改为 0, 1, 2, 3, 4。
        注意：不需要考虑数组中超出新长度后面的元素。
   */

  /**
   * 解题思路：使用双指针法，定义两个指针i（慢指针）和j（快指针），只要arrays[i]==arrays[j]，就增加j；
   * 当遇到arrays[i]！=arrays[i]时，将array[j]复制到array[i+1]，即array[i+1]=array[j];
   * 然后i指针+1，重复上述过程，直到j指针到达数组末尾。
   *
   * @param arrays
   * @return 移除重复元素后的数组新长度
   */
  public static int removeDuplicates(int[] arrays) {
    int i = 0, j = 1;
    while (j < arrays.length) {
      if (arrays[i] == arrays[j])
        j++;
      else
        arrays[++i] = arrays[j++];
    }
    return i + 1;
  }


  /*
      practice2:
        给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
        设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

      示例 1:
        输入: [7,1,5,3,6,4]
        输出: 7
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
             随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

      示例 2:
        输入: [1,2,3,4,5]
        输出: 4
        解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
             注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
             因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

      示例 3:
        输入: [7,6,4,3,1]
        输出: 0
        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
  */

  /**
   * 该题可以使用贪心算法来解决：用prices[i]表示今天的股票价格，prices[i+1]表示明天的股票价格，
   * 只要prices[i+1]>prices[i]，就在第i天买入，并在第i+1天卖出；重复上述过程，直到i=prices.length-2结束
   *
   * @param prices
   * @return 最大利润
   */
  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i] < prices[i + 1])
        maxProfit += prices[i + 1] - prices[i];
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    // test moveDuplicates method
    int arrays[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    ArrayUtils.printArray(arrays, removeDuplicates(arrays));

    // test maxProfit method
    Assert.assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    Assert.assertEquals(4, maxProfit(new int[]{1, 2, 3, 4, 5}));
    Assert.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
  }
}
