package com.stock.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 文件配置对象
 */
@Data
@Entity
@Table(name = "stock")
@EntityListeners(AuditingEntityListener.class)
public class Stock extends AbstractPersistable<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 名称
	 */
	@Column(name="name", columnDefinition=("varchar(50)  default null comment '名称'"))
	private String name;
	/**
	 * 编码
	 */
	@Column(name="code", columnDefinition=("varchar(50)  default null comment '编码'"))
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
	 * 备注
	 */
	private String remark;
}
