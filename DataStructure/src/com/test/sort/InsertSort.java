package com.test.sort;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2020--01--05--9:35
 */
public class InsertSort {
    public static void main(String[] args) {

        int[] num={2,1,-1,4,9,7,5};
        System.out.println("刚开始排序之前:"+ Arrays.toString(num));
        insertSort(num);
        //插入排序的思路
        /*
        第一轮 把num看做两个数组 {2} {6,4,-1,9,7,5}
        把{6} 插入{2} 之前先和里面的元素进行比较,如果
        比数组里面的元素大,就放在元素的右边,如果小于就
        放在元素的左边
         */
        /*
        //定义一个待插入数
        int insertVal=num[1];
        //定义一个待插入数的临近数下标
        int insertUponIndex=0;
        while(insertUponIndex>=0 && insertVal<num[insertUponIndex]){
            //临近数右移
            num[insertUponIndex+1]=num[insertUponIndex];
            //临近数下标移动
            insertUponIndex--;
        }
        //当跳出循环的时候,有两个可能,1:insertUponIndex<0,所以此时
        //要让num[insertUponIndex+1]=insertVal,2:insertVal>num[insertUponIndex]
        //所以也需要让insertUponIndex+1
        num[insertUponIndex+1]=insertVal;
        System.out.println("第一轮排序之后:"+ Arrays.toString(num));
        */
        /*
        第二轮排序
         */
        /*
        //定义一个待插入数
        insertVal=num[2];
        //定义一个待插入数的临近数下标
        insertUponIndex=1;
        while(insertUponIndex>=0 && insertVal<num[insertUponIndex]){
            //临近数右移
            num[insertUponIndex+1]=num[insertUponIndex];
            //临近数下标移动
            insertUponIndex--;
        }
        //当跳出循环的时候,有两个可能,1:insertUponIndex<0,所以此时
        //要让num[insertUponIndex+1]=insertVal,2:insertVal>num[insertUponIndex]
        //所以也需要让insertUponIndex+1
        num[insertUponIndex+1]=insertVal;
        System.out.println("第二轮排序之后:"+ Arrays.toString(num));

        */

    }
    //插入排序
    public static void insertSort(int[] num){
        //从前面几轮的排序可以发现几个规律
        /*
        1:需要插入n-1次
        2:临近数小于待插入数一位
         */

        for(int i=0;i<num.length-1;i++){
            //定义待插入数
            int insertVal=num[i+1];
            //定义临近数
            int insertUponIndex=i;
            //判断是否需要移位
            while(insertUponIndex >= 0 && insertVal<num[insertUponIndex]){
                //进行移位
                num[insertUponIndex+1]=num[insertUponIndex];
                insertUponIndex--;
            }
            //当跳出循环的时候,有两个可能,1:insertUponIndex<0,所以此时
            //要让num[insertUponIndex+1]=insertVal,2:insertVal>num[insertUponIndex]
            //所以也需要让insertUponIndex+1
            //把待插入数插入数组
            num[insertUponIndex+1]=insertVal;
            System.out.println("第"+(i+1)+"轮排序后:"+ Arrays.toString(num));
        }
    }
}
