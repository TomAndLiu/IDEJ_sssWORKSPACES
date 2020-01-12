package com.java.search;

import java.util.Arrays;

/**
 * @author liusigou
 * @create 2020--01--04--14:37
 */
//斐波那契查找
public class FibonacciSearch {
    //定义斐波那契数列的长度
    public static int maxSize=20;
    public static void main(String[] args) {
        int[] num={1,8, 10, 89, 92, 1000, 1234};
        int index=fibonacciSearch(num,92);
        System.out.println((index==-1)?("没有找到"):("找到了,下标是:"+index));
    }
    //因为后面的mid==low+F(k-1)-1,需要使用斐波那契数列,所以先获取斐波那契数列
    public static int[] fib(){
        int[] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i < f.length; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    /**
     *
     * @param num 数组
     * @param key 我们需要查找的关键码
     * @return 返回的下标
     */
    public static int fibonacciSearch(int[] num,int key){
        int low=0;
        int high=num.length-1;
        //表示斐波那契数列的下标
        int k=0;
        //存放mid值
        int mid=0;
        //得到斐波那契数列
        int[] f=fib();
        //当high还大于f[k]说明还没找到
        while(high>f[k]-1){
            k++;
        }
        //此时f[k]可能大于数组num的长度,因此需要使用Arrays类构造一个新的数组
        //不足的部分会用0填充
        int[] temp=Arrays.copyOf(num,f[k]);
        //把后面的0用temp[high]填充
        for (int i = high+1; i < temp.length; i++) {
            temp[i]=num[high];
        }
        //循环找到key
        while(low<=high){
            mid=low+f[k-1]-1;
            if(key<num[mid]) {
                //向左移动
                high = mid - 1;
                //为什么k--,因为f[k-1]是在左边,要想向左移动就k-=1
                //f[k]=f[k-1]+f[k-2] k-=1 向左去寻找
                //由于前面有f[k-1]个元素 所以拆分成f[k-1]=f[k-2]+f[k-3]
                k-=1;
            }
            else if(key>num[mid]){
                //向右移动
                low = mid + 1;
                //k-=2
                //f[k]=f[k-1]+f[k-2] k-=2 向右去寻找 f[k-1]=f[k-3]+f[k-4]
                //由于后面有f[k-2]个元素 所以拆分成f[k-1]=f[k-3]+f[k-4]
                k-=2;
            }
            else{
                //已经找到了
                //返回小的
                if(mid<=high){
                    return mid;
                }
                else{
                    return high;
                }
            }
        }
        return -1;
    }
}
