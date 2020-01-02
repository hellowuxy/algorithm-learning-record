package cn.wxy.algorithms.test;

import cn.wxy.algorithms.bubblesort.BubbleSort;
import cn.wxy.algorithms.insertionsort.InsertionSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 性能测试类
 */
public class PerformanceTest {

  public static void main(String[] args) {
    bubbleSortAndInsertionSortPerformanceTest();
    testBucketPerformance(); // 测试三次：42563ms 41673ms 42571ms
    testQuickSortPerformance(); // 测试三次：50362ms 46615ms 49018ms
  }

  /**
   * 冒泡排序和插入排序的性能测试
   */
  public static void bubbleSortAndInsertionSortPerformanceTest() {
    List<int[]> arrays = generateArrays(10000, 200);
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      BubbleSort.sort(arrays.get(i));
    }
    long end = System.currentTimeMillis();
    System.out.println("排序10000个数组，每个数组包含200个数据，冒泡排序耗时:" + (end - start) + "ms");

    arrays = generateArrays(10000, 200);
    start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      InsertionSort.sort(arrays.get(i));
    }
    end = System.currentTimeMillis();
    System.out.println("排序10000个数组，每个数组包含200个数据，插入排序耗时:" + (end - start) + "ms");

    arrays = generateArrays(10000, 200);
    start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      BubbleSort.sortOptimized(arrays.get(i));
    }
    end = System.currentTimeMillis();
    System.out.println("排序10000个数组，每个数组包含200个数据，优化后的冒泡排序耗时:" + (end - start) + "ms");
  }

  /**
   * 随机生成数组
   *
   * @param arrayNum  数组数量
   * @param arraySize 数组大小
   * @return 生成的数组集合
   */
  private static List<int[]> generateArrays(int arrayNum, int arraySize) {
    Random random = new Random();
    List<int[]> arrayList = new ArrayList<>(arrayNum);
    for (int i = 0; i < arrayNum; i++) {
      int[] arrays = new int[arraySize];
      for (int j = 0; j < arraySize; j++) {
        arrays[j] = random.nextInt(arraySize);
      }
      arrayList.add(arrays);
    }
    return arrayList;
  }

  /**
   * 测试排序1_000_000个用户，桶排序耗时
   */
  public static void testBucketPerformance() {
    List<User> userList = generateUser(1_000_000);
    long start = System.currentTimeMillis();
    bucketSort(userList);
    long end = System.currentTimeMillis();
    System.out.println("排序1_000_000个用户，桶排序耗时：" + (end - start) + "ms");
    // for (User user : userList) {
    //   System.out.println(user);
    // }
  }

  /**
   * 测试排序1_000_000个用户，快速排序耗时
   */
  public static void testQuickSortPerformance() {
    List<User> userList = generateUser(1_000_000);
    long start = System.currentTimeMillis();
    QuickSort.sort(userList);
    long end = System.currentTimeMillis();
    System.out.println("排序1_000_000个用户，快速排序耗时：" + (end - start) + "ms");
  }

  /**
   * 桶排序
   *
   * @param userList
   */
  private static void bucketSort(List<User> userList) {
    List<List<User>> bucketList = new ArrayList<>(10);
    for (int i = 0; i < 10; i++) {
      bucketList.add(new ArrayList<>());
    }
    // 将用户放入对应的桶中
    for (User user : userList) {
      if (user.getAge() <= 10) {
        // 0号桶存放0~10岁的用户
        List<User> bucket0 = bucketList.get(0);
        bucket0.add(user);
      } else if (user.getAge() <= 20) {
        // 1号桶存放11~20岁的用户
        List<User> bucket1 = bucketList.get(1);
        bucket1.add(user);
      } else if (user.getAge() <= 30) {
        // 2号桶存放21~30岁的用户
        List<User> bucket2 = bucketList.get(2);
        bucket2.add(user);
      } else if (user.getAge() <= 40) {
        // 3号桶存放31~40岁的用户
        List<User> bucket3 = bucketList.get(3);
        bucket3.add(user);
      } else if (user.getAge() <= 50) {
        // 4号桶存放41~50岁的用户
        List<User> bucket4 = bucketList.get(4);
        bucket4.add(user);
      } else if (user.getAge() <= 60) {
        // 5号桶存放51~60岁的用户
        List<User> bucket5 = bucketList.get(5);
        bucket5.add(user);
      } else if (user.getAge() <= 70) {
        // 6号桶存放61~70岁的用户
        List<User> bucket6 = bucketList.get(6);
        bucket6.add(user);
      } else if (user.getAge() <= 80) {
        // 7号桶存放71~80岁的用户
        List<User> bucket7 = bucketList.get(7);
        bucket7.add(user);
      } else if (user.getAge() <= 90) {
        // 8号桶存放81~90岁的用户
        List<User> bucket8 = bucketList.get(8);
        bucket8.add(user);
      } else {
        // 9号桶存放91~100岁的用户
        List<User> bucket9 = bucketList.get(9);
        bucket9.add(user);
      }
    }

    // 桶内排序
    for (List<User> users : bucketList) {
      QuickSort.sort(users);
    }

    // 合并
    userList.clear();
    for (List<User> users : bucketList) {
      userList.addAll(users);
    }
  }

  /**
   * 生成num个用户
   *
   * @param num 用户数量
   * @return 生成的用户
   */
  private static List<User> generateUser(int num) {
    List<User> userList = new ArrayList<>(num);
    Random random = new Random();
    for (int i = 0; i < num; i++) {
      userList.add(new User("u" + i, random.nextInt(100)));
    }
    return userList;
  }

  private static class User {
    private String name;
    private int age;

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    public User(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "User{" +
              "name='" + name + '\'' +
              ", age=" + age +
              '}';
    }
  }

  /**
   * 快速排序
   */
  public static class QuickSort {
    public static void sort(List<User> array) {
      if (array.size() == 0) {
        return;
      }
      sort(array, 0, array.size() - 1);
    }

    public static void sort(List<User> array, int low, int high) {
      if (low >= high)
        return;
      int p = partition(array, low, high);
      sort(array, low, p - 1);
      sort(array, p + 1, high);
    }

    private static int partition(List<User> array, int low, int high) {
      int i = low, j = low;
      User pivot = array.get(high);
      while (j < high) {
        if (array.get(j).getAge() < pivot.getAge()) {
          User temp = array.get(i);
          array.set(i, array.get(j));
          array.set(j, temp);
          i++;
        }
        j++;
      }
      array.set(j, array.get(i));
      array.set(i, pivot);
      return i;
    }
  }
}
