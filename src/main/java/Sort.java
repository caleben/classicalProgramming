import java.util.Arrays;
import java.util.Random;

/**
 * @author wenci
 * @date: 2017/12/1
 * @description:
 */
public class Sort {
  static int[] arr = generateArray(8);
  public static void main(String[] args) {
//    bubbleSort(8);
    fastSort();
  }

  private static void fastSort() {
    System.out.println("初始数组为：\n" + Arrays.toString(arr));
    qk(0, arr.length-1);
    System.out.println("排序后数组为：\n" + Arrays.toString(arr));
  }

  /**
   * 快速排序法
   * @param start
   * @param end
   */
  private static void qk(int start, int end) {
    if (start >= end) return;
    int point = arr[end];
    int left = start, right = end - 1;
    while (left < right) {
      while (arr[left] <= point && left < right) {
        left++;
      }
      while (arr[right] >= point && left < right) {
        right--;
      }
      if (left != right) {
        swap(left, right);
      }
    }
    if (arr[left] > arr[end]) {
      swap(left, end);
    }
    qk(start, left);
    qk(left + 1, end);
  }

  private static void swap(int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /**
   * 冒泡排序法：数组两两比较，大的放后面
   * @param length
   */
  private static void bubbleSort(int length) {
    int[] arr = generateArray(length);
    System.out.println("初始数组为：\n" + Arrays.toString(arr));
    for (int i=length-1; i>0; i--) {
      for (int j=0; j<i; j++) {
        if (arr[j] > arr[j+1]) {
          arr[j] = arr[j] ^ arr[j+1];
          arr[j+1] = arr[j+1] ^ arr[j];
          arr[j] = arr[j] ^ arr[j+1];
        }
      }
    }
    System.out.println("排序后数组为：\n" + Arrays.toString(arr));
  }

  /**
   * 选择排序法：每次将最后一个数为基准与前面的每个数比较，交换位置把大的放在后面。
   * @param length
   */
  private static void selectSort(int length) {
    int[] arr = generateArray(length);
    System.out.println("初始数组为：\n" + Arrays.toString(arr));
    for (int i=length-1; i>0; i--) {
      for (int j=0; j<i; j++) {
        if (arr[i] < arr[j]) {
          arr[i] = arr[i] ^ arr[j];
          arr[j] = arr[j] ^ arr[i];
          arr[i] = arr[i] ^ arr[j];
        }
      }
    }
    System.out.println("排序后数组为：\n" + Arrays.toString(arr));
  }

  private static int[] generateArray(int length) {
    Random rand = new Random();
    int[] arr = new int[length];
    for (int i=0; i<length; i++) {
      arr[i] = rand.nextInt(100);
    }
    return arr;
  }
}
