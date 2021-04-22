package lab13.hollywood;


import lab13.hollywood.model.Actor;
import lab13.hollywood.model.Movie;
import lab13.hollywood.model.Sex;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Controller {



    public List<Actor> getMaleActors() {
        List<Actor> activMaleActors = Provider.getMovies()
                .stream()
                .map(Movie::getCast)
                .flatMap(Collection::stream)
                .distinct()
                .filter(a -> a.getSex().equals(Sex.M))
                .collect(Collectors.toList());
        return activMaleActors;
    }
    public void printAndCoutActiveMaleActors(){
        System.out.println("Male active actors list: ");
        List<Actor> actors = getMaleActors();
        actors.forEach(System.out::println);
        System.out.println("Count : " + actors.stream().count());
    }

    public List<Actor> getActresfromMovie(int movieNumber) {
        List<Actor> actors = Provider.getMovies()
                .stream()
                .filter(m -> m.getNr() == movieNumber)
                .map(Movie::getCast)
                .flatMap(Collection::stream)
                .filter(a -> a.getSex().equals(Sex.F))
                .sorted()
                .collect(Collectors.toList());
        return actors;
    }

    public String getMovieTitleDirectedBy (String director, int movieNumber) {
        if(movieNumber < 0) {
            System.out.println("Movie number can't be less than 1");
            return null;
        }
        List<Movie> allMatches = getMovies(director);
        if ( allMatches.isEmpty()
                || movieNumber-- > allMatches.size()) {
            System.out.println("No matches!");
            return null;
        }
        return allMatches.get(movieNumber ).getTitle();
    }

    private List<Movie> getMovies(String director) {
        List<Movie> allMatches = Provider.getMovies()
                .stream()
                .filter(d -> d.getDirector().equals(director))
                .collect(Collectors.toList());
        return allMatches;
    }

    public List<Movie> getMoviesWithMaleCast() {
        List<Movie> maleMovies = Provider.getMovies()
                .stream()
                .filter(m -> m.getCast().stream()
                        .noneMatch(a -> a.getSex().equals(Sex.F)))
                .collect(Collectors.toList());
            return maleMovies;
    }


}
