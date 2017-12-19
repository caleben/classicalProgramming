import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author wenci
 * @date: 2017/11/30
 * @description:
 */
public class BookDemo {
  static long factorial = 1;

  public static void main(String[] args) {
//    System.out.println("this is normal");
//    System.err.println("this is error manually");
//    variableExchange();
    judgeMounth(6);
//    long result = multiply(5);
//    System.out.println(result);
//    selectSort(20);

  }

  /**
   * 实现一个数的阶乘，递归方式
   * @param num
   * @return
   */
  private static long multiply(int num) {
    if (num < 1) {
      return factorial;
    }
    factorial = factorial * num--;
    return multiply(num);

  }

  /**
   * @param mounth 当switch-case语句没有break时会一起执行到break的地方
   */
  private static void judgeMounth(int mounth) {
    switch (mounth) {
      case 12:
      case 1:
      case 2:
        System.out.println("" + mounth + " 是冬季");
        break;
      case 3:
      case 4:
      case 5:
        System.out.println("" + mounth + " 是春季");
        break;
      case 6:
      case 7:
      case 8:
        System.out.println("" + mounth + " 是夏季");
        break;
      case 9:
      case 10:
      case 11:
        System.out.println("" + mounth + " 是秋季");
        break;
    }
  }

  /**
   * 利用 System.setOut   setErr   setIn 改变输出输入流。
   */
  private static void redirectOutputStream() {
    PrintStream outer = System.out;
    try {
      PrintStream ps = new PrintStream("log.txt");
      System.setOut(ps);
      int age = 18;
      System.out.println("年龄设置成功");
      String sex = "女";
      System.out.println("性别设置成功");
      System.out.println(String.format("这是个%s孩子，今年%d岁了。", sex, age));
      System.setOut(outer);
      System.out.println("运行完毕，请查看日志");

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * 不使用第三个变量实现两数字互换
   */
  private static void variableExchange() {
    long a = 5569, b = 9965;
    System.out.println(String.format("a=%d, b=%d", a, b));
    System.out.println("after exchange:");
    a = a ^ b;
    b = b ^ a;
    a = a ^ b;
    System.out.println(String.format("a=%d, b=%d", a, b));
  }
}
