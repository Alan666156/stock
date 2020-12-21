package com.stock.exception;

import com.stock.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常捕获
 * @author fhx
 * @date 2020年12月13日
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BusinessException.class)
	public Result<?> businessExceptionHandler(BusinessException be) {
		log.warn("got business error", be);
		return Result.create(false, be.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public Result<?> systemExceptionHandler(Exception be) {
		log.warn("got error", be);
		return Result.create(false);
	}
}
