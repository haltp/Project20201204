package stream;

public class Student implements Comparable<Student> {
	private String name;
	private int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

//	return 0; //0이라는 값은 같다라는 의미
	//오름차순 -1, 같다: 0, 내림차순: 1
	//오름차순: 음수, 같다:0, 내림차순:양수
	@Override
	public int compareTo(Student o) {
		return this.score - o.score; //음수 되어서 오름차순 된다
//		return o.score - this.score; //양수 되어서 내림차순 된다.
	}

}
