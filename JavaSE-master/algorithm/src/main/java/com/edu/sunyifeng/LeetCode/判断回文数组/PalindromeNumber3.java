package com.edu.sunyifeng.LeetCode.判断回文数组;

/**
 * @Auther: sunyifeng
 * @Date: 2020/05/04/16:56
 * @Description: Palindrome Number：回文数字
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class PalindromeNumber3 {

    public static boolean isPalindrome(int num) {
        // 若输出数字是负数，直接输出结果为false,因为没有-12321-的整数
        // 若数字末尾是0，也为false,因为没有0123210这样的整数
        if (num < 0 || num / 10 == 0) return false;
        // 为了进入while循环，令before=1
        int befor = 1;
        int after = 0;
        while (befor > after) {
            // 从后向前将数字放在after变量中
            after = after * 10 + num % 10;
            // 数字前半段放在在befor中
            befor = num / 10;
            // 这是精髓
            num = befor;
        }
        // 如果数字是奇数位，如12321，那么就会出现befor=12,after=123，但123321确实是回文数字
        return num == after || num == after / 10;
    }

    public static void main(String[] args) {
        // int num = -12321;
        int num = 1221;
        boolean palindrome = isPalindrome(num);
        System.out.println(palindrome);
    }
}
