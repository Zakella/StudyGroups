package OOP.SimpleProject.src.main.java.ru.gb.oseminar.controller;

import OOP.SimpleProject.src.main.java.ru.gb.oseminar.data.*;
import OOP.SimpleProject.src.main.java.ru.gb.oseminar.service.UserService;
import OOP.SimpleProject.src.main.java.ru.gb.oseminar.service.StudyGroupService;
import OOP.SimpleProject.src.main.java.ru.gb.oseminar.view.StudentView;

import java.util.*;

public class Controller {


    private final UserService userService = new UserService();

    private final StudentView studentView = new StudentView();

    private final StudyGroupService studyGroupService = new StudyGroupService();

    private List<Student> studentsList;

    public void createUser(String firstName, String lastName, String patronymic) {
        userService.createUser(firstName, lastName, patronymic);

    }

    public Teacher createTeacher(String firstName, String lastName, String patronymic, Long teacherId) {
        return userService.createUser(firstName, lastName, patronymic, teacherId);

    }

    public void showAllStudents() {
        List<User> students = userService.getAll();
        studentView.sendOnConsole(students);
    }

    public List<Student> getOnlyStudents() {
        return userService.getAllStudents();
    }

    public void showTeacherInfo(Teacher teacher) {
        List<User> teachers = new ArrayList<>();
        teachers.add(teacher);
        studentView.sendOnConsole(teachers);
    }

    public void showStudyGroups() {
        studentView.showStudyGroups(this.studyGroupService.getStudyGroupList());
    }

    public void showSortStudyGroup(List<Student> studentsList) {
        Collections.sort(studentsList, new StudyGroupComparator());
        studentView.showStudents(studentsList);
    }


    public void createTimetable(Teacher teacher, List<Student> studentList) {
        this.studyGroupService.completeStudyGroup(teacher, studentList);
    }


    public void showStudentsInGroups() {
        this.studentView.showStudentsInGroup(this.studyGroupService.getStudyGroupList());

    }

}
