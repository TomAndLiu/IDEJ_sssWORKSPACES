package com.test.recursion;

/**
 * @author liusigou
 * @create 2019--12--28--9:38
 */
public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组模拟迷宫
        int[][] map=new int[8][7];

        for (int i = 0; i < map.length; i++) {
            //将左右置为墙板
            map[i][0]=1;
            map[i][6]=1;
            for (int j = 0; j < map[0].length; j++) {
                //将上下置为墙板
                map[0][j]=1;
                map[7][j]=1;
            }
        }
        //挡板画全
        map[3][1]=1;
        map[3][2]=1;
        //遍历一下
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        //开始走迷宫
        setWay(map,1,1);
        System.out.println("------------------------");
        //遍历一下
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
    //使用递归回溯给小球找路,需要传过来地图,从哪个地方找
    //使用说明
    //1:map 表示地图
    //2:i,j 表示从地图的哪个位置出发,从(1,1)出发,到(6,5)结束
    //3:当map[i][j]=0时表示该点没走过,为1时表示是墙,为2时表示通路可以走,为3时表示此路不通
    //4:走迷宫前先确定一个策略,先走下,走不通走右,再走不通就走上,还是走不通,就走左,还是走不通,回溯

    /**
     *
     * @param map 表示地图
     * @param i 起始行坐标
     * @param j 起始列坐标
     */
    public static boolean setWay(int[][] map,int i,int j){
        //如果已经到了出口,就跳出
        if(map[6][5]==2){
            return true;
        }
        else{
            //如果起始位置是0,说明这个点还没走过
            if(map[i][j]==0){
                //先设置这个点是可通行的
                map[i][j]=2;
                //先想下走,如果可以,返回true
                if(setWay(map,i+1,j)){
                    return true;
                }
                //向下走不通,就向右
                else if(setWay(map,i,j+1)){
                    return true;
                }
                //向右走不通,就向上
                else if(setWay(map,i-1,j)){
                    return true;
                }
                //向上走不通,就向左
                else if(setWay(map,i,j-1)){
                    return true;
                }
                //走不通
                else{
                    //说明是一个死路
                    map[i][j]=3;
                    return false;
                }
            }
            else{
                //else的情况有三种 map[i][j] 等于 1 2 3
                //等于1或者3,说明路不能走,等于2说明已经走过了,不用再走
                return false;
            }
        }
    }
}
