package com.stock.job;

import com.stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StockJob {

	@Autowired
	private StockService fileService;
	/**
	 * 定时任务
	 */
//	@Scheduled(cron = "0 0/1 * * * ?")
	@Scheduled(cron="0 0 03 * * ?")
	public void test() {
		log.info("start the clear timeout file job");
		try {

		} catch (Exception e) {
			log.warn("failed to loop timeout file queue", e);
		}
		log.info("finished the clear timeout file job");
	}
}
