package com.benedict.SuperGroupAssessment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/movies")

public class MovieController {
	private List<Movie> movies = new ArrayList<>();

	MovieController() {
		this.movies = buildMovies();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> getMovies() {
		return this.movies;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Movie getMovie(@PathVariable("id") Long id) {
		return this.movies.stream().filter(movie -> movie.getId() == id).findFirst().orElse(null);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Movie saveMovie(@RequestBody Movie movie) {
		Long nextId = 0L;
		if (this.movies.size() != 0) {
			Movie lastMovie = this.movies.stream().skip(this.movies.size() - 1).findFirst().orElse(null);
			nextId = lastMovie.getId() + 1;
		}

		movie.setId(nextId);
		this.movies.add(movie);
		return movie;

	}

	@RequestMapping(method = RequestMethod.PUT)
	public Movie updateUser(@RequestBody Movie movie) {
		Movie modifiedMovie = this.movies.stream().filter(m -> m.getId() == movie.getId()).findFirst().orElse(null);
		modifiedMovie.setName(movie.getName());
		modifiedMovie.setGenre(movie.getGenre());
		modifiedMovie.setDirector(movie.getDirector());
		return modifiedMovie;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable Long id) {
		Movie deleteMovie = this.movies.stream().filter(movie -> movie.getId() == id).findFirst().orElse(null);
		if (deleteMovie != null) {
			this.movies.remove(deleteMovie);
			return true;
		} else {
			return false;
		}

	}

	List<Movie> buildMovies() {
		List<Movie> movies = new ArrayList<>();

		Movie movie1 = buildMovie(1L, "Suits", "Action", "Benedict");
		Movie movie2 = buildMovie(2L, "Transporter", "Action", "Mufaro");
		Movie movie3 = buildMovie(3L, "Two and half Man", "Commedy", "Charity");
		Movie movie4 = buildMovie(4L, "Blind Sport", "Crime", "Enock");
		Movie movie5 = buildMovie(5L, "Generations", "Series", "Blessing");

		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		movies.add(movie5);

		return movies;

	}

	Movie buildMovie(Long id, String name, String genre, String director) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setName(name);
		movie.setGenre(genre);
		movie.setDirector(director);
		return movie;
	}

}
