package com.java.linkedlist;

/**
 * @author liusigou
 * @create 2019--11--11--9:53
 */
public class LinkedListTest {
    public static void main(String[] args) {
        HeroNode heroNode1=new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3=new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4=new HeroNode(4,"林冲","豹子头");
        HeroNode heroNode9=new HeroNode(9,"西门庆","小淫驴");
        SingleLinedList list=new SingleLinedList();
        /*list.addHero(heroNode1);
        list.addHero(heroNode2);
        list.addHero(heroNode3);
        list.addHero(heroNode4);*/
        list.addHeroByNo(heroNode1);
        list.addHeroByNo(heroNode2);
        list.addHeroByNo(heroNode9);
        list.addHeroByNo(heroNode4);
        list.addHeroByNo(heroNode3);
        /*HeroNode heroNode5=new HeroNode(4,"林冲","龟头");
        list.alterHeroNode(heroNode5);*/
        list.list();
        System.out.println("-------------------");
        list.reverseList();
        list.list();
        /*System.out.println("------------------");
        list.deleteHeroNode(heroNode3);
        list.list();*/
        /*System.out.println("-------------------");
        list.findHeroByNo(4);
        System.out.println("-------");
        System.out.println("有效节点:"+list.size());
        System.out.println("-------------------");
        System.out.println("倒数第二位");
        list.findHeroByReNo(2);*/
    }
}
//建立单向链表
class SingleLinedList{
    //建议一个头结点
    private HeroNode head;
    public SingleLinedList(){
        head=new HeroNode();
    }
    //添加节点到单向链表
    //当不考虑no排序的时候
    public void addHero(HeroNode heroNode){
        if(heroNode==null){
            System.out.println("不能插入空数据");
            return;
        }
        //定义一个临时变量来遍历链表
        HeroNode temp=head;
        while(temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(heroNode);
    }
    //添加节点到单向链表
    //当考虑no排序的时候
    public void addHeroByNo(HeroNode heroNode){
        if(heroNode==null){
            System.out.println("不能插入空数据");
            return;
        }
        //定义一个临时变量来遍历链表
        HeroNode temp=head;
        while(temp.getNext()!=null){
            if(temp.getNext().getNo()==heroNode.getNo()){
                System.out.println("该英雄已经存在");
                return;
            }
            if(temp.getNext().getNo()>heroNode.getNo()){
                break;
            }
            temp=temp.getNext();
        }
        heroNode.setNext(temp.getNext());
        temp.setNext(heroNode);
    }
    //根据编号来修改节点信息,编号不能变
    public void alterHeroNode(HeroNode newHeroNode){
        //判断是否为空
        if(head.getNext()==null){
            System.out.println("链表为空");
            return;
        }
        //定义一个临时变量来遍历链表
        HeroNode temp=head;
        //判断是否链表中有符合的数据
        boolean flag=false;
        while(temp.getNext()!=null){
            if(temp.getNo()==newHeroNode.getNo()){
                flag=true;
                break;
            }
            temp=temp.getNext();
        }
        if(flag){
            temp.setName(newHeroNode.getName());
            temp.setNickName(newHeroNode.getNickName());
        }
        else{
            System.out.println("链表里没有这个英雄");
            return;
        }
    }
    //删除节点
    public void deleteHeroNode(HeroNode heroNode){
        if(head.getNext()==null){
            System.out.println("链表是空的,无节点可删除");
            return;
        }
        //定义一个遍历变量
        HeroNode temp=head;
        //定义一个标识看是否有这个节点
        boolean flag=false;
        while(temp.getNext()!=null){
            if(temp.getNext().getNo()==heroNode.getNo()){
                flag=true;
                break;
            }
            temp=temp.getNext();
        }
        if(flag){
            temp.setNext(temp.getNext().getNext());
        }
        else{
            System.out.println("不存在该节点");
        }
    }
    //通过英雄编号来查找
    public void findHeroByNo(int no){
        if(no<0){
            System.out.println("英雄编号不合法");
            return;
        }
        //定义一个遍历变量
        HeroNode temp=head.getNext();
        boolean flag=false;
        while(true){
            if(temp.getNo()==no){
                flag=true;
                break;
            }
            if(temp.getNext()==null){
                break;
            }
            temp=temp.getNext();
        }
        if(flag){
            System.out.println(temp);
        }
        else{
            System.out.println("没有该英雄");
        }
    }
    //遍历链表
    public void list(){
        //如果链表为空
        if(head.getNext()==null){
            System.out.println("链表为空");
            return;
        }
        //定义一个临时变量来遍历链表
        HeroNode temp=head.getNext();
        while(true){
            System.out.println(temp);
            if(temp.getNext()==null){
                break;
            }
            temp=temp.getNext();
        }
    }
    //获取链表的有效节点
    public int size(){
        //如果链表是空
        if(head.getNext()==null){
            return 0;
        }
        HeroNode temp=head;
        int count=0;
        while(temp.getNext()!=null){
            temp=temp.getNext();
            count++;
        }
        return count;
    }
    //获取倒数第n个节点的信息
    public void findHeroByReNo(int index){
        if(index<0||index>size()){
            System.out.println("输入位置信息不合法");
            return;
        }
        //如果链表为空
        if(head.getNext()==null){
            System.out.println("链表为空");
            return;
        }
        //确定正序位置
        int site=size()-index;
        //定义遍历,从有效节点开始遍历
        HeroNode temp=head.getNext();
        //由于是有效节点,可以直接遍历
        for(int i=0;i<site;i++){
            temp=temp.getNext();
        }
        System.out.println(temp);
    }
    //链表反转
    public void reverseList(){
        //如果链表为空或者只有一个节点
        if(head.getNext()==null||head.getNext().getNext()==null){
            System.out.println("反转无意义");
            return;
        }
        //定义一个遍历变量
        HeroNode temp=head;
        //定义一个next
        HeroNode next=null;
        //定义一个反转头
        HeroNode reverseHead=new HeroNode();
        while(temp.getNext()!=null){
            temp=temp.getNext();
            next=temp.getNext();
            temp.setNext(reverseHead.getNext());
            reverseHead.setNext(temp);
            temp=next;
        }
        head.setNext(reverseHead.getNext());
    }
}
//定义英雄节点
class HeroNode{
    //排名
    private int no;
    //名字
    private String name;
    //花名
    private String nickName;
    //下一个节点
    private HeroNode next;
    //定义一个构造器作为头结点,不存放数据
    public HeroNode(){
        this.no=0;
        this.name=null;
        this.nickName=null;
        this.next=null;
    }
    //定义一个构造器作为正常节点
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.next=null;
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
