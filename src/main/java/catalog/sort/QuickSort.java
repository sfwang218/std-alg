package catalog.sort;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 实现1，划分两个区域：小于等于区域、大于区域
     */
    public static class QuickSort1 {

        public static void quickSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }

            process(arr, 0, arr.length - 1);
        }

        private static void process(int[] arr, int l, int r) {
            if (l >= r) { // base case
                return;
            }

            int mid = partition(arr, l, r);

            process(arr, l, mid - 1);
            process(arr, mid + 1, r);
        }

        // arr[L..R]上，以arr[R]位置的数做划分值
        // <= X > X
        // <= X X
        private static int partition(int[] arr, int l, int r) {
            if (l > r) {
                return -1;
            }
            if (l == r) {
                return l;
            }

            // 记录小于等于区域右边界
            int le = l - 1;
            int index = l;
            while (index < r) {
                if (arr[index] <= arr[r]) {
                    swap(arr, index, ++le);
                }
                index++;
            }
            swap(arr, ++le, r);
            return le;
        }
    }

    /**
     * 实现2，划分3个区域：小于区域、等于区域、大于区域
     */
    public static class QuickSort2 {

        public static void quickSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }

            process(arr, 0, arr.length - 1);
        }

        private static void process(int[] arr, int l, int r) {
            if (l >= r) { // base case
                return;
            }

            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);

            int[] equalArea = netherlandsFlag(arr, l, r);
            process(arr, l, equalArea[0] - 1);
            process(arr, equalArea[1] + 1, r);
        }

        // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
        // <arr[R] ==arr[R] > arr[R]
        private static int[] netherlandsFlag(int[] arr, int l, int r) {
            if (l > r) {
                return new int[]{-1, -1};
            }
            if (l == r) {
                return new int[]{l, r};
            }

            int less = l - 1; // < 区 右边界
            int more = r; // > 区 左边界
            int index = l;

            while (index < more) { // 当前位置，不能和 >区的左边界撞上
                if (arr[index] < arr[r]) {
                    swap(arr, index++, ++less);
                } else if (arr[index] == arr[r]) {
                    index++;
                } else {
                    swap(arr, index, --more);
                }
            }
            swap(arr, more, r);

            return new int[]{less + 1, more};
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
