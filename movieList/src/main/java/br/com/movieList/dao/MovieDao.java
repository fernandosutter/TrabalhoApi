package br.com.movieList.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.movieList.movie.Movie;

public class MovieDao {

	public List<Movie> getAll(){
		
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try{
			 Connection conn = (new ConnectionFactory()).getConnection();
			PreparedStatement stmt = conn.prepareStatement("select id_movies, movie_name, is_watched from movies ");
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
				Movie movie = new Movie();
				movie.setId(resultSet.getLong(1));
				movie.setName(resultSet.getString(2));
				movie.setWatched(resultSet.getString(3));
				
				movies.add(movie);
			}
		}catch (Exception e) {
			e.printStackTrace();
            throw new RuntimeException();
        }
		return movies;
	}
	
	
	public void insertMovie(Movie movie) {
        try {
           
        	// Cria a conexãoo com o banco de dados
            MovieDao moviedDAO = new MovieDao();
             Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("insert into movies(movie_name, is_watched) values(?, ?) ");
            p.setString(1, movie.getName());
            p.setString(2, movie.getWatched());
            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
}
	}
	
	public void updateMovie (Movie movie) {
        try {
            // Cria a conexão com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("update movies set movie_name = ?, is_watched = ? where id_movies = ?");

            p.setString(1, movie.getName());
            p.setString(2, movie.getWatched());
            p.setLong(3, movie.getId());
            

            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

	 public void deleteMovie(long aux) {
	        try {
	            // Cria a conexão com o banco de dados
	            Connection conn = (new ConnectionFactory()).getConnection();
	            PreparedStatement p =
	                    conn.prepareStatement("delete from movies where id_movies  = ?");

	            p.setLong(1, aux);
	            p.execute();
	            p.close();
	            conn.close();
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	    }

	 
	 public Movie selectMovie(long id) {
	        Movie movie = null ;
	        try {
	            // Cria a conexão com o banco de dados
	            Connection conn = (new ConnectionFactory()).getConnection();

	            PreparedStatement p = conn.prepareStatement("select id_movies, movie_name, is_watched from movies where id_movies = ? ");
	            p.setLong(1, id);

	            ResultSet rs = p.executeQuery();
	            if (rs.next()){
	            	movie = new Movie();
	            	movie.setId(rs.getLong(1));
	            	movie.setName(rs.getString(2));
	            	movie.setWatched(rs.getString(3));
	            
	            }
	            p.close();
	            // Fecha conexão com o banco de dados
	            conn.close();
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	        return movie;
	    }
	 
}

