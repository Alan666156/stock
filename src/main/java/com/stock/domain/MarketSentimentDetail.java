package com.stock.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 市场情绪明细信息
 */
@Data
@Entity
@Table(name = "market_sentiment_detail")
@EntityListeners(AuditingEntityListener.class)
public class MarketSentimentDetail extends AbstractPersistable<Long>{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 关联主表id
	 */
	private Long marketSentimentId;
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
	 * 涨跌幅
	 */
	private BigDecimal rate;
	/**
	 * 连板数
	 */
	private Integer num;
	/**
	 * 类型(周、月、季、年)
	 */
	private String type;
	/**
     * 行业板块
	 */
	private String industry;
	/**
	 * 备注
	 */
	private String remark;
}
