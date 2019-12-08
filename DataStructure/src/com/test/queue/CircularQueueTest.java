package com.test.queue;

/**
 * @author liusigou
 * @create 2019--12--08--14:10
 */
public class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue arrayQueue=new CircularQueue(5);
        arrayQueue.addComponent(5);
        arrayQueue.addComponent(7);
        arrayQueue.addComponent(9);
        arrayQueue.addComponent(8);

        System.out.println("------------");
        /*arrayQueue.getComponent();
        arrayQueue.getComponent();
        arrayQueue.getComponent();
        arrayQueue.getComponent();
        arrayQueue.addComponent(3);
        arrayQueue.getComponent();*/
        System.out.println("-----------------");
        arrayQueue.queueList();
    }
}
class CircularQueue{
    //定义队列最大长度
    private int maxSize;
    //定义头指针
    private int front;
    //定义尾指针
    private int rear;
    //定义存储数据的数组
    private int[] arr;
    public CircularQueue(int maxSize){
        this.maxSize=maxSize;
        this.arr=new int[maxSize];
        //头指针指向0
        this.front=0;
        //为指针指向0
        this.rear=0;
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

    //判断队列是否已经满了
    public boolean isFull(){
        //预留出一个位置来判断是否满了
        return (rear+1)%maxSize==front;
    }
    //判断是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据
    public void addComponent(int num){
        //如果已经满了
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear]=num;
        //当rear到max最大值的时候,从头开始算
        rear=(rear+1)%maxSize;
    }
    //取出数据
    public void getComponent(){
        //如果为空
        if(isEmpty()){
            System.out.println("数据为空");
            return;
        }
        System.out.println(arr[front]);
        //当front到max最大值的时候,从头开始算
        front=(front+1)%maxSize;
    }
    //显示有效数据
    public int size(){
        //当rear下标小于front下标的时候就需要加上最大值再余最大值
        return (rear+maxSize-front)%maxSize;
    }
    //取出所有数据
    public void queueList(){
        //如果为空
        if(isEmpty()){
            System.out.println("数据为空");
            return;
        }
        //从头指针开始读
        for (int i = front; i < front+size(); i++) {
            //当i大于maxSize的时候就余
            System.out.printf("%d\t",arr[i%maxSize]);
        }
    }
}
