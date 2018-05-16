package com.yizhen.demo.test;

import org.junit.Test;

import java.util.Scanner;

/**
 * 水仙花数的问题
 * @author  liuyizhen
 */
public class ShuiXianHuaTest {
    public static final int NUMBER_LIMIT = 1000;
    public static final int POW_NUM = 3;

    /**
     * 测试用例1
     */
    @Test
    public void testShuiXianHua() {
        //水仙花数
        shuiXianHuaComputer(4);
    }

    ;

    /**
     * 得到水仙花数
     */
    public static void shuiXianHuaMyOwn() {
        for (int i = 0; i < NUMBER_LIMIT; i++) {
            if (i >= 100) {
                int firstNum = i / 100;
                int secondNum = (i % 100) / 10;
                int thirdNum = i % 10;
                //abc = a*a*a + b*b*b + c*c*c
                int resultInt = (int) Math.ceil(Math.pow(firstNum, POW_NUM) + Math.pow(secondNum, POW_NUM) + Math.pow(thirdNum, POW_NUM));
                if (resultInt == i) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void shuiXianHuaComputer(int N) {
        for (int i = 3; i <= N; i++) {
            int a[] = new int[i];
            int num = (int) Math.pow(10, i - 1) + 1;
            if(N == 3){
                System.out.print(i + "位的水仙花数有：\t");
            }else if(N == 4) {
                System.out.print(i + "位的四叶玫瑰数有：\t");
            }else{

            }

            while (num <= Math.pow(10, i)) {
                int sum = 0;
                for (int j = 0; j < i; j++) {
                    //核心逻辑
                    a[j] = (int) (num / Math.pow(10, j) % 10);
                }
                for (int j = 0; j < i; j++) {
                    sum = sum + (int) Math.pow(a[j], i);
                }
                if (num == sum) {
                    System.out.print(num + "\t");
                }
                num++;
            }
            System.out.print("\n");

        }
    }
}