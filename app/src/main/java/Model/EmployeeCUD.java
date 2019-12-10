package Model;

public class EmployeeCUD {

    private int id;
    private float salary;
    private String name;
    private int age;
    private String profile_image;

    public EmployeeCUD(float employee_salary, String employee_name, int employee_age) {
        this.salary = employee_salary;
        this.name = employee_name;
        this.age = employee_age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
