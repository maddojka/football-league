package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.News;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.NONE)
class NewsRepositoryTest {

    @Autowired
    private NewsRepository newsRepository;

    @Test
    public void testSaveNews() {
        News news = new News(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Praesent ut iaculis ipsum. Vestibulum vitae gravida felis. " +
                "In et elit non elit scelerisque suscipit. " +
                "Quisque id volutpat ligula. Nullam lectus.", LocalDateTime.now());
        newsRepository.save(news);
        Assertions.assertThat(news.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindAllNews() {
        News news01 = new News(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Praesent ut iaculis ipsum. Vestibulum vitae gravida felis. " +
                "In et elit non elit scelerisque suscipit. " +
                "Quisque id volutpat ligula. Nullam lectus.", LocalDateTime.now());
        News news02 = new News(2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Praesent ut iaculis ipsum. Vestibulum vitae gravida felis. " +
                "In et elit non elit scelerisque suscipit. " +
                "Quisque id volutpat ligula. Nullam lectus.", LocalDateTime.now());
        newsRepository.save(news01);
        newsRepository.save(news02);
        List<News> news = newsRepository.findAll();
        Assertions.assertThat(news).isNotNull();
        Assertions.assertThat(news).isNotEmpty();
    }

    @Test
    @Disabled
    public void testGetNewsTest() {
        News news01 = new News(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Praesent ut iaculis ipsum. Vestibulum vitae gravida felis. " +
                "In et elit non elit scelerisque suscipit. " +
                "Quisque id volutpat ligula. Nullam lectus.", LocalDateTime.now());
        newsRepository.save(news01);
        News news = newsRepository.findById(1).get();
        Assertions.assertThat(news.getId()).isEqualTo(1);
    }
}