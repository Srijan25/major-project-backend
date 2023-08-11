package com.learn.portal.controllers;

import com.learn.portal.dto.NewsDto;
import com.learn.portal.service.NewsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping("/create")
    public ResponseEntity<NewsDto> createNews(@Valid @RequestBody NewsDto newsDto) {
        NewsDto createdNews = this.newsService.createNews(newsDto);
        return new ResponseEntity<>(createdNews, HttpStatus.CREATED);
    }

    @PutMapping("/update/{newsId}")
    public ResponseEntity<NewsDto> updateNews(@PathVariable int newsId, @Valid @RequestBody NewsDto newsDto) {
        NewsDto updatedNews = this.newsService.updateNews(newsId, newsDto);
        return new ResponseEntity<>(updatedNews, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{newsId}")
    public ResponseEntity<String> deleteNews(@PathVariable int newsId) {
        String message = this.newsService.deleteNews(newsId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
