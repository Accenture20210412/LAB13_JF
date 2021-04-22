package lab13.hollywood.model;

import java.util.Arrays;
import java.util.List;

public class Movie {

	private int nr; // numer filmu
	private String title; // tytul
	private String director; // rezyser
	private List<Actor> cast; // obsada

	public Movie(int nr, String title, String director) {
		this.nr = nr;
		this.title = title;
		this.director = director;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(Actor... actors) {
		this.cast = Arrays.asList(actors);
	}

	@Override
	public String toString() {
		return String.format("%nMovie [\tnr=%d, title='%s', director=%s,%n\tcast=%s]",
		        nr, title, director, cast);
	}

}
