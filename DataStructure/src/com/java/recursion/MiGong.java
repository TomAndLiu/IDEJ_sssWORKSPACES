package com.java.recursion;

/**
 * @author liusigou
 * @create 2019--12--22--11:00
 */
//创建回溯迷宫
public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组模拟迷宫
        int[][] map=new int[8][7];
        //先使用1表示墙
        //先把上下全部置为1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        //把左右置为1
        for (int i = 0; i < map.length; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        //假定我把路给堵了
//        map[1][2]=1;
//        map[2][2]=1;
        //打印地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("****************");
        //开始走迷宫
//        setWay(map,1,1);
        setWay2(map,1,1);
        //输出地图
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
     * @param i 表示从哪个位置开始找
     * @param j
     * @return 如果找到通路,就返回true
     */
    public static boolean setWay(int[][] map,int i,int j){
        //如果到了(6,5),且可以通行,说明已经找到出口了
        if(map[6][5]==2){
            return true;
        }else{
            //如果这个路还没有走过
            if(map[i][j]==0){
                //进行策略行走 下->右->上->左
                //假定该点可以通过,然后再回溯
                map[i][j]=2;
                //先向下走
                if(setWay(map,i+1,j)){
                    //返回true
                    return true;
                }
                //如果向下走不通
                //向右走
                else if(setWay(map,i,j+1)){
                    //返回true
                    return true;
                }
                //如果向右走不通
                //向上走
                else if(setWay(map,i-1,j)){
                    //返回true
                    return true;
                }
                //如果向上走不通
                //向左走
                else if(setWay(map,i,j-1)){
                    //返回true
                    return true;
                }
                //都走不通
                else{
                    //说明这个点是死路
                    map[i][j]=3;
                    return false;
                }
            }
            else{//如果map[i][j]!=0,说明是 1 2 3
                return false;
            }
        }
    }
    //修改走的策略 上->右->下->左
    public static boolean setWay2(int[][] map,int i,int j){
        //如果到了(6,5),且可以通行,说明已经找到出口了
        if(map[6][5]==2){
            return true;
        }else{
            //如果这个路还没有走过
            if(map[i][j]==0){
                //进行策略行走 下->右->上->左
                //假定该点可以通过,然后再回溯
                map[i][j]=2;
                //先向上走
                if(setWay2(map,i-1,j)){
                    //返回true
                    return true;
                }
                //如果向上走不通
                //向右走
                else if(setWay2(map,i,j+1)){
                    //返回true
                    return true;
                }
                //如果向右走不通
                //向下走
                else if(setWay2(map,i+1,j)){
                    //返回true
                    return true;
                }
                //如果向下走不通
                //向左走
                else if(setWay2(map,i,j-1)){
                    //返回true
                    return true;
                }
                //都走不通
                else{
                    //说明这个点是死路
                    map[i][j]=3;
                    return false;
                }
            }
            else{//如果map[i][j]!=0,说明是 1 2 3
                return false;
            }
        }
    }
}
