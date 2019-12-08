package com.java.sparsearray;

/**
 * @author liusigou
 * @create 2019--11--10--13:56
 */
public class SparseTest{
    public static void main(String[] args) {
//        创立一个11行11列的数组 0表示没有 1表示黑子 2表示白子
        int[][] chessArray=new int[11][11];
        chessArray[1][2]=1;
        chessArray[3][4]=2;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j <chessArray[i].length ; j++) {
                System.out.printf("%d\t",chessArray[i][j]);
            }
            System.out.println();
        }
//        转换成稀疏数组
        int sum=0;
        for (int i = 0; i <chessArray.length ; i++) {
            for (int j = 0; j <chessArray[i].length ; j++) {
                if(chessArray[i][j]!=0){
                    sum++;
                }
            }
        }
        int[][] sparseArray=new int[sum+1][3];
        sparseArray[0][0]=chessArray.length;
        sparseArray[0][1]=chessArray[0].length;
        sparseArray[0][2]=sum;
//        遍历把非0存进稀疏数组
//        用于记录是第几个非0
        int count=0;
        for (int i = 0; i <chessArray.length ; i++) {
            for (int j = 0; j <chessArray[i].length ; j++) {
                if(chessArray[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArray[i][j];

                }
            }
        }
        System.out.println("---------------------------");
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j <sparseArray[i].length ; j++) {
                System.out.printf("%d\t",sparseArray[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
//        稀疏数组转换成普通数组
        int[][] chessArray2=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            int row=sparseArray[i][0];
            int col=sparseArray[i][1];
            int value=sparseArray[i][2];
            chessArray2[row][col]=value;
        }
        for (int i = 0; i < chessArray2.length; i++) {
            for (int j = 0; j < chessArray2[i].length; j++) {
                System.out.printf("%d\t",chessArray2[i][j]);
            }
            System.out.println();
        }
    }
}
