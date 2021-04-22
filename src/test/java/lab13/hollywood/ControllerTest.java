package lab13.hollywood;


import lab13.hollywood.model.Actor;
import lab13.hollywood.model.Movie;
import lab13.hollywood.model.Sex;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
class ControllerTest {

    private Controller controller = new Controller();

    @Test
    public void shouldReturnActiveMaleActors() {
        controller.printAndCountActiveMaleActors();
    }

    @Test
    public void shouldReturnActressFromMovie3() {
        controller.getActressesFromMovie(3)
                .forEach(System.out::println);
    }

    @Test
    public void shouldReturnCorrectTitle() {
        String title1 = controller.getMovieTitleDirectedBy(
                "Nancy Meyers", 1);
        String title2 = controller.getMovieTitleDirectedBy(
                "Nancy Meyers", 2);
        String title3 = controller.getMovieTitleDirectedBy(
                "Nancy Meyers", 3);
        assertEquals("Czego pragna kobiety", title1);
        assertEquals("Lepiej pozno niz pozniej", title2);
        assertEquals(null, title3);
    }

    @Test
    public void shouldGetMaleMovies() {
        List<Movie> movies = controller.getMoviesWithMaleCast();
        movies.forEach(System.out::println);
        assertEquals(movies.size(), 1);
    }

    @Test
    public void shouldReturnNamesStartsWithKandJ() {
        List<Actor> actors = controller.getActortsStartsWithJandK();
        actors.forEach(System.out::println);
        System.out.println(actors.size());
        assertEquals(actors.size(), 5);
    }

    @Test
    public void shouldReturnMap() {
        Map<Sex, List<Actor>> actrosMap = controller.getMapStartsWithJandK();
        actrosMap.values().forEach(System.out::println);

    }


}