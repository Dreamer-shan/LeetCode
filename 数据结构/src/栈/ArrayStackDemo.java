package 栈;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/03/08/10:21
 * @Description:
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < 13; i++) {
            boolean push = stack.push(i);
            System.out.println("第" + (i + 1) + "次存储数据为：" + i + "，存储结果是:" + push);
        }
        for (int i = 0; i < 11; i++) {
            Object pop = stack.pop();
            System.out.println(pop);
        }
    }
}

class ArrayStack {
    Stack<Integer> stack = new Stack<>();
    private int size;
    private int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public ArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack(int capacity) {
        elements = new Object[capacity];
    }

    public boolean push(Object element) {
        try {
            checkCapacity(size + 1);
            elements[size++] = element;
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public Object pop() {
        if (size <= 0) {
            return null;
        }
        Object obj = elements[size - 1];
        elements[--size] = null;
        return obj;
    }

    public int size() {
        return size;
    }

    public Object peek(){
        if (size <= 0) {
            return null;
        }
        return elements[size - 1];
    }


    public void checkCapacity(int minCapacity) {
        if (elements.length - minCapacity < 0) {
            throw new RuntimeException("栈容量不够");
        }
    }

}
