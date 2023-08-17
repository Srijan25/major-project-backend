package com.learn.portal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.portal.dto.FeedBackDto;
import com.learn.portal.service.FeedBackService;

@RestController
@RequestMapping("/api/feedback")

public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    @PostMapping("/create")
    public ResponseEntity<FeedBackDto> createFeedBack(@RequestBody FeedBackDto feedBackDto){
        FeedBackDto createdFeedBack = this.feedBackService.createFeedBack(feedBackDto);
        return new ResponseEntity<>(createdFeedBack, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllFeedBacks(){
        return new ResponseEntity<>(this.feedBackService.getAllFeedBacks(), HttpStatus.OK);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<?> getAllFeedBacksByUserId(@PathVariable Integer userId){
        return new ResponseEntity<>(this.feedBackService.getAllFeedBacksByUserId(userId), HttpStatus.OK);
    }
    
    @GetMapping("/feedBack/{userId}")
    public ResponseEntity<List<FeedBackDto>> getFeedBackByUserId(@PathVariable Integer userId){
    	return new ResponseEntity<List<FeedBackDto>>(this.feedBackService.getAllFeedBacksByUserId(userId),HttpStatus.OK);
    }
}
