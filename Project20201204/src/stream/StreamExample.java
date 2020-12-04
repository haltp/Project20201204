package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		List<String> list = null;
		list = Arrays.asList("Hong", "Hwang", "Park", "Choi");
//		list.add("Kim");

		Stream<String> stream = list.stream();
		stream.filter((t) -> t.length() > 3)//
				.forEach((t) -> System.out.println(t));

		// 람다식 줄이기 전
//		stream.filter(new Predicate<String>() {
//
//			@Override
//			public boolean test(String t) {
//				return t.length() > 3;
//			}			
//		}).forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//			
//		});

		// BaseStream -> Stream<T>, IntStream, LongStream, DoubleStream
		// IntStream: Stream<Integer>, LongStream: Stream<Long>

		String[] strAry = { "Hong", "Hwang", "Park" };
		Stream<String> strStream = Arrays.stream(strAry);

		System.out.println("----------------");

		int[] intAry = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intAry);
		int sum = intStream.sum();
		System.out.println("합: " + sum);

		System.out.println("----------------");

		double[] dblAry = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		DoubleStream dblStream = Arrays.stream(dblAry);
		dblStream.forEach(new DoubleConsumer() {
			double result = 0;

			@Override
			public void accept(double value) { // consumer은 매개값은 있는데 리턴값이 없다
				result += value;
				System.out.println(result);
			}

		});
		System.out.println("----------------");

		IntStream is = IntStream.range(1, 10); // 1부터 9까지 출력
		is.forEach(n -> System.out.println(n));    //rangeClosed와 range 차이: range는 마지막숫자를 포함하지 않음

		System.out.println("----------------");

		is = IntStream.rangeClosed(1, 10); // 1부터 10까지 출력
		System.out.println("합: " + is.sum()); //합계 메소드

		System.out.println("----------------");

		Path path = Paths.get("list.txt"); //list.txt 열기
		try {
			Stream<String> stream1 = Files.lines(path);
			stream1.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------");
		
		path = Paths.get("c:/"); //c드라이브 밑의 파일들 보고 싶을 때
		try {
			Stream<Path> pStream = Files.list(path);
			pStream.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
