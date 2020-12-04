package lambda; //stream이 없으면 이렇게 써야한다는 걸 보여주기위한 클래스

public class Student {
	private String name;
	private String sex;
	private int score;

	public Student(String name, String sex, int score) {
		super();
		this.name = name;
		this.sex = sex;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public int getScore() {
		return score;
	}

}
