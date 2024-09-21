package taskslack;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        todo task slack arraylist
//        Озунуздун Exception классынызды тузунуз.
//        Employee деген класс тузунуз (свойства: name, age, job).
//        Age берип жатканда эгерде минус сан болсо, тузгон Exception классынызды ыргытыныз.
//                ArrayList тузуп аны жумушчулар менен толтурунуз, бироосунун жашын минус сан менен
//        бериниз, бир элементин null деп бериниз.
//        Элементтеринин маалыматтарын консолго чыгарыныз.
//        Жок индексине да кайрылып корунуз.
//                Болушу мумкун болгон бардык каталарга оз озунчо catch блогун жазыныз.
//finally блогун кошунуз акырында “Бутту” деп программаны бутурунуз.

        
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            employees.add(new Employee("Kairat", 30, "Developer"));
            employees.add(new Employee("Alina", -25, "Designer"));
            employees.add(null);
            employees.get(5);
        }catch ( InvalidAgeExeption exeption) {
            System.out.println(" Invalid age: " + exeption.getMessage());
        }catch (NullPointerException exception) {
            System.out.println("null bolboshu kerek: ");
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index: ");
        }finally {
            System.out.println(" Buttu: ");
        }

        for (Employee employee : employees) {
            if (employee != null){
                System.out.println(employee);
            }else {
                System.out.println("Employee is null. ");
            }

        }
    }
}
