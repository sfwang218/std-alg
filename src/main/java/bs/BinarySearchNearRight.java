package bs;

/**
 * 局部最小值问题
 * 如果数组中某个元素的值 比相邻的元素的值都小
 * 则该值为局部最小值
 * <p>
 * 注意：
 * 1. 数组是无序的，且相邻不相等
 * 2. 只要求返回一个局部最小值即可
 */
public class BinarySearchNearRight {

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int l = 1;
        int r = arr.length - 2;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
