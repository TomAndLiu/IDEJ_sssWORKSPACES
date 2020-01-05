package com.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author liusigou
 * @create 2020--01--01--14:59
 */
//基数排序
public class RadixSort {
    public static void main(String[] args) {
        /*
        int[] num={53,3,542,748,14,124};
        System.out.println("进行基数排序前:"+ Arrays.toString(num));
        radixSortIrony(num);
        //System.out.println("进行基数排序后:"+ Arrays.toString(num));
         */

        int[] num=new int[8000000];
        //随机生成8000个数
        for (int i = 0; i < num.length; i++) {
            num[i]=(int)(Math.random()*10000);
        }
        //System.out.println("基数排序前:"+ Arrays.toString(num));
        //定义时间格式
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取排序前的时间
        Date date1=new Date();
        String d1=simpleDateFormat.format(date1);
        System.out.println("基数排序前的时间:"+d1);
        radixSortIrony(num);
        //获取排序后的时间
        Date date2=new Date();
        String d2=simpleDateFormat.format(date2);
        System.out.println("基数排序前的时间:"+d2);
        //System.out.println("基数排序后:"+ Arrays.toString(num));
    }
    public static void radixSort(int[] num){
        //第一轮排序,针对每个元素的各位进行排序处理
        //定义一个二维数组表示十个桶
        //每个桶就是一维数组
        /*
        二维数组包含十个一维数组,由于不知道桶要定义多大,所以每个桶的大小
        都定义成num.length,所以就算数组的所有数据都集中在某一个桶,也不怕
        数据溢出
        桶排序是经典的以空间换取时间的排序算法
         */
        int[][] bucket=new int[10][num.length];

        //为了记录每个桶中实际存放了多少个数据,我们定义了一个一维数组来记录
        //每个桶每次放入了多少数据
        //bucketElementCount[0] 就是bucket[0]放入的数据个数
        int[] bucketElementCount=new int[10];

        //第一轮,遍历数组
        for (int i = 0; i < num.length; i++) {
            //取出每个元素的个位
            int digitOfElement=num[i] % 10;
            //放入桶中
            /*
            首先,根据个位数digitOfElement得知要放在第几个桶
            ,根据从bucketElementCount[digitOfElement]得知该桶
            已经放置了多少个数据,从而得到现在要放置在第几位,然后
            让bucketElementCount[digitOfElement]后移,以备下次
            要放置时标明位置
            比如bucketElementCount[digitOfElement]=0
            放入数据之后就要++
             */
            bucket[digitOfElement][bucketElementCount[digitOfElement]]=num[i];
            bucketElementCount[digitOfElement]++;
        }
        //当遍历完把数据放在桶中之后,现在就要遍历所有桶中的数据,依次放入原数组
        int index=0;
        //遍历存储每个桶数据个数的数组
        for (int i = 0; i < bucketElementCount.length; i++) {
            //遍历每个桶的数据,只有数据大于0的才进行遍历
            if(bucketElementCount[i]>0){
                //遍历这个桶的所有数据,并把这些数据依次放进原数组
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    //bucket[i][j] 取出第i个的第j个数据
                    num[index]=bucket[i][j];
                    //让下标Index++
                    index++;
                }
            }
            //遍历完一次之后就把记录这个桶数据个数的数据重置
            bucketElementCount[i]=0;
        }
        //第一轮基数排序之后
        System.out.println("第一轮基数排序之后:"+ Arrays.toString(num));

