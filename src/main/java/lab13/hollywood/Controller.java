package lab13.hollywood;


import lab13.hollywood.model.Actor;
import lab13.hollywood.model.Movie;
import lab13.hollywood.model.Sex;

import java.util.*;
import java.util.stream.Collectors;


public class Controller {



    public List<Actor> getMaleActors() {
        List<Actor> activeMaleActors = Provider.getMovies()
                .stream()
                .map(Movie::getCast)
                .flatMap(Collection::stream)
                .distinct()
                .filter(a -> a.getSex().equals(Sex.M))
                .collect(Collectors.toList());
        return activeMaleActors;
    }
    public void printAndCountActiveMaleActors(){
        System.out.println("Male active actors list: ");
        List<Actor> actors = getMaleActors();
        actors.forEach(System.out::println);
        System.out.println("Count : " + actors.stream().count());
    }

    public List<Actor> getActressesFromMovie(int movieNumber) {
        List<Actor> actors = Provider.getMovies()
                .stream()
                .filter(m -> m.getNr() == movieNumber)
                .map(Movie::getCast)
                .flatMap(Collection::stream)
                .filter(a -> a.getSex().equals(Sex.F))
                .sorted(Comparator.comparing((Actor a) -> a.getName()
                        .split(" ")[1]))
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

    public List<Actor> getActortsStartsWithJandK() {
        List<Actor> actorList = Provider.getActors().stream()
                .filter(n -> n.getName().startsWith("J") || n.getName().startsWith("K"))
                .sorted(Comparator.comparing(
                        (Actor a) -> a.getSex().toString()))
                .collect(Collectors.toList());
        return actorList;
    }

    public Map<Sex, List<Actor>> getMapStartsWithJandK() {
        Map<Sex, List<Actor>> mapActors = new HashMap<>();
        List<Actor> females = getSexActor(Sex.F);
        List<Actor> males = getSexActor(Sex.M);
        mapActors.put(Sex.F, females);
        mapActors.put(Sex.M, males);
        return mapActors;
    }

    private List<Actor> getSexActor(Sex sex) {
        return getActortsStartsWithJandK().stream()
                .filter(a -> a.getSex().equals(sex))
                .sorted(Comparator.comparing(
                        (Actor a) -> a.getName().split(" ")[1]))
                .collect(Collectors.toList());
    }


}
