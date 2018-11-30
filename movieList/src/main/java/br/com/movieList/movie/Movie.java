package br.com.movieList.movie;

public class Movie {

	private long id;
	private String name;
	private String watched;

	
	
	
	public String getName() {
		return name;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}



	public String getWatched() {
		return watched;
	}



	public void setWatched(String watched) {
		this.watched = watched;
	}
	
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", watched=" + watched + "]";
	}
	
}
