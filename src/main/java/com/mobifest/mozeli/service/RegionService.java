package com.mobifest.mozeli.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobifest.mozeli.dao.RegionDAO;
import com.mobifest.mozeli.models.Region;

@Service
public class RegionService {
	
	@Autowired
	RegionDAO regionDao;
	
	public Region saveRegion(Region mregion) {
		Region regionObj = new Region();
		regionObj.setRegionName(mregion.getRegionName());
		regionObj.setRegionAmount(mregion.getRegionAmount());
		Region savedRegion = regionDao.saveAndFlush(regionObj);
		return savedRegion;
	}
	
	public List<Region> getAllRegions() {
		List<Region> regionsList = regionDao.findAll();
		return !regionsList.isEmpty() ? regionsList : new ArrayList<Region>();
	}
	
	public String deleteRegion(Long regionId) {
		Region regionToDelete = regionDao.getOne(regionId);
		regionDao.delete(regionToDelete);
		return "Region Deleted Successfully";
	}
	

}
