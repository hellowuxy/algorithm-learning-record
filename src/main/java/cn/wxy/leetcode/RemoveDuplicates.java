package cn.wxy.leetcode;

import cn.wxy.utils.ArrayUtils;

/**
 * 删除有序数组中的重复元素:
 *   给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *   不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *  示例 1:
 *    	给定数组 arrays = [1,2,2],函数应该返回新的长度 2, 并且原数组 arrays 的前两个元素被修改为 1, 2。
 *    	注意：不需要考虑数组中超出新长度后面的元素。
 *
 *  示例 2:
 * 	    给定 arrays = [0,0,1,1,2,2,3,3,4],函数应该返回新的长度 5, 并且原数组 arrays 的前五个元素被修改为 0, 1, 2, 3, 4。
 *    	注意：不需要考虑数组中超出新长度后面的元素。
 *
 *
 *
 *
 *
 *
 *
 *  解题思路：使用双指针法，定义两个指针i（慢指针）和j（快指针），只要arrays[i]==arrays[j]，就增加j；
 *           当遇到arrays[i]！=arrays[i]时，将array[j]复制到array[i+1]，即array[i+1]=array[j];
 *           然后i指针+1，重复上述过程，直到j指针到达数组末尾。
 *
 * @autor wxyidea
 * @create 2019-07-07
 **/
public class RemoveDuplicates {

  /**
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

  public static void main(String[] args) {
    // test moveDuplicates method
    int arrays[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    ArrayUtils.printArray(arrays, removeDuplicates(arrays));
  }
}
