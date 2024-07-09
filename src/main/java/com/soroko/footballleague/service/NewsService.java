package com.soroko.footballleague.service;

import com.soroko.footballleague.repository.NewsRepository;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    private NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
