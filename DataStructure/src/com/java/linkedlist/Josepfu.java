package com.java.linkedlist;

/**
 * @author liusigou
 * @create 2019--12--10--20:11
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list=new CircleSingleLinkedList();
        list.addBoy(125);
        list.showBoy();
        System.out.println("----------------------");
        list.countBoy(10,20,125);
    }
}
//创建一个boy类
class Boy{
    //创建编号
    private int no;
    //创建指向下一个节点
    private Boy next;
    public Boy(int no) {
        this.no = no;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
//创建环形单向链表
class CircleSingleLinkedList{
    //创建一个first节点
    private Boy first;
    public CircleSingleLinkedList(){
        first=new Boy(-1);
    }

    public Boy getFirst() {
        return first;
    }

    public void setFirst(Boy first) {
        this.first = first;
    }
    //添加小孩
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("nums的值不合法");
            return;
        }
        //定义一个辅助指针
        Boy current=null;
        for (int i = 1; i <= nums; i++) {
            //创建小孩
            Boy boy=new Boy(i);
            //如果是第一个小孩
            if(i==1){
                //first指定之后不再栋,用遍历节点来遍历
                //这两句话构成了环状
                first=boy;
                first.setNext(first);
                //遍历节点此时指向first
                current=first;
            }
            //用遍历修改next指向新节点
            current.setNext(boy);
            //新节点又指向first节点
            boy.setNext(first);
            //遍历节点指向boy节点
            current=boy;
        }
    }
    //遍历节点
    public void showBoy(){
        if(first.getNext()==first||first.getNo()==-1){
            System.out.println("链表为空");
            return;
        }
        //定义遍历节点
        Boy current=first;
        //定义遍历节点
        while(true){
            System.out.printf("小孩的编号%d\n",current.getNo());
            if(current.getNext()==first){
                break;
            }
            current=current.getNext();

        }
    }
    //小孩出圈
    public void countBoy(int startNo,int countNum,int nums){
        //startNo:从第几个小孩数,countNum:数几下,nums:表示最初有几个小孩
        //如果first为空或者起始小孩编号小于1或者起始小孩编号大于小孩人数
        if(first==null||countNum<0||nums<0||startNo<1||startNo>nums){
            System.out.println("参数输入不合理,请重新输入");
            return;
        }
        //定义一个辅助节点,帮助小孩出圈
        Boy helpNode=first;
        //第一步,先让helpNode指向最后一个节点
        while(helpNode.getNext()!=first){
            helpNode=helpNode.getNext();
        }
        //此时helpNode指向最后一个节点
        //此时进入第二步的前兆,报数之前要让first移动到startNo
        /*使用for循环让first和helpNode移动startNo-1次,例如sn等于2,first就等于2-1=1
        helpNode就等于1
        * */
        for(int i=0;i<startNo-1;i++){
            first=first.getNext();
            helpNode=helpNode.getNext();
        }
        while(true){
            //如果只有一个节点,就结束
            if(helpNode==first){
                System.out.println("最后一个小孩是:"+helpNode.getNo());
                break;
            }
            //正式进入第二步,开始报数,小孩只需要移动count-1步
            for(int i=0;i<countNum-1;i++){
                first=first.getNext();
                helpNode=helpNode.getNext();
            }
            //此时first节点指向要出圈的小孩,让这个小孩出圈的方法就是先让first节点移动到下一个节点
            //再让helpNode节点指向first节点
            System.out.println(first.getNo()+"号小孩出圈");
            first=first.getNext();
            helpNode.setNext(first);
        }
    }
}
