package com.java.queue;

/**
 * @author liusigou
 * @create 2019--11--10--18:07
 */
//测试队列
public class QueueTest {
    public static void main(String[] args) {
//      创建队列
        ArrayQueue arrayQueue=new ArrayQueue(5);
        arrayQueue.addComponent(5);
        arrayQueue.addComponent(7);
        arrayQueue.addComponent(9);
        arrayQueue.addComponent(8);
        arrayQueue.addComponent(3);
        System.out.println(arrayQueue.getComponent());
        System.out.println(arrayQueue.getComponent());
        System.out.println(arrayQueue.getComponent());
        System.out.println(arrayQueue.getComponent());
        System.out.println(arrayQueue.getComponent());
        arrayQueue.addComponent(6);
//        arrayQueue.showQueue();
    }
}
//使用数组模拟队列
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
//  队列数组存储在该数组里面
    private int[] arr;
    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
//      头部front下标指向-1
        front=-1;
//      尾部rear下标指向-1
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
//  判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
//  判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
//  队列添加
    public void addComponent(int num) {
//      如果队列满了
        if(isFull()){
            System.out.println("队列已满,不能加入数据");
            return;
        }
        //尾部指针后移一位
        rear++;
        arr[rear]=num;
    }
//  获取队列数据
    public int getComponent(){
//      如果队列是空的
        if(isEmpty()){
            throw new RuntimeException("队列是空的,无法取出数据");
        }
//      头部指针后移一位
        front++;
        return arr[front];
    }
//  显示头数据
    public int getHead(){
//      如果队列是空的
        if(isEmpty()){
            throw new RuntimeException("队列是空的,无法取出数据");
        }
        return arr[front+1];
    }
//  显示完整队列数据
    public void showQueue(){
//      如果队列是空的
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d\t",arr[i]);
        }
    }
}
