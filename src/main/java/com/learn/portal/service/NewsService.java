package com.learn.portal.service;

import com.learn.portal.dto.NewsDto;

public interface NewsService {
    NewsDto createNews(NewsDto newsDto);

    NewsDto updateNews(int newsId, NewsDto newsDto);

    String deleteNews(int newsId);
}
