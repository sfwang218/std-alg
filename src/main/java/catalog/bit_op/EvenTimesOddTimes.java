package catalog.bit_op;

/**
 * 找出数组中 出现奇数次的 元素
 */
public class EvenTimesOddTimes {

    // arr中 只有一个数 出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }

        System.out.println(eor);
    }

    // arr中 有两个数字 出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int ab = 0;
        for (int i : arr) {
            ab ^= i;
        }

        // a 和 b是两种数
        // eor != 0
        // eor最右侧的1，提取出来
        // eor :     00110010110111000
        // rightOne :00000000000001000
        int rightOne = ab & (-ab); // 提取出最右的1

        int b = 0;
        for (int i : arr) {
            if ((i & rightOne) != 0) {
                b ^= i;
            }
        }

        System.out.println(b); // b
        System.out.println(ab ^ b); // a
    }
}
