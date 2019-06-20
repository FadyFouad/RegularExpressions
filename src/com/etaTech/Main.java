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

//        String alpha = "abcdoikopfdivpdoi438r0943850sdsa";
//        System.out.println(alpha.replaceAll(".","X")); //no match will replace all chars in string

        String alpha1 = "abcd11111aFadydivpdofadyr0abc85ABCsa";
        System.out.println(alpha1.replaceAll("abc","X"));
        System.out.println(alpha1.replaceAll("^abc","X"));//First abc only changed

        System.out.println(alpha1.matches("Fady"));//return false
        System.out.println(alpha1.matches("^bcd"));//return false
        System.out.println(alpha1.matches("^abcdabcoopFadyfdivfadypdoi438r0abc85ABCsa"));//return true

        System.out.println(alpha1.replaceAll("BCsa$"," End"));//End of string only

        System.out.println(alpha1.replaceAll("[abcd]","X"));
        System.out.println(alpha1.replaceAll("[ad][ba]","X"));
        System.out.println(alpha1.replaceAll("[Ff]ady"," -My Name- "));

        System.out.println(alpha1.replaceAll("[^ab]","X")); //replace all except a,b

        System.out.println(alpha1.replaceAll("[abcd12345]","X"));
        System.out.println(alpha1.replaceAll("[a-d1-5]","X"));// " - " specify range
        System.out.println(alpha1.replaceAll("(?i)[a-d1-5]","X")); //Ignore case

        System.out.println(alpha1.replaceAll("[0-9]","X")); //replace num
        System.out.println(alpha1.replaceAll("\\d","X")); //replace num
        System.out.println(alpha1.replaceAll("\\D","X")); //replace all non Digit
        System.out.println("I am A string\ta tap and a\nnew line");
        System.out.println("I am A string\ta tap and a\nnew line".replaceAll("\\s","_"));//replace space
        System.out.println("I am A string\ta tap and a\nnew line".replaceAll("\\S","_"));//replace non space
        System.out.println("I am A string\ta tap and a\nnew line".replaceAll("\\w","_"));//replace non space
        System.out.println("I am A string\ta tap and a\nnew line".replaceAll("\\W","_"));//replace space
        System.out.println("I am A string\ta tap and a\nnew line".replaceAll("\\b","_"));//surround by '_'

        System.out.println(alpha1.replaceAll("^abcd11111","-X-"));
        System.out.println(alpha1.replaceAll("^abcd1{5}","-X-"));
        System.out.println(alpha1.replaceAll("^abcd1+","-X-"));
        System.out.println(alpha1.replaceAll("^abcd1*","-X-"));

        System.out.println(alpha1.replaceAll("o+p*f","-X-"));

    }
}