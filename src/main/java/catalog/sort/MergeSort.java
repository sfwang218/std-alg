package catalog.sort;

/**
 * 归并排序
 */
public class MergeSort {

    /**
     * 递归实现
     */
    public static class MergeSort1 {
        public static void mergeSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }

            process(arr, 0, arr.length - 1);
        }

        // 把arr[L..R]排有序
        // l...r N
        // T(N) = 2 * T(N / 2) + O(N)
        // O(N * logN)
        private static void process(int[] arr, int l, int r) {
            if (l == r) { // base case
                return;
            }

            int mid = l + ((r - l) >> 1);
            process(arr, l, mid);
            process(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    /**
     * 非递归实现
     */
    public static class MergeSort2 {

        public static void mergeSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }

            int n = arr.length;
            // 步长
            int mergeSize = 1;
            while (mergeSize < n) {
                // 当前左组的 第一个位置
                int l = 0;
                while (l < n) {
                    if (mergeSize >= n - l) {
                        break;
                    }
                    int m = l + mergeSize - 1;
                    int r = m + Math.min(mergeSize, n - m - 1);
                    merge(arr, l, m, r);

                    // 下一组开始位置
                    l = r + 1;
                }

                // 防止数值范围溢出
                if (mergeSize > n / 2) {
                    break;
                }

                mergeSize <<= 1;
            }

        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 要么 p1 越界了，要么 p2 越界了
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        System.arraycopy(help, 0, arr, l, help.length);
    }
}
