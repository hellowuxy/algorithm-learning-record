package cn.wxy.practise;

import java.util.Arrays;

/**
 * 求解逆序度
 */
public class ReverseOrderDegreeQuestion {

  // 逆序度
  private int num;

  public int reverseOrderDegree(int[] array){
    mergeSort(array, 0, array.length - 1);
    return num;
  }

  private void mergeSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
  }

  private void merge(int[] array, int left, int mid, int right) {
    int i = left, j = mid + 1, k = 0;
    int[] tmp = new int[right - left + 1];
    while (i <= mid && j <= right) {
      if (array[i] <= array[j]) {
        tmp[k++] = array[i++];
      } else {
        tmp[k++] = array[j++];
        // array[i,mid] 之前大于array[j]的元素个数
        num += mid - i + 1;
      }
    }

    while (i <= mid) {
      tmp[k++] = array[i++];
    }

    while (j <= right) {
      tmp[k++] = array[j++];
    }

    for (int value : tmp) {
      array[left++] = value;
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 9, 8, 7, 6, 4, 3, 2};
    ReverseOrderDegreeQuestion degreeQuestion = new ReverseOrderDegreeQuestion();
    System.out.println(degreeQuestion.reverseOrderDegree(array));
    System.out.println(Arrays.toString(array));
  }
}
