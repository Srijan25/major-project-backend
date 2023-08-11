package com.learn.portal.service.implementation;

import com.learn.portal.dto.NewsDto;
import com.learn.portal.entites.News;
import com.learn.portal.repository.NewsRepository;
import com.learn.portal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;


    @Override
    public NewsDto createNews(NewsDto newsDto) {
        News news = new News();
        news.setNewsTitle(newsDto.getNewsTitle());
        news.setNewsDescription(newsDto.getNewsDescription());
        news.setNewsDate(newsDto.getNewsDate());
        newsRepository.save(news);
        return newsDto;

    }

    @Override
    public NewsDto updateNews(int newsId, NewsDto newsDto) {
        News news = newsRepository.findById(newsId).get();
        news.setNewsTitle(newsDto.getNewsTitle());
        news.setNewsDescription(newsDto.getNewsDescription());
        news.setNewsDate(newsDto.getNewsDate());
        newsRepository.save(news);
        return newsDto;
    }

    @Override
    public String deleteNews(int newsId) {
        News news = newsRepository.findById(newsId).get();
        newsRepository.delete(news);
        return "News Deleted";
    }
}
