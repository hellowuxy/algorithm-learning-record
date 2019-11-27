package cn.wxy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor wxyidea
 * @create 2019-06-30
 **/
public class YangHuiTriangle {

  /**
   * 生成指定行数的杨辉三角
   *
   * @param rowNums 杨辉三角行数
   * @return 杨辉三角集合
   */
  public static List<Integer[]> generate(int rowNums) {
    List<Integer[]> yhTriangle = new ArrayList<>();
    if (rowNums <= 0) {
      return yhTriangle;
    }

    for (int i = 0; i < rowNums; i++) {
      Integer[] newLine = new Integer[i + 1];
      Integer[] lastLine = null;
      if (i > 1) {
        lastLine = yhTriangle.get(i - 1); // 获取上一行数据
      }

      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          newLine[j] = 1;
        } else {
          newLine[j] = lastLine[j - 1] + lastLine[j]; // 等于左上方数字加上右上方数字之和
        }
      }
      yhTriangle.add(newLine);
    }
    return yhTriangle;
  }

  /**
   * 生成杨辉三角的指定行
   *
   * @param rowNums 行号（从1开始）
   * @return 包含指定行元素的集合
   */
  public static List<Integer> generateSpecifiedRow(int rowNums) {
    if (rowNums <= 0) {
      throw new IllegalArgumentException("rowNums must great than 0");
    }

    // 上一行
    List<Integer> prev = null;
    // 当前行
    List<Integer> cur = null;

    if (rowNums == 1) {
      List<Integer> row = new ArrayList<>();
      row.add(1);
      return row;
    } else if (rowNums == 2) {
      List<Integer> row = new ArrayList<>();
      row.add(1);
      row.add(1);
      return row;
    } else {
      prev = new ArrayList<>();
      prev.add(1);
      prev.add(1);
    }

    // 从第三行开始生成（注意：数组下标是从0开始的）
    for (int i = 2; i < rowNums; i++) {
      // 初始化当前行
      cur = new ArrayList<>(rowNums + 1);
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          cur.add(1);
        } else {
          cur.add(prev.get(j - 1) + prev.get(j));
        }
      }
      //重新设置prev，为生成下一行数据做准备
      prev = cur;
    }
    return prev;
  }

  public static void main(String[] args) {
    List<Integer[]> yhTriangle = generate(20);
    for (Integer[] line : yhTriangle) {
      StringBuilder sb = new StringBuilder();
      for (Integer ele : line) {
        sb.append(ele).append(" ");
      }
      System.out.println(sb.toString().trim());
    }
    System.out.println("----------------------------");

    List<Integer> row = generateSpecifiedRow(10);
    for (Integer ele : row) {
      System.out.print(ele + " ");
    }
  }
}
