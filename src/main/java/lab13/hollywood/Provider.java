package lab13.hollywood;

import pl.altkom.hollywood.model.Actor;
import pl.altkom.hollywood.model.Movie;
import pl.altkom.hollywood.model.Sex;

import java.util.Arrays;
import java.util.List;

//klasa pomocnicza dostarczajaca kolekcje kilku filmow
public class Provider {

	private static List<Actor> actors;
	private static List<Movie> movies;

	static {
		Actor depp = new Actor("Johnny Depp", Sex.M);
		Actor rush = new Actor("Geoffrey Rush", Sex.M);
		Actor bloom = new Actor("Orlando Bloom", Sex.M);
		Actor knightley = new Actor("Keira Knightley", Sex.F);
		Actor gibson = new Actor("Mel Gibson", Sex.M);
		Actor hunt = new Actor("Helen Hunt", Sex.F);
		Actor tomei = new Actor("Marisa Tomei", Sex.F);
		Actor grant = new Actor("Hugh Grant", Sex.M);
		Actor neeson = new Actor("Liam Neeson", Sex.M);
		Actor firth = new Actor("Colin Firth", Sex.M);
		Actor linney = new Actor("Laura Linney", Sex.F);
		Actor thompson = new Actor("Emma Thompson", Sex.F);
		Actor rickman = new Actor("Alan Rickman", Sex.M);
		Actor mccutcheon = new Actor("Martine McCutcheon", Sex.F);
		Actor nighy = new Actor("Bill Nighy", Sex.M);
		Actor atkinson = new Actor("Rowan Atkinson", Sex.M);
		Actor nicholson = new Actor("Jack Nicholson", Sex.M);
		Actor keaton = new Actor("Diane Keaton", Sex.F);
		Actor reeves = new Actor("Keanu Reeves", Sex.M);
		Actor peet = new Actor("Amanda Peet", Sex.F);
		actors = Arrays.asList(depp, rush, bloom, knightley, gibson, hunt, tomei, grant, neeson,
		        firth, linney, thompson, rickman, mccutcheon, nicholson, atkinson, nicholson, keaton,
		        reeves, peet);

		Movie movie1 = new Movie(1, "Piraci z Karaibow", "Gore Verbinski");
		movie1.setCast(depp, rush, bloom, knightley);

		Movie movie2 = new Movie(2, "Czego pragna kobiety", "Nancy Meyers");
		movie2.setCast(gibson, hunt, tomei);

		Movie movie3 = new Movie(3, "To wlasnie milosc", "Richard Curtis");
		movie3.setCast(grant, neeson, firth, linney, thompson, rickman,
		        knightley, mccutcheon, nighy, atkinson);

		Movie movie4 = new Movie(4, "Lepiej pozno niz pozniej", "Nancy Meyers");
		movie4.setCast(nicholson, keaton, reeves, peet);

		Movie movie5 = new Movie(5, "Pirates of the Carribean", "Gore Verbinski");
		movie5.setCast(depp, rush, bloom, knightley);

		Movie movie6 = new Movie(6, "Sami faceci", "Alan W.");
		movie6.setCast(depp, rush, bloom);
		movies = Arrays.asList(movie1, movie2, movie3, movie4, movie5, movie6);
	}

	public static List<Actor> getActors() {
		return actors;
	}

	public static List<Movie> getMovies() {
		return movies;
	}

}
