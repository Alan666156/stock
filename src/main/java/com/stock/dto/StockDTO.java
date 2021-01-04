package com.stock.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Alan.Fu
 */
@Data
public class StockDTO implements Serializable {
	
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
	 * 开盘价
	 */
	private BigDecimal openingPrice;
	/**
	 * 收盘价
	 */
	private BigDecimal closingPrice;
	/**
	 * 成交额
	 */
	private BigDecimal trade;
	/**
	 * 涨跌幅
	 */
	private BigDecimal rate;
	/**
	 * 备注
	 */
	private String remark;
}
