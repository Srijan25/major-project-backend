package com.learn.portal.service;

import com.learn.portal.dto.FeedBackDto;
import com.learn.portal.entites.FeedBack;

import java.util.List;

public interface FeedBackService {
    FeedBackDto createFeedBack(FeedBackDto feedBackDto);
    List<FeedBack> getAllFeedBacks();
    List<FeedBackDto> getAllFeedBacksByUserId(Integer userId);
}
