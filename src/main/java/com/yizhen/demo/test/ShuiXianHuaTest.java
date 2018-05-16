package com.yizhen.demo.test;

/**
 * 水仙花数的问题
 * @author  liuyizhen
 */
public class ShuiXianHuaTest {
    public static final int NUMBER_LIMIT = 1000;
    public static final int POW_NUM = 3;
    public static void main(String[] args){
        //水仙花数问题
        shuiXianHua();
    }

    /**
     * 得到水仙花数
     */
    public static void shuiXianHua(){
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