package com.test.linkedlist;

/**
 * @author liusigou
 * @create 2019--12--07--13:34
 */
public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println("开始启动");
        //定义数据
        HeroNode heroNode1=new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3=new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4=new HeroNode(4,"林冲","豹子头");
        //测试单向链表
        SingleLinkedList linkedList=new SingleLinkedList();
        //添加数据
//        linkedList.addHero(heroNode1);
//        linkedList.addHero(heroNode2);
//        linkedList.addHero(heroNode3);
//        linkedList.addHero(heroNode4);
        linkedList.addHeroByNo(heroNode1);
        linkedList.addHeroByNo(heroNode4);
        linkedList.addHeroByNo(heroNode3);
        linkedList.addHeroByNo(heroNode2);
        linkedList.list();
        System.out.println("英雄个数"+linkedList.length());
        linkedList.deleteHero(heroNode3);
        linkedList.list();
        linkedList.deleteHero(new HeroNode(9,"西门庆","小淫驴"));
        linkedList.list();
        System.out.println("---------------------------");
        linkedList.findByNo(2);
        linkedList.findByNo(3);
        System.out.println("---------------------");
        linkedList.alterHero(new HeroNode(1,"武松","贴行者"));
        linkedList.alterHero(new HeroNode(9,"西门庆","小淫驴"));
        linkedList.list();
        System.out.println("------------------------");
        linkedList.findHeroByReNo(2);
        System.out.println("-----------------------");
        linkedList.reverseList();
        linkedList.list();
    }
}
//定义节点
class HeroNode{
    //定义编号
    private int no;
    //定义名字
    private String name;
    //定义花名
    private String nickName;
    //定义下一个节点
    private HeroNode next;
    //定义头结点
    public HeroNode(){
        this.no=0;
        this.name=null;
        this.nickName=null;
        this.next=null;
    }
    //定义普通节点
    public HeroNode(int no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
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
//定义单向链表
class SingleLinkedList{
    //定义一个头结点
    private HeroNode head;
    public SingleLinkedList(){
        head=new HeroNode();
    }
    //定义链表长度
    public int length(){
        //定义计数器
        int count=0;
        //如果链表为空
        if(head.getNext()==null){
            return count;
        }
        //定义一个遍历器
        HeroNode current=head;
        while(current.getNext()!=null){
            current=current.getNext();
            count++;
        }
        return count;
    }
    //添加节点不排名
    public void addHero(HeroNode node){
        //判断英雄节点是否合法
        if(node==null){
            System.out.println("不能插入空数据");
            return;
        }
        //定义一个遍历指针
        HeroNode current=head;
        while(current.getNext()!=null){
            current=current.getNext();
        }
        current.setNext(node);
    }
    //添加节点排名
    public void addHeroByNo(HeroNode node){
        if(node==null){
            System.out.println("不能添加空数据");
            return;
        }
        //定义遍历节点
        HeroNode current=head;
        while(current.getNext()!=null){

            //如果英雄重复
            if(current.getNext().getNo()==node.getNo()){
                System.out.println("不能插入已存在的英雄");
                return;
            }
            //如果下一个节点英雄的排名比插入的大
            if(current.getNext().getNo()>node.getNo()){
                break;
            }
            current=current.getNext();
        }
        //先让插入节点的下一个节点指向当前指针的下一个节点，再让让当前指针的下个节点指向插入节点
        node.setNext(current.getNext());
        current.setNext(node);
    }
    //遍历节点
    public void list(){
        //如果是空链表
        if(head.getNext()==null){
            System.out.println("链表为空");
            return;
        }
        //定义遍历指针
        HeroNode current=head;
        while(current.getNext()!=null){
            current=current.getNext();
            System.out.println(current);
        }
    }
    //删除某个节点
    public void deleteHero(HeroNode node){
        //如果要删除的节点为空
        if(node==null){
            System.out.println("不能删除空节点");
            return;
        }
        //定义一个标识,判断列表有没有这个节点
        boolean flag=false;
        //定义一个遍历节点
        HeroNode current=head;
        while(current.getNext()!=null){
            //如果下一个节点就是要删除的节点
            if(current.getNext().getNo()==node.getNo()){
                flag=true;
                break;
            }
            current=current.getNext();
        }
        //判断有没有这个节点
        if(flag){
            current.setNext(current.getNext().getNext());
        }
        else{
            System.out.println("没有该节点");
        }
    }
    //通过英雄编号寻找英雄
    public void findByNo(int no){
        if(no<0||no>length()){
            System.out.println("输入编号不合理");
            return;
        }
        //判断有没有这位英雄
        boolean flag=false;
        //定义遍历指针
        HeroNode current=head;
        while(current.getNext()!=null){
            current=current.getNext();
            if(current.getNo()==no){
                flag=true;
                break;
            }
        }
        if(flag){
            System.out.println(current);
        }else{
            System.out.println("没有这位英雄");
        }
    }
    //根据编号修改英雄信息
    public void alterHero(HeroNode node){
        if(node==null){
            System.out.println("修改节点数据不能为空");
        }
        //判断是否有该英雄
        boolean flag=false;
        //定义遍历指针
        HeroNode current=head;
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
            System.out.println("没有这个英雄");
        }
    }
    //获取倒数第n个节点的信息
    public void findHeroByReNo(int index){
        if(index<0||index>length()){
            System.out.println("输入数据不合理");
            return;
        }
        //定义遍历指针
        HeroNode current=head;
        //倒数第N个,用有效节点减去index,再从0开始,由于已经是有效节点了,没必要判断是否为空
        for (int i = 0; i <=(length()-index) ; i++) {
            current=current.getNext();
        }
        System.out.println("倒数第"+index+"个的英雄数据为:"+current);

    }
    //反转链表
    public void reverseList(){
        //如果链表为空或者只有一个节点
        if(head.getNext()==null||head.getNext().getNext()==null){
            System.out.println("反转没有意义");
            return;
        }
        //定义一个遍历节点
        HeroNode current=head.getNext();
        //定义一个next节点,保存current节点的下一个几点
        HeroNode next=null;
        //定义一个全新节点
        HeroNode reverseHead=new HeroNode();
        while(current!=null){
            next=current.getNext();
            //current指向反转节点的next,反转节点的next执行current
            current.setNext(reverseHead.getNext());
            reverseHead.setNext(current);
            current=next;
        }
        //头结点的next指向反转节点的next
        head.setNext(reverseHead.getNext());
    }
}
