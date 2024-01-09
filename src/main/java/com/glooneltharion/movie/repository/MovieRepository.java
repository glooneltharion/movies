package com.glooneltharion.movie.repository;


import com.glooneltharion.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByOrderById();

    List<Movie> findAllByOrderByDirectorDescTitleAsc();

    Page<Movie> findAllByOrderByDirectorDescTitleAsc(Pageable pageable);

    List<Movie> findAllByOrderByTitle();

    List<Movie> findAllByOrderByDirector();

    List<Movie> findAllByOrderByYear();

}
