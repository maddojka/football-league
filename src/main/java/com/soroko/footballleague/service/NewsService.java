package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.News;
import com.soroko.footballleague.repository.NewsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsService {
    final NewsRepository newsRepository;

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News getNewsById(int id) {
        return newsRepository.findById(id).orElseThrow(
                () -> new MatchException(("No news found with id: " + id), new IllegalArgumentException()));
    }

    public News addNews(News news) {
        return newsRepository.save(news);
    }

    public News updateNews(int id, News updatedNews) {
        News newsToBeUpdated = getNewsById(id);
        newsToBeUpdated.setId(updatedNews.getId());
        newsToBeUpdated.setText(updatedNews.getText());
        newsToBeUpdated.setCreatedAt(updatedNews.getCreatedAt());
        return newsRepository.save(newsToBeUpdated);

    }


}
