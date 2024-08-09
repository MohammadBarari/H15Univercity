package org.example.Menu;

import org.example.Entity.Course;
import org.example.Entity.CoursePreference;
import org.example.Entity.Lesson;
import org.example.Entity.Student;
import org.example.Menu.interfaces.StudentMenuInterface;
import org.example.Service.baseEmployee.BaseEmployeeService;
import org.example.Service.baseEmployee.imp.BaseEmployeeServiceImp;
import org.example.functions.pac.TriFunction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

public class StudentMenu implements StudentMenuInterface {
    private BaseEmployeeService baseEmployeeService;
    private Scanner scanner = new Scanner(System.in);
    private Student token;
    public StudentMenu() {
        baseEmployeeService = new BaseEmployeeServiceImp();
    }
    @Override
    public boolean validate(Student token) {
        if (token != null){
            this.token = token;
            return true;
        }
        return false;
    }

    @Override
    public Course findAllCourse() {
        return null;
    }

    @Override
    public Course findCourseByCodeOrName(String code, String name) {
        return null;
    }

    public void menu(){
        token.toString();
        System.out.println("welcome back");
    }
    public void ShowAllCourseAndSelect(Student student){
        List<Course> courses = baseEmployeeService.findAll();
        System.out.println("which of them do you want just press the index of it it will show you all its lessons");
        courses.forEach(course -> {
            System.out.println(course.getName());
            System.out.println(course.getCourseCode());
            System.out.println(course.getTerm());
        });
        System.out.println("please enter the course code that you want :");
        String courseCode = notAcceptNull.apply(scanner.nextLine());
        Course course = null;
        while (true) {
            for (Course c : courses) {
                if (c.getCourseCode().equals(courseCode)) {
                    course = c;
                }
            }
            if (course == null) {
                System.out.println("enter it carefully");
                courseCode = notAcceptNull.apply(scanner.nextLine());
            }
            else {
                break;
            }
        }

        if (!tellIfItsNull.apply(Objects.isNull(course.getLessons()),"no lessons to" +
                "prefer")) {
            List<Lesson> lessons = new ArrayList<>(course.getLessons());
            System.out.println("type the index of the lesson that you want to prefer ");
            AtomicInteger i = new AtomicInteger();
            for (int j = 0; j < lessons.size(); j++) {
                System.out.println(j + " :" + lessons.get(j).getTeacher().getLastName());
                System.out.println(j + " :" + lessons.get(j).getStartLesson());
                System.out.println(j + " :" + lessons.get(j).getEndLesson());
                System.out.println(j + " :" + lessons.get(j).getDays());
            }
            int lessonIndex = checkBoundaries.apply(stringIntegerFunction.apply(scanner.nextLine())
                    , 0, lessons.size());
            if (checkIfItsNotSame.apply(student,lessons.get(lessonIndex)) && !(getUnits.apply(student) + lessons.get(lessonIndex).getNumberOfUnit() > changeMaxUnit.apply(student))) {


                CoursePreference coursePreference = new CoursePreference();
                coursePreference.setLesson(lessons.get(lessonIndex));
                if (Objects.isNull(student.getCoursePreferences())) {
                    coursePreference.setStudent(student);
                    Set<CoursePreference> coursePreferences = Set.of(coursePreference);
                    student.setCoursePreferences(coursePreferences);
                } else {
                    coursePreference.setStudent(student);
                    student.getCoursePreferences().add(coursePreference);
                }
                baseEmployeeService.update(student);
            }else {
                System.out.println("higher than maximum for your units ");
            }
        }
    }
    BiFunction<Student,Lesson,Boolean> checkIfItsNotSame = (student, lesson) -> {
        boolean isSame = true;
            List<CoursePreference> lessons = baseEmployeeService.findStudentByLessonAndStudentNumber(
                    lesson.getCourseCode(),student.getStudentNumber());
            for (CoursePreference coursePreference : lessons) {
                if (coursePreference.getGrade() != null && coursePreference.getGrade()>10){
                    isSame = false;
                }
            }
            return isSame;
    };
    Function<Student,Integer>changeMaxUnit = student -> {
        if (student.getLastTermsAverage()>18)
            return 24;
        else return 20;
    };
    Function<Student,Integer> getUnits = student -> {
        int numbers = 0;
        for (CoursePreference cp : student.getCoursePreferences()) {
           if (cp.getLesson().getCourse().getTerm().getTermDate() == student.getCurrentTerm()){
               numbers += cp.getLesson().getNumberOfUnit();
           }
        }
return numbers;
    };
    BiFunction<Boolean,String,Boolean> tellIfItsNull = (o ,s) -> {
        if (o){
            System.out.println(s);
            return true;
        }
        return false;
    };
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
    Function<String, LocalDate> getCorrectLocalDate = string -> {
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
}
