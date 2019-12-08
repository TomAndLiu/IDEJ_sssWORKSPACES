package com.test.sparsearray;

/**
 * @author liusigou
 * @create 2019--12--07--9:42
 */
public class SparseTest {
    public static void main(String[] args) {
        //创建矩阵
        int[][] chessArray=new int[4][5];
        //赋不等于0的值
        chessArray[1][3]=1;
        chessArray[2][1]=2;
        chessArray[2][3]=1;
        chessArray[3][2]=1;
        //输出矩阵
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j <chessArray[0].length ; j++) {
                System.out.printf("%d\t",chessArray[i][j]);
            }
            System.out.println();
        }
        //记录不为0的个数
        int sum=0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j <chessArray[0].length ; j++) {
                if(chessArray[i][j]!=0){
                    sum++;
                }
            }

        }
        System.out.println("--------------------------------");
        //转换成稀疏矩阵
        int[][] sparsearray=new int[sum+1][3];
        sparsearray[0][0]=chessArray.length;
        sparsearray[0][1]=chessArray[0].length;
        sparsearray[0][2]=sum;
        //记录稀疏数组的行
        int num=1;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if(chessArray[i][j]!=0){
                    sparsearray[num][0]=i;
                    sparsearray[num][1]=j;
                    sparsearray[num][2]=chessArray[i][j];
                    num++;
                }
            }
        }
        //输出稀疏数组
        for (int i = 0; i < sparsearray.length; i++) {
            for (int j = 0; j < sparsearray[0].length; j++) {
                System.out.printf("%d\t",sparsearray[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------------");
        //转换成普通矩阵
        int[][] array=new int[sparsearray[0][0]][sparsearray[0][1]];
        for (int i = 1; i < sparsearray.length; i++) {
            array[sparsearray[i][0]][sparsearray[i][1]]=sparsearray[i][2];

        }
        //输出普通矩阵
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%d\t",array[i][j]);
            }
            System.out.println();
        }
    }
}
