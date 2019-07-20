package cn.wxy.leetcode;

import cn.wxy.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 三数之和：给定一个包含 n 个整数的数组 arrays，判断 arrays 中是否存在三个元素 a，b，c ，
 *         使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *         注意：答案中不可以包含重复的三元组。
 *
 *  例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *  满足要求的三元组集合为：
 *    [
 *      [-1, 0, 1],
 *      [-1, -1, 2]
 *    ]
 *
 */
/**
 * @autor wxyidea
 * @create 2019-07-08
 **/
public class ThreeSum {

  /**
   * 解题思路：排序+双指针。
   *
   * 时间复杂度：O(n^2)
   *
   * @param arrays
   * @return
   */
  public static List<int[]> threeSum_way2(int[] arrays) {
    List<int[]> triple = new ArrayList<>();
    // sorted arrays
    Arrays.sort(arrays);
    for (int i = 0; i < arrays.length; i++) {
      // 若arrays[i]>0，则后续元素中不存在 a、b、c 使得 a+b+c=0，终止循环
      if (arrays[i] > 0)
        break;

      // 去重
      if (i > 0 && arrays[i] == arrays[i - 1])
        continue;

      int left = i + 1;
      int right = arrays.length - 1;
      while (left < right) {
        if (arrays[i] + arrays[left] + arrays[right] == 0) {
          triple.add(new int[]{arrays[i], arrays[left], arrays[right]});

          while (left < right && arrays[left] == arrays[left + 1]) {
            // 去重
            left++;
          }
          left++;

          while (left < right && arrays[right] == arrays[right - 1]) {
            // 去重
            right--;
          }
          right--;
        } else if (arrays[i] + arrays[left] + arrays[right] < 0) {
          // 小于0，左指针向右移动
          left++;
        } else {
          // 大于0，右指针向左移动
          right--;
        }
      }
    }
    return triple;
  }

  public static void main(String[] args) {
    int[] arrays = {-1, 0, 1, 2, -1, -4};
    // int[] arrays = {0, 0, 0, 0, 0, 0};
    for (int[] array : threeSum_way2(arrays)) {
      ArrayUtils.printArray(array);
    }
  }
}
