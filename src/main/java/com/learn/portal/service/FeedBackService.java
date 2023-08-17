package com.learn.portal.service;

import java.util.List;

import com.learn.portal.dto.FeedBackDto;
import com.learn.portal.entites.FeedBack;

public interface FeedBackService {
    FeedBackDto createFeedBack(FeedBackDto feedBackDto);
    List<FeedBack> getAllFeedBacks();
    List<FeedBackDto> getAllFeedBacksByUserId(Integer userId);
}
