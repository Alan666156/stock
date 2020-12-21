package com.stock.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author fhx
 * @date 2020年12月13日
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class StockService {




}
