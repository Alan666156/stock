package com.stock.util;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 接口返回定义
 * @author Alan.Fu
 */
@Data
@ToString
public class Result<T> implements Serializable {
	private static final long serialVersionUID = -7917470817867029039L;

	/** 调用是否成功 */
	private Boolean success;
	/** 状态码 */
	private String code;
	/** 消息 */
	private String messages;
	/** 数据 */
	private T data;

	public Result(){}

	public Result(Boolean success){this.success = success;}
	public Result(T data){
		this.success = true;
		this.data = data;
	}

	public Result(Boolean success, String code){this.success = success; this.code = code;}

	public Result(Boolean success, String code, String messages) {
		this.success = success;
		this.code = code;
		this.messages = messages;
	}

	public Result(Boolean success, String code, String messages, T data) {
		this.success = success;
		this.code = code;
		this.messages = messages;
		this.data = data;
	}

	public static <T> Result<T> create(boolean success) {
		return create(success, null);
	}

	public static <T> Result<T> create(boolean success, String message) {
		return new Result<T>(success, message);
	}
	public static <T> Result<T> success(T data) {
		return new Result<T>(data);
	}
	public static <T> Result<T> failure(String code, String message) {
		return new Result(true, "200", message, (Object)null);
	}
	public boolean successful() {
		return this.success;
	}
}
