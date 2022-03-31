package ru.verlonar;

import java.util.List;

public class EmployeeBookService {


    //ПОЛУЧЕНИЕ ВСЕХ СОТРУДИКОВ ОТДЕЛА
    public List<Employee> getAllEmployeeOfDepartment(List<Employee> employeeList, int department) {
        return employeeList
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    //ПОЛУЧЕНИЕ СОТРУДНИКА С МИМИАЛЬНОЙ З/П
    public Employee minimumWageEmployee(List<Employee> employeeList) {
        Employee minimumWageEmployee = employeeList.get(0);

        for (Employee e : employeeList) {
            if (e.getSalary() < minimumWageEmployee.getSalary()) {
                minimumWageEmployee = e;
            }
        }

        return minimumWageEmployee;
    }

    //ПОЛУЧЕНИЕ СОТРУДНИКА С МАКСИМАЛЬНОЙ З/П
    public Employee maximumWageEmployee(List<Employee> employeeList) {
        Employee minimumWageEmployee = employeeList.get(0);

        for (Employee e : employeeList) {
            if (e.getSalary() > minimumWageEmployee.getSalary()) {
                minimumWageEmployee = e;
            }
        }

        return minimumWageEmployee;
    }

    //ПОЛУЧЕНИЕ СУММЫ З/П
    public double sumOfAllSalariesPerMonth(List<Employee> employeeList) {
        return employeeList
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    //ПОЛУЧЕНИЕ СРЕДНЕГО З/П
    public double averageOfAllSalariesPerMonth(List<Employee> employeeList) {
        return sumOfAllSalariesPerMonth(employeeList) / employeeList.size();
    }

    //ИНДЕКСАЦИЯ З/П
    public void salaryIndexation(List<Employee> employeeList, double percent) {
        for (Employee e : employeeList) {
            e.setSalary(e.getSalary() + e.getSalary() * (percent/100));
        }
    }

    //ПЕЧАТЬ СОТРУДНИКОВ ОТДЕЛА
    public void printEmployeeListInfoWithoutDepartment(List<Employee> employeeList) {
        for (Employee e : employeeList) {
            System.out.println(e.toStringWithoutDepartment());
        }
    }

    //ПОЛУЧИТЬ СОТРУДНИКА ПО ИМЕНИ
    public Employee getEmployeeByName(List<Employee> employeeList, String name) {
        return employeeList
                .stream()
                .filter(employee -> employee.getName().equals(name))
                .toList()
                .get(0);
    }

    //ПОЛУЧИТЬ СОТРУДНИКА ПО id
    public Employee getEmployeeById(List<Employee> employeeList, int id) {
        return employeeList
                .stream()
                .filter(employee -> employee.getId() == id)
                .toList()
                .get(0);
    }
}
