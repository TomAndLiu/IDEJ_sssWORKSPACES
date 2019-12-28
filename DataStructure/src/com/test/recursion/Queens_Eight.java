package com.test.recursion;

/**
 * @author liusigou
 * @create 2019--12--28--10:53
 */
public class Queens_Eight {
    //定义皇后的个数
    int max=8;
    //只需要定义一个数组去存储所在列数就行了,行数都是固定的从0到7
    int[] arr=new int[max];
    //查看多少种
    static int count=0;
    public static void main(String[] args) {
        Queens_Eight q=new Queens_Eight();
        //摆放皇后的位置
        q.put(0);
        //多少种
        System.out.println("总共"+count+"种");
    }
    //摆放第n个皇后
    public void put(int n){
        //当n等于第九的时候,说明前面八个已经摆放完了,此时打印出它们的位置并退出
        if(n==max){
            print();
            return;
        }
        //依次摆放皇后的位置
        for (int i = 0; i < max; i++) {
            //先让这个皇后放置在第n行的第1列
            arr[n]=i;
            //判断有没有冲突
            //如果不冲突就继续摆放第n+1个
            if(!isConflict(n)){
                put(n+1);
            }
            //如果冲突了就换列,直至不冲突
        }
    }
    //判断摆放第n个皇后的时候是否会冲突
    public boolean isConflict(int n){
        //遍历当前的数组
        for (int i = 0; i < n; i++) {
            //如果要摆放的皇后与之前的皇后位置同一列或者斜对角
            //因为数组存的数是列数,利用对角线的原理判断是否斜对角
            if(arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return true;
            }
        }
        //如果要摆放的皇后没有与之前的皇后有冲突就返回true
        return false;
    }
    //打印皇后的位置
    public void print(){
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
}
