package ru.verlonar;

public class Employee {
    private static int allEmployeesId;

    private final String name;
    private int department;
    private double salary;
    private final int id;

    public Employee(String name, int department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        allEmployeesId++;
        this.id = allEmployeesId;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Имя сотрудника: ").append(name).append("\n")
                .append("Отдел: ").append(department).append("\n")
                .append("Заработная плата: ").append(salary).append("\n")
                .append("id: ").append(id).append("\n");
        return sb.toString();
    }

    public String toStringWithoutDepartment() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Имя сотрудника: ").append(name).append("\n")
                .append("Заработная плата: ").append(salary).append("\n")
                .append("id: ").append(id).append("\n");
        return sb.toString();
    }
}
