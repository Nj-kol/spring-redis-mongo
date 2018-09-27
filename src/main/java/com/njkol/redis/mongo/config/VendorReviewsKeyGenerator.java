package com.njkol.redis.mongo.config;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;

public class VendorReviewsKeyGenerator implements KeyGenerator {

	public Object generate(Object target, Method method, Object... params) {

		String key = "";
		for (Object par : params) {
			if (par instanceof String) {
				key = (String) par;
			}
		}
		return key;
	}
}
