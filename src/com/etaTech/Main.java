package com.etaTech;


/****************************************************
 *** Created by Fady Fouad on 6/20/2019 at 14:45.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------- Regular Expressions --------------------");
        String s = "i am String. Yes, i am";
        System.out.println(s);
        s = s.replaceAll("i","I");
        System.out.println(s);
    }
}