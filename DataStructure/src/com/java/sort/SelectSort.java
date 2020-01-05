package com.java.sort;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2019--12--26--20:04
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={4,5,2,1,3};
        System.out.println("最开始的时候:"+Arrays.toString(arr));
        //选择排序
        selectSort(arr);
        /*
        //第一轮排序
        //定义一个最小值的下标,默认是0
        int minIndex=0;
        //定义一个最小值,默认是第零个数
        int min=arr[0];
        //定义一个flag判断有没有发生交换
        boolean flag=false;
        for (int i = 0+1; i < arr.length; i++) {
            if(min>arr[i]){//说明此时的min不是最小值,arr[i]此时是最小值
                min=arr[i];//重置最小值
                minIndex=i;//重置最小值下标
                flag=true;
            }
        }
        //第一轮遍历后
        //看有没有交换
        if(flag){
            //让最小值所在位置等于arr[0]
            arr[minIndex]=arr[0];
            //把最小值移动到第零个位置
            arr[0]=min;
        }
        System.out.println("第一轮排序过后:"+ Arrays.toString(arr));

        //第二轮排序
        //默认最小值是第一个数
        min=arr[1];
        //默认最小值下标是1
        minIndex=1;
        for (int i = 0+1+1; i < arr.length; i++) {
            if(min>arr[i]){//说明arr[i]此时是最小值
                min=arr[i];
                minIndex=i;
                flag=true;
            }
        }
        if(flag){
            //交换位置
            arr[minIndex]=arr[1];
            arr[1]=min;
        }
        //第二轮排序后
        System.out.println("第二轮排序过后:"+Arrays.toString(arr));
        */


    }
    //选择排序
    public static void selectSort(int[] arr){

        /*
        //第一轮排序
        //定义一个最小值的下标,默认是0
        int minIndex=0;
        //定义一个最小值,默认是第零个数
        int min=arr[0];
        //定义一个flag判断有没有发生交换
        boolean flag=false;
        for (int i = 0+1; i < arr.length; i++) {
            if(min>arr[i]){//说明此时的min不是最小值,arr[i]此时是最小值
                min=arr[i];//重置最小值
                minIndex=i;//重置最小值下标
                flag=true;
            }
        }
        //第一轮遍历后
        //看有没有交换
        if(flag){
            //让最小值所在位置等于arr[0]
            arr[minIndex]=arr[0];
            //把最小值移动到第零个位置
            arr[0]=min;
        }
        System.out.println("第一轮排序过后:"+ Arrays.toString(arr));

        //第二轮排序
        //默认最小值是第一个数
        min=arr[1];
        //默认最小值下标是1
        minIndex=1;
        for (int i = 1+1; i < arr.length; i++) {
            if(min>arr[i]){//说明arr[i]此时是最小值
                min=arr[i];
                minIndex=i;
                flag=true;
            }
        }
        if(flag){
            //交换位置
            arr[minIndex]=arr[1];
            arr[1]=min;
        }
        //第二轮排序后
        System.out.println("第二轮排序过后:"+Arrays.toString(arr));

        //第三轮排序
        //默认最小值是第二个数
        min=arr[2];
        //默认最小值下标是1
        minIndex=2;
        for (int i = 1+1+1; i < arr.length; i++) {
            if(min>arr[i]){//说明arr[i]此时是最小值
                min=arr[i];
                minIndex=i;
                flag=true;
            }
        }
        if(flag){
            //交换位置
            arr[minIndex]=arr[2];
            arr[2]=min;
        }
        //第三轮排序后
        System.out.println("第三轮排序过后:"+Arrays.toString(arr));
        */




        //综上所述,可以发现一个规律,可以用for循环来解决,最外层需要i-1次

        //定义一个flag判断有没有发生交换
        boolean flag=false;
        for (int i = 0; i < arr.length-1; i++) {
            //定义一个最小值的下标,默认是i
            int minIndex=i;
            //定义一个最小值,默认是第i个数
            int min=arr[i];
            for(int j=i+1;j< arr.length;j++){
                //说明此时arr[j]才是最小值
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                    flag=true;
                }
                //如果要从大到小
                /*if(min<arr[j]){
                    min=arr[j];
                    minIndex=j;
                    flag=true;
                }*/
            }
            //如果发生了交换
            if(flag){
                arr[minIndex]=arr[i];
                arr[i]=min;
                flag=false;
            }
            System.out.println("第"+(i+1)+"次排序后"+Arrays.toString(arr));
        }

    }
}
