package com.njkol.redis.mongo.service;

import com.njkol.redis.mongo.model.Vendor;

/**
 * 
 * @author Nilanjan Sarkar
 */
public interface VendorService {

	public Vendor getVendorById(Long id) throws Exception;

	public Vendor getVendorByName(String nme) throws Exception;

	public Vendor getVendorByCode(String code) throws Exception;
	
	public void saveVendorDetails(Vendor user) throws Exception;

	public void removeVendorById(Long id) throws Exception;
}
