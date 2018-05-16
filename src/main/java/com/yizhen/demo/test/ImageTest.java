package com.yizhen.demo.test;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yizhen.demo.utils.VerifyCodeUtils;

public class ImageTest {
    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(ImageTest.class);
	    int w = 100, h = 30; 
	    File file = new File("E://4.jpg");
	    logger.info("开始生成图片......");
	    VerifyCodeUtils.outputImage(w,h,file,"552194"); 
	    logger.info("结束生成图片......");
    }
}