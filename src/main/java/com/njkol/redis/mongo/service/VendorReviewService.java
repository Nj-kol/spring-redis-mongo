package com.njkol.redis.mongo.service;

import java.util.List;

import com.njkol.redis.mongo.model.Review;

public interface VendorReviewService {

	public List<Review> getReviewsByVendorName(String vendorName) throws Exception;
	public void saveReviewForVendor(Review review,String vendorName)  throws Exception;
}
