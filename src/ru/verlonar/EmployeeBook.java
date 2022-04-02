package ru.verlonar;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBook {
    private final ArrayList<Employee> employeeBook;
    private final EmployeeBookService employeeBookService;

    public EmployeeBook() {
        this.employeeBook = new ArrayList<>();
        this.employeeBookService = new EmployeeBookService();
    }

    //ДОБАВЛЕНИЕ СОТРУДНИКА
    public void addEmployee(Employee newEmployee) {
        employeeBook.add(newEmployee);
    }

    //ИЗМЕНЕНИЕ СОТРУДНИКА ПО ИМЕНИ
    public void changeEmployeeByName(String name, double newSalary, int newDepartment) {
        if (name != null && !name.isEmpty()) {
            Employee employeeToChange = employeeBookService.getEmployeeByName(employeeBook, name);
            deleteEmployeeByName(name);
            employeeToChange.setSalary(newSalary);
            employeeToChange.setDepartment(newDepartment);
            addEmployee(employeeToChange);
            System.out.println("Сотрудник " + name + " изменен");
        } else {
            System.out.println("Ошибка: имя пустое или null");
        }
    }

    //УДАЛЕНИЕ СОТРУДНИКА ПО ИМЕНИ
    public void deleteEmployeeByName(String name) {
        if (name != null && !name.isEmpty()) {
            employeeBook.remove(employeeBookService.getEmployeeByName(employeeBook, name));
            System.out.println("Сотрудник " + name + " удален");
        } else {
            System.out.println("Ошибка: имя пустое или null");
        }
    }

    //УДАЛЕНИЕ СОТРУДНИКА ПО id
    public void deleteEmployeeById(int id) {
        if (id >= 0) {
            employeeBook.remove(employeeBookService.getEmployeeById(employeeBook, id));
            System.out.println("Сотрудник с id = " + id + " удален");
        } else {
            System.out.println("Ошибка: id не может быть отрицательным");
        }
    }

    //ПЕЧАТЬ ВСЕХ СОТРУДНИКОВ
    public void printAllEmployees() {
        System.out.println("Список сотрудников компании: ");
        for (Employee e : employeeBook) {
            System.out.println(e.toString());
        }
    }

    //ПЕЧАТЬ СОТРУДНИКОВ ОТДЕЛА
    public void printAllEmployeesFromDepartment(int department) {
        System.out.println("Список сотрудников отдела " + department + ": ");
        employeeBookService.printEmployeeListInfoWithoutDepartment(employeeBookService.getAllEmployeeOfDepartment(employeeBook, department));
    }

    //ПЕЧАТЬ ИМЕН ВСЕХ СОТРУДНИКОВ
    public void printAllEmployeesName() {
        System.out.println("Список имен сотрудников компании: ");
        for (Employee e : employeeBook) {
            System.out.println(e.getName());
        }
        System.out.println();
    }

    //ПЕЧАТЬ ИМЕН СОТРУДНИКОВ ПО ОТДЕЛАМ
    public void printEmployeesNameGroupByDepartments() {
        for (int i = 1; i < 6; i++) {
            List<Employee> employeeList = employeeBookService.getAllEmployeeOfDepartment(employeeBook, i);
            System.out.println("Сотрудники отдела " + i + ": ");
            for (Employee employee : employeeList) {
                System.out.println(employee.getName());
            }
            System.out.println();
        }
        System.out.println();
    }

    //ПОЛУЧИТЬ СУММУ ВСЕХ З/П ЗА МЕСЯЦ
    public double getSumOfAllSalariesPerMonth() {
        return employeeBookService.sumOfAllSalariesPerMonth(employeeBook);
    }

    //ПОЛУЧИТЬ СУММУ ВСЕХ З/П ОТДЕЛА ЗА МЕСЯЦ
    public double getSumOfAllSalariesPerMonthOfDepartment(int department) {
        return employeeBookService.sumOfAllSalariesPerMonth(employeeBookService.getAllEmployeeOfDepartment(employeeBook, department));
    }

    //ПОЛУЧИТЬ СОТРУДНИКА С МИНИМАЛЬНОЙ З/П
    public Employee getMinimumWageEmployee() {
        return employeeBookService.minimumWageEmployee(employeeBook);
    }

    //ПОЛУЧИТЬ СОТРУДНИКА С МИНИМАЛЬНОЙ З/П ПО ОТДЕЛУ
    public Employee getMinimumWageEmployeeOfDepartment(int department) {
        return employeeBookService.minimumWageEmployee(employeeBookService.getAllEmployeeOfDepartment(employeeBook, department));
    }

    //ПОЛУЧИТЬ СОТРУДНИКА С МАКСИМАЛЬНОЙ З/П
    public Employee getMaximumWageEmployee() {
        return employeeBookService.maximumWageEmployee(employeeBook);
    }

    //ПОЛУЧИТЬ СОТРУДНИКА С МАКСИМАЛЬНОЙ З/П ПО ОТДЕЛУ
    public Employee getMaximumWageEmployeeOfDepartment(int department) {
        return employeeBookService.maximumWageEmployee(employeeBookService.getAllEmployeeOfDepartment(employeeBook, department));
    }

    //ПОЛУЧИТЬ СРЕДНЕЕ ПО З/П ЗА МЕСЯЦ
    public double getAverageOfAllSalariesPerMonth() {
        return employeeBookService.averageOfAllSalariesPerMonth(employeeBook);
    }

    //ПОЛУЧИТЬ СРЕДНЕЕ ПО З/П ОТДЕЛА ЗА МЕСЯЦ
    public double getAverageOfAllSalariesPerMonthOfDepartment(int department) {
        return employeeBookService.averageOfAllSalariesPerMonth(employeeBookService.getAllEmployeeOfDepartment(employeeBook, department));
    }

    //ИНДЕКСАЦИЯ З/П ВСЕХ СОТРУДНИКОВ
    public void salaryIndexation(double percent) {
            employeeBookService.salaryIndexation(employeeBook, percent);
    }

    //ИНДЕКСАЦИЯ З/П СОТРУДНИКОВ ОТДЕЛА
    public void salaryIndexationOfDepartment(int department, double percent) {
            employeeBookService.salaryIndexation(employeeBookService.getAllEmployeeOfDepartment(employeeBook, department), percent);
    }

    //ПЕЧАТЬ ВСЕХ СОТРУДНИКОВ С З/П МЕНЬШЕ
    public void printAllEmployeesWithSalaryLess(double salary) {
        System.out.println("Список сотрудников с з/п меньше " + salary + ": ");
        List<Employee> employeesWithSalaryLess = employeeBook
                .stream()
                .filter(employee -> employee.getSalary() < salary)
                .toList();

        employeeBookService.printEmployeeListInfoWithoutDepartment(employeesWithSalaryLess);
    }

    //ПЕЧАТЬ ВСЕХ СОТРУДНИКОВ С З/П БОЛЬШЕ
    public void printAllEmployeesWithSalaryMore(double salary) {
        System.out.println("Список сотрудников с з/п больше " + salary + ": ");
        List<Employee> employeesWithSalaryMore = employeeBook
                .stream()
                .filter(employee -> employee.getSalary() >= salary)
                .toList();

        employeeBookService.printEmployeeListInfoWithoutDepartment(employeesWithSalaryMore);
    }
}
