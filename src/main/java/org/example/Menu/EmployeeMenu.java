package org.example.Menu;

import org.example.Entity.*;
import org.example.Menu.interfaces.MenuEmployee;
import org.example.Service.baseEmployee.BaseEmployeeService;
import org.example.Service.baseEmployee.imp.BaseEmployeeServiceImp;
import org.example.enums.Days;
import org.example.enums.Degree;
import org.example.enums.TypeOfTeacher;
import org.example.functions.pac.TriFunction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

public class EmployeeMenu implements MenuEmployee {
    Scanner scanner = new Scanner(System.in);
    private BaseEmployee baseEmployee;
    private BaseEmployeeService baseEmployeeService;
    public EmployeeMenu() {
        baseEmployeeService = new BaseEmployeeServiceImp();
    }
    public boolean validate(BaseEmployee token){
        if (baseEmployeeService.login(token.getUsername(),token.getPassword()) != null){
           baseEmployee = token;
        }return false;
    }

    public void Login()
    {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome ");
            System.out.println(baseEmployee.getFirstName());
            System.out.println(baseEmployee.getLastName());
            System.out.println(baseEmployee.getSalaryPapers());
            System.out.println("Which of this do you want");
            System.out.println("1 :  student");
            System.out.println("2 :  teacher");
            System.out.println("3 : employee");
            System.out.println("4 : lessons");
            System.out.println("5: see the salary papers");
            int choose = scanner.nextInt();
            while (choose > 4 || choose < 1){
                System.out.println("Please choose a number between 1 and 4");
                choose = scanner.nextInt();
            }
            switch (choose){
                case 1:
                {
                    System.out.println("1 : add new student");
                    System.out.println("2 : edit student");
                    System.out.println("3 : delete student");
                    int studentChoose = scanner.nextInt();
                    while (studentChoose >3 || studentChoose <1){
                        System.out.println("Invalid choice");
                        studentChoose = scanner.nextInt();
                    }
                    switch (studentChoose){
                        case 1:{
                            Student student = new Student();
                            baseEmployeeService.save(student);
                            break;

                        }
                        case 2:{
                            System.out.println("please enter the studentNumber :");
                            String studentNumber = scanner.nextLine();
                            Student student = baseEmployeeService.findByStudentNumber(studentNumber);
                            if (student == null){
                                System.out.println("student not found");
                            }
                            else {
                                System.out.println(student.toString());

                                baseEmployeeService.update(student);
                            }
                            break;
                        }
                        case 3:{
                            System.out.println("please enter the studentNumber :");
                            String studentNumber = scanner.nextLine();
                            Student student = baseEmployeeService.findByStudentNumber(studentNumber);
                            if (student == null){
                                System.out.println("student not found");
                            }
                            else {
                                System.out.println(student.toString());
                                baseEmployeeService.delete(student);
                            }
                            break;
                        }
                    }
                    break;
                }
                case 2:{
                    System.out.println("1 : add new teacher");
                    System.out.println("2 : edit teacher");
                    System.out.println("3 : delete teacher");
                    int teacherChoose = scanner.nextInt();
                    while (teacherChoose >3 || teacherChoose <1){
                        System.out.println("Invalid choice");
                        teacherChoose = scanner.nextInt();
                    }
                    switch (teacherChoose){
                        case 1:{
                            Teacher teacher = new Teacher();

                            baseEmployeeService.save(teacher);
                        }
                        case 2:{
                            System.out.println("please enter the teacherNumber");
                            String teacherNumber = scanner.nextLine();
                            Teacher teacher =null;
                            if (teacher == null){
                                System.out.println("teacher not found");
                            }
                            else {
                                System.out.println(teacher.toString());
                                System.out.println("do you want to change it you have to write all of it elements");

                            }
                        }
                        case 3:{
                            System.out.println("please enter the teacherNumber that you want to delete");
                            String teacherNumber = scanner.nextLine();
                            Teacher teacher =null;
                            if (teacher == null){
                                System.out.println("teacher not found");
                            }
                            else {
                                System.out.println(teacher.toString());
                                System.out.println("delete ? 1 for delete 2 for back");
                                int delete = scanner.nextInt();
                                if (delete == 1){
                                    baseEmployeeService.delete(teacher);
                                }
                                else {
                                    break;
                                }
                            }
                        }
                    }

                }
        }

    }
    Function<String,Integer> stringIntegerFunction = string -> {
        boolean valid = false;
        Integer outPut = null;
        while (!valid){
            try {
                outPut = Integer.parseInt(string);
                valid = true;
            }catch (Exception e){
                System.out.println("please enter the number correctly !!! ");
                string = scanner.nextLine();
            }
        }
        return outPut;
    };
    Function<Integer,Integer> checkGrade = o -> {
        while (true){
            if (o>3 && o<1){
                System.out.println("please Enter the number correctly");
                o = stringIntegerFunction.apply(scanner.nextLine());
            }
            else {
                return o;
            }
        }
    };

