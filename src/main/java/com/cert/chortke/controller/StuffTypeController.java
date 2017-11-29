package com.cert.chortke.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cert.chortke.dto.StuffType;
import com.cert.chortke.entities.StuffTypeEntity;
import com.cert.chortke.service.StuffTypeRepository;

@RestController
@RequestMapping("/api/stufftype")
public class StuffTypeController {

	private StuffTypeRepository stuffTypeRepository;

	@Autowired
	public StuffTypeController(StuffTypeRepository stuffTypeRepository) {
		this.stuffTypeRepository = stuffTypeRepository;

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<StuffTypeEntity> getUsers() {

		List<StuffTypeEntity> stuffTypeList = stuffTypeRepository.findAll();

		if (stuffTypeList != null)
			return stuffTypeList;
		return new ArrayList<StuffTypeEntity>();

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Long saveOrUpdate(/* @PathVariable("user") */ @RequestBody StuffType stuffType) {

		StuffTypeEntity entity = new StuffTypeEntity();
		entity.setContentType(stuffType.getContentType());
		entity.setKey(stuffType.getKey());
		entity.setLabel(stuffType.getLabel());
		
		StuffTypeEntity result = stuffTypeRepository.save(entity);
		if (result != null)
			return result.getId();
		return null;
	}

}
