package com.test;

/**
 * @author liusigou
 * @create 2019--12--17--10:07
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(jude("ROLE_ROOT_ADMIN"));
        System.out.println("---------------------");
        System.out.println(jude2("ROLE_ORDER_ADMIN"));
    }
    public static String jude(String role){
        String result="";
        if(role.equals("ROLE_ROOT_ADMIN")){
            result="ROLE_ROOT_ADMIN"+" has AAA permission";
        }
        else if(role.equals("ROLE_ORDER_ADMIN")){
            result="ROLE_ORDER_ADMIN"+" has BBB permission";
        }
        else if(role.equals("ROLE_NORMAL")){
            result="ROLE_ORDER_ADMIN"+" has CCC permission";
        }
        else{
            result="XXX";
        }
        return result;
    }
    public static String jude2(String role){
        return RoleEnum.valueOf(role).op();
    }
}
