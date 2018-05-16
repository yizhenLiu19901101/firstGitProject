package com.yizhen.demo.test;

public class ShuiXianHuaTest {
    public static final int NUMBER_LIMIT = 1000;
    public static final int POW_NUM = 3;
    public static void main(String[] args){
        for(int i=0;i<NUMBER_LIMIT;i++){
            if(i> 100){
                int firstNum = i/100;
                int secondNum = (i%100)/10;
                int thirdNum = i%10;
                int resultInt = (int) Math.ceil(Math.pow(firstNum,POW_NUM) + Math.pow(secondNum,POW_NUM) + Math.pow(thirdNum,POW_NUM));
                if(resultInt == i){
                    System.out.println(i);
                }
            }
        }
    }
}

