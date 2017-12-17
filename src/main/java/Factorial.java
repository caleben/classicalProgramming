/**
 * Author: wenci on 2017/12/17.
 * Description: 求阶乘，尾递归
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(getFact(5));
    }

    public static long getFact(long input) {
        long factorial = 1;
        if (input == 1) {
            return factorial;
        }
        return factorial = input * getFact(input - 1);
    }
}
