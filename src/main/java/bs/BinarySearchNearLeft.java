package bs;

/**
 * 在有序数字 sortedArr 上，找满足 >= value 的最左位置
 */
public class BinarySearchNearLeft {

    public static int nearestIndex(int[] sortedArr, int value) {
        int l = 0;
        int r = sortedArr.length - 1;
        int index = -1;

        while (l <= r) { // 至少一个数的时候
            int mid = l + ((r - l) >> 1);
            if (sortedArr[mid] >= value) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }
}
