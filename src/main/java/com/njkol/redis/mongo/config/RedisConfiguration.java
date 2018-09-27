package com.njkol.redis.mongo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.njkol.redis.mongo.model.Review;

@Configuration
public class RedisConfiguration extends CachingConfigurerSupport {

	@Value("${spring.redis.host}")
	private String redisHost;

	@Value("${spring.redis.port}")
	private String redisPort;

	@Autowired
	private VendorReviewsSerializer vendRevSer;

	private KeyGenerator keyGen = new VendorReviewsKeyGenerator();

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setUsePool(true);
		jedisConnectionFactory.setHostName(redisHost);
		jedisConnectionFactory.setPort(Integer.parseInt(redisPort));
		return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, List<Review>> redisTemplate() {
		RedisTemplate<String,List<Review>> redisTemplate = new RedisTemplate<String,List<Review>>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setExposeConnection(true);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(vendRevSer);
		return redisTemplate;
	}

	@Bean
	public RedisCacheManager cacheManager() {

		RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
		redisCacheManager.setTransactionAware(true);
		redisCacheManager.setDefaultExpiration(120);
		redisCacheManager.setLoadRemoteCachesOnStartup(false);
		redisCacheManager.setUsePrefix(true);
		return redisCacheManager;
	}

	@Bean("vendorReviewsKeyGenerator")
	public KeyGenerator keyGenerator() {
		return keyGen;
	}
}