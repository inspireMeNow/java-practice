package com.ray.service.impl;

import com.ray.pojo.score;
import com.ray.service.scoreService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class scoreServiceImplTest {
@Resource
    scoreServiceImpl scoreService;
    @Test
    void findAllScore() {
        System.out.println(scoreService.findAllScore());
    }

    @Test
    void findScoreByStu() {

    }

    @Test
    void findScoreByCourse() {
    }

    @Test
    void findScoreByStuCourse() {
    }

    @Test
    void updateScoreByStuCourse() {
        score score = new score("20204130","CS0002","89");
        System.out.println(scoreService.updateScoreByStuCourse(score));
    }

    @Test
    void deleteScoreByStuCourse() {
        score score = new score("20204130","CS0002","0");
        System.out.println(scoreService.deleteScoreByStuCourse(score));
    }

    @Test
    void deleteScoreByStu() {
    }

    @Test
    void deleteScoreByCourse() {
    }

    @Test
    void insertScoreByStuCourse() {
        score score = new score("20204130","CS0002","90");
        System.out.println(scoreService.insertScoreByStuCourse(score));
    }
}