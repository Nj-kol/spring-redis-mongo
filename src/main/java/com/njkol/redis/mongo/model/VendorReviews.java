package com.njkol.redis.mongo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Nilanjan Sarkar
 */
@Document(collection = "vendor_reviews")
public class VendorReviews implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(notes = "ID of the vendor")
	private Long id;
	@Indexed
	@ApiModelProperty(notes = "Name of the vendor")
	private String vendorName;
	@ApiModelProperty(notes = "All the reviews for the user")
	private List<Review> reviews;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
}