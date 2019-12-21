package com.test.stack;

/**
 * @author liusigou
 * @create 2019--12--21--10:03
 */
public class MyStackTest {
    public static void main(String[] args) {
        String[] ss={"as","da","ff","adf","f"};
        MyStack stack=new MyStack(5);
        for (String s : ss) {
            stack.push(s);
        }

        System.out.println(stack.pop());
        System.out.println("-----------------");
        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println("-----------------");
        stack.list();
    }
}
class MyStack{
    //定义一个任意类型的数组
    private Object[] stack;
    //定义数组最大长度
    private int maxSize;
    //定义栈顶top
    private int top=-1;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new Object[maxSize];
    }

    public Object[] getStack() {
        return stack;
    }

    public void setStack(Object[] stack) {
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
    //判断栈是否空
    public boolean isEmpty(){
        return top==-1;
    }
    //判断栈是否满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //入栈
    public void push(Object data){
        //如果满了
        if(isFull()){
            System.out.println("栈已满,请勿再添加数据");
            return;
        }
        top++;
        stack[top]=data;
        //或者写成stack[++top]=data
    }
    //出栈
    public Object pop(){
        //如果为空
        if(isEmpty()){
            System.out.println("栈是空的");
            return null;
        }
        Object data=stack[top];
        top--;
        return data;
    }
    //观看栈顶
    public Object peak(){
        //如果为空
        if(isEmpty()){
            System.out.println("栈是空的");
            return null;
        }
        return stack[top];
    }
    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈是空的");
            return;
        }
        while(top>=0){
            System.out.println(stack[top]);
            top--;
        }

    }
}