    Function<String , String> notAcceptNull = string -> {
        while (true){
            if (string.isEmpty()){
                System.out.println("cant be empty");
                string = scanner.nextLine();
            }
            return string;
        }
    };
    Function<String,LocalDate> getCorrectLocalDate = string -> {
        LocalDate localDate ;
        try {
            localDate = LocalDate.parse(string);
            return localDate;
        }catch (Exception e){
            System.out.println("please enter the date correctly !!! ");
        }
        return null;
    };
    TriFunction<Integer,Integer,Integer,Integer> checkBoundaries = (integer, integer2, integer3) -> {
        while (true){
            if (integer>integer3 && integer<integer){
                System.out.println("please Enter the number correctly under the bound");
                integer = stringIntegerFunction.apply(scanner.nextLine());
            }
            else {
                return integer;
            }
        }
    };
    Function<String, LocalTime> stringToLocalTime = string -> {
        LocalTime localTime = null;
        boolean valid = false;
        while (!valid){
            try {
                localTime = LocalTime.parse(string);
                valid = true;
            }catch (Exception e){
                System.out.println("please enter the time correctly !!! ");
                string = scanner.nextLine();
            }
        }
        return localTime;
    };

    @Override
    public void instantiateOrUpdateEmployee(BaseEmployee employee, int forUpdate) {
        System.out.println("please enter the FirstName ");
        employee.setFirstName(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the LastName ");
        employee.setLastName(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the phoneNumber ");
        employee.setPhoneNumber(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the email ");
        employee.setEmail(scanner.nextLine());

        System.out.println("please enter the major ");
        employee.setRole(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the degree :");
        int degree = checkGrade.apply(stringIntegerFunction.apply(scanner.nextLine()));
        employee.setDegree(
                switch (degree){
                    case 1 -> Degree.bachelor;
                    case 2 -> Degree.master;
                    case 3 -> Degree.phd;
                    default -> throw new IllegalStateException("Unexpected value: " + degree);
                }
        );
        System.out.println("please enter the username :");
        employee.setUsername(notAcceptNull.apply(scanner.nextLine()));
        System.out.println("please enter the password ");
        employee.setPassword(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the date of your birthday like '1402-02-12'");
        employee.setDateOfBirth(getCorrectLocalDate.apply(scanner.nextLine()));
    }

    @Override
    public void instantiateOrUpdateStudent(Student student, int forUpdate) {
        System.out.println("please enter the FirstName ");
        student.setFirstName(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the LastName ");
        student.setLastName(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the phoneNumber ");
        student.setPhoneNumber(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the email ");
        student.setEmail(scanner.nextLine());

        System.out.println("please enter the major ");
        student.setMajor(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the degree :");
        int degree = checkGrade.apply(stringIntegerFunction.apply(scanner.nextLine()));
        student.setDegree(
                switch (degree){
                    case 1 -> Degree.bachelor;
                    case 2 -> Degree.master;
                    case 3 -> Degree.phd;
                    default -> throw new IllegalStateException("Unexpected value: " + degree);
                }
        );
        System.out.println("please enter the username :");
        student.setUserName(notAcceptNull.apply(scanner.nextLine()));
        System.out.println("please enter the password ");
        student.setPassword(notAcceptNull.apply(scanner.nextLine()));
        System.out.println("please enter its last average ");
        student.setLastTermsAverage(stringIntegerFunction.apply(scanner.nextLine()));
        System.out.println("please enter the studentNumber ");
        student.setStudentNumber(notAcceptNull.apply(scanner.nextLine()));
        System.out.println("please enter the year of entrance");
        student.setYearEnter(stringIntegerFunction.apply(scanner.nextLine()));
        baseEmployeeService.save(student);
    }


    @Override
    public void instantiateOrUpdateTeacher(Teacher teacher, int forUpdate) {
        System.out.println("please enter the FirstName ");
        teacher.setFirstName(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the LastName ");
        teacher.setLastName(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the phoneNumber ");
        teacher.setPhoneNumber(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the email ");
        teacher.setEmail(scanner.nextLine());

        System.out.println("please enter the major ");
        teacher.setRole(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the degree : 1 for bachelor 2 for maseter 3 for phd");
        int degree = checkGrade.apply(stringIntegerFunction.apply(scanner.nextLine()));
        teacher.setDegree(
                switch (degree){
                    case 1 -> Degree.bachelor;
                    case 2 -> Degree.master;
                    case 3 -> Degree.phd;
                    default -> throw new IllegalStateException("Unexpected value: " + degree);
                }
        );
        System.out.println("please enter the username :");
        teacher.setUsername(notAcceptNull.apply(scanner.nextLine()));
        System.out.println("please enter the password ");
        teacher.setPassword(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the date of your birthday like '1402-02-12'");
        teacher.setDateOfBirth(getCorrectLocalDate.apply(scanner.nextLine()));

        System.out.println("please enter the type of teacher : 1 for titution and 2 for " +
                "faculity member");
        int chooseTypeOfTeacher = checkBoundaries.apply(stringIntegerFunction.apply(scanner.nextLine()),
                1,2);
        teacher.setTypeOfTeacher(
                switch (chooseTypeOfTeacher){
                    case 1 -> TypeOfTeacher.titution;
                    case 2 -> TypeOfTeacher.faculity_member;
                    default -> throw new IllegalStateException("Unexpected value: " + chooseTypeOfTeacher);
                }
        );
        System.out.println("please enter the teacher number");
        teacher.setTeacherNumber(notAcceptNull.apply(scanner.nextLine()));
        baseEmployeeService.save(teacher);
    }
    @Override
    public void instantiateOrUpdateCourse(Course course, int forUpdate) {
        System.out.println("please enter the title : ");
        course.setName(notAcceptNull.apply(scanner.nextLine()));

        System.out.println("please enter the code of the course : ");
        course.setCourseCode(notAcceptNull.apply(scanner.nextLine()));

    }
    @Override
    public void instantiateOrUpdateLesson(Lesson lesson, int forUpdate) {
        System.out.println("please enter the name of the course that you want to add lesson to it :");
        lesson.setTitle(notAcceptNull.apply(scanner.nextLine()));
        System.out.println("please enter the code of the course : ");
        lesson.setCourseCode(notAcceptNull.apply(scanner.nextLine()));
        System.out.println("please enter the day of week for lesson start from 1: saturday to 5:thursday");
        int day = checkBoundaries.apply(stringIntegerFunction.apply(scanner.nextLine()),0,5);
        lesson.setDays(
                switch (day){
                    case 0 -> Days.SATURDAY;
                    case 1 -> Days.SUNDAY;
                    case 2 -> Days.MONDAY;
                    case 3 -> Days.TUESDAY;
                    case 4 -> Days.WEDNESDAY;
                    case 5 -> Days.THURSDAY;
                    default -> throw new IllegalStateException("Unexpected value: " + day);
                }
        );
        System.out.println("please insert the start time of class in day ");
        lesson.setStartLesson(stringToLocalTime.apply(scanner.nextLine()));
        System.out.println("please insert the end time of class in day ");
        lesson.setEndLesson(stringToLocalTime.apply(scanner.nextLine()));
        System.out.println("please insert the number of unit ");
        lesson.setNumberOfUnit(stringIntegerFunction.apply(scanner.nextLine()));
        Teacher teacher = new Teacher();
        System.out.println("please enter the teacherNumber of this lesson : ");
        teacher.setTeacherNumber(scanner.nextLine());
        System.out.println("please enter the teacherName of this lesson : ");
        teacher.setFirstName(scanner.nextLine());
        System.out.println("please enter the teacher lastname of this lesson : ");
        teacher.setLastName(scanner.nextLine());
        Teacher mainTeacher = baseEmployeeService.findByTeacherCodeOrFirstNameAndLastName(teacher);
        if (mainTeacher == null) {
            System.out.println("this teacher does not exist go back create this teacher then adjust the lesson");
        }
        else {
            System.out.println(mainTeacher.toString());

            AtomicBoolean checkTimeOfTeacherLessons = new AtomicBoolean(true);
            if (mainTeacher.getLessons() != null && !mainTeacher.getLessons().isEmpty()) {
                mainTeacher.getLessons().forEach(lesson1 -> {
                    boolean sameDay = Objects.equals(lesson1.getDays(), lesson.getDays());
                    boolean inSameTime = lesson.getEndLesson().isAfter(lesson1.getStartLesson()) && lesson.getStartLesson().isBefore(lesson1.getStartLesson()) ||
                            lesson.getStartLesson().isBefore(lesson1.getEndLesson()) && lesson.getEndLesson().isAfter(lesson1.getEndLesson()) ;
                     if (sameDay && inSameTime) {
                        checkTimeOfTeacherLessons.set(false);
                    }
                });

            }
            if (checkTimeOfTeacherLessons.get()){
                Course course = baseEmployeeService.findByCourseCodeOrTitle(lesson.getCourseCode()
                        ,lesson.getTitle());

                if (Objects.isNull(course)) {
                    System.out.println("not found lets create one ");

                    System.out.println("please set the term that you want to induce this course ");
                    Integer year = stringIntegerFunction.apply(scanner.nextLine());
                   Term term = baseEmployeeService.findTerm(year);
                    course = new Course();
                    course.setCourseCode(lesson.getCourseCode());
                    course.setName(lesson.getTitle());
                    if (Objects.isNull(term)) {
                        term = new Term();
                        term.setTermDate(year);
                        course.setTerm(term);
                        Set<Course> courses = Set.of(course);
                        term.setCourses(courses);
                    }else {
                        course.setTerm(term);
                        term.getCourses().add(course);
                    }
                    lesson.setCourse(course);
                    Set<Lesson> lessons = Set.of(lesson);
                    course.setLessons(lessons);
                }else {

                    lesson.setCourse(course);
                    course.getLessons().add(lesson);
                }
                if (mainTeacher.getLessons() != null && !mainTeacher.getLessons().isEmpty()) {
                    mainTeacher.getLessons().add(lesson);
                }else {
                    Set<Lesson> lessons = Set.of(lesson);
                    mainTeacher.setLessons(lessons);
                }
                lesson.setTeacher(mainTeacher);
                baseEmployeeService.update(mainTeacher);
            }else {
                System.out.println("teacher schedules are filled for your request");
            }
        }
    }

    @Override
    public Student findStudent(String studentNumber) {
       return baseEmployeeService.findByStudentNumber(studentNumber);
    }


    @Override
    public BaseEmployee findEmployee(BaseEmployee baseEmployee) {
        return baseEmployeeService.findByEmployeeNumber(baseEmployee.getPhoneNumber());
    }


    public Set<Lesson> findLesson() {

        System.out.println("please enter the title");

        System.out.println("please enter the code ");

        System.out.println("please enter the lesson teacher :");
        return null;
    }

    @Override
    public Course findCourse(Course course) {
        System.out.println("please enter the name of the course : ");
        course.setName(notAcceptNull.apply(scanner.nextLine()));
        System.out.println("please enter the code of the course : ");
        course.setCourseCode(notAcceptNull.apply(scanner.nextLine()));
        return baseEmployeeService.findByCourseCodeOrTitle(course.getCourseCode(), course.getName());
    }

    @Override
    public void deleteEmployee(BaseEmployee baseEmployee) {
        baseEmployeeService.delete(baseEmployee);
    }

    @Override
    public void deleteStudent(Student student) {
        baseEmployeeService.delete(student);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        baseEmployeeService.delete(teacher);
    }

    @Override
    public void deleteLesson(Lesson lesson) {
        Course course = baseEmployeeService.findByCourseCodeOrTitle(lesson.getCourseCode(), lesson.getTitle());
        System.out.println("which of this you want to delete please press the code of it ");
        course.getLessons().forEach(lesson1 -> {
            System.out.println("++++++++++++++++++");
            System.out.println(lesson1.getId());
            System.out.println(lesson1.getStartLesson());
            System.out.println(lesson1.getEndLesson());
            //System.out.println(lesson1.getTeacher().getLastName());
            System.out.println(lesson1.getDays());
            System.out.println("++++++++++++++++++");
                }
        );
        System.out.println("please enter the id of the lesson that you want to delete ");
        int id = stringIntegerFunction.apply(scanner.nextLine());
        Lesson lesson2 = new Lesson();
        lesson2 = course.getLessons().stream().filter(lesson1 ->
                lesson1.getId() == id).findAny().get();
        for (int i = 0; i < lesson2.getCoursePreference().size(); i++) {
            lesson2.getCoursePreference().get(i).setStudent(null);
        }
        lesson2.setTeacher(null);
        baseEmployeeService.delete(lesson2);
    }
}
