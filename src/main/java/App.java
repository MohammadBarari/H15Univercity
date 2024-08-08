import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import org.example.Entity.*;
import org.example.Menu.EmployeeMenu;
import org.example.Service.baseEmployee.BaseEmployeeService;
import org.example.Service.baseEmployee.imp.BaseEmployeeServiceImp;
import org.example.Util.HibernateUtil;
import org.example.enums.Days;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        EmployeeMenu employeeMenu = new EmployeeMenu();
        Lesson lesson = new Lesson();
        Teacher teacher = new Teacher();
//        employeeMenu.instantiateOrUpdateTeacher(teacher,2);
//        employeeMenu.instantiateOrUpdateLesson(lesson,2);
//         BaseEmployeeService baseEmployeeService = new BaseEmployeeServiceImp();
//        lesson.setTitle("salam");
//        lesson.setDays(Days.SATURDAY);
//        lesson.setCourseCode("123141");
//        lesson.setNumberOfUnit(3);
//        Teacher teacher1 = new Teacher();
//        teacher1.setTeacherNumber("980127389");
//        teacher  = baseEmployeeService.findByTeacherCodeOrFirstNameAndLastName(teacher1);
//        lesson.setTeacher(teacher);
//        Set<Lesson> lessons = Set.of(lesson);
//        teacher.setLessons(lessons);
//        baseEmployeeService.update(teacher);
    employeeMenu.instantiateOrUpdateLesson(lesson,2);
        //employeeMenu.instantiateOrUpdateTeacher(teacher,2);

    }
}
