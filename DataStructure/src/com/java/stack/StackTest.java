package com.java.stack;

/**
 * @author liusigou
 * @create 2019--12--12--20:05
 */
public class StackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        for (int i = 0; i < 10; i++) {
            stack.addNum(i);
        }
        System.out.println(stack.pop());
        System.out.println("------------------");
        stack.show();
    }
}
//创建栈
class MyStack {
    //定义一个数组来模拟栈
    private int[] stack;
    //定义栈最大长度
    private int maxSize;
    //定义一个指针,来指向栈顶
    private int top=-1;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
    }



    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
    //判断栈满
    public boolean isFull(){
        return top==maxSize;
    }
    //判断是否为空
    public boolean isEmpty(){
        return top==-1;
    }
    //添加数据
    public void addNum(int num){
        //如果满了就不添加数据
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        //不然就top上移一位
        top++;
        stack[top]=num;
        /*
        * 或者写成
        * stack[++top]=num;
        * */
    }
    //取出数据
    public int pop(){
        //如果空就不取数据
        if (isEmpty()){
           throw new RuntimeException("栈已空");
        }
        //取出数据
        int value=stack[top];
        top--;
        return value;
    }
    //取出全部数据
    public void show(){
        while(true){
            if(isEmpty()){
                return;
            }
            //取出数据
            System.out.println(stack[top]);
            top--;
        }
    }
}
