package com.soroko.footballleague.repository;

import com.soroko.footballleague.entity.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer> {
}
