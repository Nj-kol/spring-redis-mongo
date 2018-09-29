package com.njkol.redis.mongo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.njkol.redis.mongo.exception.NoReviewsFoundException;
import com.njkol.redis.mongo.model.Review;
import com.njkol.redis.mongo.model.Vendor;
import com.njkol.redis.mongo.model.VendorReviews;

@Service
public class VendorReviewServiceImpl implements VendorReviewService {

	@Autowired
	private MongoTemplate template;

	/**
	 * Gets all the names of a vendor
	 * 
	 * @param vendorName
	 *            Name of the vendor
	 */
	public List<Review> getReviewsByVendorName(String vendorName) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("vendorName").is(vendorName));
		VendorReviews rv = template.findOne(query, VendorReviews.class);
		if (null != rv) {
			return rv.getReviews();
		} else {
			throw new NoReviewsFoundException("No Reviews found for vendor :" + vendorName);
		}
	}

	/**
	 * Saves a review for a vendor
	 * 
	 * @param review
	 *            A review by a user
	 * @param vendorName
	 *            Name of the vendor
	 */
	public void saveReviewForVendor(Review review, String vendorName) throws Exception {
		List<Review> reviews = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("vendorName").is(vendorName));
		VendorReviews rv = template.findOne(query, VendorReviews.class);
		if (rv == null) {
			rv = new VendorReviews();
			Vendor v = template.findOne(query, Vendor.class);
			reviews = new ArrayList<Review>();
			reviews.add(review);
			rv.setId(v.getId());
			rv.setVendorName(vendorName);
			rv.setReviews(reviews);
		} else {
			reviews = rv.getReviews();
			reviews.add(review);
			rv.setReviews(reviews);
		}
		template.save(rv);
	}
}