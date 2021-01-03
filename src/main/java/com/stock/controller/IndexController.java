package com.stock.controller;

import com.stock.annotation.Phone;
import com.stock.util.HttpClientUtil;
import com.stock.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Alan.Fu
 * @date 2020年12月17日
 */
@Slf4j
@RestController
public class IndexController {
	private static List<String> defaultList = Arrays.asList("sh000001", "sh000300");
	
	/**
	 * test
	 */
	@GetMapping("/test")
	public Result test(){

		return null;
	}

	/**
	 * 获取数据 600711
	 */
	@GetMapping("/getStock")
	public Result getStock(String code) throws Exception {
		log.info("=======数据获取=======");
		//同花顺--->http://q.10jqka.com.cn/
		//打开页面新浪详情---> https://finance.sina.com.cn/realstock/company/sz000625/nc.shtml
		String res = HttpClientUtil.doGet("http://suggest3.sinajs.cn/suggest/type=11,12,31,41&key=" + code);
		log.info("查询响应结果：{}" , res);
		return Result.success(res);
	}

	/**
	 * 获取数据
	 */
	@GetMapping("/getStockList")
	public Result getStockList(){

		return Result.create(true);
	}

	/**
	 * 获取数据
	 * @param mobile
	 */
	@GetMapping("/register")
	public Result register(@Phone String mobile){

		return Result.create(true);
	}

	/**
	 * 量化分析
	 */
	@GetMapping("/quantitativeMethods")
	public Result QuantitativeMethods(){
		log.info("量化分析");
		return Result.create(true);
	}

	/**
	 * bidding分析
	 */
	@GetMapping("/bidding")
	public Result bidding(String code){
		log.info("竞价分析:{}", code);
		return Result.create(true);
	}

}
