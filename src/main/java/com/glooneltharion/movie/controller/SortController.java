package com.glooneltharion.movie.controller;

import com.glooneltharion.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class SortController {

    private final MovieService movieService;

    private final int PAGE_SIZE = 3;


    @GetMapping({"/stream"})
    public String sortStream(Model model,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        model.addAttribute("movies", movieService.findAllSortStream(pageable));
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping({"/query"})
    public String homePage(Model model,
                           @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        model.addAttribute("movies", movieService.findAllSortQuery(pageable));
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping({"/object"})
    public String sort(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        model.addAttribute("movies", movieService.findAllSortObject(pageable));
        model.addAttribute("page", page);
        return "index";
    }
}
