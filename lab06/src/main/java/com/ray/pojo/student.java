package com.ray.pojo;

public class student {
    private String id;
    private String name;
    private String major;
    private String enrollment_date;
    private String sex;

    public student(){

    }
    public student(String id, String name, String major, String enrollment_date, String sex) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.enrollment_date = enrollment_date;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getEnrollment_date() {
        return enrollment_date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setEnrollment_date(String enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    @Override
    public String toString() {
        return "student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", enrollment_date='" + enrollment_date + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
