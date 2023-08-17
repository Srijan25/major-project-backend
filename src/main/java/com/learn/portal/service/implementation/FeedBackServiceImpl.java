package com.learn.portal.service.implementation;

import com.learn.portal.dto.FeedBackDto;
import com.learn.portal.entites.FeedBack;
import com.learn.portal.repository.FeedBackRepository;
import com.learn.portal.repository.UserRepository;
import com.learn.portal.service.FeedBackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedBackRepository feedBackRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public FeedBackDto createFeedBack(FeedBackDto feedBackDto) {
        FeedBack feedBack = this.modelMapper.map(feedBackDto, FeedBack.class);
        FeedBack savedFeedBack = this.feedBackRepository.save(feedBack);
        return this.modelMapper.map(savedFeedBack, FeedBackDto.class);
    }

    @Override
    public List<FeedBack> getAllFeedBacks() {
        List<FeedBack> feedBacks = this.feedBackRepository.findAll();
        return feedBacks;
    }

    @Override
    public List<FeedBackDto> getAllFeedBacksByUserId(Integer userId) {
        List<FeedBack> feedBacks = this.feedBackRepository.findByUserId(userId);
        return feedBacks.stream().map(feedBack -> this.modelMapper.map(feedBack, FeedBackDto.class)).toList();

    }
}
