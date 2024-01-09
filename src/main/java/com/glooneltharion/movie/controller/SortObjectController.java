package com.glooneltharion.movie.controller;

import com.glooneltharion.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/object")
public class SortObjectController {
    private final MovieService movieService;

    private final int PAGE_SIZE = 3;

    @GetMapping({"/{parameter}"})
    public String sort(Model model,
                       @PathVariable (required = false) String parameter, @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        model.addAttribute("movies", movieService.findAllSortObject(parameter, pageable));
        model.addAttribute("page", page);
        return "index";
    }

}
