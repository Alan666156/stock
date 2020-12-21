package com.stock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 启动入口
 * @author fuhx
 */
@Slf4j
//@EnableDiscoveryClient
//@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class StockApplication implements CommandLineRunner{
	

//	@Bean
//	public RedisTemplate<Serializable, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//		RedisTemplate<Serializable, Object> template = new RedisTemplate<Serializable, Object>();
//		template.setConnectionFactory(redisConnectionFactory);
//		setRedisSerializer(template);
//		template.afterPropertiesSet();
//		return template;
//	}
//
//	private void setRedisSerializer(RedisTemplate<Serializable, ?> template) {
//		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//		ObjectMapper om = new ObjectMapper();
//		om.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
//		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//		jackson2JsonRedisSerializer.setObjectMapper(om);
//		template.setKeySerializer(template.getStringSerializer());
//		template.setValueSerializer(jackson2JsonRedisSerializer);
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
		log.info("=========Stock Application Start Success===========");
	}
	
	@Override
	public void run(String... args) throws Exception {
		// 应用启动成功后需要执行的数据
//		Map<String, List<FileConfigInfo>> map = new HashMap<>();
//		List<FileConfig> list = fileConfigDao.findAll();
//		for(FileConfig file : list) {
//			//写入缓存
//			redisService.set(file.getAppId(), file);
//		}
		
	}
}
