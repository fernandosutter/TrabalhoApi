package br.com.movieList.controller;

@Controller
public class MovieController {
	
	@ResponseBody
	@RequestMapping(value = "/movie",method = GET, produces = "application/json")
	public List<Movie> getAll() {
		MovieDAO dao = new MovieDAO();
		
		return dao.getAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/movie/{id}",method = GET, produces = "application/json")
	public ResponseEntity<?> get(@PathVariable int id) {
		MovieDAO dao = new MovieDAO();
		
		Movie p = dao.get(id);
		if(p == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(p);
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/movie",method = POST, produces = "application/json")
	public ResponseEntity<?> add(@RequestBody Movie movie) {
		MovieDAO dao = new MovieDAO();
		dao.insert(movie);
		return  ResponseEntity.ok().build();
	
	}
	
	@ResponseBody
	@RequestMapping(value = "/Movie/{id}",method = DELETE, produces = "application/json")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		MovieDAO dao = new MovieDAO();
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
