package com.soroko.footballleague.controller;

import com.soroko.footballleague.entity.News;
import com.soroko.footballleague.service.NewsService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author yuriy.soroko
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsController {

    final NewsService newsService;

    @GetMapping("/news")
    public String getAllNews(Model model) {
        model.addAttribute("news", newsService.getAllNews());
        return "news";
    }

    @GetMapping("singlenews/{id}")
    public String getMatchById(@PathVariable int id, Model model) {
        News news = newsService.getNewsById(id);
        model.addAttribute("news_info", news);
        return "singlenews";
    }

    @GetMapping("/addnews")
    public String showNews(News news) {
        return "addnews";
    }

    @PostMapping("/addnews")
    public String addNews(@Valid News news, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "addnews";
        newsService.addNews(news);
        log.info("Adding news {}", news);
        return "redirect:/news";
    }
}
