package com.java.linkedlist;

/**
 * @author liusigou
 * @create 2019--12--09--19:58
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        HeroNode2 hero1=new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2=new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3=new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4=new HeroNode2(4,"林冲","豹子头");
        DoubleLinkedList doubleList=new DoubleLinkedList();
        doubleList.addHero2(hero1);
        doubleList.addHero2(hero2);
        doubleList.addHero2(hero3);
        doubleList.addHero2(hero4);
        doubleList.list();
        System.out.println("------------------------");
        doubleList.alterHero(new HeroNode2(4,"林冲","鬼头"));
        doubleList.list();
        System.out.println("------------------------");
        doubleList.deleteHero(4);
        doubleList.list();
        doubleList.deleteHero(5);
    }
}
class HeroNode2 {
    //排名
    private int no;
    //名字
    private String name;
    //花名
    private String nickName;
    //下一个节点
    private HeroNode2 next;
    //上一个节点
    private HeroNode2 pre;
    //定义一个头结点
    public HeroNode2() {
        this.no=0;
        this.name=null;
        this.nickName=null;
        this.next=null;
        this.pre=null;
    }
    //普通节点
    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.next=null;
        this.pre=null;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }
}
//双向链表
class DoubleLinkedList{
    //定义头结点
    private HeroNode2 head;
    public DoubleLinkedList(){
        this.head=new HeroNode2();
    }
    public HeroNode2 getHead() {
        return head;
    }

    public void setHead(HeroNode2 head) {
        this.head = head;
    }
    //双向链表添加功能,没有排序
    public void addHero2(HeroNode2 node){
        if(node==null){
            System.out.println("不能添加空数据");
            return;
        }
        //定义遍历指针
        HeroNode2 current=head;
        while(current.getNext()!=null){
            current=current.getNext();
        }
        //当前节点的下一个节点指向node
        current.setNext(node);
        //node的上一个节点指向current
        node.setPre(current);
    }
    //遍历
    public void list(){
        if(head.getNext()==null){
            System.out.println("链表为空");
            return;
        }
        //定义遍历指针
        HeroNode2 current=head;
        while(current.getNext()!=null){
            current=current.getNext();
            System.out.println(current);
        }
    }
    //修改节点
    public void alterHero(HeroNode2 node){
        //如果节点是空数据
        if(node==null){
            System.out.println("数据不合法");
            return;
        }
        //定义遍历指针
        HeroNode2 current=head;
        //判断是否有匹配的英雄节点
        boolean flag=false;
        while(current.getNext()!=null){
            current=current.getNext();
            if(current.getNo()==node.getNo()){
                flag=true;
                break;
            }
        }
        if(flag){
            current.setName(node.getName());
            current.setNickName(node.getNickName());
        }
        else{
            System.out.println("列表没有该节点");
        }
    }
    //通过编号删除节点
    public void deleteHero(int no){
        if(no<0||no>length()){
            System.out.println("数据不合法");
            return;
        }
        //定义遍历指针
        HeroNode2 current=head;
        //判断有没有这个节点
        boolean flag=false;
        while(current.getNext()!=null){
            current=current.getNext();
            if(current.getNo()==no){
                flag=true;
                break;
            }
        }
        if(flag){
            //把当前节点的上一个节点的下一个节点指向当前节点的下一个节点
            current.getPre().setNext(current.getNext());
            //如果是最后一个节点,就不用指向下面这句话
            //把当前节点的下一个节点的上一个节点指向当前节点的上一个节点
            if(current.getNext()!=null){
                current.getNext().setPre(current.getPre());
            }
        }
        else{
            System.out.println("列表没有该节点");
        }
    }
    //得出有效节点长度
    public int length(){
        int count=0;
        if(head.getNext()==null){
            return count;
        }
        //定义遍历节点
        HeroNode2 current=head;
        while(current.getNext()!=null){
            current=current.getNext();
            count++;
        }
        return count;
    }
}
