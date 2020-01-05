package com.java.sort;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2019--12--25--19:47
 */
public class BubbleSort {
    public static void main(String[] args) {
        /*
        int arr[]={3,9,-1,20,-2};
        System.out.println("第一趟排序前:"+ Arrays.toString(arr));
        //第一趟排序,将最大的数排在最后面
        //定义一个临时变量来存储临时数据
        int temp=0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        //第一趟排序完,看效果
        System.out.println("第一趟排序后:"+ Arrays.toString(arr));

        //第二趟排序,把第二大的数排在后面
        for (int i = 0; i < arr.length-1-1; i++) {
            if(arr[i]>arr[i+1]){
                temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        //第二趟排序完,看效果
        System.out.println("第二趟排序后:"+ Arrays.toString(arr));
        //第三趟排序,把第三大的数排在后面
        for (int i = 0; i < arr.length-1-1-1; i++) {
            if(arr[i]>arr[i+1]){
                temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        //第三趟排序完,看效果
        System.out.println("第三趟排序完:"+ Arrays.toString(arr));

        //第四趟排序,把第四大的数排在后面
        //定义一个临时变量来存储临时数据
        for (int i = 0; i < arr.length-1-1-1-1; i++) {
            if(arr[i]>arr[i+1]){
                temp=arr[i+1];
                arr[i+1]=arr[i];
                arr[i]=temp;
            }
        }
        //第四趟排序完,看效果
        System.out.println("第四趟排序完:"+ Arrays.toString(arr));

        //由于只有五个数,所有只需要排序四遍
        System.out.println("--------------------------------------");*/
        //优化冒泡排序
        //int array[]={1,-2,10,8,5};
        //冒泡排序
//        bubbleSort(array);
//        System.out.println("排序后:"+ Arrays.toString(array));


        /*
        //测试冒泡排序速度
        //创建8000个随机数
        int[] arr=new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*10000);
        }
        System.out.println(Arrays.toString(arr));
        //获取当前时间
        Date current=new Date();
        //格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatC = simpleDateFormat.format(current);
        System.out.println("当前时间是:"+formatC);
        //排序
        bubbleSort(arr);
        //获取排序过后的时间
        Date sortDate=new Date();
        //格式化
        String formatS=simpleDateFormat.format(sortDate);
        //排序后
        System.out.println("排序后时间:"+formatS);

        System.out.println(Arrays.toString(arr));

        */
        int arr[]={3,9,-1,20,-2};
        System.out.println("冒泡排序前:"+ Arrays.toString(arr));
        bubbleSort(arr);
    }
    public static void bubbleSort(int[] array){
        boolean flag=false;
        //定义临时变量
        int temp=0;
        //定义一个变量观看排序了多少次
        int count=0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                    flag=true;
                }
            }
            //当一轮排序完之后,判断有没有交换,没有的话就退出
            if(!flag){
                break;
            }else{
                flag=false;
            }
            System.out.println("冒泡排序第"+(i+1)+"轮:"+ Arrays.toString(array));
        }
    }
}
