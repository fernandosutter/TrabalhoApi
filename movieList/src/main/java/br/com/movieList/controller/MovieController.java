package br.com.movieList.controller;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.movieList.dao.MovieDao;
import br.com.movieList.movie.Movie;

@Controller
public class MovieController {
	
	@ResponseBody
	@RequestMapping(value = "/movie",method = GET, produces = "application/json")
	public List<Movie> getAll() {
		MovieDao dao = new MovieDao();
		
		return MovieDao.getAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/movie/{id}",method = GET, produces = "application/json")
	public ResponseEntity<?> get(@PathVariable int id) {
		MovieDao dao = new MovieDao();
		
		Movie p = dao.get(id);
		if(p == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(p);
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/movie",method = POST, produces = "application/json")
	public ResponseEntity<?> add(@RequestBody Movie movie) {
		MovieDao dao = new MovieDao();
		dao.insert(movie);
		return  ResponseEntity.ok().build();
	
	}
	
	@ResponseBody
	@RequestMapping(value = "/Movie/{id}",method = DELETE, produces = "application/json")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		MovieDao dao = new MovieDao();
		try {
			dao.deleteById(id);
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@ResponseBody
	@RequestMapping(value = "/movie/{id}",method = PUT, produces = "application/json")
	public ResponseEntity<?> putMovie(@PathVariable int id,@RequestBody  Movie movie) {
		MovieDAO dao = new MovieDAO();
		try {
			System.out.println(movie);
			movie.setId(id);
			dao.putByMovie(movie);
		}catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}

}
