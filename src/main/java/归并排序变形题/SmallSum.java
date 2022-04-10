package 归并排序变形题;

/**
 * 数组小和
 * 在一个数值中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。
 */
public class SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) { // base case
            return 0;
        }

        int mid = l + ((r - l) >> 1);

        return process(arr, l, mid)
                + process(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    /**
     * 核心思想：看一个数，右边有多少个数 比它大
     */
    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;

        while (p1 <= mid && p2 <= r) {
            if (arr[p1] < arr[p2]) {
                res += arr[p1] * (r - p2 + 1);
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        System.arraycopy(help, 0, arr, l, help.length);

        return res;
    }
}
