import java.util.Set;
import java.util.HashSet;

 class Employee {

	public int id;
	public String name;
    public Double salary;
    
	public Employee() {
		super();
	}

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}



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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void incrementSalary() {
		this.salary *= 1.1;
	}

	public void incrementSalary(int newSalary) {
		this.salary += newSalary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary  + "]";
	}


}


public class Test{
    public static void main(String[] args) {
        Set set = new HashSet<>();
        Employee a = new Employee(1, "A", 1.0);
        Employee b = new Employee(2, "B", 2.0);
        Employee c = new Employee(1, "A", 1.0);
        set.add(a); set.add(b); set.add(c);
        System.out.println(set);
    }
}