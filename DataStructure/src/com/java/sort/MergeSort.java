package com.java.sort;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2020--01--01--10:33
 */
//归并sort
public class MergeSort {
    public static void main(String[] args) {

        int[] num={8,4,5,7,1,3,6,2};
        //定义一个临时数组
        int[] temp=new int[num.length];
        System.out.println("归并排序前:"+ Arrays.toString(num));
        //进行分治归并
        mergeSort(num,0,num.length-1,temp);
        System.out.println("归并排序后:"+ Arrays.toString(num));


        /*
        int[] num=new int[8];
        //定义一个临时数组
        int[] temp=new int[num.length];
        //随机生成8000个数
        for (int i = 0; i < num.length; i++) {
            num[i]=(int)(Math.random()*10000);
        }
        //System.out.println("归并排序前:"+ Arrays.toString(num));
        //定义时间格式
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取排序前的时间
        Date date1=new Date();
        String d1=simpleDateFormat.format(date1);
        System.out.println("归并排序前的时间:"+d1);
        mergeSort(num,0,num.length-1,temp);
        //获取排序后的时间
        Date date2=new Date();
        String d2=simpleDateFormat.format(date2);
        System.out.println("归并排序前的时间:"+d2);
        //System.out.println("归并排序后:"+ Arrays.toString(num));
         */
    }

    //分治
    public static void mergeSort(int[] num,int left,int right,int[] temp){
        if(left<right){
            //进行分解
            int mid=(left+right)/2;//中间索引
            System.out.println("left="+left+",mid="+mid+",right="+right);
            //向左进行递归
            mergeSort(num,left,mid,temp);
            //向右进行递归
            mergeSort(num,mid+1,right,temp);
            //每分一次就合并一次,分到最后从最右边进行递归回来,
            /*
            一开始左递归到最后合并8 4变成4 8然后到上一个栈的右递归合并5 7变成5 7
            再返回到上一个栈的左递归合并4 8 5 7变成4 5 7 8然后到右边先进行左递归,
            再进行右递归,也就是合并1 3变成1 3,然后合并6 2变成2 6,最后合并
            4 8 5 7    1 3 2 6
             */
            mergeSort(num,left,mid,right,temp);
        }
    }


    //合治
    /**
     *
     * @param num 原始数组
     * @param left 左边开始的下标
     * @param mid 右边数组的前一个位置
     * @param right 右边开始的下标
     * @param temp 临时数组
     */
    public static void mergeSort(int[] num,int left,int mid,int right,int[] temp){
        //定义一个下标记录初始left,一个下标记录初始化右边数组第一个数
        int i=left;
        int j=mid+1;
        //记录临时数组的下标
        int t=0;

        /*/
        (一):
        先把左右两边有序的数据依次填充到temp数组中
        直到左右两边的有序序列,有一边已经处理完毕
         */
        //当i<=左边数组的最大下标 j<=左边数组的最大下标,就继续
        while(i<=mid && j<=right){
            //如果左边有序数组num[i] 小于等于 右边有序数组num[j]
            if(num[i]<=num[j]){
                //就把左边的值拷贝到temp数组
                temp[t]=num[i];
                //temp数组下标移动
                t++;
                //左边数据下标移动
                i++;
            }
            //反之,也就是右边数组的num[j] 大于 左边数组的num[i]
            else{
                //就把右边的值拷贝到temp数组
                temp[t]=num[j];
                //temp数组下标移动
                t++;
                //右边数据下标移动
                j++;
            }
        }

        /*
        (二):
        把有剩余数据的一边的数据依次填充到temp数组中
         */
        //如果i <= mid,说明左边数组还有值
        while(i<=mid){
            //让剩余的值依次拷贝到temp中
            temp[t]=num[i];
            t++;
            i++;
        }
        //如果j <= right,说明右边数组还有值
        while(j<=right){
            //让剩余的值依次拷贝到temp中
            temp[t]=num[j];
            t++;
            j++;
        }

        /*
        把temp数组的数据拷贝到原始数组中
         */
        //将temp数组拷贝原始数组中,我们要考虑到并不是每一次拷贝都是拷贝所有
        //还原临时数组temp的下标
        t=0;
        //定义一个遍历左下标
        int tempLeft=left;
        while(tempLeft<=right){
            num[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }
}
