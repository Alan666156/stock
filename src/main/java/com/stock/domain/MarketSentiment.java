package com.stock.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 市场情绪
 */
@Data
@Entity
@Table(name = "market_sentiment")
@EntityListeners(AuditingEntityListener.class)
public class MarketSentiment extends AbstractPersistable<Long>{
	
	/**
	 * market sentiment 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 上涨数量
	 */
	private Integer up;
	/**
	 * 下跌数量
	 */
	private Integer down;
	/**
	 * 涨停数量
	 */
	private Integer limitUp;
	/**
	 * 跌停数量
	 */
	private Integer limitDown;
	/**
	 * 开盘
	 */
	private BigDecimal opening;
	/**
	 * 收盘
	 */
	private BigDecimal closing;
	/**
	 * 涨跌幅
	 */
	private BigDecimal rate;
	/**
	 * 类型(周、月、季、年)
	 */
	private String type;
	/**
	 * 情绪
	 */
	private String sentiment;
	/**
	 * 备注
	 */
	private String remark;

}
