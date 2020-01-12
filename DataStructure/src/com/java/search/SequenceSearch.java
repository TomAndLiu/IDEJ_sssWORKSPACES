package com.java.search;

/**
 * @author liusigou
 * @create 2020--01--02--19:42
 */
//线性查找
public class SequenceSearch {
    public static void main(String[] args) {
        //建立一个无序数组
        int[] num={1,9,44,2,3,6,22};
        int index=sequenceSearch(num,22);
        System.out.println(index==-1?("没有找到"):("找到了,下标为"+index));
    }
    public static int sequenceSearch(int[] num,int value){
        //线性查找是逐一比对数组里的元素
        for (int i = 0; i < num.length; i++) {
            if(num[i]==value){
                //返回下标
                return i;
            }
        }
        //如果没有返回-1
        return -1;
    }
}
