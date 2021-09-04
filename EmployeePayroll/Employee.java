public class Employee {
	
	public Employee(int id, String name, int salary, String date, String gendre) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.salary = salary;
		this.gendre = gendre;
	}
	private int id;
	private String name;
	private String date;
	private int salary;
	private String gendre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getGendre() {
		return gendre;
	}
	public void setGendre(String gendre) {
		this.gendre = gendre;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", date=" + date + ", salary=" + salary + ", gendre=" + gendre
				+ "]";
	}

	
}
