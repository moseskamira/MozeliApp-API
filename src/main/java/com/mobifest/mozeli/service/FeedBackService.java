package com.mobifest.mozeli.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobifest.mozeli.dao.FeedBackDao;
import com.mobifest.mozeli.models.FeedBack;

@Service
public class FeedBackService {
	
	@Autowired
	FeedBackDao feedBackDao;
	
	public ResponseEntity<FeedBack> addFeedBack(FeedBack feedBack) {
		FeedBack myFeedBack = new FeedBack();
		myFeedBack.setCommenterFullName(feedBack.getCommenterFullName());
		myFeedBack.setCommenterEmail(feedBack.getCommenterEmail());
		myFeedBack.setCommenterText(feedBack.getCommenterText());
		FeedBack savedFeedBack = feedBackDao.saveAndFlush(myFeedBack);
		return ResponseEntity.ok().body(savedFeedBack);
	}
	
	public ResponseEntity<List<FeedBack>> fetchAllComments() {
		List<FeedBack> feedBackList = feedBackDao.findAll();
		return !feedBackList.isEmpty() ? ResponseEntity.ok().body(feedBackList) : ResponseEntity.ok().body(new ArrayList<FeedBack>());
	}
	
	public ResponseEntity<String> deleteComment(Long feedBackId) {
		FeedBack commentToDelete = feedBackDao.getOne(feedBackId);
		feedBackDao.delete(commentToDelete);
		return ResponseEntity.ok().body("Successfully Deleted Comment");
	}
}
