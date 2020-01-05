package com.java.sort;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2019--12--29--10:19
 */
public class ShellSort {
    public static void main(String[] args) {
        /*
        int[] num={8,9,1,7,2,3,5,4,6,0};
        System.out.println("开 始希尔排序之前:"+Arrays.toString(num));
        shellSort(num);
        */
        int[] num={8,9,1,7,2,3,5,4,6,0};
        System.out.println("开 始优化版希尔排序之前:"+Arrays.toString(num));
        shellSortProvide(num);
        System.out.println("开 始优化版希尔排序之后:"+Arrays.toString(num));
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
        System.out.println("选择排序前的时间:"+d1);
        shellSortProvide(num);
        //获取排序后的时间
        Date date2=new Date();
        String d2=simpleDateFormat.format(date2);
        System.out.println("选择排序后的时间:"+d2);
        */
    }
    public static void shellSort(int[] num){
        //定义一个交换变量
        int temp=0;
        //定义一个记录次数的值
        int count=0;
        //根据以上的数据可以得到一个规律,每次变化的都是步长
        for(int gap=num.length/2;gap>0;gap/=2){
            /*分为gap组数据,当gap为5的时候,每组两个数据,需要5次比较
            * 当gap=2的时候,每组5个数据,需要8次比较
            * 当gap=1的时候,总共一个组,10个数据,需要10次比较
            *  */
            for (int i = gap; i < num.length; i++) {
                //从j = i-gap哪里开始比较 j >= 0才继续执行 j-=gap每次跨越gap步
                for (int j = i-gap; j >= 0 ; j-=gap) {
                    //如果同一组数中
                    if(num[j]>num[j+gap]){
                        temp=num[j];
                        num[j]=num[j+gap];
                        num[j+gap]=temp;
                    }
                }
            }
            count++;
            System.out.println("第"+count+"轮希尔排序之后:"+Arrays.toString(num));
        }
    }
    public static void shellSortByWay(int[] num){
        int temp=0;
        //希尔排序的第一轮排序
        //第一轮排序,将10个数据分成10/2=5组
        for (int i = 5; i < num.length; i++) {
            //当i为5的时候,j为0,这两个为一组数据
            /*
             * 为什么要j-=5呢,每次跨五步进行比较
             * 所以要用j-每一组组数
             * */
            for (int j = i-5; j >=0 ; j-=5) {
                if(num[j]>num[j+5]){
                    temp=num[j];
                    num[j]=num[j+5];
                    num[j+5]=temp;
                }
            }
        }
        System.out.println("第一轮希尔排序之后:"+ Arrays.toString(num));
        //第二轮排序,将数据分成5/2=2组
        for (int i = 2; i < num.length; i++) {
            //当i为5的时候,j为0,这两个为一组数据
            /*
             * 为什么要j-=2呢,每次跨两步进行比较
             * 所以要用j-每一组组数
             * */
            for (int j = i-2; j >=0 ; j-=2) {
                if(num[j]>num[j+2]){
                    temp=num[j];
                    num[j]=num[j+2];
                    num[j+2]=temp;
                }
            }
        }
        System.out.println("第二轮希尔排序之后:"+ Arrays.toString(num));
        //第三轮排序,将数据分成2/2=1组
        for (int i = 1; i < num.length; i++) {
            //当i为5的时候,j为0,这两个为一组数据
            /*
             * 为什么要j-=1呢,每次跨一步进行比较
             * 所以要用j-每一组组数
             * */
            for (int j = i-1; j >=0 ; j-=1) {
                if(num[j]>num[j+1]){
                    temp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        //在第三轮的时候就已经排序好了,第四轮也就是当1/2=0时就不需要再继续排序
        System.out.println("第三轮希尔排序之后:"+ Arrays.toString(num));
    }
    //对交换式的希尔排序进行改进
    public static void shellSortProvide(int[] num){
        //增量gap,并逐步减少增量
        for(int gap=num.length/2;gap>0;gap/=2){
            for(int i=gap;i<num.length;i++){
                int j=i;
                int temp=num[j];
                if(num[j]<num[j-gap]){
                    while(j-gap>=0 && temp<num[j-gap]){
                        num[j]=num[j-gap];
                        j-=gap;
                    }
                    //当跳出这个循环的时候已经j=j-gap,所以此时j就是要插入的位置
                    num[j]=temp;
                }
            }
        }
    }
}
