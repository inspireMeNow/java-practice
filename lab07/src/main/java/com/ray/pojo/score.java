package com.ray.pojo;

public class score {
    int id;
    String student_id;
    String course_id;
    int score;

    public score() {
    }

    public score(int id, String student_id, String course_id, int score) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "score{" +
                "id=" + id +
                ", student_id='" + student_id + '\'' +
                ", course_id='" + course_id + '\'' +
                ", score=" + score +
                '}';
    }
}
