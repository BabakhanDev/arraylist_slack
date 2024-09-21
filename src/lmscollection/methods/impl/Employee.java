package taskslack;

public class Employee {
    String name;
    int age;
    String job;

    public Employee(String name, int age, String job)throws InvalidAgeExeption {
        if (age<0){
            throw  new InvalidAgeExeption(" Age ne mojet byt otricatelnym: "+age);
        }
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
