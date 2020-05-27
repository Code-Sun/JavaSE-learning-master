package com.edu.sunyifeng.LeetCode.大数字乘法;

import java.util.ArrayList;

/**
 * @Auther: sunyifeng
 * @Date: 2020/05/04/23:57
 * @Description:
 *
 * 这个算法我修改了很久，里面有有很多技巧值得学习
 */
public class BigNumMultiplication1 {

    public static String multiplication(String num1,String num2){
        int length1 = num1.length();
        int length2 = num2.length();
        ArrayList<int[]> results = new ArrayList<>();
        for(int i=length1-1;i>=0;i--){
            int n1=num1.charAt(i)-'0';
            int[] resultTmp=new int[length1+length2];
            int tmp=0;
            for (int j = length2-1; j >=0 ; j--) {
                int n2=num2.charAt(j)-'0';
                tmp = n1 * n2 + tmp;
                resultTmp[i + j + 1]=tmp%10;
                tmp/=10;
            }
            // 解决乘法高位进位，一个数字中的一个数位上的数和另一个数相乘后，存在进位情况
            resultTmp[i]=tmp;
            results.add(resultTmp);
        }
        // 将结果数组设置为两数长度加一，是为了高位进位，和加法里arr1比arr2多一位
        int[] resultArr=new int[length1+length2+1];
        for (int i = 0; i < results.size() ; i++) {
            resultArr = add(resultArr, results.get(i));
        }
        String result="";
        // 将整数数组转为String
        for (int i : resultArr) {
            result+=String.valueOf(i);
        }
        // 如果没有发生进位，就删除最高为的0
        if(result.charAt(0)=='0'){
            result = result.substring(1);
        }
        return result;
    }

    public static int[] add(int[] arr1,int[] arr2){
        int[] result=new int[arr1.length];
        int tmp=0;
        for (int i = arr2.length-1 ; i>=0 ; i--) {
            // arr1[i+1]是因为arr1比arr2多一位
            tmp = arr1[i+1] + arr2[i] + tmp;
            result[i+1]=tmp%10;
            tmp=tmp/10;
            // 加法的进位
            if(i==0){
                result[0]=tmp;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String num1="761";
        String num2="761";
        String s = multiplication(num1, num2);
        System.out.println(s);
        System.out.println(761*761);
    }
}
