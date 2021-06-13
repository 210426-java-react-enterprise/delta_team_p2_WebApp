package com.revature.WebApp.DTO;

import com.revature.WebApp.entities.MovieDetailsEntity;

public class WatchListDTO {
    private String fk_movie_id;
    private String movieTitle;
    private String posterURL;

    public WatchListDTO(){

    }

    public WatchListDTO(MovieDetailsEntity movie){
        this.fk_movie_id = movie.getImdbId();
        this.movieTitle = movie.getTitle();
        this.posterURL = movie.getPoster();
    }

    public String getFk_movie_id() {
        return fk_movie_id;
    }

    public void setFk_movie_id(String fk_movie_id) {
        this.fk_movie_id = fk_movie_id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }
}
