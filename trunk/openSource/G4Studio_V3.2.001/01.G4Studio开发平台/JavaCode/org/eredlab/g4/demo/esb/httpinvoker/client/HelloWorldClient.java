package org.eredlab.g4.demo.esb.httpinvoker.client;

import org.eredlab.g4.ccl.datastructure.Dto;
import org.eredlab.g4.ccl.datastructure.impl.BaseDomain;

/**
 * Httpinvoker接口
 * 
 * @author XiongChun
 * @since 2010-10-13
 * @see BaseDomain
 */
public interface HelloWorldClient {
	/**
	 * sayHello
	 * @param text
	 * @return
	 */
	public String sayHello(String text);
	
	/**
	 * 查询一条结算明细测试数据
	 * @param jsbh
	 * @return XML字符串
	 */
	public Dto queryBalanceInfo(String jsbh);
	
}
