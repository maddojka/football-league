package com.soroko.footballleague.service;

import com.soroko.footballleague.entity.Match;
import com.soroko.footballleague.entity.News;
import com.soroko.footballleague.repository.NewsRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NewsServiceTest {

    @Mock
    private NewsRepository newsRepository;
    @InjectMocks
    private NewsService underTest;

    @Test
    void getAllNews() {
        List<News> news = new ArrayList<>();
        when(newsRepository.findAll()).thenReturn(news);
        List<News> created = underTest.getAllNews();
        assertThat(created).isEqualTo(news);
    }

    @Test
    @Disabled
    void getNewsById() {
    }

    @Test
    void addNews() {
        News news = new News(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Praesent ut iaculis ipsum. Vestibulum vitae gravida felis. " +
                "In et elit non elit scelerisque suscipit. " +
                "Quisque id volutpat ligula. Nullam lectus.", LocalDateTime.now());
        when(newsRepository.save(any(News.class))).thenReturn(news);
        News savedNews = underTest.addNews(news);
        assertThat(savedNews).isNotNull();
    }

    @Test
    @Disabled
    void updateNews() {
    }
}