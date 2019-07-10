package cn.wxy.leetcode;

import cn.wxy.utils.ArrayUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和：给定一个整数数组 arrays 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *    给定 arrays = [2, 7, 11, 15], target = 9
 *    因为 arrays[0] + arrays[1] = 2 + 7 = 9；所以返回 [0, 1]
 *
 * @autor wxyidea
 * @create 2019-07-07
 **/
public class TwoSum {

  /**
   * 暴力解法：使用双重循环，遍历数组。
   *
   * 时间复杂度：O(n^2)
   *
   * 空间复杂度：O(1)
   *
   * @param arrays
   * @param target
   * @return
   */
  public static int[] twoSum_way1(int[] arrays,int target){
    for (int i = 0; i < arrays.length; i++) {
      for (int j = i + 1; j < arrays.length; j++) {
        if (arrays[i] + arrays[j] == target)
          return new int[]{i, j};
      }
    }
    throw new IllegalArgumentException("No such two sum");
  }

  /**
   * 两遍哈希表：引入哈希表，通过两次迭代找出符合要求的元素索引；第一次迭代，使用HashMap保存数组元素及其对应的下标；
   * 第二次迭代，检查每个元素对应的目标元素（target-arrays[i]）是否存在于哈希表中（注意：该元素不能是array[i]本身），
   * 若存在，则返回元素索引。
   *
   * 该解法以牺牲空间的方式提高了速度，即以空间换时间。
   *
   * 时间复杂度：O(n)，我们需要两次遍历数组，但是通过哈希表将定位目标元素的时间复杂度缩小到O(1)，所以时间复杂度为O(n)
   * 空间复杂度：O(n)，需要在hash表中保存n个元素
   *
   * @param arrays
   * @param target
   * @return
   */
  public static int[] twoSum_way2(int[] arrays,int target){
    Map<Integer, Integer> map = new HashMap<>(arrays.length);
    // 使用HashMap保存数组元素及其对应的下标
    for (int i = 0; i < arrays.length; i++) {
      map.put(arrays[i], i);
    }

    // 遍历数组，检查每个元素对应的目标元素（target-arrays[i]）是否存在于哈希表中
    for (int i = 0; i < arrays.length; i++) {
      int key = target - arrays[i];
      if (map.containsKey(key) && (map.get(key) != i))
        return new int[]{i, map.get(key)};
    }
    throw new IllegalArgumentException("No such two sum");
  }

  /**
   * 一遍哈希表：事实上，我们可以对两遍哈希表法进行优化，只需要一次迭代即可找出符合要求的元素索引，我们在迭代元素的同时，先查看哈希表
   * 中是否存在目标元素（target-arrays[i]），若存在，则返回元素索引，若不存在，则将当前元素及其索引放入哈希表中。
   *
   * 时间复杂度：O(n)，只需要遍历数组一次，耗费时间O(n),定位元素的时间为O(1)
   * 空间复杂度：O(n)，最多需要保存n个元素
   *
   * @param arrays
   * @param target
   * @return
   */
  public static int[] twoSum_way3(int[] arrays,int target){
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arrays.length; i++) {
      int key = target - arrays[i];
      if (map.containsKey(key) && (map.get(key) != i))
        return new int[]{map.get(key), i};
      else
        map.put(arrays[i], i);
    }
    throw new IllegalArgumentException("No such two sum");
  }

  public static void main(String[] args) {
    int[] arrays = {2, 7, 11, 15};
    ArrayUtils.printArray(twoSum_way1(arrays, 9));
    ArrayUtils.printArray(twoSum_way2(arrays, 9));
    ArrayUtils.printArray(twoSum_way3(arrays, 9));
  }
}
