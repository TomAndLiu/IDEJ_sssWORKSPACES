package com.java.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liusigou
 * @create 2019--12--28--19:18
 */
public class InsertSort {
    public static void main(String[] args) {
        //int[] num={101,34,109,11};
        //System.out.println("插入排序之前:"+ Arrays.toString(num));
        //插入排序
        //insertSort(num);


        int[] num=new int[800000];
        //随机生成8000个数
        for (int i = 0; i < num.length; i++) {
            num[i]=(int)(Math.random()*10000);
        }
        //定义时间格式
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取排序前的时间
        Date date1=new Date();
        String d1=simpleDateFormat.format(date1);
        System.out.println("选择排序前的时间:"+d1);
        insertSort(num);
        //获取排序后的时间
        Date date2=new Date();
        String d2=simpleDateFormat.format(date2);
        System.out.println("选择排序前的时间:"+d2);
    }
    //插入排序
    public static void insertSort(int[] num){
        /*
        //第一轮排序
        //{101,34,109,11} =》{34,101,109,11}
        //定义待插入数
        int insertVal=num[1];
        //定义待插入数临近数的下标
        int insertIndex=0;//1-1
        //insertIndex>=0确保数组不越位 insertVal<num[insertIndex]就是待插入数小于临近数
        while(insertIndex>=0&&insertVal<num[insertIndex]){
            //这个时候,临近数右移
            num[insertIndex+1]=num[insertIndex];
            //遍历下一个
            insertIndex--;
        }
        //当退出while循环的时候,说明位置可以进行插入了
        //让所处insertIndex下标的数为待插入数
        num[insertIndex+1]=insertVal;
        System.out.println("第一轮插入排序之后:"+ Arrays.toString(num));

        //第二轮排序
        //{34,101,109,11} =》{34,101,109,11}
        //定义待插入数
        insertVal=num[2];
        //定义待插入数临近数的下标
        insertIndex=1;//2-1

        while(insertIndex>=0 && insertVal<num[insertIndex]){
            //右移
            num[insertIndex+1]=num[insertIndex];
            //insertIndex左移
            insertIndex--;
        }
        //当while结束
        num[insertIndex+1]=insertVal;
        System.out.println("第二轮插入排序之后:"+ Arrays.toString(num));

        */
        //以此类推,总共需要插入n-1次

        for (int i = 0; i < num.length-1; i++) {
            //定义待插入数
            int insertVal=num[i+1];
            //定义待插入数临近数的下标
            int insertIndex=i;//1-1
            while(insertIndex>=0 && insertVal<num[insertIndex]){
                //右移
                num[insertIndex+1]=num[insertIndex];
                //insertIndex左移
                insertIndex--;
            }
            /*
            当遍历完之后,有可能有两个极端选择,insertIndex==-1或者insertVal一开始就大于
            num[insertIndex]
            */
            num[insertIndex+1]=insertVal;
            //System.out.println("第"+(i+1)+"轮插入排序之后"+Arrays.toString(num));
        }
    }
}
