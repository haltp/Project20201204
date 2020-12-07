package stream.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class EmpDAO {
	public static void main(String[] args) {
		Connection conn = DAO.getConnection();
		List<Vo> list = new ArrayList<Vo>();

		try {
			String sql = "select * from emp1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Vo vo = new Vo();
				vo.setEmployeeNo(rs.getInt("employee_id"));
				vo.setName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getInt("salary"));
				vo.setDepartmentid(rs.getInt("department_id"));

				list.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		Stream<Vo> stream = list.stream();
		stream.forEach(s -> s.showEmpInfo());
		System.out.println();

		// 1. salary 10,000이상인 사원
		System.out.println("[급여가 10,000이상인 사원]");
		list.stream().filter(new Predicate<Vo>() {

			@Override
			public boolean test(Vo t) {
				return t.getSalary() > 10000;
			}

		}).forEach(s -> s.showEmpInfo());

		// 2. 선적부서 급여 합계
		System.out.println();
		System.out.println("[선적부서 급여 합계]");

		int sum = list.stream().filter(new Predicate<Vo>() {

			@Override
			public boolean test(Vo t) {
				return t.getDepartmentid() == 50;
			}

		}).mapToInt(new ToIntFunction<Vo>() {

			@Override
			public int applyAsInt(Vo value) {
				return value.getSalary();
			}

		}).sum(); //sum은 메소드,기능, 함수 내가 지정한 sum 아님
		System.out.println(sum);

		// 2. 선적부서 급여 평균
		System.out.println();
		System.out.println("[선적부서 급여 평균]");
		double avg = list.stream().filter(new Predicate<Vo>() {

			@Override
			public boolean test(Vo t) {
				return t.getDepartmentid() == 40;

			}

		}).mapToInt(new ToIntFunction<Vo>() {

			@Override
			public int applyAsInt(Vo value) {
				return value.getSalary();
			}

		}).average().getAsDouble(); //average메소드는 뒤에 getAsDouble와야한다
		System.out.println(avg);

		// 3.급여가 5000~10000
		System.out.println();
		System.out.println("[급여가 5,000~10,000인 사원]");
		list.stream().filter(new Predicate<Vo>() {

			@Override
			public boolean test(Vo t) {
				return t.getSalary() > 5000 && t.getSalary() < 10000;
			}

		}).forEach(s -> s.showEmpInfo());

	}
}
