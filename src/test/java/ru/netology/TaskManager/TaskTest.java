package ru.netology.TaskManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void simpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Пригласить родителей на ужин");

        boolean actual = simpleTask.matches("Пригласить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void simpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Пригласить родителей на ужин");

        boolean actual = simpleTask.matches("Написать");
        Assertions.assertFalse(actual);
    }

    @Test
    public void epicMatches() {
        String[] subtasks = {"Сделать домашнее задание", "Сходить в кино", "Встретиться с друзьями"};
        Epic epic = new Epic(25, subtasks);


        boolean actual = epic.matches("Встретиться");
        Assertions.assertTrue(actual);
    }

    @Test
    public void epicNotMatches() {
        String[] subtasks = {"Сделать домашнее задание", "Сходить в кино", "Встретиться с друзьями"};
        Epic epic = new Epic(25, subtasks);

        boolean actual = epic.matches("Погулять");
        Assertions.assertFalse(actual);
    }

    @Test
    public void meetingTopicMatches() {

        Meeting meeting = new Meeting(
                433,
                "Реализация новой стратегии",
                "Развитие компании в 2025 годуу",
                "Среда 26 июня"
        );
        boolean actual = meeting.matches("Реализация");
        Assertions.assertTrue(actual);

    }

    @Test
    public void meetingProjectMatches() {

        Meeting meeting = new Meeting(
                433,
                "Реализация новой стратегии",
                "Развитие компании в 2025 годуу",
                "Среда 26 июня"
        );
        boolean actual = meeting.matches("компании");
        Assertions.assertTrue(actual);
    }

    @Test
    public void meetingNotMatches() {

        Meeting meeting = new Meeting(
                433,
                "Реализация новой стратегии",
                "Развитие компании в 2025 годуу",
                "Среда 26 июня"
        );
        boolean actual = meeting.matches("июля");
        Assertions.assertFalse(actual);
    }

}
