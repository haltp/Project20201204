package stream.homework;

public class Vo {
	private int employeeNo;
	private String name;
	private String email;
	private int salary;
	private int departmentid;
	
	
	

	public Vo(int employeeNo, String name, String email, int salary, int departmentid) {
		super();
		this.employeeNo = employeeNo;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.departmentid = departmentid;
	}
	
	public Vo() {
		
	}

	public int getEmployeeNo() {
		return employeeNo;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getSalary() {
		return salary;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	
	public void showEmpInfo() {
		System.out.println("사원번호: "+ employeeNo +", 이름: "+ name +", 메일: "+email+", 급여: "+salary);
	}
	

}
