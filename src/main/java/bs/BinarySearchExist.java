package bs;

/**
 * 二分查找
 */
public class BinarySearchExist {

    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int l = 0;
        int r = sortedArr.length - 1;
        int mid = 0;

        while (l < r) { // l..r 至少2个数的时候
            mid = l + ((r - l) >> 1);

            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return sortedArr[l] == num;
    }
}
