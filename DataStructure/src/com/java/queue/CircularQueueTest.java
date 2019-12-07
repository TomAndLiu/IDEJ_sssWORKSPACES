package com.java.queue;

/**
 * @author liusigou
 * @create 2019--11--10--19:16
 */
public class CircularQueueTest {
    public static void main(String[] args) {
        /*ArrayCircularQueue arrayCircularQueue = new ArrayCircularQueue(5);
        arrayCircularQueue.addComponent(16);
        arrayCircularQueue.addComponent(8);
        arrayCircularQueue.addComponent(11);
        arrayCircularQueue.addComponent(12);
        System.out.println(arrayCircularQueue.getComponent());
        System.out.println(arrayCircularQueue.getComponent());
        System.out.println(arrayCircularQueue.getComponent());
        System.out.println(arrayCircularQueue.getComponent());
        arrayCircularQueue.addComponent(18);
        System.out.println(arrayCircularQueue.getComponent());*/
        MyArrayCircularQueue arrayCircularQueue = new MyArrayCircularQueue(5);
        arrayCircularQueue.addComponent(16);
        arrayCircularQueue.addComponent(8);
        arrayCircularQueue.addComponent(11);
        arrayCircularQueue.addComponent(12);
        System.out.println(arrayCircularQueue.getComponent());
        System.out.println(arrayCircularQueue.getComponent());
        System.out.println(arrayCircularQueue.getComponent());
        System.out.println(arrayCircularQueue.getComponent());
        arrayCircularQueue.addComponent(18);
        System.out.println(arrayCircularQueue.getComponent());

    }
}
//模拟环形队列
class ArrayCircularQueue{
    private int maxSize;
    private int front;
    private int rear;
    //  队列数组存储在该数组里面
    private int[] arr;
    public ArrayCircularQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
//      头部front下标指向0
        front=0;
//      尾部rear下标指向0
        rear=0;
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
        return (rear+1)%maxSize==front;
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
//      在当前位置插入数据
        arr[rear]=num;
        //尾部指针后移一位
        rear=(rear+1)%maxSize;
    }
    //  获取队列数据
    public int getComponent(){
//      如果队列是空的
        if(isEmpty()){
            throw new RuntimeException("队列是空的,无法取出数据");
        }
//      现将front的值保存到一个临时变量
        int value=arr[front];
//      front下标后移
        front=(front+1)%maxSize;
//      直接返回front下标的值
        return value;

    }
    //  显示头数据
    public int getHead(){
//      如果队列是空的
        if(isEmpty()){
            throw new RuntimeException("队列是空的,无法取出数据");
        }
        return arr[front];
    }
    //  显示完整队列数据
    public void showQueue(){
//      如果队列是空的
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("%d\t",arr[i%maxSize]);
        }
    }
//  显示有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
}
//我的思路
class MyArrayCircularQueue{
    private int maxSize;
    private int front;
    private int rear;
    //  队列数组存储在该数组里面
    private int[] arr;
    public MyArrayCircularQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
//      头部front下标指向0
        front=0;
//      尾部rear下标指向0
        rear=0;
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
        return (rear+1)%maxSize==front;
    }
    //  判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //  队列添加
    public void addComponent(int num) {
//      如果队列满了
        if(isFull()) {
            System.out.println("队列已满,不能加入数据");
            return;
        }
//      先插进数据
        arr[rear]=num;
//      尾部指针后移一位
        rear++;
    }
    //  获取队列数据
    public int getComponent(){
//      如果队列是空的
        if(isEmpty()){
            throw new RuntimeException("队列是空的,无法取出数据");
        }
//      定义一个临时变量来存储头部信息
        int value=arr[front];
//      头部指针后移一位
        front++;
        return value;
    }
    //  显示头数据
    public int getHead(){
//      如果队列是空的
        if(isEmpty()){
            throw new RuntimeException("队列是空的,无法取出数据");
        }
        return arr[front];
    }
    //  显示完整队列数据
    public void showQueue(){
//      如果队列是空的
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i =front; i < front+size(); i++) {
            System.out.printf("%d\t",arr[i%maxSize]);
        }
    }
//  获取有效数据的个数
    public int size(){
        return (rear-front+maxSize)%maxSize;
    }
}

