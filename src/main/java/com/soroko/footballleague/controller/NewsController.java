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
import org.springframework.web.bind.annotation.*;

/**
 * @author yuriy.soroko
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsController {
    final NewsService newsService;


    /**
     * Show all available news
     */
    @GetMapping("/news")
    public String getAllNews(Model model) {
        model.addAttribute("news", newsService.getAllNews());
        return "news";
    }

    /**
     * Return news by endpoint id
     */
    @GetMapping("/singlenews/{id}")
    public String getMatchById(@PathVariable int id, Model model) {
        News news = newsService.getNewsById(id);
        model.addAttribute("news_info", news);
        return "singlenews";
    }

    /**
     * Get register news form
     */
    @GetMapping("/addnews")
    public String showNews(News news) {
        return "addnews";
    }

    /**
     * Adding new news to database
     */
    @PostMapping("/addnews")
    public String addNews(@Valid News news, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Something went wrong while updating news {}", news);
            return "addnews";
        }
        newsService.addNews(news);
        log.info("Adding news {}", news);
        return "redirect:/news";
    }

    /**
     * Get edit form of the news by id
     */
    @GetMapping("singlenews/{id}/editnews")
    public String editNews(Model model, @PathVariable int id) {
        model.addAttribute("editNews", newsService.getNewsById(id));
        return "editnews";
    }

    /**
     * Edit data of existing news by id
     */
    @PostMapping("singlenews/{id}")
    public String updateNews(@ModelAttribute("singlenews") @Valid News news,
                             @PathVariable int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Something went wrong while updating news {}", news);
            return "editnews";
        }
        newsService.updateNews(id, news);
        log.info("Updating news {}", news);
        return "redirect:/news";
    }
}
