package com.glooneltharion.movie.service;

import com.glooneltharion.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Page<Movie> findAll(Pageable pageable);
    Page<Movie> findAllSortStream(Pageable pageable);

    List<Movie> findAllSortQuery();

    Page<Movie> findAllSortQuery( Pageable pageable);

    Page<Movie> findAllSortObject(Pageable pageable);

    Page<Movie> findAllSortByTitle(Pageable pageable);

    Page<Movie> findAllSortByDirector(Pageable pageable);

    Page<Movie> findAllBySortByYear(Pageable pageable);

    Page<Movie>  findAllSortObject(String parameter, Pageable pageable);
}
