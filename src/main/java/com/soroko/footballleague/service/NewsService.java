package com.soroko.footballleague.service;

import com.soroko.footballleague.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

}
