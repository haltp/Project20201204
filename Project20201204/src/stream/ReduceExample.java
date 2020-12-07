package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class ReduceExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(//
				new Student("Hong", 80), //
				new Student("Hong", 90), //
				new Student("Hong", 87)//
		);
		int sum = list.stream().mapToInt(new ToIntFunction<Student>() {

			@Override
			public int applyAsInt(Student v) {
				return v.getScore();
			}

		}).sum();
		System.out.println(sum);

		// reduce
		int result = list.stream().mapToInt(t -> t.getScore())//
				.reduce(new IntBinaryOperator() {

					@Override
					public int applyAsInt(int left, int right) {
						System.out.println("left: " + left + " right: " + right);
						return left + right;
					}
				}).getAsInt();
		System.out.println(result);

		System.out.println("=====================");
		result = list.stream().mapToInt(t -> t.getScore())//
				.reduce(0, (left, right) -> left + right);
		System.out.println(result);

		// 람다식 줄이기 전
//		result = list.stream().mapToInt(t -> t.getScore())//
//				.reduce(0, new IntBinaryOperator() {
//
//					@Override
//					public int applyAsInt(int left, int right) {
//						System.out.println("left: " + left + " right: " + right);
//						return left + right;
//					}
//				});
//		System.out.println(result);

		System.out.println("=====================");
		result = list.stream().mapToInt(t -> t.getScore())//
				.reduce(0, (left, right) -> left > right ? left : right);
		System.out.println("최대값: "+result);
		
		
		System.out.println("=====================");
		result = list.stream().mapToInt(t -> t.getScore())//
				.reduce((left, right) -> left < right ? left : right)//
				.getAsInt();
		System.out.println("최소값: "+result);
		
		System.out.println("=====================");
		double avg = list.stream().mapToDouble(t -> t.getScore())//
				.reduce((left, right) -> (left +right)/2)//
				.getAsDouble();
		System.out.println("평균: "+avg);
			
		
	}
}
