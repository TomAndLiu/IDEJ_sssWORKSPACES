package com.test.sort;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2020--01--11--13:39
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] num={-9,0,-5,23,0,70};
        System.out.println("快速排序前:"+ Arrays.toString(num));
        quickSort(num,0,num.length-1);
        System.out.println("快速排序后:"+ Arrays.toString(num));

    }
    //快速排序

    /**
     *
     * @param num 数组
     * @param left 左下标
     * @param right 右下标
     */
    public static void quickSort(int[] num,int left,int right){
        //定义一个l和r来接收left和right
        int l=left;
        int r=right;
        //定义一个中轴值
        int pivot=num[(left+right)/2];
        //定义一个交换的值
        int temp;
        //开始遍历,把比pivot小的放在pivot的左边,比pivot大的放在pivot的右边
        while(l<r){
            //左边的索引开始遍历
            while(num[l]<pivot){
                l++;
            }
            //跳出循环的时候说明num[l]>=pivot
            //右边的索引开始遍历
            while(num[r]>pivot){
                r--;
            }
            //跳出循环的时候说明num[r]<=pivot
            //此时如果l>r,说明整个数组已经有序
            if(l>=r){
                break;
            }
            else{
                //进行交换
                temp=num[l];
                num[l]=num[r];
                num[r]=temp;
            }
            //如果遇到与中轴值相等的,就再移动一次,不然会陷入死循环
            //如果遇到num[l]等于中轴值,就让l++
            if(num[l]==pivot){
                l++;
            }
            //如果遇到num[r]等于中轴值,就让r--
            if(num[r]==pivot){
                r--;
            }
        }
        //跳出循环的时候,如果出现l==r,必须都移动一位,不然会直接结束
        if(l==r){
            l++;
            r--;
        }
        //跳出循环的时候就是当一轮排序后
        //如果left还是小于r,就继续向左边进行快速排序
        if(left<r){
            quickSort(num,left,r);
        }
        //如果l还是小于right,就继续向右边进行快速排序
        if(l<right){
            quickSort(num,l,right);
        }
    }
}
