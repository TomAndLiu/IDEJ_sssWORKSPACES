package com.test.queue;

/**
 * @author liusigou
 * @create 2019--12--08--13:31
 */
public class QueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(5);
        arrayQueue.addComponent(5);
        arrayQueue.addComponent(7);
        arrayQueue.addComponent(9);
        arrayQueue.addComponent(8);
        arrayQueue.addComponent(3);
        /*arrayQueue.getComponent();
        arrayQueue.getComponent();
        arrayQueue.getComponent();
        arrayQueue.getComponent();
        arrayQueue.getComponent();
        arrayQueue.getComponent();*/
        System.out.println("------------------------");
        arrayQueue.queueList();
    }
}
class ArrayQueue{
    //定义队列最大值
    private int maxSize;
    //定义头指针
    private int front;
    //定义尾指针
    private int rear;
    //定义一个数组存储信息
    private int[] arr;
    //初始化数据
    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        //指向头指针的前一个位置
        front=-1;
        //指向尾指针的前一个位置
        rear=-1;
    }
    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
    //判断队列是否已满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //队列添加
    public void addComponent(int num){
        //如果满了就不添加
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        //尾部指针往前一位
        rear++;
        //赋值
        arr[rear]=num;
    }
    //获取队列
    public void getComponent(){
        //如果队列是空的就返回
        if(isEmpty()){
            System.out.println("队列为空,无法取出数据");
            return;
        }
        //先让头指针移动一位
        front++;
        System.out.println(arr[front]);
    }
    //显示所有的数据
    public void queueList(){
        //如果队列是空的就返回
        if(isEmpty()){
            System.out.println("队列为空,无法取出数据");
            return;
        }
        for (int i = 0; i < maxSize; i++) {
            System.out.printf("%d\t",arr[i]);
        }
    }
}
