package entity;

import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private String position;
    private int dep_number;

    public Employee(int id, String name, String surname, String position, int dep_number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.dep_number = dep_number;
    }

    public Employee() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDep_number() {
        return dep_number;
    }

    public void setDep_number(int dep_number) {
        this.dep_number = dep_number;
    }

    @Override
    public String toString() {
        return "entity.Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", dep_number=" + dep_number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                dep_number == employee.dep_number &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, position, dep_number);
    }
}
