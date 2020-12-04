package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {
//		String[] strs = "Java8 lambda".split(" "); //공란을 기준으로 나누어 배열을 만들겠다
//		String[] str = "Java8-lambda-Hello".split("-"); //'-'을 기준으로 나누어 배열을 만들겠다
		
		List<String> strList = Arrays.asList("Java8 lambda", "stream mapping");
		strList.stream().flatMap((t) -> Arrays.stream(t.split(" ")))//
		.filter(s -> s.startsWith("l"))
		.forEach(s -> System.out.println(s)); 
		
		//람다식 줄이기 전
//		List<String> strList = Arrays.asList("Java8 lambda", "stream mapping");
//		strList.stream().flatMap(new Function<String, Stream<String>>() {
//
//			@Override
//			public Stream<String> apply(String t) {
//				return Arrays.stream(t.split(" ")); //t.split(" ")은 배열이 된다
//			}
//			
//		}).filter(s -> s.startsWith("l"))//문자열이 l로 시작하는 것
//		.forEach(s -> System.out.println(s)); //s를 출력하겠다
		
		strList.stream()//
		.map((t) ->t.toUpperCase())//
		.forEach(s -> System.out.println(s));
		
		//람다식 줄이기 전
//		strList.stream()//
//		.map(new Function<String, String> (){
//
//			@Override
//			public String apply(String t) {
//				return t.toUpperCase();
//			}
//		}).forEach(s -> System.out.println(s));
		
		System.out.println("-----------------------------");
		
		List<Student> students = Arrays.asList(
				new Student("송다희", "F", 80),//
				new Student("윤태현", "M", 75),//
				new Student("이혜빈", "F", 85),//
				new Student("정병기", "M", 90));
		double avg = students.stream().mapToInt(new ToIntFunction<Student>() {

			@Override
			public int applyAsInt(Student s) {
				System.out.println(s.getName()+"-"+s.getScore());
				return s.getScore();
			}
			
		}).average().getAsDouble();
		System.out.println(avg);
		
		
		
		
		
		
	}
}
