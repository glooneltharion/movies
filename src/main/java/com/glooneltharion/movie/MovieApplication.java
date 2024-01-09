package com.glooneltharion.movie;

import com.glooneltharion.movie.model.Movie;
import com.glooneltharion.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class MovieApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }


    private static List<Movie> movies = List.of(
            new Movie("Eternal Sunshine of the Spotless Mind", "Michel Gondry", 2004),
            new Movie("Requiem for a Dream", "Darren Aronofsky", 2000),
            new Movie("Corpse Bride", "Tim Burton", 2005),
            new Movie("Memento", "Christopher Nolan", 2000),
            new Movie("Donnie Darko", "Richard Kelly", 2001),
            new Movie("Equilibrium", "Kurt Wimmer", 2002),
            new Movie("Little Miss Sunshine", "Jonathan Dayton & Valerie Faris", 2006),
            new Movie("Veronika Decides to Die", "Emily Young", 2009),
            new Movie("A Clockwork Orange", "Stanley Kubrick", 1971),
            new Movie("The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", 2001),
            new Movie("The Lord of the Rings: The Two Towers", "Peter Jackson", 2002),
            new Movie("The Lord of the Rings: The Return of the King", "Peter Jackson", 2003),
            new Movie("Enter the Void", "Gaspar Noé", 2009),
            new Movie("Fight Club", "David Fincher", 1999),
            new Movie("The Shining", "Stanley Kubrick", 1980),
            new Movie("Trainspotting", "Danny Boyle", 1996),
            new Movie("Tucker and Dale vs Evil", "Eli Craig", 2010),
            new Movie("Se7en", "David Fincher", 1995)
    );

    private final MovieRepository movieRepository;


    @Override
    public void run(String... args) throws Exception {


        for (Movie movie : movies) {
            //System.out.println(movie.getTitle());
            movieRepository.save(movie);
        }

        //OFFSET- n of elements before
        //PAGE = OFFSET / PAGESIZE



        Pageable pageable = PageRequest.ofSize(3);
        Page<Movie> page;
        do {

            page = movieRepository.findAll(pageable);

            System.out.println(page.getSize());

            for (Movie movie : page) {
                System.out.printf("Page number is: %d/%d, Offset id %d/%d, Page size is %d - Todo id - %d, title - %s%n",
                        pageable.getPageNumber(),
                        page.getTotalPages(),
                        pageable.getOffset(),
                        page.getTotalElements(),
                        pageable.getPageSize(),
                        movie.getId(),
                        movie.getTitle());
            }

            pageable = pageable.next();

        } while (page.getTotalPages() > pageable.getPageNumber());

    }
}

