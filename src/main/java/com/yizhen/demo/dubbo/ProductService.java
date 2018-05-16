package com.yizhen.demo.dubbo;

import org.springframework.stereotype.Component;

@Component(value="productService")
public class ProductService implements IProduct {

	@Override
	public String getProductName(String caller) {
		// TODO Auto-generated method stub
        return caller+":jim";
	}
}