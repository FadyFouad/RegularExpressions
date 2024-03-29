package com.etaTech;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/****************************************************
 *** Created by Fady Fouad on 6/20/2019 at 14:45.***
 ***************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------- Regular Expressions --------------------");
        String s = "i am String. Yes, i am";
        System.out.println(s);
        s = s.replaceAll("i", "I");
        System.out.println(s);

//        String alpha = "abcdoikopfdivpdoi438r0943850sdsa";
//        System.out.println(alpha.replaceAll(".","X")); //no match will replace all chars in string

        String alpha1 = "abcd11111aFadydivpdofadyr0abc85ABCsa";
        System.out.println(alpha1.replaceAll("abc", "X"));
        System.out.println(alpha1.replaceAll("^abc", "X"));//First abc only changed

        System.out.println(alpha1.matches("Fady"));//return false
        System.out.println(alpha1.matches("^bcd"));//return false
        System.out.println(alpha1.matches("^abcdabcoopFadyfdivfadypdoi438r0abc85ABCsa"));//return true

        System.out.println(alpha1.replaceAll("BCsa$", " End"));//End of string only

        System.out.println(alpha1.replaceAll("[abcd]", "X"));
        System.out.println(alpha1.replaceAll("[ad][ba]", "X"));
        System.out.println(alpha1.replaceAll("[Ff]ady", " -My Name- "));

        System.out.println(alpha1.replaceAll("[^ab]", "X")); //replace all except a,b

        System.out.println(alpha1.replaceAll("[abcd12345]", "X"));
        System.out.println(alpha1.replaceAll("[a-d1-5]", "X"));// " - " specify range
        System.out.println(alpha1.replaceAll("(?i)[a-d1-5]", "X")); //Ignore case

        System.out.println(alpha1.replaceAll("[0-9]", "X")); //replace num
        System.out.println(alpha1.replaceAll("\\d", "X")); //replace num
        System.out.println(alpha1.replaceAll("\\D", "X")); //replace all non Digit
        System.out.println("I am A string\ta tap and a\nnew line");
        System.out.println("I am A string\ta tap and a\nnew line".replaceAll("\\s", "_"));//replace space
        System.out.println("I am A string\ta tap and a\nnew line".replaceAll("\\S", "_"));//replace non space
        System.out.println("I am A string\ta tap and a\nnew line".replaceAll("\\w", "_"));//replace non space
        System.out.println("I am A string\ta tap and a\nnew line".replaceAll("\\W", "_"));//replace space
        System.out.println("I am A string\ta tap and a\nnew line".replaceAll("\\b", "_"));//surround by '_'

        System.out.println(alpha1.replaceAll("^abcd11111", "-X-"));
        System.out.println(alpha1.replaceAll("^abcd1{5}", "-X-"));
        System.out.println(alpha1.replaceAll("^abcd1+", "-X-"));
        System.out.println(alpha1.replaceAll("^abcd1*", "-X-"));

        System.out.println(alpha1.replaceAll("o+p*f", "-X-"));

        System.out.println("\n------------------------------------------------");

        StringBuilder stringHTML = new StringBuilder("<h1>Head h1<h1>");
        stringHTML.append("\n" + "<h2>Head h2<h2>");
        stringHTML.append("\n" + "<p>paragraph<p>");
        stringHTML.append("\n" + "<p>another paragraph<p>");
        stringHTML.append("\n" + "<h2>another Head h2<h2>");
        stringHTML.append("\n" + "<p>last paragraph<p>");

//        String h2Pattern = ".*<h2>.*";
        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(stringHTML);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " from " + matcher.start() + " to " + matcher.end());
            System.out.println(stringHTML.substring(matcher.start(), matcher.end()));
        }

        System.out.println("\n-------------------------------------------");
//        String h2PatternGroup = "(<h2>)";
        String h2PatternGroup = "(<h2>.*?<h2>)";// Question mark turn greedy quantifier into lazy quantifier
        Pattern groupPattern = Pattern.compile(h2PatternGroup);
        Matcher groupMatcher = groupPattern.matcher(stringHTML);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();
        while (groupMatcher.find()) {
            System.out.println(groupMatcher.group());
        }

        System.out.println("\n-------------------------------------------");
        String htPatternGroups = "(<h2>)(.+?)(<h2>)";
        Pattern h2TextPattern = Pattern.compile(htPatternGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(stringHTML);
        while (h2TextMatcher.find()) {
            System.out.println(h2TextMatcher.group());
            System.out.println(h2TextMatcher.group(2));
        }
        System.out.println("\n-------------------------------------------");
        // "abc" "a" and "b" and "c"
        // [[Hh]arry
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        // [^abc]
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)"; //not operator == ^ op
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println(count + ": from " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        System.out.println("\n-------------------------------------------");
        // t(?=v)
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        String phone1 = "1234567890";  // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone1 = " + phone1.matches("^([(][0-9]{3}[)][ ][0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([(][0-9]{3}[)][ ][0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([(][0-9]{3}[)][ ][0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([(][0-9]{3}[)][ ][0-9]{3}[\\-][0-9]{4})$"));

        System.out.println("\n-------------------------------------------");
        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));

    }
}