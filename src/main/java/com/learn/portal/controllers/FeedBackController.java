package com.learn.portal.controllers;

import com.learn.portal.dto.FeedBackDto;
import com.learn.portal.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
