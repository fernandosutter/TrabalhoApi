package br.com.movieList.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.movieList.movie.Movie;

public class MovieDao {
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
	
	public void updateUser (Movie movie) {
        try {
            // Cria a conexão com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("update movies set movies_name = ?, is_watched = ? where id_movies = ?");

            p.setString(1, movie.getName());
            p.setString(1, movie.getWatched());
            p.setLong(3, movie.getId());
            

            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }


	
}

