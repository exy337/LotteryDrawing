package com.exy337;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这个程序是抽奖的算法：比如手机号抽奖，抽中以后，不会再次出现。
 * 把所有手机号放入numbers数组即可完成替换
 * 来源自Java核心技术卷1（中文版）P83
 * @version 1.00 2017-10-30
 * @author exy337
 */

public class LotteryDrawing {

    //在类中放main函数是单元测试调试技巧
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("抽几个数(球,手机号)？");
        int k = in.nextInt();

        System.out.println("共多少个数(球,手机号)？");
        int n = in.nextInt();

        // numbers, 所有的数(球,手机号)
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++)
        {
            numbers[i] = i+1;
        }

        LotteryDrawing drawing = new LotteryDrawing();
        int[] result = drawing.getLotteryDrawing(k,numbers);

        Arrays.sort(result); //给选出来的数排序，仅是为了显示好看
        for(int r : result)
            System.out.print(r + " ");
    }

    // k 抽几个数(球,手机号)？
    // numbers, 所有的数(球，手机号)
    public int[] getLotteryDrawing(int k, int[] numbers)
    {
        int n = numbers.length; //数组的长度,共多少个数
        int[] result = new int[k];
        for(int i = 0; i < k; i++)
        {
            //Math.random()方法返回一个0到1之间(包含0，不包含1）的随机浮点数.
            //用n乘以这个数，就可以得到0到n-1之间的一个随机数
            int r = (int) (Math.random() * n);
            result[i] = numbers[r];

            numbers[r] = numbers[n-1];//用最后一个数替换被抽出去的数,并且n减一
            n--;
        }
        return  result;
    }
    // 本方法很容易替换为 "字符串数组" 版本
    // public String[] getLotteryDrawing(int k, String[] numbers)
}
