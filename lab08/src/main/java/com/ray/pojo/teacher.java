package com.ray.pojo;

public class teacher {
    String id;
    String name;
    String department;
    int salary;
    String sex;

    public teacher(){

    }
    public teacher(String id, String name, String department, int salary, String sex) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getsex() {
        return sex;
    }

    public void setsex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", sex='" + sex + '\'' +
                '}';
    }
}
