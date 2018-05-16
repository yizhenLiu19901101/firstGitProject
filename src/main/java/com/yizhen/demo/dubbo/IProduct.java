package com.yizhen.demo.dubbo;

public interface IProduct {
	/**
	 * 获得产品名称
	 * @param caller
	 * @return
	 */
    String getProductName(String caller);
}
