package Tree;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/10/15:23
 * @Description:
 */
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode l, TreeNode r) {
        val = x;
        this.left = l;
        this.right = r;
    }
}


/**
 * 思路：左边A栈，右边B栈
 * 1.A栈往B栈压入数据，要一次性把A栈数据一个一个都压入B栈
 * 2.如果B栈不为空，A栈绝对不能向B栈压入数据。
 */
class TwoStacksQueue<E> {
    public Stack<E> stackPush;
    public Stack<E> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<E>();
        stackPop = new Stack<E>();
    }

    //元素进栈
    public void offer(E pushInt) {
        stackPush.push(pushInt);
    }

    public E poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public E peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public boolean empty() {
        return stackPush.isEmpty();
    }


    public static void main(String[] args) {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int data = rand.nextInt(100);
            System.out.print(data + " ");
            queue.offer(data);
        }
        System.out.println();
        System.out.println("出队：");
        while (!queue.empty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}


class Queue<E> {  //用的jdk自带的栈
    private Stack<E> s1 = new Stack<>();
    private Stack<E> s2 = new Stack<>();

    public void offer(E val) {   //入队
        s1.push(val);
    }

    public E poll() {   //出队
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        E val = s2.peek();
        s2.pop();
        //获取出队元素后，再将s2里面的元素放入s1里面。
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return val;
    }

    public E peek() {//查看对头元素
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        E val = s2.peek();
        //获取出队元素后，再将s2里面的元素放入s1里面。
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return val;
    }

    public boolean empty() { //判断队是否为空
        return s1.empty();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int data = rand.nextInt(100);
            System.out.print(data + " ");
            queue.offer(data);
        }
        System.out.println();
        System.out.println("出队：");
        while (!queue.empty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