        //第二轮排序
        for (int i = 0; i < num.length; i++) {
            //取出每个元素的十位
            int digitOfElement=(num[i] / 10) % 10;
            //放入桶中
            /*
            首先,根据个位数digitOfElement得知要放在第几个桶
            ,根据从bucketElementCount[digitOfElement]得知该桶
            已经放置了多少个数据,从而得到现在要放置在第几位,然后
            让bucketElementCount[digitOfElement]后移,以备下次
            要放置时标明位置
            比如bucketElementCount[digitOfElement]=0
            放入数据之后就要++
             */
            bucket[digitOfElement][bucketElementCount[digitOfElement]]=num[i];
            bucketElementCount[digitOfElement]++;
        }
        //当遍历完把数据放在桶中之后,现在就要遍历所有桶中的数据,依次放入原数组
        //重置index
        index=0;
        //遍历存储每个桶数据个数的数组
        for (int i = 0; i < bucketElementCount.length; i++) {
            //遍历每个桶的数据,只有数据大于0的才进行遍历
            if(bucketElementCount[i]>0){
                //遍历这个桶的所有数据,并把这些数据依次放进原数组
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    //bucket[i][j] 取出第i个的第j个数据
                    num[index]=bucket[i][j];
                    //让下标Index++
                    index++;
                }
            }
            //遍历完一次之后就把记录这个桶数据个数的数据重置
            bucketElementCount[i]=0;
        }
        //第二轮基数排序之后
        System.out.println("第二轮基数排序之后:"+ Arrays.toString(num));

        //第三轮排序
        for (int i = 0; i < num.length; i++) {
            //取出每个元素的百位
            int digitOfElement=(num[i] / 100) % 10;
            //放入桶中
            /*
            首先,根据个位数digitOfElement得知要放在第几个桶
            ,根据从bucketElementCount[digitOfElement]得知该桶
            已经放置了多少个数据,从而得到现在要放置在第几位,然后
            让bucketElementCount[digitOfElement]后移,以备下次
            要放置时标明位置
            比如bucketElementCount[digitOfElement]=0
            放入数据之后就要++
             */
            bucket[digitOfElement][bucketElementCount[digitOfElement]]=num[i];
            bucketElementCount[digitOfElement]++;
        }
        //当遍历完把数据放在桶中之后,现在就要遍历所有桶中的数据,依次放入原数组
        //重置index
        index=0;
        //遍历存储每个桶数据个数的数组
        for (int i = 0; i < bucketElementCount.length; i++) {
            //遍历每个桶的数据,只有数据大于0的才进行遍历
            if(bucketElementCount[i]>0){
                //遍历这个桶的所有数据,并把这些数据依次放进原数组
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    //bucket[i][j] 取出第i个的第j个数据
                    num[index]=bucket[i][j];
                    //让下标Index++
                    index++;
                }
            }
            //遍历完一次之后就把记录这个桶数据个数的数据重置
            bucketElementCount[i]=0;
        }
        //第二轮基数排序之后
        System.out.println("第三轮基数排序之后:"+ Arrays.toString(num));
    }
    //根据规律退出的完整版基数排序
    public static void radixSortIrony(int[] num){
        //每一轮排序,都要针对每个元素的各位进行排序处理
        //定义一个二维数组表示十个桶
        //每个桶就是一维数组
        /*
        二维数组包含十个一维数组,由于不知道桶要定义多大,所以每个桶的大小
        都定义成num.length,所以就算数组的所有数据都集中在某一个桶,也不怕
        数据溢出
        桶排序是经典的以空间换取时间的排序算法
         */
        int[][] bucket=new int[10][num.length];

        //为了记录每个桶中实际存放了多少个数据,我们定义了一个一维数组来记录
        //每个桶每次放入了多少数据
        //bucketElementCount[0] 就是bucket[0]放入的数据个数
        int[] bucketElementCount=new int[10];

        //定义一个index来记录原数组填充桶数据时的位置
        int index=0;

        //总共要排序几轮呢?是根据数组最大数是几位数来计算几轮的,比如最大数是百位数
        //就排序三轮

        //先获取最大数
        int max=num[0];
        for (int i = 1; i < num.length; i++) {
            if(num[i]>max){
                max=num[i];
            }
        }
        //判断这个最大数是第几位
        //利用字符串的长度来获取最大位数
        //比如最大数是475 然后475加上空字符串变成 "475",它的length等于3,而475的位数
        //也是百位数,这是一个很巧妙的方法,= =
        int maxLength=(max+"").length();

        //开始遍历
        //定义一个n初始值是1 每次遍历之后都n=n*10
        for (int l = 0,n=1; l < maxLength; l++,n*=10 ) {
            for (int i = 0; i < num.length; i++) {
                //取出每一轮所需要的元素的位数
                int digitOfElement=(num[i] / n) % 10;
                //放入桶中
            /*
            首先,根据个位数digitOfElement得知要放在第几个桶
            ,根据从bucketElementCount[digitOfElement]得知该桶
            已经放置了多少个数据,从而得到现在要放置在第几位,然后
            让bucketElementCount[digitOfElement]后移,以备下次
            要放置时标明位置
            比如bucketElementCount[digitOfElement]=0
            放入数据之后就要++
             */
                bucket[digitOfElement][bucketElementCount[digitOfElement]]=num[i];
                bucketElementCount[digitOfElement]++;
            }
            //当遍历完把数据放在桶中之后,现在就要遍历所有桶中的数据,依次放入原数组

            //遍历存储每个桶数据个数的数组
            for (int i = 0; i < bucketElementCount.length; i++) {
                //遍历每个桶的数据,只有数据大于0的才进行遍历
                if(bucketElementCount[i]>0){
                    //遍历这个桶的所有数据,并把这些数据依次放进原数组
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        //bucket[i][j] 取出第i个的第j个数据
                        num[index]=bucket[i][j];
                        //让下标Index++
                        index++;
                    }
                }
                //遍历完一次之后就把记录这个桶数据个数的数据重置
                bucketElementCount[i]=0;
            }
            //填充到原数组之后,重置index
            index=0;

            //System.out.println("第"+(l+1)+"轮基数排序之后:"+Arrays.toString(num));
        }
    }
}
