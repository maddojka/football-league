package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.News;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
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

}