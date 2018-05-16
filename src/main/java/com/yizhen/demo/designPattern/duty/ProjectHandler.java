package com.yizhen.demo.designPattern.duty;

/**
 * 具体类
 * @author liuyizhen
 *
 */
public class ProjectHandler extends ConsumeHandler {
    @Override
    public void doHandler(String user, double free) {
        if (free < 500) {
            if (user.equals("lwx")) {
                System.out.println("给予报销:" + free);
            }else {
                System.out.println("报销不通过");
            }
         } else {
             if (getNextHandler() != null) {
                 getNextHandler().doHandler(user, free);
             }
         } 
    }
}
