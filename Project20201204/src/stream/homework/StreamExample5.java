package stream.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;

public class StreamExample5 {
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

		// 2. 선적부서 급여 평균
		System.out.println();
		System.out.println("[선적부서 급여 평균]");
		OptionalDouble avg = list.stream().filter((t) -> t.getDepartmentid() == 50)//
				.mapToInt((value) -> value.getSalary())//
				.average();
		
		System.out.println(avg.orElse(0.0)); //값이 있으면 avg, 값이 없으면 0.0으로 출력하겠다

//		avg.ifPresent(new DoubleConsumer() {
//
//			@Override
//			public void accept(double value) {
//				System.out.println(avg.getAsDouble());
//
//			}
//
//		});

	}
}
