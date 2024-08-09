package org.example.Menu;

import org.example.Entity.CoursePreference;
import org.example.Entity.Teacher;
import org.example.Menu.interfaces.TeacherMenuInterFace;
import org.example.Service.baseEmployee.BaseEmployeeService;
import org.example.Service.baseEmployee.imp.BaseEmployeeServiceImp;
import org.example.functions.pac.TriFunction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;

public class TeacherMenu implements TeacherMenuInterFace {
    private Scanner scanner = new Scanner(System.in);
    private Teacher token;
    private BaseEmployeeService baseEmployeeService;
    public TeacherMenu(){
        baseEmployeeService = new BaseEmployeeServiceImp();
    }
    @Override
    public boolean validate(Teacher token) {
        if (baseEmployeeService.login(token.getUsername(),token.getPassword()) != null){
            this.token = token;
            return true;
        }
        return false;
    }

    @Override
    public void menu() {

    }
    @Override
    public void changeGradeOfStudents(Teacher teacher){
        System.out.println(teacher.getSalaryPapers().toString());
        System.out.println(teacher.getFirstName());
        System.out.println(teacher.getFirstName());
        System.out.println(teacher.getUsername());
        System.out.println(teacher.getRole());
        System.out.println("please enter the lesson do you wnat to see the students :" );
            System.out.println("please inset student number ");
            String studentNumber = notAcceptNull.apply(scanner.nextLine());
            System.out.println("please insert curse code ");
            String courseCode = notAcceptNull.apply(scanner.nextLine());
            List<CoursePreference> coursePreferences = baseEmployeeService.findStudentByLessonAndStudentNumber(
                    courseCode,studentNumber
            );
            List<CoursePreference> teacherCourse = new ArrayList<>();
            for (CoursePreference coursePreference : coursePreferences){
                if (Objects.equals(coursePreference.getLesson().getTeacher().getTeacherNumber(), teacher.getTeacherNumber())){
                    System.out.println(coursePreference.getLesson().getTitle()  );
                    System.out.println("please enter the grade : ");
                    Integer grade = stringIntegerFunction.apply(scanner.nextLine());
                    coursePreference.setGrade(checkBoundaries.apply(grade, 0, 20));
                    baseEmployeeService.update(coursePreference);
                }
            }
    }

    @Override
    public void showSalaryPaper(Teacher teacher) {
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
