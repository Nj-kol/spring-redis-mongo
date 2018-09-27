package com.njkol.redis.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.njkol.redis.mongo.model.Vendor;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private MongoTemplate template;

	public Vendor getVendorById(Long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return template.findOne(query, Vendor.class);
	}

	public Vendor getVendorByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("vendorName").is(name));
		return template.findOne(query, Vendor.class);
	}

	public Vendor getVendorByCode(String code) {
		Query query = new Query();
		query.addCriteria(Criteria.where("vendorCode").is(code));
		return template.findOne(query, Vendor.class);
	}

	
	public void saveVendorDetails(Vendor user) {
		template.save(user);
	}

	public void removeVendorById(Long id) {
		throw new UnsupportedOperationException();
	}
}
