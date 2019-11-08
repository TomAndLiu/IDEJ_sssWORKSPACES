package com.company;

import java.util.HashMap;

/**
 * @author liusigou
 * @create 2019--11--08--10:23
 */
public class DeBugTest {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("name","LiLei");
        map.put("age","16");
        map.put("school","NeaSoft");
        map.put("major","computer");
        String age=map.get("age");
        System.out.println("age = " + age);
        map.remove("major");
        System.out.println(map);

    }
}
