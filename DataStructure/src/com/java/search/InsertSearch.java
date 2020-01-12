package com.java.search;

/**
 * @author liusigou
 * @create 2020--01--04--10:38
 */
//插值查找
public class InsertSearch {
    public static void main(String[] args) {
        /*
        int[] num=new int[100];
        for (int i = 0; i < num.length; i++) {
            num[i]=i;
        }
         */
        int[] num={1,5,6,9,12,33,62,88,122,122};
        int index=insertSearch(num,0,num.length-1,1);
        System.out.println(index);
    }
    public static int insertSearch(int[] num,int left,int right,int findVal){
        //查找次数
        System.out.println("查找次数~");
        //如果左边索引大于右边索引说明已经遍历完整个数组还没找到
        //findVal<num[0] || findVal>num[num.length-1]必须要有,不然公式可能会越界
        if(left>right || findVal<num[0] || findVal>num[num.length-1]){
            return -1;
        }
        //让mid用插值
        int mid=left+(right-left)*(findVal-num[left])/(num[right]-num[left]);
        //如果num[mid] 大于 findVal
        if(num[mid]>findVal){
            //左递归
            return insertSearch(num,left,mid-1,findVal);
        }
        else if(num[mid]<findVal){
            //右递归
            return insertSearch(num,mid+1,right,findVal);
        }
        else{
            //找到了
            return mid;
        }
    }
}
