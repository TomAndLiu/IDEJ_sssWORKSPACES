package com.test.sort;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2020--01--12--12:58
 */
//基数排序
public class RadixSort {
    public static void main(String[] args) {
        int[] num={53,3,542,748,14,124};
        System.out.println("进行基数排序前:"+ Arrays.toString(num));
        radixSortIrony(num);
        //radixSort(num);
        //System.out.println("进行基数排序后:"+ Arrays.toString(num));
    }
    public static void radixSort(int[] num){
        /*
        定义一个二维数组来存储十个桶及桶内的数据
        定义一个一位数组来存储每个桶内数据量的多少
         */
        //第一轮排序
        //定义十个桶,每个桶的大小取数组长度,这样就是数组
        //所有的值都在通一个桶也不会数组越界
        int[][] bucket=new int[10][num.length];
        //定义一个一位数组来存储每个桶内数据量的多少
        int[] bucketElementCount=new int[10];
        //第一轮
        for(int i=0;i<num.length;i++){
            //取出每个元素的个位数
            int digitOfElement=num[i]%10;
            //存进该位数所对应的桶内
            /*
            bucketElementCount[digitOfElement]
            该桶对应的数据的个数
            */
            bucket[digitOfElement][bucketElementCount[digitOfElement]]=num[i];
            //该桶对应的数据的个数++
            bucketElementCount[digitOfElement]++;
        }
        //当把数据放完,就该把桶内的数据依次放进原数组
        //定义一个下标来遍历原数组的位置
        int index=0;
        //遍历每个桶
        for (int i = 0; i < bucket.length; i++) {
            //如果桶内的数据大于0才遍历
            if(bucketElementCount[i]>0){
                //遍历每个桶的数据
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    //把桶内数据依次放进原数组
                    num[index]=bucket[i][j];
                    index++;
                }
                //把这个桶内数据初始化为0,方便下次存储
                bucketElementCount[i]=0;
            }
        }
        System.out.println("基数排序第一轮:"+ Arrays.toString(num));
        //第二轮
        for (int i = 0; i < num.length; i++) {
            //取出每个数的十位
            int digitOfElement=(num[i]/10)%10;
            bucket[digitOfElement][bucketElementCount[digitOfElement]]=num[i];
            bucketElementCount[digitOfElement]++;
        }
        //重新遍历数组就要初始化下标
        index=0;
        // 遍历每个桶
        //把桶内数据依次放入原数组
        for (int i = 0; i < bucket.length; i++) {
            //如果桶内有数据
            if(bucketElementCount[i]>0){
                //遍历每个桶的数据
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    num[index]=bucket[i][j];
                    index++;
                }
                //初始化桶内数据个数
                bucketElementCount[i]=0;
            }
        }
        System.out.println("基数排序第二轮:"+ Arrays.toString(num));


    }
    /*
    完整版基数排序的思路,找到最大的数,看这个数是几位数,
    然后从个位数,十位数..直到最大数的位数取模看这
    个数是几,就放在几号桶
     */
    public static void radixSortIrony(int[] num){
        //定义十个桶
        int[][] bucket=new int[10][num.length];
        //定义存储每个桶数据个数
        int[] bucketElementCount=new int[10];
        //定义一个index来记录原数组填充桶数据时的位置
        int index=0;
        //获取最大数
        int maxValue=num[0];
        for(int i=1;i<num.length;i++){
            if(num[i]>maxValue){
                maxValue=num[i];
            }
        }
        //获取最大数的位数
        int maxLength=(maxValue+"").length();
        //根据位数来判断要排序几轮
        for (int l = 0,n=1; l < maxLength; l++,n*=10) {
            //遍历数组
            for (int i = 0; i < num.length; i++) {
                //获取每个数的位数
                int digitOfElement=(num[i]/n)%10;
                bucket[digitOfElement][bucketElementCount[digitOfElement]]=num[i];
                bucketElementCount[digitOfElement]++;
            }

            //把每个桶内的数据依次放进原数组
            //遍历每个桶
            for (int i = 0; i < bucket.length; i++) {
                //如果桶内数据大于0才遍历
                if(bucketElementCount[i]>0){
                    //遍历每个桶
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        num[index]=bucket[i][j];
                        //数组下标移动
                        index++;
                    }
                    //初始化桶内数据个数
                    bucketElementCount[i]=0;
                }
            }
            //初始化数组下标
            index=0;
            System.out.println("第"+(l+1)+"轮基数排序之后:"+Arrays.toString(num));
        }
    }
}
