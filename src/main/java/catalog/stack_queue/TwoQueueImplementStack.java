package catalog.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用两个队列 实现一个 栈
 */
public class TwoQueueImplementStack {

    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack() {
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T pop() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            T res = queue.poll();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;

            return res;
        }

        public T peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }

            T res = queue.peek();

            help.offer(queue.poll());
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;

            return res;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {

        System.out.println("test begin");
        TwoQueueStack<Integer> myStack = new TwoQueueStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.pop().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish!");
    }
}
