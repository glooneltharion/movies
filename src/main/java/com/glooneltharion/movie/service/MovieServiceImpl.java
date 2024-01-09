package com.glooneltharion.movie.service;

import com.glooneltharion.movie.model.Movie;
import com.glooneltharion.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAllByOrderById();
    }

    @Override
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }


    //Sort by Director Desc and by Title Asc Stream
    @Override
    public Page<Movie> findAllSortStream(Pageable pageable) {
        return convertListToPage(sortByDirectorDesc(sortByTitleAsc(movieRepository.findAll())), pageable);
    }

    //Sort by Director Desc and by Title Asc Query

    @Override
    public List<Movie> findAllSortQuery() {
        return movieRepository.findAllByOrderByDirectorDescTitleAsc();
    }

    @Override
    public Page<Movie> findAllSortQuery(Pageable pageable) {
        return movieRepository.findAllByOrderByDirectorDescTitleAsc(pageable);
    }

    //Sort by Director Desc and by Title Asc Sort Object extended from JPA Repo

    public Page<Movie> findAllSortObject(Pageable pageable) {
        return convertListToPage(movieRepository.findAll(
                Sort.by("director").descending()
                        .and(Sort.by("title"))
        ), pageable);
    }

    @Override
    public Page<Movie> findAllSortObject(String parameter, Pageable pageable) {
        return convertListToPage(movieRepository.findAll(
                Sort.by(parameter)
        ), pageable);
    }


    @Override
    public Page<Movie> findAllSortByTitle(Pageable pageable) {
        return convertListToPage(movieRepository.findAllByOrderByTitle(), pageable);
    }

    @Override
    public Page<Movie> findAllSortByDirector(Pageable pageable) {
        return convertListToPage(movieRepository.findAllByOrderByDirector(), pageable);
    }

    @Override
    public Page<Movie> findAllBySortByYear(Pageable pageable) {
        return convertListToPage(movieRepository.findAllByOrderByYear(), pageable);
    }



    private List<Movie> sortByTitleAsc(List<Movie> movies) {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .collect(Collectors.toList());
    }

    private List<Movie> sortByDirectorDesc(List<Movie> movies) {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getDirector).reversed())
                .collect(Collectors.toList());
    }

    private Page<Movie> convertListToPage(List<Movie> movieList, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), movieList.size());

        return new PageImpl<>(movieList.subList(start, end), pageable, movieList.size());
    }
}

