package com.test;

/**
 * @author liusigou
 * @create 2019--12--17--10:13
 */
public enum RoleEnum implements RoleOperation{
    //系统管理员
    ROLE_ROOT_ADMIN{
        @Override
        public String op() {
            return "ROLE_ROOT_ADMIN"+" has AAA permission";
        }
    },
    //订阅管理员
    ROLE_ORDER_ADMIN{
        public String op(){
            return "ROLE_ORDER_ADMIN"+" has BBB permission";
        }
    },
    //普通用户
    ROLE_NORMAL{
        @Override
        public String op() {
            return "ROLE_ORDER_ADMIN"+" has CCC permission";
        }
    }
}
