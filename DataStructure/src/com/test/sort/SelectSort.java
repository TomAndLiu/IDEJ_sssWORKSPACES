package com.test.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liusigou
 * @create 2019--12--28--13:53
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] num={2,-3,5,4,9,-1};
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
        selectSort(num);
        //获取排序后的时间
        Date date2=new Date();
        String d2=simpleDateFormat.format(date2);
        System.out.println("选择排序前的时间:"+d2);
        //selectSort(num);
    }
    /*
    选择排序思路,先假定第一个数min为最小值,一个数minIndex记录下标min,然后一轮下来,如果其中有比min
    还小的数就让min等于这个数,minIndex等于这个数的下标,等这一轮遍历完就开始交换,交换完,最小值就是
    第下标为0的数,第二轮排序就从第二个数开始,所以第一层for循环只需要n-1次,第二次需要遍历到最后一个数
    ,所以是n次
    */
    public static void selectSort(int[] num){
        //定义一个标识判断最小值有没有发生交换
        boolean flag=false;
        //遍历n-1次就行了
        for (int i = 0; i < num.length-1; i++) {
            //定义一个最小值,默认初始值是num[0],然后逐步后移 num[1] num[2] ... num[n-1-1]
            int min=num[i];
            //定义一个最小值下标
            int minIndex=i;
            //从i+1开始比较与min比较
            for (int j = i+1; j < num.length; j++) {
                if(num[j]<min){
                    min=num[j];
                    minIndex=j;
                    flag=true;
                }
            }
            //一轮排序后
            if(flag){
                //最小值发生变换,所以进行交换
                num[minIndex]=num[i];
                num[i]=min;
                flag=false;
            }
            //没有发生变化就继续循环
            //System.out.println("第"+(i+1)+"次排序之后:"+ Arrays.toString(num));
        }
    }
}
