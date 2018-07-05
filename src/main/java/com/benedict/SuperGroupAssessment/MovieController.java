package com.benedict.SuperGroupAssessment;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MovieController {

	@Autowired
	MovieRepository movieRepository;

	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@PostMapping("/movies")
	public Movie createMovie(@Valid @RequestBody Movie movie) {
		return movieRepository.save(movie);
	}

	@PutMapping("/movies/{id}")
	public Movie updateNote(@PathVariable(value = "id") Long movieId, @Valid @RequestBody Movie movieDetails) {

		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

		movie.setName(movieDetails.getName());
		movie.setGenre(movieDetails.getGenre());
		movie.setDirector(movieDetails.getDirector());

		Movie updatedMovie = movieRepository.save(movie);
		return updatedMovie;
	}

	@DeleteMapping("/movies/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable(value = "id") Long movieId) {
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

		movieRepository.delete(movie);

		return ResponseEntity.ok().build();
	}

}
