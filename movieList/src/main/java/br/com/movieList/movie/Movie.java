package br.com.movieList.movie;

public class Movie {

	private long id;
	private String name;
	private boolean watched;
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
	public boolean isWatched() {
		return watched;
	}
	public void setWatched(boolean watched) {
		this.watched = watched;
	}
	
}
