package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(//
				new Student("Hong", 80), //
				new Student("Hwang", 90), //
				new Student("Park", 87)//
		);

//		list.stream().filter(s -> s.getScore()/10 == 8)//
//		.forEach(s -> System.out.println(s.getName()+","+s.getScore()));

		// sorted
//		List<Student> student80s = list.stream().filter(s -> s.getScore() / 10 == 8)//
//				.sorted()//
//				.collect(Collectors.toList());
//		for (Student student : student80s) {
//			System.out.println("이름: " + student.getName() + " / 점수: " + student.getScore());
//		}

		//
		list.stream().filter(s -> s.getScore() / 10 == 8)//
				.sorted()//
				.collect(Collectors.toMap(new Function<Student, String>() {

					@Override
					public String apply(Student t) {
						return t.getName();
					}
				}, new Function<Student, Integer>() {

					@Override
					public Integer apply(Student t) {
						return t.getScore();
					}
				}));
		System.out.println("=================");
		//위의것을 람다식 줄인 것
		list.stream().filter(s -> s.getScore() / 10 == 8)//
				.sorted()//
				.collect(Collectors.toMap(//
						(t) -> t.getName(), //
						(t) -> t.getScore()//
						)//
				);
		
		System.out.println("=================");
		Map<String, Integer> map = list.stream().filter(s -> s.getScore() / 10 == 8)//
		.sorted()//
		.collect(Collectors.toMap(//
				(t) -> t.getName(), //
				(t) -> t.getScore()//
				)//
		);
		System.out.println("=================");
		Set<String> set = map.keySet();
		for(String key : set) {
			System.out.println("Key: " + key+", Val: "+ map.get(key));
		}
	}
}
