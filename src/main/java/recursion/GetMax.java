package recursion;

/**
 * 递归实现 求 arr中的最大值
 */
public class GetMax {

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]范围上求最大值  L ... R   N
    private static int process(int[] arr, int l, int r) {
        // arr[L..R]范围上只有一个数，直接返回，base case
        if (l == r) {
            return arr[l];
        }

        // L...R 不只一个数
        // mid = (L + R) / 2
        int mid = l + ((r - l) >> 1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
}
