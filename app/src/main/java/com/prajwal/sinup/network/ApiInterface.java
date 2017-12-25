package com.prajwal.sinup.network;


import com.prajwal.sinup.network.movies.GenresList;
import com.prajwal.sinup.network.movies.Movie;
import com.prajwal.sinup.network.movies.MovieCastsOfPersonResponse;
import com.prajwal.sinup.network.movies.MovieCreditsResponse;
import com.prajwal.sinup.network.movies.NowShowingMoviesResponse;
import com.prajwal.sinup.network.movies.PopularMoviesResponse;
import com.prajwal.sinup.network.movies.SimilarMoviesResponse;
import com.prajwal.sinup.network.movies.TopRatedMoviesResponse;
import com.prajwal.sinup.network.movies.UpcomingMoviesResponse;
import com.prajwal.sinup.network.people.Person;
import com.prajwal.sinup.network.tvshows.AiringTodayTVShowsResponse;
import com.prajwal.sinup.network.tvshows.OnTheAirTVShowsResponse;
import com.prajwal.sinup.network.tvshows.PopularTVShowsResponse;
import com.prajwal.sinup.network.tvshows.SimilarTVShowsResponse;
import com.prajwal.sinup.network.tvshows.TVCastsOfPersonResponse;
import com.prajwal.sinup.network.tvshows.TVShow;
import com.prajwal.sinup.network.tvshows.TVShowCreditsResponse;
import com.prajwal.sinup.network.tvshows.TopRatedTVShowsResponse;
import com.prajwal.sinup.network.videos.VideosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hitanshu on 27/7/17.
 */

public interface ApiInterface {

    //MOVIES

    @GET("movie/now_playing")
    Call<NowShowingMoviesResponse> getNowShowingMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/popular")
    Call<PopularMoviesResponse> getPopularMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/upcoming")
    Call<UpcomingMoviesResponse> getUpcomingMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/top_rated")
    Call<TopRatedMoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/{id}")
    Call<Movie> getMovieDetails(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Call<VideosResponse> getMovieVideos(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/credits")
    Call<MovieCreditsResponse> getMovieCredits(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/similar")
    Call<SimilarMoviesResponse> getSimilarMovies(@Path("id") Integer movieId, @Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("genre/movie/list")
    Call<GenresList> getMovieGenresList(@Query("api_key") String apiKey);

    //TV SHOWS

    @GET("tv/airing_today")
    Call<AiringTodayTVShowsResponse> getAiringTodayTVShows(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/on_the_air")
    Call<OnTheAirTVShowsResponse> getOnTheAirTVShows(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/popular")
    Call<PopularTVShowsResponse> getPopularTVShows(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/top_rated")
    Call<TopRatedTVShowsResponse> getTopRatedTVShows(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/{id}")
    Call<TVShow> getTVShowDetails(@Path("id") Integer tvShowId, @Query("api_key") String apiKey);

    @GET("tv/{id}/videos")
    Call<VideosResponse> getTVShowVideos(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("tv/{id}/credits")
    Call<TVShowCreditsResponse> getTVShowCredits(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("tv/{id}/similar")
    Call<SimilarTVShowsResponse> getSimilarTVShows(@Path("id") Integer movieId, @Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("genre/tv/list")
    Call<GenresList> getTVShowGenresList(@Query("api_key") String apiKey);

    //PERSON

    @GET("person/{id}")
    Call<Person> getPersonDetails(@Path("id") Integer personId, @Query("api_key") String apiKey);

    @GET("person/{id}/movie_credits")
    Call<MovieCastsOfPersonResponse> getMovieCastsOfPerson(@Path("id") Integer personId, @Query("api_key") String apiKey);

    @GET("person/{id}/tv_credits")
    Call<TVCastsOfPersonResponse> getTVCastsOfPerson(@Path("id") Integer personId, @Query("api_key") String apiKey);

}
