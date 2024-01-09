package com.glooneltharion.movie.controller;

import com.glooneltharion.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/query")
public class SortQueryController {

    private final MovieService movieService;

    private final int PAGE_SIZE = 3;

    @GetMapping({"/title"})
    public String sortQueryTitle(Model model ,@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        model.addAttribute("movies", movieService.findAllSortByTitle(pageable));
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping({"/director"})
    public String sortQueryDirector(Model model,  @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        model.addAttribute("movies", movieService.findAllSortByDirector(pageable));
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping({"/year"})
    public String sortQueryYear(Model model,  @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        model.addAttribute("movies", movieService.findAllBySortByYear(pageable));
        model.addAttribute("page", page);
        return "index";
    }
}
