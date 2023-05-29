package com.ray.pojo;

public class score {
    String student_id;
    String course_id;
    String score;
    String course_name;
    int credit;
    int semester;

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
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

    public score() {
    }

    public score(String student_id, String course_id, String score) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.score = score;
    }

    public String getStudent_id() {
        return student_id;
    }

    public score(String student_id, String course_id, String score, String course_name, int credit, int semester) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.score = score;
        this.course_name = course_name;
        this.credit = credit;
        this.semester = semester;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "score{" +
                "student_id='" + student_id + '\'' +
                ", course_id='" + course_id + '\'' +
                ", score='" + score + '\'' +
                ", course_name='" + course_name + '\'' +
                ", credit=" + credit +
                ", semester=" + semester +
                '}';
    }
}
