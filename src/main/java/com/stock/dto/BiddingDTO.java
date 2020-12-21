package com.stock.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 竞价指标计算
 */
@Data
public class BiddingDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 交易额
	 */
	private BigDecimal tradeAmount;
	/**
	 * 昨日最大成交量
	 */
	private BigDecimal yesterdayMax;
	/**
	 * 计算今日成交量多少符合参与
	 */
	private BigDecimal tradeNum;
	/**
	 * 涨跌幅
	 */
	private BigDecimal rate;
	/**
	 * 备注
	 */
	private String remark;
}
