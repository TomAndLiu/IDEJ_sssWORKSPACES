package com.test.sort;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2020--01--05--13:49
 */
//希尔排序
public class ShellSort {
    public static void main(String[] args) {
        int[] num={8,9,1,7,2,3,5,4,6,0};
        System.out.println("开 始希尔排序之前:"+ Arrays.toString(num));
        //shellSort(num);
        shellSortImprove(num);
        /*
        希尔排序的思路:根据数组的长度来划分每一轮分组的组数,比如
        假定数组长度为8,第一轮的的步数为gap=8/2=4,8个元素分为四组,每一个元素与
        它所在组对应的数的步数为gap=4,第二轮的步数为gap=4/2=2,8个元素分为2组
        每一个元素与它所在组对应的数的步数为gap=2,第三轮的步数为gap=2/2=1,8个元
        素分为1组,此时我们发现当gap=1的时候就是最后一次排序了
         */
        /*
        //第一轮排序
        //定义一个步数
        int gap=num.length/2;
        //定义一个交换变量
        int temp=0;
        //遍历数组,由于数组有10个,所以第一轮的gap=5,5组数据,需要遍历num.length-5次
        for(int i=5;i<num.length;i++){
            //每一组的数组都互相比较
            for(int j=i-gap;j>=0;j-=gap){
                //同一组的数据相邻步数为gap
                if(num[j]>num[j+gap]){
                    temp=num[j];
                    num[j]=num[j+gap];
                    num[j+gap]=temp;
                }
            }
        }
        System.out.println("第一轮希尔排序之后:"+ Arrays.toString(num));
        //第二轮排序
        gap=gap/2;
        //遍历数组,由于第一轮的gap=5,所以第二轮的gap=5/2=2,需要遍历num.length-2
        for(int i=2;i<num.length;i++){
            //每一组的数组都互相比较
            for(int j=i-gap;j>=0;j-=gap){
                //同一组的数据相邻步数为gap
                if(num[j]>num[j+gap]){
                    temp=num[j];
                    num[j]=num[j+gap];
                    num[j+gap]=temp;
                }
            }
        }
        System.out.println("第二轮希尔排序之后:"+ Arrays.toString(num));
        */
    }
    //希尔排序
    public static void shellSort(int[] num){
        //结合几轮排序的规律
        //当gap=1的时候就是最后一次,所以用gap>0
        //定义一个交换变量
        int temp=0;
        //定义一个记录次数的值
        int count=0;
        for(int gap=num.length/2;gap>0;gap/=2){
            //总共需要遍历的次数为num.length-gap
            for(int i=gap;i<num.length;i++){
                //比较每一组的数据
                for(int j=i-gap;j>=0;j-=gap){
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
    //希尔排序优化
    public static void shellSortImprove(int[] num){
        //结合几轮排序的规律
        //当gap=1的时候就是最后一次,所以用gap>0
        //定义一个记录次数的值
        int count=0;
        for(int gap=num.length/2;gap>0;gap/=2){
            for(int i=gap;i<num.length;i++){
                //定义一个j
                int j=i;
                //获取j下标的值
                int temp=num[j];
                if(num[j-gap]>num[j]){
                    while(j-gap>=0 && num[j-gap]>temp){
                        //进行移位
                        num[j]=num[j-gap];
                        //跨步数寻找上一个数
                        j-=gap;
                    }
                    //当跳出来的时候,说明可以插入了
                    //因为已经减过了 j-=gap;
                    num[j]=temp;
                }

            }
            count++;
            System.out.println("第"+count+"轮希尔排序之后:"+Arrays.toString(num));
        }
    }
}
