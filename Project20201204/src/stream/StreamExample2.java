package stream;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		// 1~100
		// 짝수만 결과를 출력
		IntStream.rangeClosed(1, 100).filter(t -> t % 2 == 0) // rangeClosed와 range 차이: range는 마지막숫자를 포함하지 않음
				.forEach(n -> System.out.println(n));

		System.out.println("---------------------------------");
		// 람다식 줄이기 전 (.눌러서 뭐가 뜨는지 잘 확인 해야한다)
		IntStream.rangeClosed(1, 100).filter(new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value % 2 == 0;
			}
		}).forEach(new IntConsumer() {

			@Override
			public void accept(int value) {
				System.out.println(value);
			}

		});

		System.out.println("---------------------------------");

		int sum = IntStream.rangeClosed(1, 10).filter(t -> t % 2 == 0) // 합계구하기
				.sum();
		System.out.println(sum);

		System.out.println("---------------------------------");

		// 최대값 구하기
		int[] intAry = { 2, 6, 4, 8, 1, 9 };
		IntStream is = Arrays.stream(intAry);
		OptionalInt max = is.max();
		System.out.println("max: " + max);
		int iMax = max.getAsInt();
		System.out.println("iMax: " + iMax);

		// 최소값 구하기
		is = Arrays.stream(intAry);
		int min = is.min().getAsInt();
		System.out.println("min: " + min);

		// 평균 구하기
		is = Arrays.stream(intAry);
		double avg = is.average().getAsDouble();
		System.out.println("평균: " + avg);

		
		// 조건(filter) : 조건을 걸러내고 싶어서 : 위의 int[]의 짝수만 출력
		Arrays.stream(intAry).filter((a) -> a % 2 == 0)//
				.forEach((a) -> System.out.println(a));

		// 람다식 줄이기 전
//		Arrays.stream(intAry).filter(new IntPredicate() {
//			@Override
//			public boolean test(int a) {
//				return a % 2 == 0;
//			}
//		}).forEach(new IntConsumer() {
//			@Override
//			public void accept(int a) {
//				System.out.println(a);
//			}
//		});

	}
}
