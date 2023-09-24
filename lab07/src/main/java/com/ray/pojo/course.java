package com.ray.pojo;

public class course {
    String id;
    String name;

    int credit;
    int semester;
    String teacher_id;
    public course() {

    }

    public course(String id, String name, int credit, int semester, String teacher_id) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.semester = semester;
        this.teacher_id = teacher_id;
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", semester=" + semester +
                ", teacher_id='" + teacher_id + '\'' +
                '}';
    }
}
