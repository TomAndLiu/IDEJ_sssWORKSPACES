package com.java.recursion;

/**
 * @author liusigou
 * @create 2019--12--19--20:09
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        System.out.println("阶乘之后等于"+factorial(5));
    }
    public static void test(int n){
        if(n>2){
            test(n-1);
        }
//        else{
//            System.out.println("n= "+n);
//        }
        //加else和不加else是有区别的,加了else 只输出一个2,因为递归的时候,除了2>2的条件不成立走else，其他
        //都走了if
        System.out.println("n= "+n);

    }
    //阶乘
    public static int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return factorial(n-1)*n;
        }
    }
}
