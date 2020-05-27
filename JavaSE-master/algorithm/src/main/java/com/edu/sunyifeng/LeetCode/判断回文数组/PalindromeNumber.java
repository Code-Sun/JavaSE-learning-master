package com.edu.sunyifeng.LeetCode.判断回文数组;

/**
 * @Auther: sunyifeng
 * @Date: 2020/05/04/16:56
 * @Description: Palindrome Number：回文数字
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class PalindromeNumber {

    /**
     * 判断一个整数是否是回文数
     *
     * @param num
     * @return true, false
     */
    public static boolean isPalindrome(int num) {
        //不加这行代码，也能正确输出结果；这两种情况没必要进入while循环，提高效率
        // 0也满足回文整数的要求，(num % 10 == 0 && num != 0)判断的是10的整数倍的非零整数
        if (num < 0 || (num % 10 == 0 && num != 0)) return false;
        int after = 0;
        while (num > after) {
            // 先取出末位，再将去掉最后一位
            after = after * 10 + num % 10;
            // 去掉最后一位
            num = num / 10;
        }
        return num == after || num == after / 10;
    }


    public static void main(String[] args) {
        // 数位是奇数
        int num = 12321;
        // 数位是偶数
        // int num = 1221;
        // 0也满足回文整数的要求
        // int num=0;
        // 负数
        // int num = -1221;
        boolean palindrome = isPalindrome(num);
        System.out.println(palindrome);
    }
}
