package com.company;

import com.java.Customer;

import java.util.ArrayList;

/**
 * @author liusigou
 * @create 2019--11--07--12:27
 */
public class Test {
    private static final Customer cus=new Customer();
    public static void main(String[] args) {
        System.out.println("s");
        int num=10;
        String[] arr=new String[]{"lilei","hanmei"};

        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
        for (String s : arr) {
            System.out.println(s);
        }
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            System.out.println(s);
        }
        ArrayList<Object> list = new ArrayList<>();
        for (Object o : list) {
            
        }
        for (int i = 0; i < list.size(); i++) {
            
        }
        if (list == null) {
            
        }
        if (list != null) {
            
        }
    }
}
