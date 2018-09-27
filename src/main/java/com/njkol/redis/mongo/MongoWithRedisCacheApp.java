package com.njkol.redis.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MongoWithRedisCacheApp {

	public static void main(String[] args) {
		SpringApplication.run(MongoWithRedisCacheApp.class, args);
	}
}
