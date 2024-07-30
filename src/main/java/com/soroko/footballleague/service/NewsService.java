package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.News;
import com.soroko.footballleague.repository.NewsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsService {
    final NewsRepository newsRepository;

    public List<News> getAllNews() {
        News news01 = new News();
        news01.setId(1);
        news01.setCreatedAt(LocalDateTime.now());
        news01.setText("This is my first news here!");
        News news02 = new News();
        news02.setId(2);
        news02.setCreatedAt(LocalDateTime.now());
        news02.setText("This is my second news here!");
        List<News> news = newsRepository.findAll();
        if (news.isEmpty()) {
            news.add(news01);
            news.add(news02);
        }
        return news;
    }

    public News getNewsById(int id) {
        News news = new News();
        news.setId(1);
        news.setCreatedAt(LocalDateTime.now());
        news.setText("This is my first news here!");
        return newsRepository.findById(id).orElse(news);
    }

    public long addNews(News news) {
        return newsRepository.save(news).getId();
    }

    public void updateNews(int id, News updatedNews) {
        News newsToBeUpdated = getNewsById(id);
        newsToBeUpdated.setText(updatedNews.getText());
        newsToBeUpdated.setCreatedAt(updatedNews.getCreatedAt());
    }


}
