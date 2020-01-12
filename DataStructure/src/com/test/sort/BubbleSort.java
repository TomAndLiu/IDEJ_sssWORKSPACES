package com.test.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liusigou
 * @create 2019--12--28--13:24
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int[] num={2,-3,5,4,9,-1};
        int[] num=new int[80000];
        //随机生成8000个数
        for (int i = 0; i < num.length; i++) {
            num[i]=(int)(Math.random()*10000);
        }
        //定义时间格式
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取排序前的时间
        Date date1=new Date();
        String d1=simpleDateFormat.format(date1);
        System.out.println("冒泡排序前的时间:"+d1);
        bubbleSort(num);
        //获取排序后的时间
        Date date2=new Date();
        String d2=simpleDateFormat.format(date2);
        System.out.println("冒泡排序前的时间:"+d2);
    }
    //冒泡排序的思路,相邻两个数互相比较,一轮排序之后,最大的就会在最右边,需要排序n-1轮
    //每次排序,只需要比较n-1次
    //冒泡排序的优化,通过一个flag判断有没有发生交换,如果一次都没有,说明一件有序,可以直接退出
    public static void bubbleSort(int[] num){
        //定义一个temp在交换的时候存值
        int temp=0;
        //定义一个标识判断有没有发生交换
        boolean flag=false;
        for (int i = 0; i < num.length-1; i++) {
            //可以观察到一个规律,当排序完一轮之后,下一轮需要比较的次数会减一,所以第二个for循环写成
            for (int j = 0; j < num.length-1-i; j++) {
                //如果左边的数大于右边的数,交换
                if(num[j]>num[j+1]){
                    temp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                    flag=true;
                }
            }
            //System.out.println("第"+(i+1)+"次排序之后:"+ Arrays.toString(num));
            //如果没有发生交换,说明已经排序完,退出
            if(!flag){
                break;
            }
            else{
                //否则在一轮排序之后继续吧标识设为false
                flag=false;
            }
        }
    }
}
