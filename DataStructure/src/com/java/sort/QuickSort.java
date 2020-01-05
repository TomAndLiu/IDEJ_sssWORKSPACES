package com.java.sort;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2019--12--29--20:03
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] num={-9,0,0,23,0,70};
        System.out.println("快速排序前:"+ Arrays.toString(num));
        quickSort2(num,0,num.length-1);
        System.out.println("快速排序后:"+ Arrays.toString(num));


        /*
        int[] num=new int[8000000];
        //随机生成8000个数
        for (int i = 0; i < num.length; i++) {
            num[i]=(int)(Math.random()*10000);
        }
        //定义时间格式
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取排序前的时间
        Date date1=new Date();
        String d1=simpleDateFormat.format(date1);
        System.out.println("快速排序前的时间:"+d1);
        quickSort(num,0,num.length-1);
        //获取排序后的时间
        Date date2=new Date();
        String d2=simpleDateFormat.format(date2);
        System.out.println("快速排序前的时间:"+d2);
        */
    }
    //快速排序

    /**
     *
     * @param num 一维数组
     * @param left 左边的索引
     * @param right 右边的索引
     */
    public static void quickSort(int[] num,int left,int right){
        int l=left;//左索引下标
        int r=right;//右索引下标
        int pivot=num[(left+right)/2];//中轴值
        int temp=0;//定义一个临时变量进行交换
        //开始进行循环遍历,该循环的目的是为了找出比pivot小的放在pivot左边,比pivot大的放在
        //pivot右边
        while(l<r){
            //左边的索引开始遍历,找到比pivot大或者等于pivot的记录下来
            while(num[l]<pivot){
                l++;
            }
            //退出之后,此时num[l]比pivot大
            //右边的索引开始遍历,找到比pivot小或者等于pivot的记录下来
            while(num[r]>pivot){
                r--;
            }
            //退出之后,此时num[r]比pivot小

            //如果l>=r,说明已经按照pivot左边的值小于pivot,pivot右边的值大于pivot
            //的规律进行排列,所以没必要进行交换
            if(l>=r){
                break;
            }
            else{
                //此时进行交换
                temp=num[l];
                num[l]=num[r];
                num[r]=temp;
            }
            //下面这两个不知道为什么
            /*
            * 如果不加这两个,在num[l]==pivot的时候就会一直陷入while(num[l]<pivot)的死循环
            * 所以当num数组中存在与中轴数相同的时候就后移一位或者前移一位
            * */
            if(num[l]==pivot){
                l++;
            }
            if(num[r]==pivot){
                r--;
            }


        }

        //遍历结束如果出现l==r，就左边加一,右边减一
        if(l==r){
            l++;
            r--;
        }
        //向左边递归
        if(left<r){
            quickSort(num,left,r);
        }
        //向右边递归
        if(right>l){
            quickSort(num,l,right);
        }
        //System.out.println("第一轮快速排序后:"+Arrays.toString(num));
    }
    public static void quickSort2(int[] num,int left,int right){
        //定义两个游标来接收left right
        int l=left;
        int r=right;
        //定义一个交换值
        int temp=0;
        //定义中轴值,也就是基准,取中间的数作为基准
        int pivot=num[(l+r)/2];
        //开始遍历,当左游标小于右游标的时候
        while(l<r){
            //在左边找到比基准大的数
            while(num[l]<pivot){
                l++;
            }
            //跳出这个循环的时候说明找到大于或者等于基准的值
            //在右边找到比基准小的数
            while(num[r]>pivot){
                r--;
            }
            //跳出这个循环的时候说明找到小于或者等于基准的值
            //如果l>=r,说明此时数据已经按照左边的值小于基准 右边的值大于基准的规律排列
            if(l>=r){
                break;
            }
            else{
                //进行交换
                temp=num[l];
                num[l]=num[r];
                num[r]=temp;
            }
            //交换完后如果发现 num[l]或者num[r] 等于中轴值,就要移动,不然会陷入死循环的
            if(num[l]==pivot){
                l++;
            }
            if(num[r]==pivot){
                r--;
            }
        }
        //跳出循环之后
        //如果l==r,必须要把他们错开来,不然进入递归的时候会报错
        if(l==r){
            l++;
            r--;
        }
        //在每一个递归的栈里面,left right都是不会变化的,而l r游标会变化位置
        //递归是有步骤的,先想左边一直递归,左边递归好就从一个个栈里面逐步退出去右递归

        //如果left还是小于右游标,就继续左递归
        //left到r是一个完整待排序部分
        if(left<r){
            quickSort2(num,left,r);
        }

        //如果right还是大于左游标,就继续右递归
        //l到right是一个完整待排序部分
        if(right>l){
            quickSort2(num,l,right);
        }
    }
}
