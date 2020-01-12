package com.java.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusigou
 * @create 2020--01--02--20:08
 */
//二分查找,必须数组有序
public class BinarySearch {
    public static void main(String[] args) {
        /*
        int[] num=new int[100];
        for (int i = 0; i < num.length; i++) {
            num[i]=i;
        }
        */
        int[] num={1,5,6,9,12,33,62,88,122,122};
        //int index=binarySearch(num,0,num.length-1,122);
        //System.out.println(index==-1?("没有找到"):("找到了,下标为"+index));
        List<Integer> list=binarySearchImprove(num,0,num.length-1,1);
        System.out.println(list);
    }

    /**
     *
     * @param num 数组
     * @param left 左下标
     * @param right 右下标
     * @param findVal 要查找的值
     * @return 如果找到返回下标,没有找到就返回-1
     */
    public static int binarySearch(int[] num,int left,int right,int findVal){
        //当left>right的时候说明已经遍历完整个数组却没找到值,所有返回-1
        if(left>right){
            return -1;
        }
        //拿到中间的下标
        int mid=(left+right)/2;
        //中间的值
        int midVal=num[mid];

        //如果midVal大于要寻找的值findVal
        if(midVal>findVal){
            //向左递归
            return binarySearch(num,left,mid-1,findVal);
        }
        //如果小于要寻找的值
        else if(midVal<findVal){
            //向右递归
            return binarySearch(num,mid+1,right,findVal);
        }
        //等于要找到的值
        else{
            return mid;
        }

    }
    //完善二分查找,当要查找的值在数组中存在多个相同的数时,返回所有数的下标
    public static List<Integer> binarySearchImprove(int[] num, int left, int right, int findVal){
        System.out.println("查找次数~");
        //当left>right的时候说明已经遍历完整个数组却没找到值,所有返回-1
        if(left>right){
            return null;
        }
        //拿到中间的下标
        int mid=(left+right)/2;
        //中间的值
        int midVal=num[mid];

        //如果midVal大于要寻找的值findVal
        if(midVal>findVal){
            //向左递归
            return binarySearchImprove(num,left,mid-1,findVal);
        }
        //如果小于要寻找的值
        else if(midVal<findVal){
            //向右递归
            return binarySearchImprove(num,mid+1,right,findVal);
        }
        //等于要找到的值
        else{
            //当找到mid的时候,先向mid索引的左边扫描,将找到的值放进List
            //然后向mid索引的右边扫描,将找到的值放进List
            //定义一个存储目标值的数组
            List<Integer> indexList=new ArrayList<Integer>();
            //先把mid值加进去
            indexList.add(mid);
            //向左扫描
            int tempLeft=mid-1;
            while(true){
                //如果tempLeft<0 或者num[tempLeft] != findVal(也就是mid左边不存在与num[mid]相等的数)
                if(tempLeft<0 || num[tempLeft] != findVal){
                    //退出
                    break;
                }
                //不然就把temp放进去
                indexList.add(tempLeft);
                //继续左移
                tempLeft--;
            }
            //向右扫描
            int tempRight=mid+1;
            while(true){
                //如果tempRight>num.length-1 或者num[tempRight] != findVal(也就是mid右边
                // 不存在与num[mid]相等的数)
                if(tempRight>num.length-1 || num[tempRight] != findVal){
                    //退出
                    break;
                }
                //不然就把temp放进去
                indexList.add(tempRight);
                //继续左移
                tempRight++;
            }

            //返回list
            return indexList;
        }
    }
}
