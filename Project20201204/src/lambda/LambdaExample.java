package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class LambdaExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(//
				new Student("Hong", "MALE", 70), //
				new Student("Hwang", "FEMALE", 80), //
				new Student("Park", "MALE", 90), //
				new Student("Choi", "FEMALE", 85) //
		);

		// 1. 여학생정보: 이름 - 점수
		System.out.println("[여학생정보]");
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				System.out.println(student.getName() + "-" + student.getScore());
			}
		}

		System.out.println();
		System.out.println("[80점 초과]");

		// 2. 전체학생: 점수 80점 초과하는 학생
		for (Student student : list) {
			if (student.getScore() > 80) {
				System.out.println(student.getName() + "-" + student.getScore());
			}
		}

		System.out.println();
		System.out.println("[남학생 총점]");

		// 3. 남학생의 총점: 남학생총점: 160점 나오게
		int sum = 0;
		for (Student student : list) {
			if (student.getSex().equals("MALE")) {
				sum += student.getScore();
			}
		}
		System.out.println("남학생 총점: " + sum);

		System.out.println();
		System.out.println("[여학생평균]");

		// 4. 여학생의 평균: 여학생평균: 82.5점나오게
		sum = 0;
		int count = 0;
		double avg = 0;
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				count++;
				sum += student.getScore();

			}
		}
		avg = (double) sum / count;
		System.out.println("여학생 평점: " + avg);
		System.out.println();
		System.out.println("---------------");

		// 반복문 (반복자): 스트림(반복자)
		// 스트림 생성 -> 소진.

		// 1. 여학생정보
		System.out.println("[여학생정보]");
		Stream<Student> stream = list.stream();
		stream.filter((t) -> t.getSex().equals("FEMALE"))
				.forEach((t) -> System.out.println(t.getName() + "-" + t.getScore()));

		// 람다식 줄이기 전
		// Stream<Student>stream = list.stream();
		// stream.filter(new Predicate<Student>() {
		//
		// @Override
		// public boolean test(Student t) {
		// return t.getSex().equals("FEMALE");
		// }
		//
		// }).forEach(new Consumer<Student>() {
		// @Override
		// public void accept(Student t) {
		// System.out.println(t.getName()+"-"+t.getScore());
		// }
		//
		// });
		System.out.println();

		// 2.80점 초과
		// 스트림은 흘려보내고 나면 새롭게 만들어야함
		System.out.println("[80점 초과]");
		stream = list.stream();
		stream.filter((t) -> t.getScore() > 80)//
				.forEach((t) -> System.out.println(t.getName() + t.getScore()));

		// 람다식 줄이기 전
//		stream = list.stream();
//		stream.filter(new Predicate<Student>() {
//
//			@Override
//			public boolean test(Student t) {
//				return t.getScore() > 80;
//			}
//		}).forEach(new Consumer<Student>() {
//
//			@Override
//			public void accept(Student t) {
//				System.out.println(t.getName() + t.getScore());
//			}
//
//		});
		System.out.println();

		// 3. 남학생 총점
		System.out.println("[남학생 총점]");
		int sum1 = list.stream().filter(t -> t.getSex().equals("MALE"))//
				.mapToInt((value) -> value.getScore())//
				.sum();
		System.out.println("총점: " +sum1);

//		int sum1 = list.stream().filter(t -> t.getSex().equals("MALE"))//
//				.mapToInt(new ToIntFunction<Student>() {
//
//					@Override
//					public int applyAsInt(Student value) {
//						return value.getScore();
//					}
//				}).sum();
		
		
		System.out.println();
		System.out.println("[여학생 평균]");
		list.stream().filter(t->t.getSex().equals("FEMALE"))//
		.mapToInt(s -> s.getScore())//
		.average()//
		.getAsDouble();;
		System.out.println("평균: " +avg);
		
		
		

	}
}
