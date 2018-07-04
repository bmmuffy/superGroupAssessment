package com.benedict.SuperGroupAssessment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperGroupAssessmentApplicationTests {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	private MockMvc mockMvc;
	private final String MOVIE_REQUEST = "{\n\t\"name\": \"Suits\",\n\t\"genre\": \"Series\",\n\t\"director\": \"quantity\"}\n\t]\n}";
	@Autowired
	private MovieController movieController;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
	}

	@Test
	public void shouldAddMovie() throws Exception {
		this.mockMvc.perform(post("/movies").content(MOVIE_REQUEST).contentType(APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());

	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldReturnBadRequest() throws Exception {
		this.mockMvc.perform(post("/movies").contentType(APPLICATION_JSON_UTF8)).andExpect(status().is(400));

	}

	@Test
	public void shouldListMovies() throws Exception {
		this.mockMvc.perform(get("/movies").contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk());

	}

	@Test
	public void shouldReturnNotFound() throws Exception {
		this.mockMvc.perform(get("/mov").contentType(APPLICATION_JSON_UTF8)).andExpect(status().is(404));

	}

}
