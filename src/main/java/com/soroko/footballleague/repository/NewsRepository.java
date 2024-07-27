package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
}
