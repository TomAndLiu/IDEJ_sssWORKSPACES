package com.java.recursion;

/**
 * @author liusigou
 * @create 2019--12--22--18:25
 */
//八皇后问题
public class Queens_Eight {
    //定义一个max表示有多少个皇后
    int max=8;
    //定义数组,保存放置皇后的位置的结果
    int[] array=new int[max];
    //定义一个数存储多少种解法
    static int count=0;
    //定义一个数判断一共调用了多少次判断冲突
    static int judgeCount=0;
    public static void main(String[] args) {
        Queens_Eight q=new Queens_Eight();
        //开始放置
        q.check(0);
        //得到多少种
        System.out.println("总共有:"+count+"种");
        //调用了多少次judge
        System.out.println("总共调用了:"+judgeCount+"次");
    }

    //编写一个方法去放置第n个皇后
    public void check(int n){
        //如果n==max,说明是在放第九个皇后,所以前八个皇后已经放好了,所以不用再放了
        if(n==max){
            print();
            return;
        }
        //依次放入皇后,判断是否冲突
        for (int i = 0; i < max; i++) {
            //先将当前皇后n 放置第n行第一列
            array[n]=i;
            //判断第n个皇后到第i列时,会不会冲突
            if(judge(n)){
                //judge(n)成立则不冲突
                //如果不冲突
                //放置n+1个皇后,看冲不冲突
                check(n+1);
            }
            //如果冲突了,则继续执行
        }
    }
    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    //查看当我们放置第n个皇后的时候,会不会与前面的皇后冲突
    public boolean judge(int n){
        judgeCount++;
        //遍历前面哪些皇后
        for (int i = 0; i < n; i++) {
            //如果前面的皇后有一个与第n个皇后同一列或者同一斜线
            //Math.abs(n-i)==Math.abs(array[n]-array[i])来判断是不是同一列
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])) {
                return false;
            }
        }
        return true;
    }
    //写一个方法,将八皇后摆放的位置输出
    public void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
