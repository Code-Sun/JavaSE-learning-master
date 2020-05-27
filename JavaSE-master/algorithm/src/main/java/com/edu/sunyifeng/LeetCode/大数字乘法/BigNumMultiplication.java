package com.edu.sunyifeng.LeetCode.大数字乘法;

/**
 * @Auther: sunyifeng
 * @Date: 2020/05/04/23:57
 * @Description:
 * 这个算法是将别人的算法改进的，非常巧妙，比我代码更优雅
 */
public class BigNumMultiplication {

    public static String multiplication(String num1,String num2){
        int length1 = num1.length();
        int length2 = num2.length();
        int[] resultArray=new int[length1+length2];
        for(int i=length1-1;i>=0;i--){
            int n1=num1.charAt(i)-'0';
            int tmp=0;
            for (int j = length2-1; j >=0 ; j--) {
                int n2=num2.charAt(j)-'0';
                // resultArray[i + j + 1]可以拿到上一次遍历计算完的数字的最后一位，随着j的变化，逐次拿到前几位
                tmp = n1 * n2 + resultArray[i + j + 1]+tmp;
                resultArray[i + j + 1]=tmp%10;
                // 每次计算完的结果，取出进位的数，为下次计算用
                tmp/=10;
            }
            resultArray[i]=tmp;
        }
        String result="";
        for (int num : resultArray) {
            result+=String.valueOf(num);
        }
        return result;
    }

    public static void main(String[] args) {
        String num1="557";
        String num2="32";
        String result = multiplication(num1, num2);
        System.out.println(result);
        System.out.println(557*32);
    }
}
