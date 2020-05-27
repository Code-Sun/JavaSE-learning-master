package com.edu.sunyifeng.LeetCode.大数字加法;

/**
 * @Auther: sunyifeng
 * @Date: 2020/05/02/16:00
 * @Description: 进位：加法必须解决进位问题
 * 对其：使两个数组等长，遍历时好遍历
 * 结果数组多出一位：为了解决两个等长的字符串数字相加后产生了进位
 */
public class BigStringAddtion1 {

    /**
     * @param num1
     * @param num2
     * @return
     */
    public static String bigStringAddtion(String num1, String num2) {

        int length1 = num1.length();
        int length2 = num2.length();
        // 对数组分类
        String shortStr,longtStr;
        if (length1 > length2) {
            longtStr = num1;
            shortStr = num2;
        } else {
            longtStr = num2;
            shortStr = num1;
        }
        int length = shortStr.length();
        int difference = Math.abs(length1 - length2);
        StringBuilder tmp = new StringBuilder();
        int carryBit = 0;
        // 这个有问题，对一个数组比一个长1位，计算结果正确，其他都不行
        // 原因是
        for (int i = length - 1; i >= 0; i--) {
            int n1 = shortStr.charAt(i) - '0';
            int n2 = longtStr.charAt(i + difference)-'0';
            int sum = n1 + n2 + carryBit;
            int num = sum % 10;
            carryBit=sum/10;
            tmp.insert(0,num);
            if(i==0){
                tmp.insert(0,carryBit+(longtStr.charAt(i)-'0'));
            }
        }
        return tmp.toString();
    }

    public static void main(String[] args) {

        String num1 = "2797";
        String num2 = "84";

        String s = bigStringAddtion(num1, num2);
        System.out.println(s);

    }
}
