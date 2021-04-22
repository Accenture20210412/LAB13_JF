package lab13.hollywood.model;

public class Actor implements Comparable<Actor> {

	private Sex sex; // plec
	private String name; // imie i nazwisko

	public Actor(String name, Sex sex) {
		this.name = name;
		this.sex = sex;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Actor [%s, %s]", name, sex);
	}

	@Override
	public int compareTo(Actor a) {
		return name.compareTo(a.getName());
	}

}
