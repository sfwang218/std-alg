package bit_op;

import java.util.Arrays;

/**
 * 交换数组两个元素位置，利用了两个特性:
 *   1. 交换律
 *   2. 相同的数 异或为 0
 * arr[i] ^ arr[j] ^ arr[i] = arr[j]
 */
public class Swap {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};

        int i = 0;
        int j = 2;

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

        System.out.println(Arrays.toString(arr));
    }

}
