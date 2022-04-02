package ru.verlonar;


public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee(new Employee("Ivan Ivanov", 1, 60_000.23));
        employeeBook.addEmployee(new Employee("Petr Petrov", 1, 70_145));
        employeeBook.addEmployee(new Employee("Ivan Petrov", 2, 30_368.98));
        employeeBook.addEmployee(new Employee("Petr Ivanov", 2, 35_000));
        employeeBook.addEmployee(new Employee("Tatyana Mihailovna", 5, 368_500));
        employeeBook.addEmployee(new Employee("Elena Borisovna", 3, 73_000.63));
        employeeBook.addEmployee(new Employee("Maxim Kulebyako", 4, 89_863));
        employeeBook.addEmployee(new Employee("Vasiliy Vasilyevich", 4, 99_999.99));
        employeeBook.addEmployee(new Employee("Ivan Vasilyevich", 5, 200_000));
        employeeBook.addEmployee(new Employee("Petr Vasilyevich", 3, 47_689));

        employeeBook.printAllEmployees();
        employeeBook.printAllEmployeesFromDepartment(5);
        employeeBook.printAllEmployeesFromDepartment(1);
        employeeBook.printAllEmployeesName();
        employeeBook.printEmployeesNameGroupByDepartments();
        System.out.println(employeeBook.getSumOfAllSalariesPerMonth());
        System.out.println(employeeBook.getSumOfAllSalariesPerMonthOfDepartment(3));
        System.out.println(employeeBook.getSumOfAllSalariesPerMonthOfDepartment(2));
        System.out.println(employeeBook.getMinimumWageEmployee());
        System.out.println(employeeBook.getMaximumWageEmployee());
        System.out.println(employeeBook.getMinimumWageEmployeeOfDepartment(5));
        System.out.println(employeeBook.getMaximumWageEmployeeOfDepartment(4));
        System.out.println(employeeBook.getAverageOfAllSalariesPerMonth());
        System.out.println(employeeBook.getAverageOfAllSalariesPerMonthOfDepartment(1));
        System.out.println(employeeBook.getAverageOfAllSalariesPerMonthOfDepartment(2));
        employeeBook.salaryIndexation(10);
        System.out.println(employeeBook.getSumOfAllSalariesPerMonth());
        employeeBook.salaryIndexationOfDepartment(3, 50);
        System.out.println(employeeBook.getSumOfAllSalariesPerMonth());
        System.out.println(employeeBook.getMaximumWageEmployeeOfDepartment(3));
        employeeBook.printAllEmployeesWithSalaryLess(90_000);
        employeeBook.printAllEmployeesWithSalaryMore(100_000);
        employeeBook.deleteEmployeeByName("Elena Borisovna");
        employeeBook.deleteEmployeeById(9);
        employeeBook.changeEmployeeByName("Tatyana Mihailovna", 100_000, 1);
        employeeBook.printAllEmployees();
        employeeBook.salaryIndexation(-30);
        System.out.println(employeeBook.getSumOfAllSalariesPerMonth());
    }
}
