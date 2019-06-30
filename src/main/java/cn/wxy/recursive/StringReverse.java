package cn.wxy.recursive;

/**
 * 递归思想
 *
 * @autor wxyidea
 * @create 2019-06-28
 **/
public class StringReverse {

  /**
   * 递归逆向打印字符串
   *
   * @param index   索引
   * @param strings 字符串数组
   */
  public static void printReverse(int index, char[] strings) {
    if (strings == null || index >= strings.length)
      return;
    printReverse(index + 1, strings); // error: i++ ++i
    System.out.print(strings[index]);
  }

  /**
   * 递归逆向打印字符串
   *
   * @param index   索引
   * @param strings 字符串数组
   */
  public static void printReverseAnother(int index, char[] strings) {
    if (strings == null || index < 0)
      return;
    System.out.print(strings[index]);
    printReverseAnother(--index, strings);
  }

  /**
   * 反转字符串，空间复杂度O(1)
   *
   * @param strings 字符串数组
   */
  public static void reverseString(char[] strings) {
    int i = 0, j = strings.length - 1;
    while (i < j) {
      char temp = strings[i];
      strings[i] = strings[j];
      strings[j] = temp;
      i++;
      j--;
    }
    System.out.println(strings);
  }

  /**
   * 递归的方式反转字符串，且空间复杂度为O(1)
   *
   * @param strings 字符串数组
   */
  public static void reverseStringRecursive(char[] strings) {
    helper(0, strings.length - 1, strings);
    System.out.println(strings);
  }

  /**
   * 递归的方式反转字符串的帮助器
   *
   * @param i       索引，向数组尾部前进
   * @param j       索引，向数组头部前进
   * @param strings 字符串数组
   */
  public static void helper(int i, int j, char[] strings) {
    if (i > j)
      return;
    char temp = strings[i];
    strings[i] = strings[j];
    strings[j] = temp;
    helper(++i, --j, strings);
  }


  public static void main(String[] args) {
    String str = "string";
    printReverse(0, str.toCharArray());
    System.out.println();

    printReverseAnother(str.toCharArray().length - 1, str.toCharArray());
    System.out.println();

    reverseString(str.toCharArray());

    reverseStringRecursive(str.toCharArray());
  }

}
