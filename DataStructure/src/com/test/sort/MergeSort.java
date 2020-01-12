package com.test.sort;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2020--01--12--10:24
 */
//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] num={8,4,5,7,1,3,6,2};
        //定义一个临时数组
        int[] temp=new int[num.length];
        System.out.println("归并排序前:"+ Arrays.toString(num));
        //进行分治归并
        mergeSort(num,0,num.length-1,temp);
        System.out.println("归并排序后:"+ Arrays.toString(num));
    }
    //分治
    public static void mergeSort(int[] num,int left,int right,int[] temp) {
        if(left<right){
            //定义中间值
            int mid=(left+right)/2;
            //向左进行递归分治
            mergeSort(num,left,mid,temp);
            //向右进行递归分治
            mergeSort(num,mid+1,right,temp);
            //分治完进行合并排序
            mergeSort(num,left,mid,right,temp);
        }
    }    //合并
    /**
     *
     * @param num 给定数组
     * @param left 左边数组的起始下标
     * @param mid 左边数组的最后最后一位的下标,也就是右边数组的起始下标的前一位
     * @param right 右边数组最后一位的下标
     * @param temp  临时数组
     */
    public static void mergeSort(int[] num,int left,int mid,int right,int[] temp){
        //定义一个遍历左边数组的下标
        int i=left;
        //定义一个遍历右边数组的下标
        int j=mid+1;
        //定义一个遍历临时数组的下标
        int t=0;
        while(i<=mid && j<=right){
            //如果左边的小于等于右边的数,就把左边的数拷贝到临时数组里面
            if(num[i]<=num[j]){
                temp[t]=num[i];
                //临时数组下标移动
                t++;
                //左下标移动
                i++;
            }
            //如果左边的大于的,就把右边的数拷贝到临时数组里面
            else{
                temp[t]=num[j];
                //临时数组下标移动
                t++;
                //右下标移动
                j++;
            }
        }
        //当跳出循环的时候,就是有一个数组已经全部填充到临时数组,另一个数组还有数据剩余
        //如果i<=mid,说明左边数组还有值
        while(i<=mid){
            temp[t]=num[i];
            //临时数组下标移动
            t++;
            //左下标移动
            i++;
        }
        //如果j<=right,说明右边数组还有值
        while(j<=right){
            temp[t]=num[j];
            //临时数组下标移动
            t++;
            //右下标移动
            j++;
        }
        //当把数据都放进临时数组之后,就要把临时数组的值拷贝到实际数组里面
        //由于分治会递归分成很多次,所以定义一个原数组的遍历左下标
        int numLeft=left;
        //把临时数组下标初始化为0,因为之前填充临时数组的时候移动过了
        t=0;
        while(numLeft<=right){
            num[numLeft]=temp[t];
            numLeft++;
            t++;
        }
    }
}
