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

    /**
     * 冒泡排序和插入排序的性能测试
     */
    public static void bubbleSortAndInsertionSortPerformanceTest() {
        List<int[]> arrays = generateArrays(10000,200);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            BubbleSort.sort(arrays.get(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("排序10000个数组，每个数组包含200个数据，冒泡排序耗时:" + (end - start) + "ms");

        arrays = generateArrays(10000,200);
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            InsertionSort.sort(arrays.get(i));
        }
        end = System.currentTimeMillis();
        System.out.println("排序10000个数组，每个数组包含200个数据，插入排序耗时:" + (end - start) + "ms");

        arrays = generateArrays(10000,200);
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

    public static void main(String[] args) {
        bubbleSortAndInsertionSortPerformanceTest();
    }
}
