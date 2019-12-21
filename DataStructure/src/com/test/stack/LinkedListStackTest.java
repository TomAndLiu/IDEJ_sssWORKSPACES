package com.test.stack;

/**
 * @author liusigou
 * @create 2019--12--21--10:36
 */
public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack linkedListStack=new LinkedListStack();
        linkedListStack.push("s");
        linkedListStack.push(5);
        linkedListStack.push(6);
        linkedListStack.push('a');
        System.out.println(linkedListStack.size());
        System.out.println("-----------------------");
        System.out.println(linkedListStack.peak());
        System.out.println(linkedListStack.pop());
        System.out.println("---****************");
        linkedListStack.list();
    }
}
//定义一个节点类
class Node<E>{
    //定义一个Object类型的数据
    private Object data;
    //定义Next
    private Node<E> next;
    //定义节点
    public Node(Object data){
        this.data=data;
    }
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
//定义一个用链表实现的栈
class LinkedListStack<E>{
    //定义一个top节点
    Node<E> top;
    public LinkedListStack(){

    }
    //获取链表有效个数
    public int size(){
        int count=0;
        //定义遍历节点
        Node current=top;
        while(current!=null){
            count++;
            current=current.getNext();
        }
        return count;
  }
    //判断栈是否为空
    public boolean isEmpty(){
        return size()==0;
    }
    //添加数据
    public void push(Object data){
        if(data==null){
            System.out.println("不能添加空数据");
            return;
        }
        //如果是第一个数
        if(top==null){
            top=new Node<E>(data);
        }else{
            //创建一个节点
            Node<E> node=new Node<E>(data);
            //让当前节点指向栈顶
            node.setNext(top);
            //栈顶top指针上移
            top=node;
        }
    }
    //取出数据
    public Object pop(){
        if(isEmpty()){
            System.out.println("栈为空,无法取出数据");
            return null;
        }
        Object data=top.getData();
        top=top.getNext();
        return data;
    }
    //观看栈顶
    public Object peak(){
        if(isEmpty()){
            System.out.println("栈为空,无法取出数据");
            return null;
        }
        return top.getData();
    }
    //完整遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈为空,无法取出数据");
            return;
        }
        //定义遍历指针
        Node<E> current=top;
        while(current!=null){
            System.out.println(current.getData());
            current=current.getNext();
        }
    }
}
