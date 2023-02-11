package 荣耀;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/24/21:27
 * @Description:
 */
public class MyStack {
    private int[] data;
    private int size;
    private int top;

    public MyStack(int size) {
        this.size = size;
        data = new int[size];
        top = -1;   //表示空栈
    }

    public boolean isEmpty(){
        return top == -1;
    }
    private boolean isFull() {
        return top + 1 == size;
    }

    public void push(int val){
        if (isFull()){
            System.out.println("栈满了");
        }
        this.data[++top] = val;

    }

    private int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("栈满了");
        }else {
            return this.data[top--];
        }
    }
    private void print(){
        for (int i = top; i >= 0; i--) {
            System.out.println(this.data[i]);
        }
    }

    private int peek(){
        return this.data[top];
    }

    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int pop = stack.pop();
        int pop1 = stack.pop();
        System.out.println(stack.peek());
        stack.print();
        int[][] intervals = new int[][]{{1},{2}};
        Arrays.sort(intervals, (o1, o2)->o1[0] - o2[0]);
//        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        list.toArray(new int[][]{});
        List<Integer> list1 = new ArrayList<>();
        list1.toArray();
    }
}
