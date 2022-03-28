package stack_queue;

/**
 * 数组实现 队列
 */
public class RingArrayToQueue {

    public static class MyQueue {
        private int[] arr;
        private final int limit;
        private int size;
        private int pushIndex;
        private int pollIndex;


        public MyQueue(int limit) {
            arr = new int[limit];
            this.limit = limit;
            this.size = 0;
            this.pushIndex = 0;
            this.pollIndex = 0;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }

            size++;
            arr[pushIndex] = value;
            pushIndex = nextIndex(pushIndex);
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了");
            }

            size--;
            int value = arr[pollIndex];
            this.pollIndex = nextIndex(pollIndex);
            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int index) {
            return index < limit - 1 ? index + 1 : 0;
        }
    }
}
