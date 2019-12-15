package com.java.stack;

/**
 * @author liusigou
 * @create 2019--12--14--13:46
 */

public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack linkedListStack=new LinkedListStack();
        linkedListStack.addComponent(5);
        linkedListStack.addComponent(6);
        linkedListStack.addComponent("你好");

        linkedListStack.addComponent("必须");


        System.out.println(linkedListStack.pop());

        System.out.println("---------------------");
        linkedListStack.list();

    }
}
//创建一个节点类
class Node<E>{
    private Object data;
    private Node<E> next;
    public Node(){
        this.data = null;
        this.next=null;
    }
    //普通节点
    public Node(Object data) {
        this.data = data;
        this.next=null;
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
//用链表做出栈的结构
class LinkedListStack<E>{

    //定义一个top指针
    private Node<E> top=null;
    public LinkedListStack(){

    }

    public Node<E> getTop() {
        return top;
    }

    public void setTop(Node<E> top) {
        this.top = top;
    }
    //获取链表的有效个数
    public int size(){
        int count=0;
        //定义一个遍历节点
        Node<E> current=top;
        //如果top节点指向空就返回0
        while(current!=null){
            count++;
            //如果下个节点不为空就继续,否则就跳出
            if(current.getNext()!=null){
                current=current.getNext();
            }
            else{
                break;
            }

        }
        return count;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return size()==0;
    }
    //添加数据
    public void addComponent(Object data){
        if(data==null){
            System.out.println("不能添加空数据");
            return;
        }
        //如果是空,就让top成为第一个节点
        if(isEmpty()){
            top=new Node<E>(data);
        }
        else{
            //新增节点
            Node<E> node=new Node<E>(data);
            //新节点指向top
            node.setNext(top);
            //top等于新节点
            top=node;
        }
    }
    //取出数据
    public Object pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空,无法取出数据");
        }
        //利用一个result来接收top的值
        Object result= top.getData();
        top=top.getNext();
        return result;
    }
    //完整取出数据
    public void list(){
        if(isEmpty()){
            throw new RuntimeException("栈为空,无法取出数据");
        }
        //当栈不为空就继续遍历
        while(size()>0){
            System.out.println(pop());
        }
    }
}
