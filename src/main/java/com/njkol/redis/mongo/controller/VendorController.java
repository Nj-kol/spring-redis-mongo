package com.njkol.redis.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.njkol.redis.mongo.model.Vendor;
import com.njkol.redis.mongo.service.VendorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller for managing vendor lifecycle
 * 
 * @author Nilanjan Sarkar
 *
 */
@RestController
@RequestMapping("/vendor")
@Api(value = "Vendor Management")
public class VendorController {

	@Autowired
	private VendorService service;

	@PostMapping("/onboard")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Onboards a vendor")
	public void create(@RequestBody Vendor vendor) throws Exception {
		service.saveVendorDetails(vendor);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retrives a Vendor by their id", response = Vendor.class)
	public Vendor getVendorById(@PathVariable Long id) throws Exception {
		return service.getVendorById(id);
	}

	@GetMapping("/name/{name}")
	@ApiOperation(value = "Retrives a Vendor by name", response = Vendor.class)
	public Vendor fetchVendorDetailsByName(@PathVariable String name) throws Exception {
		return service.getVendorByName(name);
	}
	
	@GetMapping("/code/{code}")
	@ApiOperation(value = "Retrives a Vendor by code", response = Vendor.class)
	public Vendor fetchVendorDetailsByCode(@PathVariable String code) throws Exception {
		return service.getVendorByCode(code);
	}
}
