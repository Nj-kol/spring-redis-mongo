package com.njkol.redis.mongo.config;

import org.springframework.util.SerializationUtils;

import java.util.List;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

import com.njkol.redis.mongo.model.Review;

/**
 * Customer Serializer
 * 
 * @author Nilanjan Sarkar
 *
 */
@Component
public class VendorReviewsSerializer implements RedisSerializer<List<Review>> {

	public byte[] serialize(List<Review> t) throws SerializationException {
		return SerializationUtils.serialize(t);
	}

	public List<Review> deserialize(byte[] bytes) throws SerializationException {
		return (List<Review>) SerializationUtils.deserialize(bytes);
	}

}
