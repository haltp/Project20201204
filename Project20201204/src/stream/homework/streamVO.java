package stream.homework;

public class streamVO {
	private int num;
	private String name;
	private String email;
	private int salary;
	
	
	public streamVO(int num, String name, String email, int salary) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
	
	
	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	public void showstreamInfo() {
		System.out.println("사원번호: "+ num +", 이름: "+ name +", 메일: "+email+", 급여: "+salary);
	}
	
	
}
