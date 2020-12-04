package stream.homework; //jre 마우스 오른쪽 클릭 빌드패치 configure 어쩌고 눌러서 오라클 연결먼저

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.db21125.EmployeeVO;


public class StreamMain {
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public List getEmpList() {
		conn = DAO.getConnection();
		sql = "select employee_id, first_name, email, salary from employees where salary >=10000";
		List list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				streamVO vo = new streamVO();
				vo.setNum(rs.getInt("employee_id"));
				vo.setName(rs.getString("first_name"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getInt("salary"));
								
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}
		
		
		
		return list;
		

		
		
	}
	
	
	
	
	
}

//HR: emp1
//50: 선적부서

//salary 10000이상인 사원 출력
//사원번호, 이름, 메일, 급여
//2.선적부서
//급여합계(평균)
//3. 급여가 5000에서 10000인사람의 사원번호 이름 메일 급여