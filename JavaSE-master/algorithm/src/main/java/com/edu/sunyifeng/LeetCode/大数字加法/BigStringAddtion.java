package com.edu.sunyifeng.LeetCode.大数字加法;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @Auther: sunyifeng
 * @Date: 2020/05/02/16:00
 * @Description:
 * 进位：加法必须解决进位问题
 * 对齐：使两个数组等长，遍历时好遍历
 * 结果数组多出一位：为了解决两个等长的字符串数字相加后产生了进位
 */
public class BigStringAddtion {

    /**
     * @param num1
     * @param num2
     * @return
     */
    public static String bigStringAddtion(String num1, String num2) {

        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        int length1 = array1.length;
        int length2 = array2.length;
        int maxLenth = Math.max(length1, length2);
        // 两数组长度之差
        int difference = Math.abs(length1 - length2);
        char[] differenceArray = new char[difference];
        // 将差数组全部填充为字符0
        Arrays.fill(differenceArray, '0');
        // 为较短的数组前面补0
        if (length1 > length2) {
            array2 = ArrayUtils.addAll(differenceArray, array2);
        } else {
            array1 = ArrayUtils.addAll(differenceArray, array1);
        }
        // 结果字符数组。选择字符数组是为了方便转化为字符串
        char[] rsArray = new char[maxLenth + 1];
        // 进位标志
        int carryBit = 0;
        for (int i = maxLenth - 1; i >= 0; i--) {
            int a = Integer.parseInt(String.valueOf(array1[i]));
            int b = Integer.parseInt(String.valueOf(array2[i]));
            // 两数相加，将进位也加上
            int sum = a + b + carryBit;
            int num = sum % 10;
            // 每次计算进位，是为了前一位的两数相加时，让进位的数值也参与运算
            carryBit = sum / 10;
            // 将数字转为字符
            rsArray[i + 1] = String.valueOf(num).toCharArray()[0];
            // 当被计算的数组遍历到第一个元素时，将进位插入到结果数组的第一个元素中
            if (i == 0) {
                rsArray[i] = String.valueOf(carryBit).toCharArray()[0];
            }
        }
        return String.valueOf(rsArray);
    }

    public static void main(String[] args) {

        String num1 = "2345928575288542";
        String num2 = "8408538205";

        String s = bigStringAddtion(num1, num2);
        System.out.println(s);

    }
}
