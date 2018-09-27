package com.njkol.redis.mongo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.njkol.redis.mongo.model.Review;
import com.njkol.redis.mongo.service.VendorReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller for managing vendor reviews
 * 
 * @author Nilanjan Sarkar
 *
 */
@RestController
@RequestMapping("/reviews")
@CacheConfig(cacheNames = "vendorReviewCache")
@Api(value = "Vendor Review Management")
public class VendorReviewController {

	private final static Logger logger = Logger.getLogger(VendorReviewController.class);

	@Autowired
	private VendorReviewService service;

	// Not a write through cache
	@PostMapping("/add/{vendorName}")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Adds review for a vendor")
	public void create(@RequestBody Review review, @PathVariable String vendorName) throws Exception {
		logger.info("Inside create ");
		service.saveReviewForVendor(review, vendorName);
	}

	@Cacheable(key = "#vendorName", sync = true)
	@GetMapping("/get/{vendorName}")
	@ApiOperation(value = "Retrives all the reviews for a Vendor", response = List.class)
	public List<Review> fetchReviewsForVendor(@PathVariable String vendorName) throws Exception {
		logger.info("Inside fetchReviewForVendor ");
		return service.getReviewsByVendorName(vendorName);
	}
}
