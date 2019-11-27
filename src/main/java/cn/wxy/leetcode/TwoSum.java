package cn.wxy.leetcode;

import cn.wxy.utils.ArrayUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * @autor wxyidea
 * @create 2019-07-07
 **/
public class TwoSum {

  public static int[] twoSum_way1(int[] arrays, int target) {
    for (int i = 0; i < arrays.length; i++) {
      for (int j = i + 1; j < arrays.length; j++) {
        if (arrays[i] + arrays[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    throw new IllegalArgumentException("No such two sum");
  }


  public static int[] twoSum_way2(int[] arrays, int target) {
    Map<Integer, Integer> map = new HashMap<>(arrays.length);
    // 使用HashMap保存数组元素及其对应的下标
    for (int i = 0; i < arrays.length; i++) {
      map.put(arrays[i], i);
    }

    // 遍历数组，检查每个元素对应的目标元素（target-arrays[i]）是否存在于哈希表中
    for (int i = 0; i < arrays.length; i++) {
      int key = target - arrays[i];
      if (map.containsKey(key) && (map.get(key) != i)) {
        return new int[]{i, map.get(key)};
      }
    }
    throw new IllegalArgumentException("No such two sum");
  }

  public static int[] twoSum_way3(int[] arrays, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arrays.length; i++) {
      int key = target - arrays[i];
      if (map.containsKey(key) && (map.get(key) != i)) {
        return new int[]{map.get(key), i};
      } else {
        map.put(arrays[i], i);
      }
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
